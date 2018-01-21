import java.util.Arrays.*;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, i,j,k,low,high,mid,n = nums.length;
        int []x = nums;
        for ( i = 0; i < n-2; ++i )
            for ( j = i+1; j < n-1; ++j ) {
                int len = x[i]+x[j];
                if ( x[n-1] < len ) {
                    ans += (n-1-(j+1)+1);
                    continue ;
                }
                if ( x[j+1] >= len ) continue ;
                assert( x[j+1] < len && x[n-1] >= len );
                for ( low = j+1, high = n-1; low+1 < high; ) {
                    mid = (low+high)/2;
                    if ( x[mid] < len ) low = mid;
                    else high = mid;
                }
                ans += (low-(j+1)+1);
            }
        return ans;
    }
}