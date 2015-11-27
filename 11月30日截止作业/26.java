public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 0;
	    if(nums == null){
	        return length;
	    }
	    length = nums.length;
	    if(length == 1){
	        return length;
	    }
	    int i = 0;
	    int j = 1;
	    while(j < length){
	        if(nums[i] == nums[j]){
	            j++;
	        }
	        else{
	            nums[i+1] = nums[j];
	            i++;
	        }
	    }
	    length = i+1;
	    return length;
    }
}
