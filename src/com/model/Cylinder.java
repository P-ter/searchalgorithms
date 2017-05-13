package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 */
public class Cylinder extends Polygon {

    private double radius;
    /**
     * The default constructor to set the default value to its attributes
     */
    public Cylinder()
    {
        super();
        setRadius(0);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this Cylinder
     * @param radius the radius of this Cylinder
     */
    public Cylinder(double height, double radius) {
        super(height);
        setRadius(radius);
    }
    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height to set to this Cylinder
     * @param radius the radius to set to this Cylinder
     * @param compareType the compare type of this Cylinder. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public Cylinder(double height, double radius, char compareType) throws InvalidCompareTypeException
    {
        super(height,compareType);
        setRadius(radius);
    }

    /**
     * Method to get the radius of this Cylinder
     * @return the radius of this Cylinder
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Method to set the radius of this Cylinder
     * @param radius the radius to set to this Cylinder
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        double area  = Math.PI * Math.pow(getRadius(), 2);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = getBaseArea() * getHeight();
        return volume;
    }
}
