package com.sortAlgorithms;

import java.util.ArrayList;

/**
 * Created by FPT on 11/9/2016.
 * Description: This class implements Insertion Sort algorithms
 */
public class InsertionSort {
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> sortingList)
    {
         //The first loop to go over the unsorted list
        for(int i =1; i <sortingList.size(); i++)
        {
            T currentShape = sortingList.get(i);
            boolean found = false;
            // The second loop to find where to put the current shape into the sorted list
            for(int j = 0; j <= i && !found; j++)
            {
                T comparingShape = sortingList.get(j);
                if(currentShape.compareTo(comparingShape) >0 && j!=i)
                {
                    //The third loop to shift the position to the
                    for(int k = i; k >j; k--)
                    {
                        T transition = sortingList.get(k-1);
                        sortingList.set(k, transition);
                    }
                    sortingList.set(j, currentShape);
                    found = true;
                }
            }
        }
        return sortingList;
    }
}
