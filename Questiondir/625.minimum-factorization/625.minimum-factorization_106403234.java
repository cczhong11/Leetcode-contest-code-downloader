public class Solution {
    public int smallestFactorization(int a) {
        StringBuilder temp = new StringBuilder("");
        for(int i = 9; i > 1 && temp.length() <= 10; --i) {
            while(a%i == 0) {
                temp.append(i);
                a /= i;
            }
        }
        if(temp.length() == 0 && a == 1) temp.append(1);
        String t = temp.reverse().toString();
        if(a > 1 || temp.length() > 10 || Long.parseLong(t) > Integer.MAX_VALUE)
            return 0;
        else return Integer.parseInt(t);
    }
}