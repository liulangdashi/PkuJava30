public class Solution {
    public int addDigits(int num) {
        int sum=0;
        while(true){
        do{
                sum+=num%10;
                num=num/10;
            }while(num!=0);//����num����λ���ĺ�
            if(sum/10!=0) {//�������һλ������ô��sum����num,Ȼ���sum��ֵ0
                num=sum;
                sum=0;
            }
            else if(sum/10==0) //���Ϊһλ������ô�ͽ����������
                return sum;
        }
    }
}