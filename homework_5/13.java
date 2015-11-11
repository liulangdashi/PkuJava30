public class Solution {
// 基本字符	
// I
// V
// X
// L
// C
// D
// M
// 相应的阿拉伯数字表示为	
// 1
// 5
// 10
// 50
// 100
// 500
// 1000
// 1.相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
// 2.小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
// 3.小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
// 4.正常使用时、连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）；
// 5.在一个数的上面画一条横线、表示这个数扩大 1000 倍。
    public int romanToInt(String s) {
        if(s!=null){
            int sum=func(s.charAt(0));//先去s的第一个元素
            for(int i=1;i<s.length();i++){
         //根据罗马数字第3条规则，当左边的元素比右边的元素小时，就要用右边的减去左边的元素
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
        switch(c){//罗马数字阿拉伯数字的对照表
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