import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Solution {


    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        boolean[] hash = new boolean[128];
        for (char ch : J.toCharArray()) {
            hash[ch] = true;
        }
        for (char ch : S.toCharArray()) {
            if (hash[ch]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}



