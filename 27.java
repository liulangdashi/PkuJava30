public class Solution {
    public int removeElement(int[] nums, int val) {
        int newIndex = 0;  //��������ָ��newIndex,oldIndex����nums[newIndex]��Ϊ���ص�����
        for (int oldIndex = 0; oldIndex < nums.length; ++oldIndex) {  
            if (nums[oldIndex] != val) {  //��������Ԫ��Ϊval��newIndexǰ��
                nums[newIndex++] = nums[oldIndex];  
            }   
        }  
        return newIndex;  
    }
}