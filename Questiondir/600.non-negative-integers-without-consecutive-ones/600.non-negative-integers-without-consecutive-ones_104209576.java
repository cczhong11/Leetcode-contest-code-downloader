public class Solution {
    private static final int MAX_LEN = 10000000;
    private static int[] res = new int[MAX_LEN];
    
    public int findIntegers(int num) {
        
        if (num < 0) return 0;
        if (num == 0) return 1;
        
        if (num < MAX_LEN) {
            if (res[num] == 0) 
                res[num] = findIntegers(num >> 1) + findIntegers((num - 1) >> 2);
            return res[num];
        }
        
        Map<Integer, Integer> cache = new HashMap<>();
        if (cache.containsKey(num)) return cache.get(num);
        
        int total = 0;
        int prefixEndingZero = (num >> 1);
        total += findIntegers(prefixEndingZero);
        
        int prefixEndingOne = ((num - 1) >> 2);
        total += findIntegers(prefixEndingOne);
        
        cache.put(num, total);
        return total;
        
        
        // if (num < 0) return 0;
        // if (num == 0) return 1;
        
        // int size = (num >> 1) + 2;
        // List<Integer> res = new ArrayList<Integer>((num >> 1) + 2);
        // res.add(1);
        // for (int i = 1; i < size; i++) {
        //     int prefixEndingZero = (i >> 1);
        //     int prefixEndingOne = ((i - 1) >> 2);
        //     res.add(res.get(prefixEndingZero) + res.get(prefixEndingOne));
        //     // res[i] = res[prefixEndingZero] + res[prefixEndingOne];
        // }
        
        // return res.get(num >> 1) + res.get((num - 1) >> 2);
        
        // int[] res = new int[(num >> 1) + 2];
        
        // res[0] = 1;
        // for (int i = 1; i < res.length; i++) {
        //     int prefixEndingZero = (i >> 1);
        //     int prefixEndingOne = ((i - 1) >> 2);
        //     res[i] = res[prefixEndingZero] + res[prefixEndingOne];
        // }
        
        // return res[num >> 1] + res[(num - 1) >> 2];
        
        // int[] endZero = new int[(num >> 1) + 2];
        // int[] endOne = new int[(num >> 1) + 2];
        
        // endZero[0] = 1;
        // endOne[0] = 0;
        
        // for (int i = 1; i < endZero.length; i++) {
        //     int prefixEndingZero = (i >> 1);
        //     int prefixEndingOne = ((i - 1) >> 2);
        //     endZero[i] = endZero[prefixEndingZero] + endOne[prefixEndingZero];
        //     endOne[i] = endZero[prefixEndingOne] + endOne[prefixEndingOne];
        // }
        // // System.out.println(Arrays.toString(endZero));
        // // System.out.println(Arrays.toString(endOne));
        // return endZero[num >> 1] + endOne[num >> 1] + endZero[(num - 1) >> 2] + endOne[(num - 1) >> 2];
        
        // int[] endZero = new int[num];
        // int[] endOne = new int[num];
        
        // endZero[0] = 1;
        // endOne[0] = 1;
        
        // for (int i = 1; i < num; i++) {
        //     int prefixEndingZero = ((i+1) >> 1);
        //     int prefixEndingOne = (i >> 2);
        //     endZero[i] = endZero[prefixEndingZero] + endOne[prefixEndingZero];
        //     endOne[i] = endZero[prefixEndingOne] + endOne[prefixEndingOne];
        // }
        // return endZero[num - 1] + endOne[num - 1];
        
        // int[] endZero = new int[num + 1];
        // int[] endOne = new int[num + 1];
        
        // endZero[0] = 1;
        // endOne[0] = 0;
        
        // for (int i = 1; i <= num; i++) {
        //     int prefixEndingZero = (i >> 1);
        //     int prefixEndingOne = ((i - 1) >> 2);
        //     endZero[i] = endZero[prefixEndingZero] + endOne[prefixEndingZero];
        //     endOne[i] = endZero[prefixEndingOne] + endOne[prefixEndingOne];
        // }
        // return endZero[num] + endOne[num];
        
        
        // Map<Integer, Integer> cache = new HashMap<>();
        // if (cache.containsKey(num)) return cache.get(num);
        
        // int total = 0;
        // int prefixEndingZero = (num >> 1);
        // total += findIntegers(prefixEndingZero);
        
        // int prefixEndingOne = ((num - 1) >> 2);
        // total += findIntegers(prefixEndingOne);
        
        // cache.put(num, total);
        // return total;
    }
    
    
}