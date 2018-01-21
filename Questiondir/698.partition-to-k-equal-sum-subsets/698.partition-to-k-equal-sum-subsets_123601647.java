class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum+=nums[i];
        }
        
        if(sum%k !=0){
            return false;
        }
        
        target =sum/k;
        
        // cant do straight greedy (all 1s + big)
        
        ArrayList<Integer> targets = new ArrayList<>();
        for(int i = 0; i < k; ++i){
            targets.add(target);
        }
        Arrays.sort(nums);
        
        boolean result = part(targets, nums, nums.length-1);
        return result;
        
        
    }
    static int target;
    
    // can we partition nums starting at cur num to hit targets
    public boolean part( ArrayList<Integer> targets, int[] nums, int curNumIndex){
        
        if(curNumIndex == -1){
            return true;
        }
        
        
        int curNum = nums[curNumIndex];
        for(int i = 0; i < targets.size(); ++i){
            //try putting current num into target i
            
            if(targets.get(i) < curNum){
                continue;
            }else if( targets.get(i) != target){
                targets.set(i, targets.get(i)-curNum);
                boolean result = part(targets, nums, curNumIndex-1);
                if(result){
                    return true;
                }else{
                    targets.set(i, targets.get(i) + curNum);
                }
            }else{
                targets.set(i, targets.get(i)-curNum);
                boolean result= part(targets, nums, curNumIndex-1);
                
                targets.set(i, targets.get(i)+curNum);
                return result;
            }
            
        }
        return false;
        
    }
    
    
    
    
}