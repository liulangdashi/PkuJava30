public class Solution {
    public int singleNumber(int[] nums) {
        int sgl=nums[0];
        //nums[0] ^ nums[1]  ^ ....，可以将所有相同元素交换至相邻位置，首先运算相同元素，则会产生(n - 1)/2	//个0异或积，剩余一个单一元素，他们的异或积为这个单一元素自己
        for(int i=1;i<nums.length;i++)
            sgl=sgl^nums[i];
        return sgl;
    }
}