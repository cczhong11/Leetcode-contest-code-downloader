class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return res;
        }
        
        List<Square> sqs = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int start = positions[i][0], h = positions[i][1];
            int end = start + h - 1;
            int maxH = 0;
            for (Square sq : sqs) {
                if (!(sq.start > end || sq.end < start)) {
                    maxH = Math.max(maxH, sq.h);
                }
            }
            Square newSQ = new Square(start, end, maxH + h);
            sqs.add(newSQ);
            if (i == 0) {
                res.add(newSQ.h);
            } else {
                res.add(Math.max(res.get(i - 1), newSQ.h));
            }
            
        }
        return res;
    }
    
    private static class Square {
        int start, end;
        int h;
        
        Square(int s, int e, int hh) {
            start = s;
            end = e;
            h = hh;
        }
    }
}