package algorithms.sortbenchmark;

import algorithms.bubblesort.BubbleSort;
import algorithms.insertionsort.ClassicInsertionSort;
import algorithms.insertionsort.MyInsertionSort;
import algorithms.selectionsort.MinMaxSelectionSort;
import algorithms.selectionsort.SelectionSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static algorithms.sortbenchmark.Stub.createBigArray;

@State(Scope.Benchmark)
public class SortSortedArrayBenchmark {

    private int[] arrayToSort;

    @Setup(Level.Trial)
    public void setUp() {
        arrayToSort = createBigArray();
    }

    private int[] copyArray() {
        return Arrays.copyOf(arrayToSort, arrayToSort.length);
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void classicInsertionSort(Blackhole bh) {
        int[] arr = copyArray();
        ClassicInsertionSort.execute(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void myInsertionSort(Blackhole bh) {
        int[] arr = copyArray();
        MyInsertionSort.execute(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void selectionSort(Blackhole bh) {
        int[] arr = copyArray();
        SelectionSort.execute(arr);
        bh.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void minMaxSelectionSort(Blackhole bh) {
        int[] arr = copyArray();
        MinMaxSelectionSort.execute(arr);
        bh.consume(arr);
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void binaryTree(Blackhole bh) {
//        int[] arr = copyArray();
//        BinaryTreeWithOO.executeAndReturnInOrderTraversal(arr);
//        bh.consume(arr);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void binaryTreeWithOO(Blackhole bh) {
//        int[] arr = copyArray();
//        BinaryTree.executeAndReturnInOrderTraversal(arr);
//        bh.consume(arr);
//    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void bubbleSort(Blackhole bh) {
        int[] arr = copyArray();
        BubbleSort.execute(arr);
        bh.consume(arr);
    }
}

