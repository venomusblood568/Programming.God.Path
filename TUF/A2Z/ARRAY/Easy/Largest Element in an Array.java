class Solution{
    public static int largest(int[] arr){
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
//tc => O(n)
//sc => O(1)