import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int findMinMoves(int[] machines) {
        if (machines.length <= 0) return 0;

        int n = machines.length;
        int[] prefix = new int[n], suffix = new int[n];
        for (int i = 0; i < n; i++)
            prefix[i] = machines[i] + (i > 0 ? prefix[i - 1] : 0);
        int sum = prefix[n - 1];
        for (int i = n - 1; i >= 0; i--)
            suffix[i] = machines[i] + (i < n - 1 ? suffix[i + 1] : 0);

        if (sum % n != 0) return -1;
        int per = sum / n;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int toLeft = -((i > 0 ? prefix[i - 1] : 0) - i * per);
            int toRight = -((i + 1 < n ? suffix[i + 1] : 0) - (n - i - 1) * per);
            int totalTo = (toLeft > 0 ? toLeft : 0) + (toRight > 0 ? toRight : 0);
            int totalRec = Math.max(toLeft < 0 ? -toLeft : 0, toRight < 0 ? -toRight : 0);
            ans = Math.max(ans, Math.max(totalTo, totalRec));
        }
        return ans;
    }
}
