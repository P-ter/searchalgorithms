package com.model;

import com.exception.InvalidCompareTypeException;

/**
 * Created by FPT on 11/8/2016.
 * Description: abstract class that implements Comparable and GeometricalFigureADT interface
 * This class implements the compareTo method that allows its objects to be able to compare to each other.
 */
public abstract class Polygon implements Comparable<Polygon>, GeometricalFigureADT{
    protected char compareType;
    protected double height;

    /**
     * The default constructor to set the default value to its attributes
     */
    public Polygon() {
        this.height = 'h';
        setHeight(0);
    }

    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this figure
     */
    public Polygon(double height)
    {
        this.height = 'h';
        setHeight(height);
    }

    /**
     * The non default constructor to initialize class level variables with user provided data.
     * @param height the height of this figure
     * @param compareType the compare type of this figure. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public Polygon(double height, char compareType) throws InvalidCompareTypeException
    {
        setCompareType(compareType);
        setHeight(height);
    }
    @Override
    public abstract double getBaseArea();
    @Override
    public abstract double getVolume();

    /**
     * Method to set the height of this figure
     * @param height the height of this figure
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * Method to get the value of this figure height
     * @return the height of this figure
     */
    public double getHeight()
    {
        return this.height;
    }

    /**
     * Method to get the compare type of this figure
     * @return the compare type of this figure. It can be either 'h', 'v', 'a'.
     */
    public char getCompareType() {
        return compareType;
    }

    /**
     * Method to set the compare type of this figure
     * @param compareType the compare type of this figure. The value can be 'h' - for compare by height
     *                    'v' - to compare by Volume
     *                    'a' - to compare by Base area
     * @throws InvalidCompareTypeException if the compare type is other than 'h', 'v' or 'a'
     */
    public void setCompareType(char compareType) throws InvalidCompareTypeException {
        if(compareType == 'h' || compareType == 'v' || compareType == 'a' ) {
            this.compareType = compareType;
        }
        else
        {
            throw new InvalidCompareTypeException("Invalid Compare Type");
        }
    }
    @Override
    public int compareTo(Polygon o) {
        double difference = 0;
        if(this.getCompareType() == 'v'){
            difference = this.getVolume() - o.getVolume();
        } else if (this.getCompareType() == 'h') {
            difference = this.getHeight() - o.getHeight();
        } else if (this.getCompareType() == 'a') {
            difference = this.getBaseArea() - o.getBaseArea();
        }
        if(difference > 0)
        {
            return 1;
        } else if( difference ==0){
            return 0;
        } else {
            return -1;
        }
    }
    @Override
    public String toString()
    {
        return "" + this.getClass().getSimpleName() + " Height: " + getHeight() + " Volume: " + getVolume() + " Base Area: " + getBaseArea() + " \n";
    }
}
