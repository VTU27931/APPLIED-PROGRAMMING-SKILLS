class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0,left=0,right=0;
        for(int n:nums){
            sum+=n;
        }
        for(int i=0;i<nums.length;i++){
            right=sum-left-nums[i];
            if(right==left)
                return i;
            left+=nums[i];
        }
        return -1;
    }
}