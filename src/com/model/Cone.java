package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class Cone extends Polygon {
    private double radius;

    /**
     * The default constructor to set the default value to its attributes
     */
    public Cone()
    {
        super();
        setRadius(0);
    }

    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Cone
     * @param radius the radius of this Cone
     */
    public Cone(double height, double radius){
        super(height);
        setRadius(radius);
    }

    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Cone
     * @param radius the radius to set to this Cone
     * @param compareType the compare type of this Cone. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public Cone(double height, double radius, char compareType) throws InvalidCompareTypeException
    {
        super(height,compareType);
        setRadius(radius);
    }

    @Override
    public double getBaseArea() {
        double area = Math.PI * Math.pow(getRadius(), 2);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (1.0/3.0) * getBaseArea() * getHeight();
        return volume;
    }

    /**
     * Method to get the radius of this Cone
     * @return the radius of this Cone
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Method to set the radius of this Cone
     * @param radius to set to this Cone
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
