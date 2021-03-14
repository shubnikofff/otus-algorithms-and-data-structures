package ru.otus.kruskal;

import java.util.stream.IntStream;

public class DisjointSetSystem {

    private final int[] set;

    private final int[] rank;

    public DisjointSetSystem(int size) {
        rank = new int[size];
        set = IntStream.range(0, size).toArray();
    }

    private int getSetOf(int x) {
        return x == set[x] ? x : (set[x] = getSetOf(set[x]));
    }

    boolean union(int a, int b) {
        final int setA = getSetOf(a);
        final int setB = getSetOf(b);

        if (setA == setB) {
            return false;
        }

        if (rank[setA] < rank[setB]) {
            set[setA] = setB;
        } else {
            set[setB] = setA;
            if (rank[setA] == rank[setB]) {
                rank[setA]++;
            }
        }

        return true;
    }
}
