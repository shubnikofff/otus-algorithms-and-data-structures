package ru.otus;

public class ShellSort {

    public static int[] sort(int[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i + gap < array.length; i++) {
                int j = i + gap;
                int tmp = array[j];

                while (j - gap >= 0 && array[j - gap] > tmp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = tmp;
            }
        }

        return array;
    }
}
