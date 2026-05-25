package algorithms;

import algorithms.binarytree.BinaryTree;
import algorithms.binarytree.oo.BinaryTreeWithOO;
import algorithms.insertionsort.ClassicInsertionSort;
import algorithms.insertionsort.MyInsertionSort;
import algorithms.selectionsort.SelectionSort;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;

@State(Scope.Benchmark)
public class SortBenchmark {

    private int[] baseArray;
    private static final int SIZE = 10000;

    @Setup(Level.Trial)
    public void setUp() {
        baseArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            baseArray[i] = i;
        }
        Random rnd = new Random(123);
        for (int i = SIZE - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int t = baseArray[i];
            baseArray[i] = baseArray[j];
            baseArray[j] = t;
        }
    }

    private int[] copyArray() {
        return Arrays.copyOf(baseArray, baseArray.length);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkClassicInsertionSort(Blackhole bh) {
        int[] arr = copyArray();
        ClassicInsertionSort.execute(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkMyInsertionSort(Blackhole bh) {
        int[] arr = copyArray();
        MyInsertionSort.execute(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkSelectionSort(Blackhole bh) {
        int[] arr = copyArray();
        SelectionSort.execute(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkBinaryTree(Blackhole bh) {
        int[] arr = copyArray();
        BinaryTreeWithOO.executeAndReturnInOrderTraversal(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkBinaryTreeWithOO(Blackhole bh) {
        int[] arr = copyArray();
        BinaryTree.executeAndReturnInOrderTraversal(arr);
        bh.consume(arr);
    }
}

