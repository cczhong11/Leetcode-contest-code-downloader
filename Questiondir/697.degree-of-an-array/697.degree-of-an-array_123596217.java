class Solution {
    public int findShortestSubArray(int[] nums) {
        
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int i =0; i < nums.length; ++i){
            if(!freqCount.containsKey(nums[i])){
                freqCount.put(nums[i],0);
            }
            freqCount.put(nums[i], 1+freqCount.get(nums[i]));
        }
        
        int maxFreq = 0;
        HashSet<Integer> numsWithMaxFreq = new HashSet<>();
        for(int i : freqCount.keySet()){
            if(freqCount.get(i) > maxFreq){
                numsWithMaxFreq = new HashSet<>();
                maxFreq = freqCount.get(i);
                numsWithMaxFreq.add(i);
                
            }else if( freqCount.get(i) == maxFreq){
                numsWithMaxFreq.add(i);
            }
        }
        
        if( maxFreq == 1){
            return 1;
        }
        
        HashMap<Integer, Integer> firstOf = new HashMap<>();
        HashMap<Integer, Integer> lastOf = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(numsWithMaxFreq.contains(nums[i])){
                if(!firstOf.containsKey(nums[i])){
                    firstOf.put(nums[i],i);
                }
                lastOf.put(nums[i],i);
            }
        }
        
        int best = nums.length;
        for(int i : numsWithMaxFreq){
            int dif = lastOf.get(i)-firstOf.get(i)+1;
            best= Math.min(best, dif);
        }
        return best;
    }
}