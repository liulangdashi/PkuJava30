public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str1=new StringBuilder();//str��������s����ĸ������
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='0'&&s.charAt(i)<='9')
                str1.append(s.charAt(i));
        }
        StringBuilder str2=new StringBuilder(str1);
        str2.reverse();//str2��������str1���ַ�����ת
        String s1=str1.toString().toLowerCase();//�������ַ�������ĸ�����Сд
        String s2=str2.toString().toLowerCase();
        return (s1.equals(s2)?true:false);
    }
}