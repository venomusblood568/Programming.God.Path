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
# [3] Merge Two Sorted Lists 
```
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the start of the merged list
        ListNode head = new ListNode(0);
        
        // Base cases: if both lists are null, return null
        if (list1 == null && list2 == null) return null;
        
        // If list1 is null, return list2 as there is nothing to merge from list1
        if (list1 == null) return list2;
        
        // If list2 is null, return list1 as there is nothing to merge from list2
        if (list2 == null) return list1;

        // Compare the current nodes of list1 and list2
        if (list1.val > list2.val) {
            // If list1's value is greater, set head to list2
            head = list2;
            // Move list2 to the next node
            list2 = list2.next;
        } else {
            // If list2's value is greater or equal, set head to list1
            head = list1;
            // Move list1 to the next node
            list1 = list1.next;
        }

        // Recursively merge the remaining nodes of both lists
        // Set the next pointer of the current head to the result of the recursive merge
        head.next = mergeTwoLists(list1, list2);
        
        // Return the head of the merged list
        return head;
    }
}

```
# [4] Best Time to Buy and Sell Stock
```
class Solution {
    public int maxProfit(int[] prices) {
        // Initialize buy to the first element in prices
        int buy = prices[0];
        // Initialize profit to 0
        int profit = 0;
        
        // Loop through each price in the prices array
        for (int i = 0; i < prices.length; i++) {
            // If the current price is less than the current buy price
            if (prices[i] < buy) {
                // Update buy to the current price
                buy = prices[i];
            }
            // If the profit from selling at the current price is greater than the current profit
            else if (prices[i] - buy > profit) {
                // Update profit to the profit from selling at the current price
                profit = prices[i] - buy;
            }
        }
        // Return the maximum profit found
        return profit;
    }
}

```
# [5] Valid Palindrome
```
class Solution {
    public boolean isPalindrome(String s) {
        //edge case
        if(s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            char leftchar = s.charAt(left);
            char rightchar = s.charAt(right);

            if(!Character.isLetterOrDigit(leftchar)){
                left++;
            }
            else if(!Character.isLetterOrDigit(rightchar)){
                right--;
            }
            else{
                if(Character.toLowerCase(leftchar) != Character.toLowerCase(rightchar)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
```
# [6]  Invert Binary Tree
```
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: If the current node is null, return null (no tree to invert)
        if (root == null) {
            return null;
        }

        // Temporarily store the left subtree
        TreeNode temp = root.left;

        // Recursively invert the right subtree and assign it to the left child of the current node
        root.left = invertTree(root.right);

        // Recursively invert the left subtree (stored in temp) and assign it to the right child of the current node
        root.right = invertTree(temp);

        // Return the current node after its left and right children have been swapped (inverted)
        return root;
    }
}

```

# [7] Valid Anagram
```
class Solution {
    public boolean isAnagram(String s, String t) {
        // Convert the strings to character arrays
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Sort the character arrays
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Compare the sorted character arrays
        return Arrays.equals(sChars, tChars);
    }
}

```
# [8] Binary Search
```
class Solution {
    public int search(int[] nums, int target) {
        //edge case
        if(nums == null) return -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
```

# [9] Linked List Cycle
```
public class Solution {
    // Floyd's Tortoise and Hare approach
    public boolean hasCycle(ListNode head) {
        // BASE CASE: If the list is empty, there is no cycle
        if (head == null) {
            return false;
        }

        // Initialize two pointers, fast and slow, both pointing to the head of the list
        ListNode fast = head;
        ListNode slow = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            // Move fast pointer two steps ahead
            fast = fast.next.next;
            // Move slow pointer one step ahead
            slow = slow.next;

            // If slow and fast pointers meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If we reach the end of the list, there is no cycle
        return false;
    }
}

```
# [10] Maximum Depth of Binary Tree 
```
class Solution {
    public int maxDepth(TreeNode root) {
        //base case
        if(root == null){
            return 0;
        }
        // counting the left hand side
        int lh = maxDepth(root.left);
        // counting the right hand side
        int rh = maxDepth(root.right);

        // 1 is for currentnode and Math.max will select the higher value;
        return 1 + Math.max(lh,rh);
    }
}
```
# [11] Single Number
```
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0 ; i < nums.length ; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
```
# [12] Reverse Linked List
```
class Solution {
    public ListNode reverseList(ListNode head) {
        // Initialize newhead to null. This will eventually become the head of the reversed list.
        ListNode newhead = null;
        
        // Iterate through the list until head becomes null (end of the list).
        while (head != null) {
            // Store the next node in the list in a temporary variable 'next'.
            ListNode next = head.next;
            
            // Reverse the current node's pointer by making head.next point to newhead.
            head.next = newhead;
            
            // Move newhead to point to the current head. This grows the reversed list.
            newhead = head;
            
            // Move head to the next node in the original list to continue the process.
            head = next;
        }
        
        // Return newhead, which is now the head of the fully reversed list.
        return newhead;
    }
}

```

