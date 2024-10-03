import java.util.ArrayList;

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            boolean leader = true;
            for(int j = i+1; j < n;j++){
                if(arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader){
                ans.add(arr[i]);
            }
        }
        return ans;

    }
}