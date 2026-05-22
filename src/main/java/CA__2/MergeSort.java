/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

import java.util.ArrayList;

/**
 *
 * @author driss
 */
public class MergeSort {

    // sorts the list recursively
    public static ArrayList<String> sort(ArrayList<String> list) {
        // if only 1 thing its already sorted
        if (list.size() <= 1) {
            return list;
        }

        int middle = list.size() / 2;

        // split into 2 halves
        ArrayList<String> leftHalf = new ArrayList<>(list.subList(0, middle));
        ArrayList<String> rightHalf = new ArrayList<>(list.subList(middle, list.size()));

        // sort each half (this is the recursive bit)
        leftHalf = sort(leftHalf);
        rightHalf = sort(rightHalf);

        // put them back together
        return mergeTogether(leftHalf, rightHalf);
    }

    // merges 2 sorted lists into 1
    static ArrayList<String> mergeTogether(ArrayList<String> left, ArrayList<String> right) {
        ArrayList<String> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            // compare ignoring case
            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // add leftover from left
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        // add leftover from right
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }
}
