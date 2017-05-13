package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class PentagonPrism extends Prism {

    /**
     * The default constructor to set the default value to its attributes
     */
    public PentagonPrism()
    {
        super();
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Pentagonal Prism
     * @param length the edge length of this Pentagonal Prism
     */
    public PentagonPrism(double height, double length)
    {
        super(height, length);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Pentagonal Prism
     * @param length the edge length to set to this Pentagonal Prism
     * @param compareType the compare type of this Pentagonal Prism. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public PentagonPrism(double height, double length, char compareType) throws InvalidCompareTypeException
    {
        super(height, length, compareType);
    }

    @Override
    public double getBaseArea() {
        return (5*Math.pow(getLength(),2) * Math.tan(Math.toRadians(54)))/4.0;
    }

}
