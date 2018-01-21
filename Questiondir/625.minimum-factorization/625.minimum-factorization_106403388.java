public class Solution {
    public int smallestFactorization(int a) {
        if (a == 1) return 1;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                list.add(i);
                a /= i;
            }
        }
        //System.out.println(a);
        if (a != 1) return 0;
        
        Collections.sort(list);
        
        long res = 0;
        for (int i : list) {
            res = 10 * res + i;
        }
        
        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }
}