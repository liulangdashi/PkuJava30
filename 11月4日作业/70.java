public class Solution {
    public int climbStairs(int n) {
        int f1 = 0;
        int f2 = 0;
        if(n==0){
            f2 = 0;
        }
        else if(n == 1){
            f2 = 1;
        }
        else if(n == 2){
            f2 = 2;
        }
        else{
            f1 = 1;
            f2 = 2;
            int count = 3;
            do{
                // int temp = f1;
                // f1 = f1 + f2;
                // f2 = temp;
                int temp = f2;
                f2 = f1 + f2;
                f1 = temp;
                count++;
            }while(count <= n);
        }
        // return f1;
        return f2;
    }
}