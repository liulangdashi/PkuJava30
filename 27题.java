public class Solution {
    public int removeElement(int[] nums, int val) {
        int i,count=0;
        for(i=0;i<nums.length;i++)
        if(nums[i]==val)
        count++;
        else if(count>0)
        nums[i-count]=nums[i];
        return nums.length-count;
    }
}