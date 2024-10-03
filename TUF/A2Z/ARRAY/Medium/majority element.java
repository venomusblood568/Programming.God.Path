// TC => O(n)
// SC => O(1)
class solution{
    public class majority(int nums){
        int count = 0;
        int majority = nums[0];
        for(int i : nums){
            if(count == 0){
                majority = i;
                count++;
            }
            else if(i == majority){
                count++;
            }
            else{
                count--;
            }
        }
        return majority;
    }
}