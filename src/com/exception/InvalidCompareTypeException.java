package com.exception;

/**
 * Created by FPT on 11/8/2016.
 *
 * Class Description: This exception is thrown when the compare type is
 * not either 'h' - to compare by Height, 'v' - to compare by Volume, or 'a' - to compare by Base Area
 */
public class InvalidCompareTypeException extends Exception {
    /**
     * Default Constructor to create an instance of the Exception
     */
    public InvalidCompareTypeException(){}
    /**
     * Non-default constructor to create an instance of the Exception taking the error message
     * @param message - error message
     */
    public InvalidCompareTypeException(String message)
    {
        super(message);
    }
}