# [13] Majority Element
```
class Solution {
    public int majorityElement(int[] nums) {
        // Initialize count to 0, which will track the balance between the current majority candidate and others
        int count = 0;
        
        // Initialize the first element of the array as the initial majority candidate
        int major = nums[0];

        // Iterate through each element in the array
        for(int i : nums) {
            // If count is 0, set the current element as the new majority candidate
            if(count == 0) {
                major = i;    // Update major to the current element
                count++;      // Increment count because we have one occurrence of the new candidate
            }
            // If the current element matches the current majority candidate
            else if(i == major) {
                count++;      // Increment count because the candidate is confirmed again
            }
            // If the current element is different from the majority candidate
            else {
                count--;      // Decrement count because we have a competing element
            }
        }
        
        // After processing all elements, return the majority candidate
        return major;
    }
}

```
# [14] Missing Number

```
class Solution {
    public int missingNumber(int[] nums) {
        // Calculate the length of the array, which represents the range of numbers from 0 to n
        int n = nums.length;
        
        // Calculate the expected sum of all numbers from 0 to n using the formula n*(n+1)/2
        int expected_sum = n * (n + 1) / 2;
        
        // Initialize actual_sum to 0, which will be used to sum all elements in the array
        int actual_sum = 0;
        
        // Iterate through the array and calculate the sum of all elements
        for(int i : nums) {
            actual_sum += i;  // Add each element in nums to actual_sum
        }
        
        // The missing number is the difference between the expected sum and the actual sum
        return expected_sum - actual_sum;
    }
}

```

# [15] Reverse String

```
class Solution {
    public void reverseString(char[] s) {
        // Initialize a pointer 'i' at the beginning of the array
        int i = 0;
        
        // Initialize a pointer 'j' at the end of the array
        int j = s.length - 1;
        
        // Continue swapping characters until the pointers meet or cross
        while (i <= j) {
            // Temporarily store the character at index 'i'
            // since we are storing char so use char not int
            char temp = s[i];
            
            // Swap the character at index 'i' with the character at index 'j'
            s[i] = s[j];
            s[j] = temp;
            
            // Move the 'i' pointer one step to the right
            i++;
            
            // Move the 'j' pointer one step to the left
            j--;
        }
    }
}

```

