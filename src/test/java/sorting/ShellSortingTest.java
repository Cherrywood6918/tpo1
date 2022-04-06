package sorting;

import org.junit.jupiter.api.Test;
import sorting.ShellSorting;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortingTest {

    @Test
    void sortRandomlyUnsortedArray() {
        double[] arr = {3.232, 0.231, 0.563, Double.MAX_VALUE, 7.984, 2, 5.232, 4.321, Double.MIN_VALUE, 6.0012};
        ShellSorting.sort(arr);
        assertArrayEquals(new double[]{Double.MIN_VALUE, 0.231, 0.563, 2, 3.232, 4.321, 5.232, 6.0012, 7.984, Double.MAX_VALUE}, arr);
    }

    @Test
    void sortAlreadySortedArray() {
        double[] arr = {Double.MIN_VALUE, 0.231, 0.563, 2, 3.232, 4.321, 5.232, 6.0012, 7.984, Double.MAX_VALUE};
        ShellSorting.sort(arr);
        assertArrayEquals(new double[]{Double.MIN_VALUE, 0.231, 0.563, 2, 3.232, 4.321, 5.232, 6.0012, 7.984, Double.MAX_VALUE}, arr);
    }

    @Test
    void sortReverseSortedArray() {
        double[] arr = {Double.MAX_VALUE, 7.984, 6.0012, 5.232, 4.321, 3.232, 2, 0.563, 0.231, Double.MIN_VALUE};
        ShellSorting.sort(arr);
        assertArrayEquals(new double[]{Double.MIN_VALUE, 0.231, 0.563, 2, 3.232, 4.321, 5.232, 6.0012, 7.984, Double.MAX_VALUE}, arr);
    }

    @Test
    void sortArrayAllWhoseValuesAreSame() {
        double[] arr = {1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5};
        ShellSorting.sort(arr);
        assertArrayEquals(new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}, arr);
    }

    @Test
    void sortArrayWithRepeatedValues() {
        double[] arr = {Double.MAX_VALUE, 0.231, 8.42, 5.232, 4.321, 3.232, 2, 8.42, 0.231, Double.MIN_VALUE};
        ShellSorting.sort(arr);
        assertArrayEquals(new double[]{Double.MIN_VALUE, 0.231, 0.231, 2, 3.232, 4.321, 5.232, 8.42, 8.42, Double.MAX_VALUE}, arr);
    }

    @Test
    void sortArrayIfArrayIsEmpty() {
        double[] arr = {};
        ShellSorting.sort(arr);
        assertArrayEquals(new double[]{}, arr);
    }

    @Test
    void sortArrayIfNull() {
        double[] arr = null;
        ShellSorting.sort(arr);
        assertArrayEquals(null, arr);
    }


}
