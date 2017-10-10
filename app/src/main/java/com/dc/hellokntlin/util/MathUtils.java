package com.dc.hellokntlin.util;

/**
 * Created by dingchao on 2017/8/30.
 */

public final class MathUtils
{
    public static int round(float d)
    {
        return (int)(d + 0.5F);
    }

    public static float distance(float aX, float aY, float bX, float bY)
    {
        float xDiff = aX - bX;
        float yDiff = aY - bY;
        return (float)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public static float distance(int aX, int aY, int bX, int bY)
    {
        int xDiff = aX - bX;
        int yDiff = aY - bY;
        return (float)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
