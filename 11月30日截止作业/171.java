public class Solution {
    public int titleToNumber(String s) {
        s = s.toUpperCase();
		if(s == null || s.equals("")){
			return 0;
		}else{
			int length = s.length();
			int result = 0;
			for(int i = 0; i < length; i++){
				int add = s.charAt(i) - 'A' + 1;
				result = result * 26 + s.charAt(i) - 'A' + 1;
			}
			return result;
		}
    }
}