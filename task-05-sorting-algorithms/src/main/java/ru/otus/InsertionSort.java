package ru.otus;

public class InsertionSort {

    static int[] sort(int[] array) {

        int swapItem, j;

        for (int i = 0; i < array.length; i++) {
            swapItem = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > swapItem) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = swapItem;
        }

        return array;
    }
}
