public class Solution{
   static void bubblesort(int[] arr, int n){
      for(int i = n-1; i >= 1; i--){
         for(int j = 0; j <= i - 1; j++){
            if(arr[j] > arr[j+1]){
               int temp = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = temp;
            }
         }
      }
   } 
}

//flagged version
/*
   public class Solution{
   static void bubblesort(int[] arr, int n){
      for(int i = n-1; i >= 1; i--){
         int didswap = 0;  // Flag to check if any swap was made
         for(int j = 0; j <= i - 1; j++){
            if(arr[j] > arr[j+1]){
               // Swap the elements if they are in the wrong order
               int temp = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = temp;
               didswap = 1;  // Set the flag if a swap is made
            }
         }
         // If no swap occurred, the array is already sorted, so break early
         if(didswap == 0){
            break;
         }
      }
   }
}

*/

//Recursive way
/*
   public class Solution {
    
      // Recursive bubble sort function
      static void bubbleSortRecursive(int[] arr, int n) {
        // Base case: if there is only one element, it's already sorted
        if (n == 1) {
            return;
        }

        // Perform one pass of bubble sort (move the largest element to the end)
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap arr[i] and arr[i + 1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursively call bubble sort on the remaining array
        bubbleSortRecursive(arr, n - 1);
   }
 */