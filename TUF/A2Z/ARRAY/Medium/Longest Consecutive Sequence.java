class solution{
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
       if( n == 0){
        return 0;
       } 
       Arrays.sort(nums);
       int maxi = 0;
       int count = 1;
       
       for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    count++;
                }else{
                    maxi = Math.max(maxi, count);
                    count = 1;
                }
            }
        }
        return Math.max(count,maxi);
    }
}