public class Solution {
    public String intToRoman(int num) {
        String[][] s={  
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},//��һ�б�1��10����������  
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},//  �ڶ��б���10��90����������
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // �����б���100��900����������
            {"", "M", "MM", "MMM"}  //�����б���1000��3000����������
        };  
       if(num<1||num>3999) return "";//���ֲ��Ϸ���������ַ���
       int m=0;//�����������s�������
       int n=0;//�����������s�������
       //StringBuilder ss=new StringBuilder("");
       String ss="";//ss��������Ҫ�������������
       while(num!=0){
           m=num%10;
          // ss.append(s[n][m]).toString().reverse();
          ss=s[n][m]+ss;//��ôд�Ǳ�֤�¼��������Ԫ���Ǽ��������ǰ��
           n++;
           num=num/10;
       }
       //return ss.toString().reverse();
       return ss;
    }
}