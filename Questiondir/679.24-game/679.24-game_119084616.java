class Solution {

    public boolean judgePoint24(int[] nums) {
        double[] remained = new double[4];
        for(int i = 0; i < nums.length; i++) {
            remained[i] = nums[i];
        }
        return dfs(remained, 4);
    }
    
    private boolean dfs(double[] remained, int needed) {
        if(needed == 1) {
            return Math.abs(remained[0] - 24.0) < 0.0000001;
        }
        for(int i = 0; i < needed; i++) {
            for(int j = i+1; j < needed; j++) {
                double op1 = remained[i], op2 = remained[j];
                remained[j] =  remained[needed-1];
                
                remained[i] = op1 + op2;
                if(dfs(remained, needed-1)) return true;
                
                remained[i] = op1 - op2;
                if(dfs(remained, needed-1)) return true;
                
                remained[i] = op2 - op1;
                if(dfs(remained, needed-1)) return true;
                
                remained[i] = op1 * op2;
                if(dfs(remained, needed-1)) return true;
                
                if(op2 != 0.0) {
                    remained[i] = op1 / op2;
                    if(dfs(remained, needed-1)) return true;
                }
                
                if(op1 != 0.0) {
                    remained[i] = op2 / op1;
                    if(dfs(remained, needed-1)) return true;
                }
                
                remained[needed-1] = remained[j];
                remained[i] = op1;
                remained[j] = op2;
            }
        }
        return false;
    }
    
    
}