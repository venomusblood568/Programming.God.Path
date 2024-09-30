// tc => O(n)
// sc => O(1)
class solution{
    public int secondlargest(int[] arr){
        int max = -1;
        int sec_max = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                sec_max = max;
                max = arr[i];
            }
            else if(arr[i] > sec_max && arr[i] < max){
                sec_max = arr[i];
            }
        }
        return sec_max;
    }
}