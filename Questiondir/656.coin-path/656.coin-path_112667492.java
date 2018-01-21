import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> cheapestJump(int[] A, int B) {
        if (A.length == 1) {
            return Arrays.asList(1);
        }

        int n = A.length;
        int INF = Integer.MAX_VALUE / 2;
        int[] f = new int[A.length];
        int[] next = new int[A.length];

        Arrays.fill(f, INF);
        f[n - 1] = A[n - 1] == -1 ? INF : A[n - 1];
        next[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] == -1) continue;

            int which = -1;
            for (int j = i + 1; j < n && j <= i + B; j++)
                if (f[j] < INF && (which == -1 || f[j] < f[which])) {
                    which = j;
                }
            if (which != -1) {
                f[i] = A[i] + f[which];
                next[i] = which;
            }
        }
//        System.out.println(Arrays.toString(f));

        if (f[0] < INF) {
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i != n - 1; i = next[i])
                path.add(i + 1);
            path.add(n);
            return path;

        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.cheapestJump(new int[]{1, 2, 4, -1, 2}, 2));
        System.out.println(sol.cheapestJump(new int[]{1, 2, 4, -1, 2}, 1));
        System.out.println(sol.cheapestJump(new int[]{1, 1, 1, 1, 1, 1, 1}, 2));
        System.out.println(sol.cheapestJump(new int[]{1, 1, 1, 1, 1, 1, 1}, 5));
        System.out.println(sol.cheapestJump(new int[]{0, 0, 0, 0, 0, 0}, 3));
        System.out.println(sol.cheapestJump(new int[]{1, 0, 0, 0, 0}, 4));
        System.out.println(sol.cheapestJump(new int[]{1, 0, 1, 0, 0}, 4));
        System.out.println(sol.cheapestJump(new int[]{1, 0, 0, 1, 0}, 4));
    }
}