import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] intArray = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void bucketSort(int[] intArray) {

        List<Integer>[] buckets = new List[10];

        createListFor(buckets);

        for (int i = 0; i < intArray.length; i++) {
            int index = hashKey(intArray[i]);
            buckets[index].add(intArray[i]);
        }

        sort(buckets);

        merge(intArray, buckets);
    }

    private static void merge(int[] intArray, List<Integer>[] buckets) {
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                intArray[index++] = value;
            }
        }
    }

    private static void createListFor(List<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }
    }

    private static void sort(List<Integer>[] buckets) {
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
    }

    private static int hashKey(int value) {
        return value / 10;
    }
}
