public class Solution {
    public int reverse(int x) {
      
        long sum=0;  //���ﳤ���͵�sum���淭ת���������Ϊ��ת���ܻ����
        while(x!=0)  
        {  
            int temp=x%10;  
            sum=sum*10+temp;  
            if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)   //�������  
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