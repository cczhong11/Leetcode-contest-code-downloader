public class Excel {
    int[][] form;
    HashMap<String, String[]> hm;
    
    public Excel(int H, char W) {
        form = new int[H][W];
        hm = new HashMap<String, String[]>();
    }
    
    public void set(int r, char c, int v) {
        if (r > form.length || c - 'A' >= form[0].length)
            return;
        
        if (hm.containsKey("" + c + r))
            hm.remove("" + c + r);
        form[r - 1][c - 'A'] = v;
    }
    
    public int get(int r, char c) {
        if (r > form.length || c - 'A' >= form[0].length)
            return - 1;
            
        if (hm.containsKey("" + c + r)) {
            return sum(r, c, hm.get("" + c + r));
        }

        return form[r - 1][c - 'A'];
    }
    
    public int sum(int r, char c, String[] strs) {
        if (r > form.length || c - 'A' >= form[0].length)
            return - 1;
        
        int sum = 0;
        
        for (String str : strs) {
            if (str.indexOf(":") != -1) {
                String[] temp = str.split(":");
                int startR = temp[0].charAt(1) - '0';
                if (temp[0].length() > 2) {
                    startR *= 10;
                    startR += temp[0].charAt(2) - '0';
                }
                char startC = temp[0].charAt(0);
                
                int endR = temp[1].charAt(1) - '0';
                if (temp[1].length() > 2) {
                    endR *= 10;
                    endR += temp[1].charAt(2) - '0';
                }
                char endC = temp[1].charAt(0);
                
                for (int i = startR; i <= endR; i++) {
                    for (char j = startC; j <= endC; j++) {
                        sum += get(i, j);
                    }
                }
            } else {
                int r2 = str.charAt(1) - '0';
                if (str.length() > 2) {
                    r2 *= 10;
                    r2 += str.charAt(2) - '0';
                }
                char c2 = str.charAt(0);
                
                sum += get(r2, c2);
            }
        }
        
        set(r, c, sum);
        hm.put("" + c + r, strs);
        
        return sum;
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */