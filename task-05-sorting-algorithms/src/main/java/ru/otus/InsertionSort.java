package ru.otus;

public class InsertionSort {

    static int[] sort(int[] array) {

        int insertItem, j;

        for (int i = 0; i < array.length; i++) {
            insertItem = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > insertItem) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = insertItem;
        }

        return array;
    }
}
