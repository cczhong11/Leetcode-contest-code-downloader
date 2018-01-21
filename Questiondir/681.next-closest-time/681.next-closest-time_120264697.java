class Solution {
    public String nextClosestTime(String time) {
        int num1 = time.charAt(0) - '0';
        int num2 = time.charAt(1) - '0';
        int num3 = time.charAt(3) - '0';
        int num4 = time.charAt(4) - '0';
        boolean[] nums = new boolean[10];
        nums[num1] = true;
        nums[num2] = true;
        nums[num3] = true;
        nums[num4] = true;
        int min = 0;
        for(int i = 0; i < 10; i++) {
            if(nums[i]) {
                min = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(time);
        for(int i = 4; i >= 0; i--) {
            if(i == 2) {
                continue;
            }
            int limit;
            if(i == 4) {
                limit = 10;
            } else if(i == 3) {
                limit = 6;
            } else if(i == 1) {
                limit = num1 == 2 ? 5 : 10;
            } else {
                limit = 3;
            }
            int cur = findNext(nums, time.charAt(i) - '0', limit);
            if(cur != -1) {
                sb.setCharAt(i, (char)(cur + '0'));
                return sb.toString();
            } else {
                sb.setCharAt(i, (char)(min + '0'));
            }
        }
        return sb.toString();
    }
    
    private int findNext(boolean[] nums, int k, int limit) {
        while(++k < limit) {
            if(nums[k]) {
                return k;
            }
        }
        return -1;
    }
        
}