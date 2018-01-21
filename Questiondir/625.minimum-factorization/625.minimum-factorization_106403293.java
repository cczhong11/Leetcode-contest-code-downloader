public class Solution {
    public int smallestFactorization(int a) {
        if(a == 1) return 1;
        int int2 = 0;
        int int3 = 0;
        int int5 = 0;
        int int7 = 0;

        int num = a;
        while(num>1) {
            if(num % 2 == 0) {
                int2++;
                num /= 2;
            } else if(num % 3 == 0) {
                int3++;
                num /= 3;
            } else if(num % 5 == 0) {
                int5++;
                num /= 5;
            } else if(num % 7 == 0) {
                int7++;
                num /= 7;
            } else {
                return 0;
            }
        }

        int int9 = int3 / 2;
        int3 = int3 % 2;
        int int8  = int2 / 3;
        int2 = int2 % 3;

        int int6 = 0;
        if(int3 == 1 && int2 >= 1) {
            int6= 1;
            int3 = 0;
            int2 --;
        }

        int int4 = int2 / 2;
        int2 = int2 % 2;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<int2; i++) {
            sb.append(2);
        }
        for(int i=0; i<int3; i++) {
            sb.append(3);
        }
        for(int i=0; i<int4; i++) {
            sb.append(4);
        }
        for(int i=0; i<int5; i++) {
            sb.append(5);
        }
        for(int i=0; i<int6; i++) {
            sb.append(6);
        }
        for(int i=0; i<int7; i++) {
            sb.append(7);
        }
        for(int i=0; i<int8; i++) {
            sb.append(8);
        }
        for(int i=0; i<int9; i++) {
            sb.append(9);
        }

        long ans = Long.parseLong(sb.toString());
        if(ans > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) ans;
    }
}