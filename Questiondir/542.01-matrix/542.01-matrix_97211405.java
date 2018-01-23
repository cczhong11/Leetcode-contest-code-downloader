public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n = matrix.size(), m = 0;
        for(List<Integer> tmp : matrix) {
            m = tmp.size();
            break;
        }
        int[][] mat = new int[n][m];
        int i=0, j=0;
        for(List<Integer> row : matrix){
            j = 0;
            for(Integer entry : row) mat[i][j++] = entry;
            i++;
        }
        int[][] res = updateMatrix(mat);
        
        LinkedList<List<Integer>> ret = new LinkedList();
        for(int[] row : res){
            LinkedList<Integer> cur = new LinkedList();
            for(int entry : row) cur.add(entry);
            ret.add(cur);
        }
        return ret;
    }
    
    public int[][] updateMatrix(int[][] matrix){
        // int debugcount = 0;
        LinkedList<Integer> rowbag = new LinkedList(), colbag = new LinkedList();
        int n = matrix.length, m = matrix[0].length;
        int[][] ret = new int[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) if(matrix[i][j]==0){
            rowbag.add(i);
            colbag.add(j);
            ret[i][j] = 0;
        }
        else{
            ret[i][j] = Integer.MAX_VALUE;
        }
        while(rowbag.size()>0){
            // debugcount += 1;
            // if(debugcount==100) return ret;
            int r = rowbag.removeFirst(), c = colbag.removeFirst();
            // System.out.println("ret["+r+"]["+c+"]="+ret[r][c]);
            int val = ret[r][c] + 1;
            if(val==Integer.MIN_VALUE) continue;
            if(r>0) deal(ret, r-1, c, val, rowbag, colbag);
            if(r<n-1) deal(ret, r+1, c, val, rowbag, colbag);
            if(c>0) deal(ret, r, c-1, val, rowbag, colbag);
            if(c<m-1) deal(ret, r, c+1, val, rowbag, colbag);
        }
        return ret;
    }
    
    public void deal(int[][] ret, int r, int c, int val, LinkedList<Integer> rowbag, LinkedList<Integer> colbag){
        if(ret[r][c]<=val) return;
        ret[r][c] = val;
        rowbag.add(r);
        colbag.add(c);
    }
}