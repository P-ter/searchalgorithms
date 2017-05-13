package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class Pyramid extends Polygon {
    private double length;
    /**
     * The default constructor to set the default value to its attributes
     */
    public Pyramid () throws InvalidCompareTypeException{
        super();
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Pyramid
     * @param length the edge length of this Pyramid
     */
    public Pyramid(double height, double length) throws InvalidCompareTypeException{
        super(height);
        setLength(length);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Pyramid
     * @param length the edge length to set to this Pyramid
     * @param compareType the compare type of this Pyramid. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public Pyramid (double height, double length, char compareType) throws InvalidCompareTypeException{
        super(height,compareType);
        setLength(length);
    }

    /**
     * Method to get the edge length of this Pyramid
     * @return the edge length of this Pyramid
     */
    public double getLength() {
        return length;
    }

    /**
     * Method to set the edge length of this Pyramid
     * @param length the edge length to set to this Pyramid
     */
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getBaseArea() {
        double area = Math.pow(getLength(), 2);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (1.0/3.0) * getBaseArea() *getHeight();
        return volume;
    }
}
