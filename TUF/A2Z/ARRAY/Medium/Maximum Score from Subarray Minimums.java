//Time Complexity: O(n)
//Space Complexity: O(1)
class solution{
    public pairWithMaxSum(List<Integer> arr) {
        int max = 0;
        for(int i = 0; i < arr.size()-1;i++){
            int sum = arr.get(i) + arr.get(i+1);
            max = Math.max(sum,max); 
        }
        return max;
    }

}