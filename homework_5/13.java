public class Solution {
// �����ַ�	
// I
// V
// X
// L
// C
// D
// M
// ��Ӧ�İ��������ֱ�ʾΪ	
// 1
// 5
// 10
// 50
// 100
// 500
// 1000
// 1.��ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
// 2.С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
// 3.С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
// 4.����ʹ��ʱ����д�������ظ����ó������Ρ��������ϵ��ĵ��ӡ�IIII�����⣩��
// 5.��һ���������滭һ�����ߡ���ʾ��������� 1000 ����
    public int romanToInt(String s) {
        if(s!=null){
            int sum=func(s.charAt(0));//��ȥs�ĵ�һ��Ԫ��
            for(int i=1;i<s.length();i++){
         //�����������ֵ�3�����򣬵���ߵ�Ԫ�ر��ұߵ�Ԫ��Сʱ����Ҫ���ұߵļ�ȥ��ߵ�Ԫ��
                if(func(s.charAt(i-1))<func(s.charAt(i)))
                 sum=sum+func(s.charAt(i))-2*func(s.charAt(i-1));
                else 
                   sum=sum+func(s.charAt(i));
            }
            return sum;
        }
        return -1;
    }
    
    int func(char c){
        switch(c){//�������ְ��������ֵĶ��ձ�
            case 'I':  return 1;  
            case 'V':  return 5; 
            case 'X':  return 10; 
            case 'L':  return 50;
            case 'C':  return 100;  
            case 'D':  return 500;
            case 'M':  return 1000; 
        }
        return 0;
    }
}