# [16] Diameter of Binary Tree
```
class Solution {
    // Class-level variable to store the maximum diameter of the binary tree
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Start the depth-first search to compute the diameter
        depth(root);
        // Return the maximum diameter found
        return max;
    }

    private int depth(TreeNode root) {
        // Base case: if the node is null, the depth is 0
        if (root == null) return 0;

        // Recursively compute the depth of the left subtree
        int left = depth(root.left);
        // Recursively compute the depth of the right subtree
        int right = depth(root.right);

        // Update the maximum diameter using the sum of left and right subtree depths
        max = Math.max(max, left + right);

        // Return the depth of the current subtree (1 + max depth of left or right subtree)
        return 1 + Math.max(left, right);
    }
}
```
# [17] Middle of the Linked List
```
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```
# [18] Convert Sorted Array to Binary Search Tree
```
class Solution {
    // Main function to convert a sorted array to a balanced binary search tree (BST)
    public TreeNode sortedArrayToBST(int[] nums) {
        // If the input array is empty, return null (no tree to build)
        if (nums.length == 0) return null;

        // Call the helper function with the full range of the array
        return helper(nums, 0, nums.length - 1);
    }

    // Helper function to recursively build the BST from the sorted array
    private TreeNode helper(int[] nums, int left, int right) {
        // Base case: if left index exceeds right, the subtree is empty, return null
        if (left > right) return null;

        // Base case: if only one element is left, create a leaf node with that value
        if (left == right) return new TreeNode(nums[left]);

        // Calculate the middle index to maintain the balance of the BST
        int mid = (left + right) / 2;

        // Create the root node with the value at the middle index
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left subtree with the left half of the array
        root.left = helper(nums, left, mid - 1);

        // Recursively build the right subtree with the right half of the array
        root.right = helper(nums, mid + 1, right);

        // Return the constructed tree rooted at this node
        return root;
    }
}

```
# [19] Maximum Subarray 
```
class Solution {
    public int maxSubArray(int[] nums) {
        int MaxSum = Integer.MIN_VALUE;
        int CurrentSum = 0;
        for(int i = 0; i < nums.length; i++){
            CurrentSum += nums[i];
        
            if(CurrentSum > MaxSum){
                MaxSum = CurrentSum;
            }
            if(CurrentSum < 0){
                CurrentSum = 0;
            }
        }
        return MaxSum;
    }
}
```
# [20] Climbing Stairs
```
class Solution {
    // Method to calculate the number of ways to climb 'n' stairs
    public int climbStairs(int n) { // FIBONACCI
        
        // If there are 1 or 2 stairs, return n directly because:
        // - If n = 1, there's only 1 way to climb 1 stair.
        // - If n = 2, there are 2 ways to climb 2 stairs (either 1+1 or 2).
        if (n <= 2)
            return n;

        // Initialize the number of ways to get to the first and second steps
        int one = 1;  // 1 way to reach the 1st step
        int two = 2;  // 2 ways to reach the 2nd step

        // Loop through the steps starting from the 3rd step up to the nth step
        for (int i = 3; i <= n; i++) {
            // Temporarily store the value of 'one', which represents ways to get to (i-2)
            int temp = one;

            // Update 'one' to be the current 'two', which now represents ways to get to (i-1)
            one = two;

            // Update 'two' to be the sum of 'two' and 'temp', representing ways to get to the ith step
            two += temp;
        }

        // Return the number of ways to reach the nth step
        return two;
    }
}
```

# [21] Symmetric Tree

```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode lh, TreeNode rh){
        if(lh == null && rh == null){
            return true;
        }
        if(lh == null || rh == null){
            return false;
        }
        return lh.val == rh.val 
        && isMirror(lh.left, rh.right) 
        && isMirror(lh.right, rh.left);
    }
}
```
# [22] Binary Tree Level Order Traversal

```
class Solution {
    // Method to perform level order traversal of the binary tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize the list that will store the level order traversal
        List<List<Integer>> ans = new ArrayList<>();
        // Call the helper method to fill the list with nodes at each level
        helper(ans, root, 0);
        // Return the result list
        return ans;
    }

    // Helper method to perform a recursive traversal of the tree
    private void helper(List<List<Integer>> ans, TreeNode current, int level) {
        // Base case: if the current node is null, return
        if (current == null) {
            return;
        }

        // If the current level doesn't have a list yet, create one
        if (ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }

        // Add the current node's value to the list corresponding to its level
        ans.get(level).add(current.val);

        // Recursively call the helper for the left subtree, incrementing the level
        helper(ans, current.left, level + 1);

        // Recursively call the helper for the right subtree, incrementing the level
        helper(ans, current.right, level + 1);
    }
}

```

# [23] Best Time to Buy and Sell Stock II

```
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for(int i = 1; i < n ; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
```
# [24] House Robber

```
class Solution {
    public int rob(int[] nums) {
       // Edge case: If no houses exist, return 0
       if(nums.length == 0) {
           return 0;
       }
       
       // Edge case: If there's only one house, return its value
       if(nums.length == 1) {
           return nums[0];
       }

       // Initialize two variables to track maximum profit
       int p1 = 0; // Maximum profit up to the current house
       int p2 = 0; // Maximum profit up to the previous house

       // Iterate through each house's money in the array
       for(int i : nums) {
           // Temporarily store the current max profit
           int temp = p1;

           // Update p1 to be the maximum of either robbing this house or skipping it
           p1 = Math.max(p2 + i, p1);

           // Update p2 to the previous maximum (stored in temp)
           p2 = temp;
       } 

       // Return the maximum profit after processing all houses
       return p1;
    }
}

```
# [25] Number of 1 Bits

```
class Solution {
    public int hammingWeight(int n) {
        int counter = 0;
        while( n != 0){
            n = n & (n-1);
            counter++;
        }
        return counter;
    }
}
```
# [26] Validate Binary Search Tree

