import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Solution {


    public boolean isIdealPermutation(int[] A) {
        int local = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                local++;
            }
        }

        int global = sort(A, A.clone(), 0, A.length - 1);
//        System.out.println(global);
//        System.out.println(Arrays.toString(A));
        return local == global;
    }

    int sort(int[] a, int[] tmp, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int ans = 0, mid = (l + r) / 2, i = l, j = mid + 1, k = l;
        ans += sort(a, tmp, l, mid);
        ans += sort(a, tmp, mid + 1, r);
        while (i <= mid && j <= r) {
            if (a[i] > a[j]) {
                ans += mid - i + 1;
                tmp[k++] = a[j++];
            } else {
                tmp[k++] = a[i++];
            }
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];

        for (i = l; i <= r; i++) a[i] = tmp[i];

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(sol.isIdealPermutation(new int[]{1, 2, 0}));

        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = 8 - i;
        }
        System.out.println(sol.isIdealPermutation(a));
    }
}



