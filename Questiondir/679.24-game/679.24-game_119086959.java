class Solution {
    /* think: input is small
    can try all possibilities 
    */
    public boolean judgePoint24(int[] nums) {
        // case: 2 nums merge into 1, the other 2 merge into another, then operate on the two results
        double[] a = new double[4];
        a[0] = nums[0];
        a[1] = nums[1];
        a[2] = nums[2];
        a[3] = nums[3];
        
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                // figure out the other two index
                boolean[] taken = new boolean[4];
                taken[i] = true;
                taken[j] = true;
                int ind1 = -1;
                int ind2 = -1;
                for (int k = 0; k < 4; k++) {
                    if (!taken[k]) {
                        if (ind1 < 0) {
                            ind1 = k;
                        }
                        else {
                            ind2 = k;
                        }
                    }
                }
                
                // get result
                HashSet<Double> res1 = getPossibleResult(a, i, j);
                HashSet<Double> res2 = getPossibleResult(a, ind1, ind2);
                if (canGet24(res1, res2)) {
                    return true;
                }
            }
        }
        
        // case: adding numbers to experssion one by one
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) continue;
                HashSet<Double> res1 = getPossibleResult(a, i, j);
                for (int k = 0; k < 4; k++) {
                    if (k == i) continue;
                    if (k == j) continue;
                    boolean[] taken = new boolean[4];
                    taken[i] = true;
                    taken[j] = true;
                    taken[k] = true;
                    int ind1 = -1;
                    for (int bb = 0; bb < 4; bb++) {
                        if (!taken[bb]) {
                            if (ind1 < 0) {
                                ind1 = bb;
                            }
                        }
                    }
                    // sequence is present as i, j, k, ind1
                    
                    // include k
                    HashSet<Double> res2 = new HashSet<>();
                    for (double x : res1) {
                        res2.addAll(getPossibleResultFromTwo(x, a[k]));
                    }
                    
                    // include res2
                    HashSet<Double> res3 = new HashSet<>();
                    for (double x : res2) {
                        res3.addAll(getPossibleResultFromTwo(x, a[ind1]));
                    }
                    if (res3.contains(24.0)) {
                        return true;
                    }
                }
            }
        }
        
        
        
        
        
        return false;
    }
    
    private boolean canGet24(HashSet<Double> a, HashSet<Double> b) {
        for (double x : a) {
            for (double y : b) {
                if (canGet24FromTwo(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean canGet24FromTwo(double a, double b) {
        HashSet<Double> result = getPossibleResultFromTwo(a, b);
        for (double x : result) {
            if (x == 24) {
                return true;
            }
        }
        return false;
    }
    
    private HashSet<Double> getPossibleResult(double[] a, int i, int j) {
        return getPossibleResultFromTwo(a[i], a[j]);
    }
    
    private HashSet<Double> getPossibleResultFromTwo(double a, double b) {
        HashSet<Double> result = new HashSet<>();
        result.add(a + b);
        result.add(a - b);
        result.add(b - a);
        result.add(a * b);
        if (b != 0) result.add(a / b);
        if (a != 0) result.add(b / a);
        return result;
    }
}