package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class SquarePrism extends Prism {
    /**
     * The default constructor to set the default value to its attributes
     */
    public SquarePrism()
    {
        super();
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Square Prism
     * @param length the edge length of this Square Prism
     */
    public SquarePrism(double height, double length)
    {
        super(height, length);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Square Prism
     * @param length the edge length to set to this Square Prism
     * @param compareType the compare type of this Square Prism. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public SquarePrism(double height, double length, char compareType) throws InvalidCompareTypeException
    {
        super(height, length, compareType);
    }

    @Override
    public double getBaseArea() {
        return Math.pow(getLength(), 2);
    }

}
