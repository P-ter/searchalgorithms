package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public abstract class Prism extends Polygon {

    private double length;
    /**
     * The default constructor to set the default value to its attributes
     */
    public Prism() {
        super();
    }

    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Prism
     * @param length the edge length of this Prism
     */
    public Prism(double height, double length) {
        super (height);
        setLength(length);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Prism
     * @param length the edge length to set to this Prism
     * @param compareType the compare type of this Prism. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public Prism(double height, double length, char compareType) throws InvalidCompareTypeException{
        super(height, compareType);
        setLength(length);
    }

    /**
     * Method to get the edge length of this Prism
     * @return the edge length of this Prism
     */
    public double getLength() {
        return length;
    }

    /**
     * Method to set the edge length of this Prism
     * @param length the edge length to set to this Prism
     */
    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public abstract double getBaseArea();
    @Override
    public double getVolume() {
        return getBaseArea() * getHeight();
    }
}
