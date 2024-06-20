//826. Most Profit Assigning Work
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Step 1: Find the maximum difficulty level among all jobs
        int max = 0;
        for (int d : difficulty)
            max = Math.max(max, d);

        // Step 2: Create a DP array to store the maximum profit for each difficulty level
        int[] dp = new int[max + 1];
        for (int i = 0; i < difficulty.length; i++)
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);

        // Step 3: Fill the DP array such that dp[i] holds the maximum profit for any difficulty up to i
        for (int i = 1; i <= max; i++)
            dp[i] = Math.max(dp[i - 1], dp[i]);

        // Step 4: Calculate the total profit by assigning the best possible job to each worker
        int ans = 0;
        for (int w : worker) {
            // If worker's capability is greater than max difficulty, assign the job with max difficulty
            if (w > max)
                ans += dp[max];
            else
                // Otherwise, assign the job corresponding to worker's capability
                ans += dp[w];
        }

        // Return the total profit
        return ans;
    }
}
