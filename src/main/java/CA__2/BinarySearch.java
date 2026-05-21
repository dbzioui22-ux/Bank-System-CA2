/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

import java.util.ArrayList;

/**
 *
 * @author horatio
 */
public class BinarySearch {

    // searches for target in the list
    public static int search(ArrayList<String> list, String target) {
        // convert to array first
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return doSearch(arr, target, 0, arr.length - 1);
    }

    // the actual recursive search
    static int doSearch(String[] arr, String target, int lo, int hi) {
        if (lo > hi) {
            return -1; // didnt find it
        }

        int mid = (lo + hi) / 2;

        int compare = arr[mid].compareToIgnoreCase(target);
        if (compare == 0) {
            return mid; // found!
        }
        if (compare < 0) {
            // look in right half
            return doSearch(arr, target, mid + 1, hi);
        } else {
            // look in left half
            return doSearch(arr, target, lo, mid - 1);
        }
    }
}
