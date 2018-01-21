class Solution {
    public int reachNumber(int target) {
        if (target==0) return 0;
        if (target<0) target=-target;
        int sum=0,i=1;
        for (i=1;i<=100000;i++)
        {
            sum+=i;
            if (sum>=target && (sum-target)%2==0) break;
        }
        return i;
    }
}