```
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Base case: If the tree is empt,
        if (root == null) return true;

        // Create a stack to help with the iterative in-order traversal of the tree.
        Stack<TreeNode> stack = new Stack<>();

        // Pointer to keep track of the previously visited node during traversal.
        TreeNode pre = null;

        // Main loop: Continue as long as there are nodes to process (either root is not null or stack is not empty).
        while (root != null || !stack.isEmpty()) {
            
            // Traverse to the leftmost node, pushing all nodes onto the stack.
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Pop the node from the stack (the leftmost unprocessed node).
            root = stack.pop();

            // Check if the current node's value is less than or equal to the previous node's value.
            // If it is, the tree is not a valid BST.
            if (pre != null && root.val <= pre.val) {
                return false;
            }

            // Update 'pre' to the current node, as it will be the previous node in the next iteration.
            pre = root;

            // Move to the right subtree to continue the in-order traversal.
            root = root.right;
        }

        // If the entire tree has been traversed without finding any violations, return true indicating it is a valid BST.
        return true;
    }
}

```
# [27]  Min Stack

```
class MinStack {

    public Stack<Integer> stac;
    public Stack<Integer> minStack;

    public MinStack() { 
        stac = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stac.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int a = minStack.peek();
        if(stac.pop() == a){
            minStack.pop();
        }
    }
    
    public int top() {
        return stac.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

```

# [28] Contains Duplicate

```
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
```
# [29] Kth Smallest Element in a BST

```
class Solution {
    private int count = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode node, int k ){
        if(node == null){
            return;
        }
        inorder(node.left,k);
        count++;
        if(count == k){
            result = node.val;
            return;
        }
        inorder(node.right,k);
    }

}
```
# [30] Merge Intervals

```
// SLIDING WINDOW TECHNIUQE
class Solution {
    public int[][] merge(int[][] intervals) {
       List<int[]> answer = new ArrayList<>();

       if(intervals.length != 0 || intervals != null){
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i: intervals){
            if(i[0] <= end){
                end = Math.max(end,i[1]);
            }
            else{
                answer.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        answer.add(new int[]{start,end});
       } 
       return answer.toArray(new int[0][]);
    }
}
```

# [31] Set Matrix Zeroes

```
class Solution {
    public void setZeroes(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;

       int[] row = new int [m];
       int[] col = new int [n];

       for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] == 1 || col[j] ==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```

# [32] Spiral Matrix

```
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0){
            return result;
        }

        int rows = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int  right = col - 1;
        int top = 0;
        int bottom = rows - 1;

        while(left <= right && top <= bottom){
            for(int i = left; i <= right ; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom ; i++){
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
```

# [33] 3Sum

```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length -2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    while(j < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k-1]){
                        k--;
                    }

                    j++;
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }
}
```

# [34] Binary Tree Zigzag Level Order Traversal

```
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList <>();
        helper(root,0,res);
        return res;
    }
    private void helper(TreeNode root, int level,List<List<Integer>> list){
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add(new ArrayList<>());
        }
        if(level % 2 == 0){
            list.get(level).add(root.val);
        }
        else{
            list.get(level).add(0,root.val);
        }
        helper(root.left, level+1,list);
        helper(root.right,level+1,list);
    }
}
```

# [35] Construct Binary Tree from Preorder and Inorder Traversal

```
class Solution {
    int prestart = 0;
    int instart = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder,int[]inorder,int inend){
        if(prestart >= preorder.length){
            return null;
        }

        if(inorder[instart] == inend){
            instart++;
            return null;    
        }

        TreeNode root = new TreeNode(preorder[prestart++]);
        root.left = build(preorder,inorder,root.val);
        root.right = build(preorder,inorder,inend);
        return root;

    }
}
```
# [36]  Container With Most Water 

```
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxarea =0;

        while(left < right){
            int currentarea = Math.min(height[left],height[right]) * (right - left);
            maxarea = Math.max(maxarea , currentarea);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
    }
}
```
# [37] Flatten Binary Tree to Linked List

```
class Solution {
    private TreeNode prev = null; // Previous node in flattened list

    public void flatten(TreeNode root) {
        if (root == null) // Base case: end of recursion
            return;
        
        flatten(root.right); // Flatten right subtree
        
        flatten(root.left); // Flatten left subtree
        
        root.right = prev; // Link right to previously processed node
        root.left = null; // Set left to null (no left child in flattened list)
        
        prev = root; // Update prev to current node
    }

}
```

