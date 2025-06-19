import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Sort {

    // Time Complexity: O(n*n)
    public static void selectionSort(int[] arr){
        long start = System.nanoTime();
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        long end = System.nanoTime();
        System.out.print("Selection Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Time Taken: "+ (end - start)/ 1_000_000.0+ " ms");
    }

    public static void insertionSort(int[] arr){

    }

    public static void bubbleSort(int[] arr){
        boolean swapped = false;
        int temp;
        long start = System.nanoTime();
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
        long end = System.nanoTime();
        System.out.print("Bubble Sort:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Time Taken: "+ (end - start)/ 1_000_000.0+" ms");
    }

    public static void mergeSort(int[] arr){

    }

    public static void quickSort(int[] arr){

    }

    public static void heapSort(int[] arr){

    }
}
