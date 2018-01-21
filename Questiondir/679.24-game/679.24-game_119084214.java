class Solution {
    public boolean judgePoint24(int[] nums) {
        Arrays.sort(nums);
        do{
            List<Double> res=cal(nums,0,nums.length-1);
            for(double d:res){
                if(d>23.9999&&d<24.0001){
                    return true;
                }
            }
        }
        while(getPermutation(nums));
        
        
        return false;
    }
    public List<Double> cal(int[] nums,int start,int end){
        List<Double> res=new ArrayList<Double>();
        if(start==end){
            res.add((double)nums[start]);
            return res;
        }
        for(int i=start;i<end;i++){
            List<Double> l=cal(nums,start,i);
            List<Double> r=cal(nums,i+1,end);
            for(double lnum:l){
                for(double rnum:r){
                    res.add(lnum+rnum);
                    res.add(lnum-rnum);
                    res.add(lnum*rnum);
                    res.add(lnum/rnum);
                }
            }
        }
        return res;
    }
    public boolean getPermutation(int[] nums){
        int cutPoint=nums.length-1;
        while(cutPoint>0){
            if(nums[cutPoint]>nums[cutPoint-1]){
                break;
            }
            cutPoint--;
        }
        if(cutPoint==0){
            return false;
        }
        int curr=nums[cutPoint-1];
        for(int i=nums.length-1;i>=cutPoint;i--){
            if(nums[i]>curr){
                nums[cutPoint-1]=nums[i];
                nums[i]=curr;
                int start=cutPoint;
                int end=nums.length-1;
                while(start<end){
                    int temp=nums[start];
                    nums[start]=nums[end];
                    nums[end]=temp;
                    start++;
                    end--;
                }
                break;
            }
        }
        return true;
    }
}