# [38] Group Anagrams

```
class Solution {
    public List<List<String>> groupAnagrams(String[] words) {
        Map<String,List<String>> anagramgroup = new HashMap<>();

        for(String word: words){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if(!anagramgroup.containsKey(key)){
                anagramgroup.put(key,new ArrayList<>(List.of(word)));
            }
            else{
                anagramgroup.get(key).add(word);
            }
        }

        return new ArrayList<>(anagramgroup.values());
    }
}
```

# [39]  Implement Trie (Prefix Tree)
```
class Trie {
    Node root; // Root node of the Trie

    public Trie() {
        root = new Node(); // Initialize root node
    }

    public void insert(String word) {
        root.insert(word, 0); // Insert the word starting at root
    }

    public boolean search(String word) {
        return root.search(word, 0); // Search for the word starting at root
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0); // Check prefix starting at root
    }
}

class Node {
    Node[] nodes; // Array to store child nodes (26 for each letter)
    boolean isEnd; // Marks if the node is the end of a word

    Node() {
        nodes = new Node[26]; // Initialize nodes array for each letter
    }

    // Insert a word starting from a specific index
    public void insert(String word, int idx) {
        if (idx >= word.length()) {
            return; // End recursion if index exceeds word length
        }
        int i = word.charAt(idx) - 'a'; // Find the position of the current letter
        if (nodes[i] == null) {
            nodes[i] = new Node(); // Create a new node if it doesn't exist
        }
        if (idx == word.length() - 1) {
            nodes[i].isEnd = true; // Mark end of the word
        }
        nodes[i].insert(word, idx + 1); // Recursively insert the rest of the word
    }

    // Search for a word starting from a specific index
    public boolean search(String word, int idx) {
        if (idx >= word.length()) {
            return false; // End of word not reached
        }
        Node node = nodes[word.charAt(idx) - 'a']; // Get the node for the current letter
        if (node == null) {
            return false; // If the node doesn't exist, the word doesn't exist
        }
        if (idx == word.length() - 1 && node.isEnd) {
            return true; // Word found if it's the end
        }
        return node.search(word, idx + 1); // Recursively search the rest of the word
    }

    // Check if a prefix exists, starting from a specific index
    public boolean startsWith(String prefix, int idx) {
        if (idx >= prefix.length()) {
            return false; // End of prefix not reached
        }
        Node node = nodes[prefix.charAt(idx) - 'a']; // Get the node for the current letter
        if (node == null) {
            return false; // If the node doesn't exist, the prefix doesn't exist
        }
        if (idx == prefix.length() - 1) {
            return true; // Prefix found
        }
        return node.startsWith(prefix, idx + 1); // Recursively check the rest of the prefix
    }
}
```
# [40] Kth Largest Element in an Array

```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0; // Start index of the array
        int end = nums.length - 1; // End index of the array
        int index = nums.length - k; // Index to find (0-based index)

        while(start <= end) {
            int pivot = partition(nums, start, end); // Partition and get pivot index
            if(pivot < index) {
                start = pivot + 1; // Search right part
            } else if(pivot > index) {
                end = pivot - 1; // Search left part
            } else {
                return nums[pivot]; // Found the k-th largest element
            }
        }
        return nums[start]; // Return element if not found by partition
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start]; // Choose pivot
        int left = start + 1; // Left pointer
        int right = end; // Right pointer

        while(left <= right) {
            while(left <= right && nums[left] <= pivot) {
                left++; // Move left pointer right
            }
            while(left <= right && nums[right] > pivot) {
                right--; // Move right pointer left
            }
            if(left <= right) {
                swap(nums, left, right); // Swap elements
                left++;
                right--;
            }
        }
        swap(nums, start, right); // Place pivot in correct position
        return right; // Return pivot index
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; // Swap elements
    }
}

```
# [41] Find Peak Element

