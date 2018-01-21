class Solution {
    
    class Node {
        int l;
        int r;
        int h;
        Node (int l ,int h) {
            this.l = l;
            this.r = l + h;
            this.h = h;
        }
    }
    
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        List<Node>      q = new ArrayList<>();   
        
        int max = 0;
        for (int[] sqr : positions) {
            Node curr = new Node(sqr[0], sqr[1]);
            for (Node prev : q) {
                if (curr.l < prev.r && prev.l < curr.r) {
                    if (prev.h + sqr[1] > curr.h) curr.h = prev.h + sqr[1];
                }
            }
            
            q.add(curr);
            
            if (curr.h > max) {
                max = curr.h;
            }
            ans.add(max);
        }
        
        return ans;
    }
}