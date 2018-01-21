public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int findIntegers(int num) {
        if (num <= 2) return num+1;
        if (num == 3) return 3;
        if (map.containsKey(num)) return map.get(num);
        int h1 = 0, h2 = 0, l = 0, n = num;
        while (n > 0) {
            h2 = h1;
            h1 = n & 1;
            n = n >> 1;
            l++;
        }
        int count = 0;
        count += findIntegers((1 << (l-1))-1);
        if (h2 == 0) {
            count += findIntegers(num - (1 << (l-1)));
        } else {
            count += findIntegers((1 << (l-2))-1);
        }
        map.put(num, count);
        return count;
    }
}