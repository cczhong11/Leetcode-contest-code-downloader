public class Solution {
    public int smallestFactorization(int a) {
        List<Integer> factor = new ArrayList<>();
        
        int index = 9;
        if (a == 1) {
            return 1;
        }
        while (a > 1 && index > 1) {
            if (a % index == 0) {
                factor.add(index);
                a /= index;
            } else {
                index--;
            }
        }
        
        if (index == 1) {
            return 0;
        }
        
        //System.out.println(factor.toString());
        long result = 0;
        for (int i = factor.size() - 1; i >= 0; i--) {
            result = result * 10 + factor.get(i);
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        
        return (int)result;
    }
}