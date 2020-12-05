package ru.otus;

public class InsertionSort {

    static int[] sort(int[] array) {

        final int length = array.length;
        int currentItem, j;

        for (int i = 0; i < length; i++) {
            currentItem = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > currentItem) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = currentItem;
        }

        return array;
    }
}
