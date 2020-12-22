package ru.otus.sort;

public class QuickSort {

    public static void sort(short[] array) {
        sort(0, array.length - 1, array);
    }

    private static void sort(int left, int right, short[] array) {
        if (left >= right) {
            return;
        }

        final int center = partition(left, right, array);
        sort(left, center - 1, array);
        sort(center + 1, right, array);
    }

    private static int partition(int left, int right, short[] array) {
        final int pivot = array[right];
        int a = left - 1;

        for (int m = left; m <= right; m++) {
            if (array[m] <= pivot) {
                swap(++a, m, array);
            }
        }

        return a;
    }

    private static void swap(int from, int to, short[] array) {
        final short buffer = array[from];
        array[from] = array[to];
        array[to] = buffer;
    }
}
