package com.sushinski.examplechartapp.utils;

import java.util.Random;

/**
 * Android GPUImage Wrapper
 * created by sushinski: pavel.sushi@gmail.com
 *
 * Helper class for random nubers generation
 */
public class RandomRanger {
    private static final Random mRandom = new Random(System.currentTimeMillis());

    private RandomRanger(){
    }

    /**
     * Generates float number in whole range
     * @return
     */
    public static float nextFloat(){
        return mRandom.nextFloat();
    }

    /**
     * Generates int in desired range
     * @param n upper range value
     * @return
     */
    public static int nextInt(int n) {
        return mRandom.nextInt(n);
    }

    /**
     * Generates float in desired range
     * @param min min range value
     * @param max max range value
     * @return
     */
    public static float randomInRange(float min, float max) {
        float range = max - min;
        float scaled = mRandom.nextFloat() * range;
        return scaled + min;
    }

    /**
     * Generates double in desired range
     * @param min min range value
     * @param max max range value
     * @return generated randow double value
     */
    public static double randDoubleRange(double min, double max){
        double range = max - min;
        double scaled = mRandom.nextFloat() * range;
        return scaled + min;
    }
}
