package com.sortAlgorithms;

import java.util.ArrayList;

/**
 * Created by FPT on 11/10/2016.
 * Description: This class implements BubbleSort algorithms
 */
public class BubbleSort {
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> sortingList)
    {
        //loop from the second last element to the start
        for(int i = (sortingList.size()-1); i >= 0; i--)
        {
            //loop through the unsorted part to find the largest element from the
            for(int k =0; k < i; k++)
            {
                T current = sortingList.get(k);
                T comparing = sortingList.get(k+1);
                if(current.compareTo(comparing) <0)
                {
                    sortingList.set((k+1), current);
                    sortingList.set(k, comparing);
                }
            }
        }
        return sortingList;
    }
}
