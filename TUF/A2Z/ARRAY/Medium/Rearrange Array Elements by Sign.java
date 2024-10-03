//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] output = new int[nums.length];
        int odd = 0;
        int even = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) { // Positive numbers go to even index
                output[odd] = nums[i];
                odd += 2;
            } else { // Negative numbers go to odd index
                output[even] = nums[i];
                even += 2;
            }
        }
        return output;
    }
}
