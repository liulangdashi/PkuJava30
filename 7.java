public class Solution {
    public int reverse(int x) {
        long result = 0;
        // int flag = -1;
        // if(x >= 0)
        // 	flag = 1;
        int flag = 1;
        if( x < 0 ){
            flag = -1;
            x *= flag;
        }
        while(x != 0){
        	int n = x % 10;
        	result = result * 10 + n;
        	x = x/10;
        }
        result *= flag;
        if(result > 2147483647 || result < -2147483648)
            return 0;
        return (int)result;
    }
}