class Solution {
    public boolean judgePoint24(int[] nums) {
        if(nums == null || nums.length < 4)  return false;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(judge3(nums[i] + nums[j], i, j, nums))  return true;
                if(judge3(nums[i] - nums[j], i, j, nums))  return true;
                if(judge3(nums[j] - nums[i], i, j, nums))  return true;
                if(judge3(nums[i] * nums[j], i, j, nums))  return true;
                if(judge3((double)nums[i] / ((double)nums[j]), i, j, nums))  return true;
                if(judge3((double)nums[j] / ((double)nums[i]), i, j, nums))  return true;
            }
        }
        return false;
    }
    public boolean judge3(double a, int i, int j, int[] nums) {
        System.out.println(a);
        double[] temp = new double[3];
        temp[0] = a;
        double sum = a;
        int index = 1;
        for(int k = 0; k < 4; k++) {
            if(k == i || k == j)  continue;
            temp[index++] = nums[k];
            sum += nums[k];
        }
        System.out.println(temp[2]);
        for(int k = 0; k < 2; k++) {
            for(int z = k + 1; z < 3; z++) {
                if(judge2(temp[k] + temp[z], sum - temp[k] - temp[z]))  return true;
                if(judge2(temp[k] - temp[z], sum - temp[k] - temp[z]))  return true;
                if(judge2(temp[z] - temp[k], sum - temp[k] - temp[z]))  return true;
                if(judge2(temp[k] * temp[z], sum - temp[k] - temp[z]))  return true;
                if(judge2(temp[k] / temp[z], sum - temp[k] - temp[z]))  return true;
                if(judge2(temp[z] / temp[k], sum - temp[k] - temp[z]))  return true;
            }
        }
        return false;
        
    }
    
    public boolean judge2(double a, double b) {
        
        if(a + b == 24.0)  return true;
        if(a - b == 24.0)  return true;
        if(b - a == 24.0)  return true;
        if(a * b == 24.0)  return true;
        if(a / b == 24.0)  return true;
        if(b / a == 24.0)  return true;
        return false;
    }
}