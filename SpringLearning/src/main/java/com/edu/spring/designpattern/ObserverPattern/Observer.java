package com.edu.spring.designpattern.ObserverPattern;

/**
 * 观察者的通用抽象类
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

    /**
     *  @author fangpan
     *  @since 2020/8/19 14:24
     *
     *  twoSum
     */
    public static void main(String[] args) throws Exception {

        int [] nums = new int[]{2, 4, 6, 9};

        int target = 15;

        int[] ints = twoSum(nums, target);

        System.out.println(ints[0]+","+ints[1] );


    }

    public static int[] twoSum(int[] nums, int target) throws Exception {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j<nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        throw new Exception();
    }

}
