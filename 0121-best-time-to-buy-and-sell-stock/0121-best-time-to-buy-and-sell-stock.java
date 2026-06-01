class Solution {
    public int maxProfit1(int[] prices) {
        int max_profit=0, buy_price=prices[0];
        for(int i=0; i< prices.length; i++){
           int current_prices=prices[i] - buy_price;
                if(current_prices > max_profit){                   
                    max_profit =current_prices;
                }
                if(prices[i] < buy_price){
                    buy_price=prices[i];
                }            
        }
        return max_profit;
    }

    public int maxProfit(int[] prices) {
    int mini= prices[0];
    int profit =0;
    for(int i=0; i<prices.length; i++){
        int cost= prices[i]-mini;
        profit = Math.max(profit, cost);
        mini = Math.min(mini, prices[i]);
    }
    return profit;
    }
}