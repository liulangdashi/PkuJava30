public class Solution {
    public String reverseWords(String s) {
        if(s == null)
            return null;
        String [] strs = s.split(" ");
        String result = "";
        if(strs.length == 0)
        {
            // return s;
            return result;
        }
        for(int i = strs.length-1; i>=0; i--){
        	result += strs[i];
        	if(i == 0)
        		break;
        	else if(!strs[i-1].equals("")){
        		result += " ";
        	}
        }
//        result += strs[0];
        return result;
    }
}