public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxC = tasks[0];
        int maxF = 1;
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c)>maxF){
                maxC = c;
                maxF = map.get(c);
            }
        }
        
        int extraSpaces = 0;
        int emptySpots = n * (maxF-1);

        for(char c : map.keySet()){
            if(c==maxC) continue;
            int len = map.get(c);
            if(len == maxF){
                extraSpaces++;
                emptySpots -= len-1;
            } 
            else{
                emptySpots -= len;
            }
            if(emptySpots<=0) return tasks.length;
        }
        return maxF + n * (maxF-1)+ extraSpaces;
        
        
        
    }
}