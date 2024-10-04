import java.util.List;

class Solution{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if(matrix == null || matrix.length == 0){
            return ans;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;

        while(left <= right && top <= bottom){
            // Traverse from left to right
            for(int i = left; i <= right ; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            
            // Traverse from top to bottom on the rightmost column
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            
            // Traverse from right to left on the bottom row (if needed)
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from bottom to top on the leftmost column (if needed)
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
