public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length<3)
            return list;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (left>i+1 && nums[left]==nums[left-1]) {
                    left++;
                    continue;
                }
                if (right<nums.length-2 && nums[right]==nums[right+1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum==0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    list.add(item);
                    left++;
                    right--;
                } else if (sum>0) {
                    right--;
                } else {
                    left++;
                }
            } 
        } 
        return list;
    }
}