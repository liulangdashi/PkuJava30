public class Solution {
    public String intToRoman(int num) {
        String[][] s={  
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},//第一行保1到10的罗马数字  
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},//  第二行保存10到90的罗马数字
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 第三行保存100到900的罗马数字
            {"", "M", "MM", "MMM"}  //第四行保存1000到3000的罗马数字
        };  
       if(num<1||num>3999) return "";//数字不合法就输出空字符串
       int m=0;//这个用来保存s数组的列
       int n=0;//这个用来保存s数组的行
       //StringBuilder ss=new StringBuilder("");
       String ss="";//ss用来保存要输出的罗马数字
       while(num!=0){
           m=num%10;
          // ss.append(s[n][m]).toString().reverse();
          ss=s[n][m]+ss;//这么写是保证新加入的数组元素是加在数组的前面
           n++;
           num=num/10;
       }
       //return ss.toString().reverse();
       return ss;
    }
}