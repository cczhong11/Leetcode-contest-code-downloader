public class Solution {
    public int findIntegers(int num) {
        if (num == 0) return 1;
        if (num == 1) return 2;
        // List<Integer> result = new ArrayList<>();
        int[] result = new int[2178309];
        result[0] = 0;
        result[1] = 1;
        int pp = 1;
        int p = 2;
        int count = 2;
        while (p <= num) {
            // System.out.println("p == " + p + ":");
            // int size = result.size();
            for (int i = 0; result[i] < pp; ++i) {
                int v = result[i] + p;
                if (v <= num)
                    result[count++] = v;
                else
                    break;
            }
            // for (int i : result)
            //     System.out.println(i);
            pp = p;
            p = p + p;
        }
        return count;
    }
}