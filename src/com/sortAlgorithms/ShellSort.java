package com.sortAlgorithms;

import java.util.ArrayList;

/**
 * Created by FPT on 11/10/2016.
 * Description: This class implements Shell Sort algorithms
 * Complexity Analysis:
 * - Best case: when the list is nearly sorted descendantly, then the inner if will always be true, which also means that the
 * inner most loop will never be executed. That will lead to a O(nlogn)
 * - Worst case: when the list is nearly sorted ascendently, then the inner if will always be true, which also means that
 * the inner most loop will be executed most of the time. That will lead to a O(n(logn)^2)
 */
public class ShellSort {
    public static <T extends Comparable<T>>ArrayList<T> sort(ArrayList<T> sortingList)
    {
        int interval = sortingList.size()/2;
        while(interval>0) //This takes logn operations
        {
            int outer = interval;
            while (outer < sortingList.size()){ //This takes n/2 operations
                T current = sortingList.get(outer);
                int inner = outer - interval;
                T comparing = sortingList.get(inner);
                if(current.compareTo(comparing) >0)
                {
                    sortingList.set(outer, comparing);
                    boolean found = false;
                    while((inner - interval) >=0 && !found) //This takes logn operations
                    {
                        comparing = sortingList.get(inner - interval);
                        if(current.compareTo(comparing) >0)
                        {
                            sortingList.set(inner, comparing);
                            inner -= interval;
                        }
                        else
                        {
                            found = true;
                        }
                    }
                    sortingList.set(inner, current);
                }
                outer ++;
            }

            interval /=2;
        }

        return sortingList;
    }
}
