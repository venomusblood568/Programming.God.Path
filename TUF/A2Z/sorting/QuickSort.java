public class QuickSort {

    // Method to perform quicksort on the array
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find the pivot index
            int pivotIndex = partition(array, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Method to partition the array based on the pivot
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choosing the last element as the pivot
        int i = low - 1;  // Index of the smaller element
        
        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot, swap it
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element to its correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1; // Return the partitioning index
    }

    // Main method to test the sorting algorithm
    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62, 32};
        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        
        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
