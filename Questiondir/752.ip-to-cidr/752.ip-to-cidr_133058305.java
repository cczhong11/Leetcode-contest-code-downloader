import java.util.ArrayList;
import java.util.List;

public class Solution {

    private String to(long x) {
        long a = x % 256;
        x /= 256;
        long b = x % 256;
        x /= 256;
        long c = x % 256;
        x /= 256;
        long d = x % 256;
        x /= 256;
        return d + "." + c + "." + b + "." + a;
    }

    private long toto(String ip) {
        String[] tokens = ip.split("\\.");
        long ans = 0;
        for (int i = 0; i < tokens.length; i++)
            ans = ans * 256 + Integer.parseInt(tokens[i]);
        return ans;
    }

    private int zeros(long x) {
        if (x == 0) return 32;

        int ans = 0;
        while (x % 2 == 0) {
            ans++;
            x /= 2;
        }
        return ans;
    }

    public List<String> ipToCIDR(String ip, int range) {
        List<String> res = new ArrayList<>();
        long x = toto(ip);
        while (range > 0) {
            int zeros = zeros(x);
            while ((1L << zeros) > range) {
                zeros--;
            }
            res.add(to(x) + "/" + (32 - zeros));

            range -= 1L << zeros;
            x += 1L << zeros;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.ipToCIDR("255.0.0.7", 10));
        System.out.println(sol.ipToCIDR("255.0.0.7", 1));
        System.out.println(sol.ipToCIDR("0.0.0.0", 1));
        System.out.println(sol.ipToCIDR("0.0.0.0", 2));
        System.out.println(sol.ipToCIDR("0.0.0.0", 3));
        System.out.println(sol.ipToCIDR("0.0.0.0", 4));
    }
}

