package com.edu.rpcdemo.consumer;

import com.edu.rpcdemo.protocol.InvokeProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxy {

    public static <T> T create(Class<?> clazz) {

        MethodProxy methodProxy = new MethodProxy(clazz);

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), methodProxy);


    }


    private static class MethodProxy implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (Object.class.equals(method.getDeclaringClass())) {

                try {
                    return method.invoke(proxy);

                } catch (Exception e) {

                }
            } else {
                return rpcInvoker(proxy, method, args);
            }

            return null;
        }

        private Class<?> clazz;

        public MethodProxy(Class<?> clazz) {
            this.clazz = clazz;
        }

        private Object rpcInvoker(Object proxy, Method method, Object[] args) {

            InvokeProtocol invokeProtocol = new InvokeProtocol();

            invokeProtocol.setClassname(this.clazz.getName());
            invokeProtocol.setMethodName(method.getName());
            invokeProtocol.setValues(args);
            invokeProtocol.setParams(method.getParameterTypes());

            RpcProxyHandle rpcProxyHandle = new RpcProxyHandle();

            NioEventLoopGroup group = new NioEventLoopGroup();


            try {
                Bootstrap bootstrap = new Bootstrap();

                bootstrap.group(group)
                        .channel(NioServerSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {

                                ChannelPipeline pipeline = ch.pipeline();

                                pipeline.addLast("frameEncoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));

                                pipeline.addLast("encoder", new ObjectEncoder());

                                pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                                pipeline.addLast("handle", rpcProxyHandle);

                                ChannelFuture future = bootstrap.connect("localhost", 8080);

                                future.channel().writeAndFlush(invokeProtocol).sync();

                                future.channel().closeFuture().sync();
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }

            return rpcProxyHandle.getResponse();

        }
    }






}
