public class Excel {
    private Cell[][] sheet;

    public Excel(int H, char W) {
        int w = W-'A'+1;
        sheet = new Cell[H][w];
        for(int row = 0; row < sheet.length; row++) {
            for (int col = 0; col < sheet[row].length; col++) {
                sheet[row][col] = new BasicCell(0);
            }
        }
    }
    
    public void set(int r, char c, int v) {
        sheet[r-1][c-'A'] = new BasicCell(v);
    }
    
    public int get(int r, char c) {
        return sheet[r-1][c-'A'].get();
    }
    
    public int sum(int r, char c, String[] strs) {
        sheet[r-1][c-'A'] = new SumCell(strs);
        return get(r,c);
    }
    
    private abstract class Cell {
        public abstract int get();
    }
    
    private class BasicCell extends Cell {
        int value;
        
        BasicCell(int value) {
            this.value = value;
        }
        
        public int get() {
            return value;
        }
    }
    
    private class SumCell extends Cell {
        String[] strs;
        
        SumCell(String[] strs) {
            this.strs = strs;
        }
        
        public int get() {
            int sum = 0;
            for(String cellname : strs) {
                if(cellname.contains(":")) {
                    // System.out.println(cellname);
                    String[] bounds = cellname.split(":");
                    char colstart = bounds[0].charAt(0);
                    char colend = bounds[1].charAt(0);
                    int rowstart = Integer.parseInt(bounds[0].substring(1,bounds[0].length()));
                    int rowend = Integer.parseInt(bounds[1].substring(1,bounds[1].length()));
                    for(char col = colstart; col <= colend; col++) {
                        for(int row = rowstart; row <= rowend; row++) {
                            int value = Excel.this.get(row, col);
                            // System.out.println("" + col + row + ":" + value);
                            sum += value;
                        } 
                    }
                } else {
                    char col = cellname.charAt(0);
                    int row = Integer.parseInt(cellname.substring(1,cellname.length()));
                    sum += Excel.this.get(row, col);
                }
            }
            // System.out.println("sum : " + sum);
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