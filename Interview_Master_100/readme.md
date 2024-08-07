# Interview Master 100

# [1] Two sum 
```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            for(int j = i+1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}
```
# [2] Valid Parentheses
```
class Solution {
    // Method to check if the given string of brackets is valid
    public boolean isValid(String s) {
        // Initialize a stack to keep track of expected closing brackets
        Stack<Character> stack = new Stack<>();
        
        // Loop through each character in the string
        for (char x : s.toCharArray()) {
            // If the character is an opening bracket, push the corresponding closing bracket onto the stack
            if (x == '(') {
                stack.push(')');
            } else if (x == '{') {
                stack.push('}');
            } else if (x == '[') {
                stack.push(']');
            }
            // If the character is a closing bracket, check for matching top of the stack
            else if (stack.isEmpty() || stack.pop() != x) {
                // If stack is empty or the top of the stack does not match the character, return false
                return false;
            }
        }
        
        // If the stack is empty, all opening brackets were properly closed; return true
        return stack.isEmpty();
    }
}

```
