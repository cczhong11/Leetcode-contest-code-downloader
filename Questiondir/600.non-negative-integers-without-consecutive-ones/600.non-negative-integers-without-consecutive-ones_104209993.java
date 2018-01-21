public class Solution {
    HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
    int[] itob(int num) {
        if (num == 0 || num == 1) {
            int[] b = new int[1];
            b[0] = num;
            return b;
        }
        List<Integer> l = new ArrayList<Integer>();
        while (num > 0) {
            l.add(num % 2);
            num /= 2;
        }
        int[] b = new int[l.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = l.get(b.length - i - 1);
        }
        return b;
    }
    int btoi(int[] b) {
        int sum = 0;
        int pow = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            sum += pow * b[i];
            pow *= 2;
        }
        return sum;
    }
    public int findIntegers(int num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 2;
        }
        int[] b = itob(num);
        //System.out.println(Arrays.toString(b));
        
        int[] b1 = new int[b.length];
        Arrays.fill(b1, 1);
        b1[0] = 0;
        int num1 = btoi(b1);
        
        b[0] = 0;
        int num2;
        if (b[1] == 0) {
            num2 = btoi(b);
        }
        else {
            Arrays.fill(b, 1);
            b[0] = 0;
            b[1] = 0;
            num2 = btoi(b);
        }
        //System.out.println(num1+" "+num2);
        if (!h.containsKey(num1)) {
            h.put(num1, findIntegers(num1));
        }
        if (!h.containsKey(num2)) {
            h.put(num2, findIntegers(num2));
        }
        
        return  h.get(num1) + h.get(num2);
    }
}