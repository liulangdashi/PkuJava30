public class Solution {
    public int removeElement(int[] nums, int val) {
        int newIndex = 0;  //设置两个指针newIndex,oldIndex，用nums[newIndex]作为返回的数组
        for (int oldIndex = 0; oldIndex < nums.length; ++oldIndex) {  
            if (nums[oldIndex] != val) {  //遇到数组元素为val，newIndex前进
                nums[newIndex++] = nums[oldIndex];  
            }   
        }  
        return newIndex;  
    }
}