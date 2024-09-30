//TC => O(n)
//Sc => O(1)
class solution{
    public int movezero(int[] nums){
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}