class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        HashMap<Integer,Integer> f = new HashMap<>();
        HashMap<Integer,Integer> l = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
            if(!f.containsKey(nums[i])){
                f.put(nums[i],i);
                l.put(nums[i],i);
            }
            l.put(nums[i],i);
        }
        int max = 0;
        for(int key:m.keySet()){
            int v = m.get(key);
            max = Math.max(max,v);
        }
        int r = nums.length;
        for(int key:m.keySet()){
            int v = m.get(key);
            if(v==max){
                int len = l.get(key)-f.get(key)+1;
                r = Math.min(r,len);
            }
        }
        return r;
        
        
        
        
        
    }
}