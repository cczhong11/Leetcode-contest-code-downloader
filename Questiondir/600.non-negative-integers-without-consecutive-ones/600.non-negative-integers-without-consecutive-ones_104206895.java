public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int findIntegers(int num) {
        if(num < 3) return num + 1;
        long front = 4;
        int prev = 3, prevprev = 2;
        int re = 3;
        while(true) {
            if(front == num + 1) return re;
            else if(front > num + 1) {
                if(front / 2 + front /4 <= num + 1) return re;
                else return map.get((int)(front / 2)) + findIntegers(num - (int)(front / 2));
            }
            map.put((int)front, re);
            re += prevprev;
            int curr = prev + prevprev;
            prevprev = prev;
            prev = curr;
            front *= 2;
        }
    }
}