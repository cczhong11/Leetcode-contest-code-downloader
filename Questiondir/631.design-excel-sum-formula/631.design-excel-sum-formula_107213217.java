import java.util.Arrays;

public class Excel {
    private class SumUnit {
        int fromRow;
        int toRow;
        int fromCol;
        int toCol;

        public SumUnit(String range) {
            String[] split = range.split(":");
            fromRow = Integer.parseInt(split[0].substring(1)) - 1;
            fromCol = getCol(split[0].charAt(0));
            int last = split.length - 1;
            toRow = Integer.parseInt(split[last].substring(1)) - 1;
            toCol = getCol(split[last].charAt(0));
        }

        int get() {
            int result = 0;
            for (int i = fromRow; i <= toRow; i++) {
                for (int j = fromCol; j <= toCol; j++) {
                    result += array[i][j].get();
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return "SumUnit{" +
                    "fromRow=" + fromRow +
                    ", toRow=" + toRow +
                    ", fromCol=" + fromCol +
                    ", toCol=" + toCol +
                    '}';
        }
    }

    private class Node {
        boolean isValue;
        int value;
        SumUnit[] sumUnits;

        public Node(int value) {
            isValue = true;
            this.value = value;
        }

        public Node(String[] range) {
            isValue = false;
            sumUnits = new SumUnit[range.length];
            for (int i = 0; i < range.length; i++) {
                sumUnits[i] = new SumUnit(range[i]);
            }
        }

        int get() {
            if (isValue) {
                return value;
            } else {
                int result = 0;
                for (SumUnit sumUnit : sumUnits) {
                    result += sumUnit.get();
                }
                return result;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "isValue=" + isValue +
                    ", value=" + value +
                    ", sumUnits=" + Arrays.toString(sumUnits) +
                    '}';
        }
    }

    Node[][] array;

    static int getCol(char c) {
        return c - 'A';
    }

    public Excel(int H, char W) {
        int height = H;
        int width = getCol(W) + 1;
        array = new Node[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = new Node(0);
            }
        }
    }

    public void set(int r, char c, int v) {
        int i = r - 1;
        int j = getCol(c);
        array[i][j] = new Node(v);
    }

    public int get(int r, char c) {
        int i = r - 1;
        int j = getCol(c);
        return array[i][j].get();
    }

    public int sum(int r, char c, String[] strs) {
        int i = r - 1;
        int j = getCol(c);
        array[i][j] = new Node(strs);
        return array[i][j].get();

    }

    public static void main(String[] args) {
        Excel obj = new Excel(3, 'C');
        System.out.println(obj.sum(1, 'A', new String[]{"A2"}));
//        System.out.println(Arrays.deepToString(obj.array));
        obj.set(2, 'A', 1);
//        System.out.println(Arrays.deepToString(obj.array));

        System.out.println(obj.get(1, 'A'));

    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */