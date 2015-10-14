public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str1=new StringBuilder();//str用来保存s中字母和数字
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='0'&&s.charAt(i)<='9')
                str1.append(s.charAt(i));
        }
        StringBuilder str2=new StringBuilder(str1);
        str2.reverse();//str2用来保存str1的字符串反转
        String s1=str1.toString().toLowerCase();//将两个字符串的字母都变成小写
        String s2=str2.toString().toLowerCase();
        return (s1.equals(s2)?true:false);
    }
}