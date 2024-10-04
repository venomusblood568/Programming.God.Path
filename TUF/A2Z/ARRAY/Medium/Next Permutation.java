class solution{
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            Arrays.sort(nums,0,n);
            return;
        }

        for(int i = n-1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        Arrays.sort(nums,index+1,n);
    }
}