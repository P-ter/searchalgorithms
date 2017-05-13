package com.exception;

/**
 * Created by FPT on 11/11/2016.
 *
 * Class Description: This exception is thrown when the arguments taken from user
 * are more or less than three arguments with -f for file, -t for compare type and -s for sorting type
 */

public class InvalidArgumentException extends Exception{
    /**
     * Default Constructor to create an instance of the Exception
     */
    public InvalidArgumentException(){}
    /**
     * Non-default constructor to create an instance of the Exception taking the error message
     * @param message - error message
     */
    public InvalidArgumentException(String message){
        super(message);
    }
}
