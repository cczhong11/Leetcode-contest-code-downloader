import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Solution {


    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        double left = 0, right = 1e8 + 10;
        for (int _ = 0; _ < 80; _++) {
            double mid = (left + right) / 2;
            if (isok(stations, mid, K)) right = mid;
            else left = mid;
        }
        return (left + right) / 2;
    }

    boolean isok(int[] a, double gap, int k) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] > gap) {
                cnt += Math.max(0, (int) Math.ceil((a[i + 1] - a[i]) / gap) - 1);
            }
        }
        return cnt <= k;

//        int cnt = 0;
//        double begin = a[0];
//        TreeSet<Double> tree = new TreeSet<>();
//        for (int i : a) {
//            tree.add((double) i);
//        }
//        while (tree.size() > 0 && cnt <= k) {
////            System.out.println(tree);
//            if (tree.first() - begin > gap) {
//                if (tree.first() - begin > gap * 3) {
//                    int need = (int) (Math.floor(tree.first() - begin) / gap) - 1;
//                    cnt += need;
//                    begin += gap * need;
//                } else {
//                    cnt++;
//                    tree.add(begin + gap);
//                    begin = tree.first();
//                }
//            } else {
//                begin = tree.pollFirst();
//            }
//        }
//
//        return cnt <= k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0));
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 20));
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3}, 2));
//        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3}, 3));
        System.out.println(sol.minmaxGasDist(new int[]{1, 1, 1, 1}, 4));
        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3}, 4));
        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3}, 5));
        System.out.println(sol.minmaxGasDist(new int[]{1, 2, 3}, 6));
    }
}



