package com.sortAlgorithms;

import java.util.ArrayList;

/**
 * Created by FPT on 11/9/2016.
 * \Description: This class implements Selection Sort algorithms
 */
public class SelectionSort {
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> sortingList) {

        for (int i = 0; i < (sortingList.size() - 1); i++) {
            T largest = sortingList.get(i);
            int largestIndex = i;
            for (int j = i + 1; j < sortingList.size(); j++) {
                int comparison = largest.compareTo(sortingList.get(j));
                if (comparison <0) {
                    largest = sortingList.get(j);
                    largestIndex = j;
                }
            }
            if (largestIndex != i) {
                T transition = sortingList.get(i);
                sortingList.set(i, sortingList.get(largestIndex));
                sortingList.set(largestIndex, transition);
            }
        }
        return sortingList;
    }
}
