package com.sortAlgorithms;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by FPT on 11/10/2016.
 * Description: This class implements QuickSort algorithms
 */
public class QuickSort {
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> sortingList)
    {
        if(sortingList.size() < 1)
        {
            return sortingList;
        }
        else if (sortingList.size() == 2)
        {
            T firstItem = sortingList.get(0);
            T secondItem = sortingList.get(1);
            if(firstItem.compareTo(secondItem) <0)
            {
                sortingList.set(0, secondItem);
                sortingList.set(1, firstItem);
            }
            return sortingList;
        }
        else
        {
            T pivot = sortingList.get(0);
            ArrayList<T> sortedList = new ArrayList<>(sortingList.size());
            ArrayList<T> lower = new ArrayList<>(sortingList.size()/2);
            ArrayList<T> upper = new ArrayList<>(sortingList.size()/2);
            for(int i = 1; i<sortingList.size(); i++){
                T current = sortingList.get(i);
                if(current.compareTo(pivot)<0){
                    lower.add(current);
                } else {
                    upper.add(current);
                }
            }
            sortedList.addAll(sort(upper));
            sortedList.add(pivot);
            sortedList.addAll(sort(lower));
            return sortedList;
        }
    }
}
