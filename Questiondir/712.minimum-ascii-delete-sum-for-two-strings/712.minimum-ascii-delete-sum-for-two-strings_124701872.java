class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] cache = new Integer[s1.length() + 1][s2.length() + 1];
        
        return minimumDeleteSum(s1, 0, s2, 0, cache);
    }
    
    private int minimumDeleteSum(String s1, int index1, String s2, int index2, Integer[][] cache) {
        int n = s1.length(), m = s2.length();
        
        if (cache[index1][index2] == null) {
            if (index1 == s1.length() && index2 == s2.length()) {
                cache[index1][index2] = 0;
            } else if (index1 == s1.length()) {
                cache[index1][index2] = sum(s2.toCharArray(), index2, s2.length());
            } else if (index2 == s2.length()) {
                cache[index1][index2] = sum(s1.toCharArray(), index1, s1.length());
            } else {
                int min = Integer.MAX_VALUE;

                if (s1.charAt(index1) == s2.charAt(index2)) {
                    min = minimumDeleteSum(s1, index1 + 1, s2, index2 + 1, cache);
                } else {
                    min = Math.min(minimumDeleteSum(s1, index1, s2, index2 + 1, cache) + s2.charAt(index2),
                                   minimumDeleteSum(s1, index1 + 1, s2, index2, cache) + s1.charAt(index1));
                }

                cache[index1][index2] = min;
            }
        }
        
        return cache[index1][index2];
    }
    
    private int sum(char[] array, int start, int end) {
        int sum = 0;
        
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        
        return sum;
    }
}