```
class Solution {
    int start = 0; // Start index of the longest palindrome found
    int max = 0;   // Length of the longest palindrome found
    
    // Main function to find the longest palindromic substring
    public String longestPalindrome(String s) {
        // If the string length is less than 2, return the string itself
        if(s.length() < 2){
            return s;
        }

        // Convert the string to a character array for easier manipulation
        char[] chars = s.toCharArray();

        // Iterate through each character in the string
        for(int i = 0; i < chars.length; i++){
            // Check for odd length palindromes centered at i
            helper(chars, i, i);
            // Check for even length palindromes centered between i and i+1
            helper(chars, i, i + 1);
        }

        // Return the longest palindromic substring found
        return s.substring(start, start + max);
    }

    // Helper function to expand around the center and check for palindromes
    private void helper(char[] chars, int j, int k){
        // Expand outwards as long as the characters match and are within bounds
        while(j >= 0 && k < chars.length && chars[j] == chars[k]){
            j--; // Move left pointer leftwards
            k++; // Move right pointer rightwards
        }
        // Update max length and start index if a longer palindrome is found
        if(max < k - j - 1){
            max = k - j - 1; // Update max with the new length of the palindrome
            start = j + 1;   // Update start to the new starting index of the palindrome
        }
    }
}

```
# [42] Longest Substring Without Repeating Characters
```
//second approach 
//tc => O(n^2) and sc => O(1) 
// tc => O(n) and sc = O(m,n) this is for sliding window technique

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lp = 0; // Left pointer (start of the current window)
        int rp = 0; // Right pointer (end of the current window)
        int maxLen = 0; // Variable to store the maximum length of substring without repeating characters
        
        // Traverse the string with the right pointer
        while (rp < s.length()) {
            char c = s.charAt(rp); // Get the current character at the right pointer
            
            // Check for duplicates by scanning the current window [lp, rp)
            for (int i = lp; i < rp; i++) {
                if (s.charAt(i) == c) { // If a duplicate is found
                    lp = i + 1; // Move the left pointer to the right of the duplicate character
                    break; // Exit the loop since we've handled the duplicate
                }
            }
            
            // Calculate the length of the current window and update maxLen if it's the longest found so far
            maxLen = Math.max(maxLen, rp - lp + 1);
            
            // Move the right pointer to the next character
            rp++;
        }
        
        return maxLen; // Return the maximum length of substring without repeating characters
    }
}

```
# [47] Permutations
```
import java.util.ArrayList;  // Import ArrayList class for using list data structures
import java.util.List;       // Import List interface

class Solution {
    // List to store all the permutations of the given array
    private List<List<Integer>> ans = new ArrayList<>();

    // Helper method to perform the recursive permutation generation
    private void recursion_helper(int[] nums, int i) {
        // Base case: If the current index i equals the length of the array
        if (i == nums.length) {
            // Create a new list to store the current permutation
            List<Integer> temp = new ArrayList<>();
            // Add all elements of nums to temp
            for (int num : nums) {
                temp.add(num);
            }
            // Add the current permutation to the ans list
            ans.add(temp);
            // Exit the recursion at this branch
            return;
        }
        // Loop through the array starting from index i to generate permutations
        for (int j = i; j < nums.length; j++) {
            // Swap the element at index i with the element at index j
            swap(nums, i, j);
            // Recursively call the helper method with the next index
            recursion_helper(nums, i + 1);
            // Swap back to restore the original array order (backtrack)
            swap(nums, i, j);
        }
    }

    // Method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        // Temporary variable to hold the value during swapping
        int temp = nums[i];
        // Swap the elements
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Public method to generate all permutations of the given array
    public List<List<Integer>> permute(int[] nums) {
        // Start the recursion with the initial index 0
        recursion_helper(nums, 0);
        // Return the list containing all permutations
        return ans;
    }
}

```


***
***

# [98] Find Peak Element

```
//binary search 
class Solution {
    public int findPeakElement(int[] nums) {

        // for base case 1
        if(nums.length == 1){
            return 0;
        }
        
        int n = nums.length;

        // for base case 2
        if(nums[0] > nums[1]){
            return 0;
        }
        // for base case 3
        if(nums[n-1] > nums[n-2]){
            return n-1;
        }

        int low = 1;
        int high = n - 2;

        while(low <= high){
            int mid = low + ((high-low) / 2 );
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(nums[mid] < nums[mid - 1]){
                high = mid - 1;
            }
            else if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
        }
        return -1;
    }
}
```

# [99] Find Minimum in Rotated Sorted Array

```
#binary search approach
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1; 
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + ((high - low)/2);
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }else{
                ans = Math.min(ans,nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
```

# [100] Remove Duplicates from Sorted Array

```
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int count = 1;
        
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] != nums[i-1]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
```
