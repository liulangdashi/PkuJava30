public class Solution {
    public int addDigits(int num) {
        int sum=0;
        while(true){
        do{
                sum+=num%10;
                num=num/10;
            }while(num!=0);//计算num各个位数的和
            if(sum/10!=0) {//如果不是一位数，那么把sum赋给num,然后把sum赋值0
                num=sum;
                sum=0;
            }
            else if(sum/10==0) //如果为一位数，那么就将这个数返回
                return sum;
        }
    }
}