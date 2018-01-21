public class Excel {
        Cell[][] cells;
        private static class Cell
        {
            public int val;
            public HashSet<Cell> to = new HashSet<Cell>();
            public HashMap<Cell, Integer> from = new HashMap<Cell, Integer>();
            public void update(int v, boolean removeFrom)
            {
                notifychange(v-val);
                val = v;
                if(removeFrom)
                {
                    //remove it from from cells
                    for(Cell f : this.from.keySet())
                    {
                        f.to.remove(this);
                    }

                    //reset
                    this.from.clear();
                }
            }

            public void notifychange(int diff)
            {
                for(Cell cell : to)
                {
                    int oldV = cell.val;
                    cell.val+=diff*cell.from.get(this);
                    cell.notifychange(cell.val-oldV);
                }
            }
        }
        public Excel(int H, char W) {
            cells = new Cell[H][W-'A'+1];
            for(int i=0;i<H;i++)
            {
                for(int j=0;j<W-'A'+1;j++)
                {
                    cells[i][j] = new Cell();
                }
            }
        }

        public void set(int r, char c, int v) {
            int row = r-1;
            int col = c-'A';
            Cell cell = cells[row][col];
            cell.update(v, true);
        }

        public int get(int r, char c) {
            int row = r-1;
            int col = c-'A';
            Cell cell = cells[row][col];
            return cell.val;
        }

        public int sum(int r, char c, String[] strs) {
            int row = r-1;
            int col = c-'A';
            Cell cell = cells[row][col];
            //clear depends
            cell.from.clear();
            int newV = 0;
            for(String str : strs)
            {
                // add depend and update value at last
                if(str.contains(":"))
                {
                    String[] fromTo = str.split(":");
                    int[] from = getPos(fromTo[0]);
                    int[] to = getPos(fromTo[1]);
                    for(int i=from[0];i<=to[0];i++)
                    {
                        for(int j=from[1];j<=to[1];j++)
                        {
                            Cell fromCell = cells[i][j];
                            newV+=fromCell.val;
                            cell.from.putIfAbsent(fromCell,0);
                            cell.from.put(fromCell, cell.from.get(fromCell)+1);
                            fromCell.to.add(cell);
                        }
                    }
                }else{
                    int[] pos = getPos(str);
                    Cell fromCell = cells[pos[0]][pos[1]];
                    newV+=fromCell.val;
                    cell.from.putIfAbsent(fromCell,0);
                    cell.from.put(fromCell, cell.from.get(fromCell)+1);
                    fromCell.to.add(cell);
                }
            }

            cell.update(newV, false);
            return newV;
        }

        private int[] getPos(String str)
        {
            int[] rc = new int[2];
            if(str.length() == 2)
            {
                rc[1] = str.charAt(0)-'A'; // col
                rc[0] = str.charAt(1)-'1';// row
            }else{

                rc[1] = str.charAt(0)-'A'; // col
                rc[0] = str.charAt(1)-'0';// row
                rc[0] = rc[0]*10+str.charAt(2)-'0';// row
            }

            return rc;
        }
    }

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */