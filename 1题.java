public class Solution {
    public int[] twoSum(int[] numbers, int target) {
	    HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
	    int[] a=new int[2];
	    for(int i=0;i<numbers.length;i++){
	        if(hashmap.containsKey(numbers[i])){
	            int k=hashmap.get(numbers[i]);
	            a[0]=k+1;
	            a[1]=i+1;
	        }
	        else
	        hashmap.put(target-numbers[i],i);
	  }
	  	return a;
    }
}