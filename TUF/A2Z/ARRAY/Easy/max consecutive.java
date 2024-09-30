class solution{
    public int find_max_con_once(int[] nums){
        int count = 0;
        int maxcount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxcount = Math.max(maxcount, count);
            }else{
                count = 0;
            }
        }
        return maxcount;
    }
}