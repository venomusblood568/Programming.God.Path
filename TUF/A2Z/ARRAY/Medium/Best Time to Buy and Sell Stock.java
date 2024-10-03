//Time Complexity: O(n)
//Space Complexity: O(1)
class solution{
    public void int buyandsell(int prices){
        int buy = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > buy){
                buy = prices[i];
            }
            else if(prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}