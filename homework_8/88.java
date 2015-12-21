public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
	//������һ������Ϊm������num3����nums1
        int[] nums3=new int[m];
        for(int i=0;i<m;i++){
            nums3[i]=nums1[i];
        }
        //�ù鲢�����nums2�����nums3����鲢��nums1
        int i=0,j=0;
        int count=0;
        while(i<m&&j<n){
            if(nums3[i]<nums2[j]) 
                nums1[count++]=nums3[i++];
            else 
                nums1[count++]=nums2[j++];
        }
        if(i==m){
            while(j<n){
                nums1[count++]=nums2[j++];
            }
        }
        if(j==n){
            while(i<m){
                nums1[count++]=nums3[i++];
            }
        }
    }
}