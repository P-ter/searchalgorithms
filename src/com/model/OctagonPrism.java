package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class OctagonPrism extends Prism {
    /**
     * The default constructor to set the default value to its attributes
     */
    public OctagonPrism()
    {
        super();
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Octagonal Prism
     * @param length the edge length of this Octagonal Prism
     */
    public OctagonPrism(double height, double length)
    {
        super(height, length);
    }

    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Octagonal Prism
     * @param length the edge length to set to this Octagonal Prism
     * @param compareType the compare type of this Octagonal Prism. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public OctagonPrism(double height, double length, char compareType) throws InvalidCompareTypeException
    {
        super(height, length, compareType);
    }

    @Override
    public double getBaseArea() {
        return 2.0*(1+Math.sqrt(2))* Math.pow(getLength(),2);
    }
}
