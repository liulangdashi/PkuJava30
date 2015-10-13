public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap();
        int [] result = new int[2];
        for(int i = 0; i < nums.length; i++){
        	map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length;){
        	int n = target - nums[i];
//        	if()
        	if(map.get(n) != null && (int)map.get(n) != i){
        		result[0] = i + 1;
        		result[1] = (int)map.get(n) + 1;
        		break;
         	}
        }
        return result;
    }
}