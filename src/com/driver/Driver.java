package com.driver;

import com.exception.InvalidArgumentException;

/**
 * Created by FPT on 11/11/2016.
 * Description: The driver class that only contains the main method to create and call the start
 * method from the Sorter object
 */
public class Driver {

    /**
     * Main method to instantiate and call the start method from a Sorter object
     * @param args argument provided by user
     */
    public static void main (String[] args)
    {
        try {
            Sorter sorter = new Sorter(args);
            sorter.start();
        } catch (InvalidArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
