public class Solution {
    public int singleNumber(int[] nums) {
        int sgl=nums[0];
        //nums[0] ^ nums[1]  ^ ....�����Խ�������ͬԪ�ؽ���������λ�ã�����������ͬԪ�أ�������(n - 1)/2	//��0������ʣ��һ����һԪ�أ����ǵ�����Ϊ�����һԪ���Լ�
        for(int i=1;i<nums.length;i++)
            sgl=sgl^nums[i];
        return sgl;
    }
}