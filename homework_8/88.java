public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
	//先申明一个长度为m的数组num3保存nums1
        int[] nums3=new int[m];
        for(int i=0;i<m;i++){
            nums3[i]=nums1[i];
        }
        //用归并排序把nums2数组和nums3数组归并到nums1
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