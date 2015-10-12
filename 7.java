public class Solution {
    public int reverse(int x) {
      
        long sum=0;  //这里长整型的sum保存翻转后的数，因为翻转可能会溢出
        while(x!=0)  
        {  
            int temp=x%10;  
            sum=sum*10+temp;  
            if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)   //溢出处理  
            {  
                sum=sum>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;    
               // return (int)sum;  
               return 0;  
            }  
            x=x/10;  
        }  
        return (int)sum;  
    }
}