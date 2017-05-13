package com.driver;

import com.exception.InvalidArgumentException;
import com.exception.InvalidCompareTypeException;
import com.exception.InvalidSortTypeException;
import com.model.*;
import com.sortAlgorithms.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by FPT on 11/11/2016.
 * Description: Class to take the argument as input from user and use that input
 * to find the data file, as well as to determine the sort type and compare type of the
 * shapes that are taking in from the data file.
 */
public class Sorter {
    private String[] agrs;
    private FileReader dataFile;
    private char sortType;
    private char compareType;

    /**
     * Non-default constructor to set the value to this object's attributes
     * @param args the String argument taken from user input.
     */
    public Sorter(String[] args)
    {
        this.agrs = args;
        this.dataFile = null;
        this.sortType = 0;
        this.compareType = 0;
    }

    /**
     * Method to start reading data from the data file and sort it in descending order
     * @throws InvalidArgumentException if the arguments taking in from user are not three arguments with
     * one -f for the data file path, -t for the compare type and -s for the sorting type
     */
    public void start() throws InvalidArgumentException
    {
        if (this.agrs.length == 3)
        {
            for(int i = 0; i< this.agrs.length; i++)
            {
                if(this.agrs[i].toLowerCase().contains("-f"))
                {
                    setFile(this.agrs[i]);
                }
                else if(this.agrs[i].toLowerCase().contains("-t"))
                {
                    setCompareType(this.agrs[i]);
                }
                else if(this.agrs[i].toLowerCase().contains("-s"))
                {
                    setSortType(this.agrs[i]);
                }
                else
                {
                    throw new InvalidArgumentException("Invalid argument");
                }
            }
        } else{
            throw new InvalidArgumentException("There should be 3 arguments for this program");
        }

        ArrayList<Polygon> shapeList = getShapeList();

        try
        {
            shapeList = sort(shapeList);
        } catch (InvalidSortTypeException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Private method that sort the list of Polygon objects based on the sort type taken in from user input
     * @param sortingList the list of Polygons that need to be sorted
     * @return the sorted list of Polygons from greatest to smallest
     * @throws InvalidSortTypeException is thrown when the sort type is not in the follwing list:
     * 'b' - Bubble Sort
     * 's' - Selection Sort
     * 'i' - Insertion Sort
     * 'm' - Merge Sort
     * 'q' - Quick Sort
     * 'z' - Shell Sort
     */
    private ArrayList<Polygon> sort(ArrayList<Polygon> sortingList) throws InvalidSortTypeException
    {
        long startTime = 0;
        long endTime = 0;
        switch (sortType) {
            case 'b':
                startTime = System.currentTimeMillis();
                sortingList = BubbleSort.sort(sortingList);
                endTime = System.currentTimeMillis();
                break;
            case 's':
                startTime = System.currentTimeMillis();
                sortingList = SelectionSort.sort(sortingList);
                endTime = System.currentTimeMillis();
                break;
            case 'i':
                startTime = System.currentTimeMillis();
                sortingList = InsertionSort.sort(sortingList);
                endTime = System.currentTimeMillis();
                break;
            case 'm':
                startTime = System.currentTimeMillis();
                sortingList = MergeSort.sort(sortingList);
                endTime = System.currentTimeMillis();
                break;
            case 'q':
                startTime = System.currentTimeMillis();
                sortingList = QuickSort.sort(sortingList);
                endTime = System.currentTimeMillis();
                break;
            case 'z':
                startTime = System.currentTimeMillis();
                sortingList = ShellSort.sort(sortingList);
                endTime = System.currentTimeMillis();
                break;
            default:
                throw new InvalidSortTypeException("Invalid sort type");
        }

        int i = 0;
        System.out.print("Item " + (i+1) + " " + sortingList.get(i));
        i+=999;
        while (i<sortingList.size())
        {
            System.out.print("Item " + (i+1) + " " + sortingList.get(i));
            i += 1000;
        }
        if(i != sortingList.size())
        {
            System.out.print("Item " + sortingList.size() + " " + sortingList.get(sortingList.size()-1));
        }
        System.out.println("Time taken: " + (endTime-startTime) + " milliseconds");

        return sortingList;
    }

    /**
     * Support method to go the the data file and get the list of Polygon objects
     * @return the list of Polygon objects from the data file
     */
    private ArrayList<Polygon> getShapeList()
    {
        try {
            BufferedReader in = new BufferedReader(dataFile);
            String token[] = in.readLine().split(" ");
            List<String> stringList = new ArrayList<>(Arrays.asList(token));
            Iterator<String> iterator = stringList.iterator();
            ArrayList<Polygon> polygonList = new ArrayList<>(Integer.parseInt(iterator.next()));
            while (iterator.hasNext()) {
                String shapeName = iterator.next().toLowerCase();
                double value1 = Double.parseDouble(iterator.next());
                double value2 = Double.parseDouble(iterator.next());
                Polygon polygon = null;
                switch (shapeName) {
                    case "cone":
                        polygon = new Cone(value1, value2, this.compareType);
                        break;
                    case "cylinder":
                        polygon = new Cylinder(value1, value2, this.compareType);
                        break;
                    case "octagonalprism":
                        polygon = new OctagonPrism(value1, value2, this.compareType);
                        break;
                    case "pentagonalprism":
                        polygon = new PentagonPrism(value1, value2, this.compareType);
                        break;
                    case "pyramid":
                        polygon = new Pyramid(value1, value2, this.compareType);
                        break;
                    case "squareprism":
                        polygon = new SquarePrism(value1, value2, this.compareType);
                        break;
                    case "triangularprism":
                        polygon = new TrianglePrism(value1, value2, this.compareType);
                        break;
                    default:
                        throw new Exception("Invalid Shape");
                }
                polygonList.add(polygon);

            }
            return polygonList;
        } catch (IOException e)
        {
            System.out.println("IOException");
        } catch (InvalidCompareTypeException i)
        {
            System.out.println(i.getMessage());
        } catch (Exception a)
        {
            System.out.println(a.getMessage());
        }
        return null;
    }

    /**
     * Private method to get the file name from the argument and open a new FileReader to
     * that data file
     * @param args the argument taken from user input that starts with -f
     */
    private void setFile(String args) {
        String fileName = args.substring(2);
        try {
            this.dataFile = new FileReader(new File("res/" + fileName));

        }
        //Exception is thrown if the file is not found
        catch (FileNotFoundException e)
        {
            System.out.println("Data file not found");
        }
    }

    /**
     * Private method to set the compare type taken from the user-provided argument for the Polygon objects
     * @param args argument taken from the user input that starts with -t
     */
    private void setCompareType(String args)
    {
        this.compareType = args.toLowerCase().charAt(2);
    }

    /**
     * Private support method to set the sort type taken from the user-provided argument for this Sorter object
     * @param args argument taken from user input that starts with -s
     */
    private void setSortType(String args)
    {
        this.sortType = args.toLowerCase().charAt(2);
    }
}
