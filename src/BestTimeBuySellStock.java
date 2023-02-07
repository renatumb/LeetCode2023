// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        
        int left = 0;
        int maxP = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[left]) {
                left = i;
            }
            maxP = Math.max(maxP, prices[i] - prices[left]);
        }
        return maxP;
    }
}
