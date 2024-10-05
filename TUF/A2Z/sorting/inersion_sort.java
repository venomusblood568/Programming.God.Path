public class inersion_sort{
    static void in_sort(int[] arr, int n){
        for(int i = 0; i < n-1; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}

/*
public class solution{
    static void in_sort_recursion(int[] arr, int i , int n){
        if(i == n) return;
        int j = i;
        while(j > 0 && arr[j-1] > arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
        in_sort_recursion(arr , i+1, n);
    }
} 
*/