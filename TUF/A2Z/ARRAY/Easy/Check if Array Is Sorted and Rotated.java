class solution{
    public boolean check(int[] nums){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }
        if(nums[0] > nums[n-1]){
            count++;
        }
        return count <= 1;
    }
}

/*
 * class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;  // Counter to track the number of "drops" where order is violated

        // Iterate through the array, checking if the current element is greater than the next
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {  // Found a "drop" point
                count++;
            }
        }
        
        // Check for rotation: If the last element is greater than the first,
        // there might be another "drop" between nums[n-1] and nums[0].
        if (nums[0] < nums[n - 1]) {
            count++;
        }

        // If the number of "drops" is 0 or 1, the array is sorted and rotated
        return count <= 1;
    }
}

 */