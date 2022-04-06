package sorting;

public class ShellSorting {

    public static void sort(double[] arr) {
        if (arr!=null) {
            int len = arr.length;
            int gap = len / 2;
            while (gap > 0) {
                for (int i = gap; i < len; i++) {
                    for (int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j -= gap) {
                        double temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
                gap /= 2;
            }
        }
    }
}
