//TC => O(n)
//Sc => O(1)
class solution{
    public int removeDuplicate(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}