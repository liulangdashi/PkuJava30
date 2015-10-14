public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] num=nums.clone();//num数组拷贝nums数组
        Arrays.sort(num);//讲num数组排序
        int len=nums.length;
        int left=0,right=len-1,sum=0;
        ArrayList<Integer> num1=new ArrayList<Integer>();
        while(left<right){//一遍遍历找出两数相加为目标值的两个数
            sum=num[left]+num[right];
            if(sum==target){
                for(int i=0;i<len;i++){
                    if(num[left]==nums[i])
                        num1.add(i+1);
                    else if(num[right]==nums[i])
                        num1.add(i+1);
                    if(num1.size()==2)
                        break;
                }
            break;
            }
            else if(sum<target)
                left++;
            else if(sum>target)
                right--;
        }
        int[] rt=new int[2];
        rt[0]=num1.get(0);
        rt[1]=num1.get(1);
        return rt;
    }
}