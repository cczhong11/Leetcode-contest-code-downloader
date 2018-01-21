public class Excel {

    private int[][] data;
    private Map<String, String[]> sum = new HashMap<>();
    
    public Excel(int H, char W) {
        data = new int[H][W-'A' + 1];
    }
    
    public void set(int r, char c, int v) {
        data[r - 1][c - 'A'] = v;
        sum.put("" + c + r , null);
    }
    
    public int get(int r, char c) {
        return calculate("" + c + r);
    }
    
    private int getRaw(int r, char c) {
        return data[r - 1][c - 'A'];
    }
    
    public int sum(int r, char c, String[] strs) {
        sum.put("" + c + r, strs);
        return calculate("" + c + r);
    }
    
    private int calculate(String key) {
        String[] formula = sum.get(key);
        if (formula == null) {
            return getRaw(Integer.parseInt(key.substring(1)) , key.charAt(0));
        } else {
            int sum = 0;
            for (String e : formula) {
                int index = e.indexOf(":");
                if (index < 0) {
                    sum += calculate(e);
                } else {
                    String start = e.substring(0, index);
                    String end = e.substring(index + 1);
                    int rowStart = Integer.parseInt(start.substring(1));
                    char colStart = start.charAt(0);
                    int rowEnd = Integer.parseInt(end.substring(1));
                    char colEnd = end.charAt(0);
                    for (int i = rowStart; i <= rowEnd; i++) {
                        for (char j = colStart; j <= colEnd; j++) {
                            sum += calculate("" + j + i);
                        }
                    }
                }
            }
            return sum;
        }
        
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */