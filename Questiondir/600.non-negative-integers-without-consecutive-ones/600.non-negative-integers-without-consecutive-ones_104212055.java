public class Solution {
    void calc() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int[] nums = new int [n];
        for (int i = 0; i < n; i ++) {
            nums[i]  = scan.nextInt();
        }

        int[] nono = new int [t];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < t; i ++) {
            int v = scan.nextInt();
            set.add(v);
        }

        for (int i = 0; i < n; i ++) {
            int v = nums[i];
            int add = 0, res = 0;
            for (int j = 1; j <= 1000; j ++) {
                if (set.contains(j)) continue;
                v --;
                add ++;
                if (v <= 0) {
                    res = j;
                    break;
                }
            }
            System.out.println(res);
        }
    }

    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        boolean []vis = new boolean [n];
        int res = 0;
        for (int i = 0; i < n; i ++) {
            if (vis[i]) continue;
            int cnt = 0, from = i, cur = i;
            do {
                cnt ++;
                vis[cur]  = true;
                cur = nums[cur];
            } while (cur != from);

            res = Math.max(res, cnt);
        }
        return res;
    }

    int[][] dp = new int [32][2];

    public int findIntegers(int num) {

        for (int i = 0; i < 32; i ++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 0; i < 32;i  ++) {
            dp[i][0] = dfs(i, 0);
            dp[i][1] = dfs(i, 1);
        }


        return calc(num);
    }

    int calc(int num) {
        if (num == 0) return 1;

        int res = 0;
        boolean first = true;
        for (int i = 31; i >= 0; i --) {
            if ( ((num >> i) & 1 )== 1) {
                if (first) {
                    res += dfs(i, 0);
                    first = false;
                }
                int mask = ~(1 << i);
                num = num & mask;

                if (checkbit(num, i - 1) == 1) {
                    int big = (1 << (i - 1)) - 1;
                    int one = calc(big);
                    res += one;
                } else {
                    int one = calc(num);
                    res += one;
                }
                break;
            }
        }
        return res;
    }

    int checkbit(int num, int bit) {
        if (bit < 0) return 0;
        num >>= bit;
        return (num & 1);
    }

    int dfs(int idx, int bit) {
        if (idx < 0) return 0;
        if (idx == 0) return dp[0][bit];

        if (dp[idx][bit] != -1) return dp[idx][bit];
        int res = 0;
        if (bit == 1) {
            res += dfs(idx - 1, 0);
        } else {
            res += dfs(idx - 1, 1);
            res += dfs(idx - 1, 0);
        }
        return res;
    }

    int find(int num) {
        int res = 0;
        for (int i = 0; i <= num; i ++) {
            char[] cs = Integer.toBinaryString(i).toCharArray();
            if (check(cs)) {
//                System.out.println(cs);
                res++;
            }
        }
        return res;
    }

    boolean check(char[] cs) {
        for (int i = 1; i < cs.length; i ++) {
            if (cs[i - 1] == '1' && cs[i] == '1') return false;
        }
        return true;
    }

  
}