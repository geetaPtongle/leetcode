class Solution {
    public int maxProfit(int[] prices) {
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
}