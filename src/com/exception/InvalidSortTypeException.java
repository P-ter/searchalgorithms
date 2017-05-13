package com.exception;

/**
 * Created by FPT on 11/8/2016.
 *
 * Class Description: This exception is thrown when the sort type is not in the follwing list:
 * 'b' - Bubble Sort
 * 's' - Selection Sort
 * 'i' - Insertion Sort
 * 'm' - Merge Sort
 * 'q' - Quick Sort
 * 'z' - Shell Sort
 */
public class InvalidSortTypeException extends Exception {
    /**
     * Default Constructor to create an instance of the Exception
     */
    public InvalidSortTypeException() {}
    /**
     * Non-default constructor to create an instance of the Exception taking the error message
     * @param message - error message
     */
    public InvalidSortTypeException(String message)
    {
        super(message);
    }
}
