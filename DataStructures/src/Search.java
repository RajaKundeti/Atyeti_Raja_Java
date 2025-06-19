public class Search {

    public static void linearSearch(int[] arr, int element){
        for (int j : arr) {
            if (j == element) System.out.println("Element found!");
        }
    }

    public static void binarySearch(int[] arr, int element){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if (arr[mid] == element)
                System.out.println("Element found!");
            if (arr[mid] < element)
                low = mid+1;
            else
                high = mid-1;
        }
        System.out.println("Element not found!");
    }
}
