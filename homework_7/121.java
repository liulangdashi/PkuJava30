public class Solution {
    public int maxProfit(int[] prices) {
        //ֻ��Ҫ�ҳ����Ĳ�ֵ���ɣ��� max(prices[j] �C prices[i]) ��i < j��һ�α�������
          int min = Integer.MAX_VALUE,max=0;
           for (int i=0;i<prices.length;i++){
             min=Math.min(min,prices[i]);//�ҳ���������С��Ԫ��
             max=Math.max(max,prices[i]-min);//�ҳ������в����������Ԫ��
         }
         return max;
    }
}