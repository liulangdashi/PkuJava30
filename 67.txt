public class Solution {
    public String addBinary(String a, String b) {
    	if(a==null || b==null)
    		return null;
    	int len1 = a.length();
        int len2 = b.length();
        String solutionString= null;
        if(len1 < len2)
        	solutionString = deal(a, b, len1, len2);
        else
        	solutionString = deal(b, a, len2, len1);
        return solutionString;
        
    }
    public String deal(String a, String b, int len1, int len2)
    {
    	String sum = "";
    	String add = "0";
    	for(int i = len2-1; i >= 0; i--){
    		if(i >= len2 - len1){
    			if(a.charAt(i-len2+len1) =='0' && b.charAt(i)=='0'){
    				sum = add + sum;
    				add ="0";
    			}
    			else if((a.charAt(i-len2+len1) == '0' && b.charAt(i)=='1')
    					||(a.charAt(i-len2+len1) =='1' && b.charAt(i)=='0')){
    				if(add.equals("0")){
    					sum = "1" + sum;
    					add = "0";
    				}
    				else{
    					sum = "0" + sum;
    					add = "1";
    				}
//    				int num = 1 + Integer.getInteger(add);
//    				add = Integer.toString(num/2);
//    				num %=2;
//    				sum.add(0, Integer.toString(num));
    			}
    			else if(a.charAt(i-len2+len1) == '1' && b.charAt(i)=='1'){
    				// sum = "0" + sum;
    				sum = add + sum;
    				add = "1";
    			}
    		}
    		else{
	    		if(b.charAt(i)=='0'){
	    			sum = add + sum;
					add = "0";
				// 	break;
	    		}
	    		else if(b.charAt(i) == '1'){
	    			if(add.equals("0")){
	    				sum = "1" + sum;
    					add = "0";
    				}
    				else{
    					sum = "0" + sum;
    					add = "1";
    				}
	    		}
    		}
    	}
    	if(add.equals("1")){
    		sum = "1" + sum;
    	}
    	return sum.toString();
    }
}