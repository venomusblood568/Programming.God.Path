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
