class solution{
    public int missingNumber(int[] nums){
        int n = nums.length;
        int expected_sum = n * (n+1)/2;
        int actual_sum = 0;
        for(int i: nums){
            actual_sum += i;
        }
        return expected_sum - actual_sum;
    }
}