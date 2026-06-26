class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount=0;
        int n=nums.length;
        int[] res=new int[n];
        int prod=1;

        for(int i:nums){
            if(i!=0){
                prod*=i;
            }
            else{
                zeroCount++;
            }
        }

        if(zeroCount>1){
            return new int[n];
        }
        
        for(int i=0;i<n;i++){
            if(zeroCount>0){
                res[i]=(nums[i]==0)?prod:0;
            }
            else{
                res[i]=prod/nums[i];
            }
        }

        return res;
    }
}  
