package com.edu.rpcdemo.registry;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RegistryHandler extends ChannelInboundHandlerAdapter {

    private static ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<>(256);

    private Set<String> classNames = new HashSet<>(16);

    public RegistryHandler() {

        scannerClasses("com.edu.rpcdemo.provider");

        doRegister();

    }

    private void doRegister() {

        if (classNames.size() == 0) {
            return;
        }

        for (String className : classNames) {

            try {
                Class<?> aClass = Class.forName(className);

                Class<?> anInterface = aClass.getInterfaces()[0];

                registryMap.put(anInterface.getName(), aClass.newInstance());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    private void scannerClasses(String packageName) {

        URL resource = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));

        File file = new File(resource.getFile());

        if (file.isDirectory()) {
            scannerClasses(packageName + file.getName());
        } else {
            classNames.add(packageName + file.getName().replace(".class", "").trim());
        }

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }
}
