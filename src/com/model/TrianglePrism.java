package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class TrianglePrism extends Prism {
    /**
     * The default constructor to set the default value to its attributes
     */
    public TrianglePrism()
    {
        super();
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Triangle Prism
     * @param length the edge length of this Triangle Prism
     */
    public TrianglePrism(double height, double length)
    {
        super(height, length);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Triangle Prism
     * @param length the edge length to set to this Triangle Prism
     * @param compareType the compare type of this Triangle Prism. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public TrianglePrism(double height, double length, char compareType) throws InvalidCompareTypeException
    {
        super(height, length, compareType);
    }

    @Override
    public double getBaseArea() {
        return (Math.pow(getLength(),2) * Math.sqrt(3.0))/4.0;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * getHeight();
    }
}
