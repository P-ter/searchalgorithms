package com.sortAlgorithms;

import java.util.ArrayList;

/**
 * Created by FPT on 11/10/2016.
 * Description: This class implements Merge Sort algorithms
 */
public class MergeSort {
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> sortingList)
    {
        if(sortingList.size() <= 1)
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
            int middleIndex = sortingList.size()/2;
            ArrayList<T> subList = new ArrayList<>(sortingList.size());
            ArrayList<T> mergingList1 =  sort(new ArrayList<T>(sortingList.subList(0, middleIndex)));
            ArrayList<T> mergingList2 = sort(new ArrayList<T>(sortingList.subList(middleIndex, sortingList.size())));
            int l1Index = 0;
            int l2Index =0;
            while(l1Index<mergingList1.size() && l2Index<mergingList2.size())
            {
                T firstItem = mergingList1.get(l1Index);
                T secondItem = mergingList2.get(l2Index);
                if(firstItem.compareTo(secondItem) >0)
                {
                    subList.add(firstItem);
                    l1Index++;
                }else {
                    subList.add(secondItem);
                    l2Index++;
                }
            }
            if(l1Index == mergingList1.size() && l2Index < mergingList2.size()){
                subList.addAll(mergingList2.subList(l2Index, mergingList2.size()));
            } else if (l2Index== mergingList2.size() && l1Index < mergingList1.size()){
                subList.addAll(mergingList1.subList(l1Index, mergingList1.size()));
            }

            return subList;
        }
    }
}
