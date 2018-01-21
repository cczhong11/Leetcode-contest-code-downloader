import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(sol.isOneBitCharacter(new int[]{1, 1, 1, 0}));
        {

        }
    }

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (bits[i] == 0) {
                i++;
                if (i >= bits.length) return true;
            } else {
                i += 2;
                if (i >= bits.length) return false;
            }
        }
        throw new RuntimeException("...");
    }
}
