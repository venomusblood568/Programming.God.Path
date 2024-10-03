// TC => O(n)
// SC => O(1)
class solution{
    public void sortcolor(int nums){
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(low< high){
            if(nums[i] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[i] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public void swap(int nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}