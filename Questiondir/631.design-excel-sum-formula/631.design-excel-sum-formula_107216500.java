import java.util.*;

public class Excel {


    int H, W;
    int[] a;
    List<Integer>[] need;
    long[] hash;

    String f(int i) {
        int h = i / W;
        int w = i % W;
        return "" + (char) (w + 'A') + (h + 1);
    }

    int f(String s) {
        int w = s.charAt(0) - 'A';
        int h = Integer.parseInt(s.substring(1)) - 1;
        return h * W + w;
    }

    public Excel(int H, char W) {
        this.H = H;
        this.W = W - 'A' + 1;
        int n = H * this.W;
        a = new int[n];
        need = new List[n];
        for (int i = 0; i < n; i++) {
            need[i] = new ArrayList<>();
        }
        hash = new long[n];
//
//        for (int i = 0; i < n; i++) {
//            String s = f(i);
//            System.out.println(s + " " + f(s));
//        }
    }

    public void set(int r, char c, int v) {
        Arrays.fill(hash, Long.MAX_VALUE);
        int id = (r - 1) * W + c - 'A';
        a[id] = v;
        need[id].clear();
    }

    public int get(int r, char c) {
        return myGet(r - 1, c - 'A');
    }

    private int myGet(int r, int c) {
        int id = r * W + c;
        if (hash[id] != Long.MAX_VALUE) return (int) (hash[id]);

        int val;
        if (need[id].isEmpty())
            val = a[id];
        else {
            val = 0;
            for (int i : need[id]) {
                val += myGet(i / W, i % W);
            }
        }

        hash[id] = val;
        return val;
    }

    public int sum(int r, char c, String[] strs) {
        Arrays.fill(hash, Long.MAX_VALUE);
        int id = (r - 1) * W + c - 'A';
        need[id].clear();

        for (String s : strs) {
            if (s.contains(":")) {
                int cb = f(s.split(":")[0]), wb = f(s.split(":")[1]);
                int rr = cb / W, rrr = wb / W;
                int cc = cb % W, ccc = wb % W;

//                System.out.println(s);
//                System.out.println(rr + " " + rrr);
//                System.out.println(cc + " " + ccc);

                for (int i = rr; i <= rrr; i++)
                    for (int j = cc; j <= ccc; j++) {
//                    if (i * W + j == f("D7")) {
//                        System.out.println("Hit D7");
//                    }
                        need[id].add(i * W + j);
                    }
            } else {
                need[id].add(f(s));
            }
        }
        System.out.println(need[id]);
        return get(r, c);
    }

    private void print() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(myGet(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Excel a = new Excel(3, 'C');
//
//        a.print();
//
//        a.set(1, 'A', 2);
//        a.print();
//
//        a.sum(3, 'C', new String[]{"A1", "A1:B2"});
//        a.print();
//
//        a.set(2, 'B', 2);
//        a.print();

        Excel a = new Excel(26, 'Z');
        a.set(1, 'A', 1);
        a.set(1, 'I', 1);
        int v = a.sum(7, 'D', new String[]{"A1:D6", "A1:G3", "A1:C12"});
        System.out.println("v = " + v);

        a.sum(10, 'G', new String[]{"A1:D7", "D1:F10", "D3:I8", "I1:I9"});
        a.print();

    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */