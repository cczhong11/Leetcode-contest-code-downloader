public class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length==0)return 0;
        int count=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count--;
            }
            else {
                count++;
            }
            if(!map.containsKey(count)){
                map.put(count,i);
            }
            else{
                int num=map.get(count);
                if(i-num>max)max=i-num;
            }
        }
        return max;
    }
}