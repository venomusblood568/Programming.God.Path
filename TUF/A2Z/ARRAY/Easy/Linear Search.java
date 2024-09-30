//TC => O(n)
//SC => O(1)

class solution{
    public int linear_search(int[] nums, int N, int K){
        for(int i = 0; i < N; i++){
            if(nums[i] == K){
                return 1;
            }
        }
        return -1;
    }
}