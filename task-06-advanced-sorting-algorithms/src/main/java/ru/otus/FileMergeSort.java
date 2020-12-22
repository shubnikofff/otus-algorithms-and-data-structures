package ru.otus;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMergeSort {

    private static final int MAX_SIZE_FOR_IN_MEMORY_SORTING = 10_000;

    public static void sort(String filename) throws IOException {
        try (final RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            sort(0, file.length() / 2 - 1, file);
        }
    }

    private static void sort(long left, long right, RandomAccessFile file) throws IOException {
        if (left >= right) {
            return;
        }

        if (right - left < MAX_SIZE_FOR_IN_MEMORY_SORTING) {
            sortInMemory(left, right, file);
            return;
        }

        final long pivot = (left + right) / 2;

        sort(left, pivot, file);
        sort(pivot + 1, right, file);
        merge(left, pivot, right, file);
    }

    private static void sortInMemory(long left, long right, RandomAccessFile file) throws IOException {
        final short[] array = new short[(int) (right - left) + 1];
        file.seek(left * 2);
        for (int i = 0; i < array.length; i++) {
            array[i] = file.readShort();
        }
        QuickSort.sort(array);
        file.seek(left * 2);
        for (short value : array) {
            file.writeShort(value);
        }
    }

    private static void merge(long left, long pivot, long right, RandomAccessFile file) throws IOException {
        long l = left;
        long r = pivot + 1;
        final String mergeFilename = "tmp" + File.separator + left + "_" + pivot + "_" + right;

        try (final RandomAccessFile mergeFile = new RandomAccessFile(mergeFilename, "rw")) {
            while (l <= pivot && r <= right) {
                file.seek(l * 2);
                final short leftItem = file.readShort();
                file.seek(r * 2);
                final short rightItem = file.readShort();

                if (leftItem < rightItem) {
                    mergeFile.writeShort(leftItem);
                    l++;
                } else {
                    mergeFile.writeShort(rightItem);
                    r++;
                }
            }

            while (l <= pivot) {
                file.seek(l++ * 2);
                mergeFile.writeShort(file.readShort());
            }

            while (r <= right) {
                file.seek(r++ * 2);
                mergeFile.writeShort(file.readShort());
            }

            for (long i = left; i <= right; i++) {
                file.seek(i * 2);
                mergeFile.seek((i - left) * 2);
                file.writeShort(mergeFile.readShort());
            }
        }

        Files.deleteIfExists(Path.of(mergeFilename));
    }
}
