public class Solution {
    public int trailingZeroes(int n) {
//      int num2 = 0;
// 		int num5 = 0;
// 		int count = 0;
// 		while(count <= n){
// 			int temp = n;
/*			while(temp != 0){
				int a = temp/2;
				if((temp - a*2) == 0){
					temp = a;
					num2++;
				}
				else{
					break;
				}
			}
*/
// 			while(temp != 0){
// 				int b = temp/5;
// 				if((temp - b*5) == 0){
// 					temp = b;
// 					num5++;
// 				}
// 				else{
// 					break;
// 				}
// 			}
// 			count += 5;
// 		}
// 		if(num2 < num5){
// 			return num2;
// 		}
// 		else{
// 			return num5;
// 		}
        int num5 = 0;
		while(n > 0){
			num5 += n/5;
			n = n/5;
		}
		return num5;
    }
}