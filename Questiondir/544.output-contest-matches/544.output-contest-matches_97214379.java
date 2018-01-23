public class Solution {
    // (((1,8),(4,5)),((2,7),(3,6)))
    // 0001, 1000, 0100, 0101, 0111, 0011, 0110  
    public String findContestMatch(int n) {
        if(n <= 1)
            return "";
        
        LinkedList<String> dq = new LinkedList<>();
        
        for(int i = 1; i <= n; ++i){
            dq.addLast("" + i);
        }
        
        
        while(dq.size() > 1){
            
            LinkedList<String> ndq = new LinkedList<>();
            
            while(dq.size() > 0){
                ndq.addLast("(" + dq.removeFirst() + "," + dq.removeLast() + ")");
            }
            
            dq = ndq;
        }
        
        return dq.removeFirst();
        
    }
}