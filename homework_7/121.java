public class Solution {
    public int maxProfit(int[] prices) {
        //只需要找出最大的差值即可，即 max(prices[j] – prices[i]) ，i < j。一次遍历即可
          int min = Integer.MAX_VALUE,max=0;
           for (int i=0;i<prices.length;i++){
             min=Math.min(min,prices[i]);//找出数组中最小的元素
             max=Math.max(max,prices[i]-min);//找出数组中差距最大的两个元素
         }
         return max;
    }
}