import java.util.SortedMap;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        TreeMap<Integer, Integer> xToHeight = new TreeMap<>();
        
        
        xToHeight.put(0,0);
        ArrayList<Integer> results = new ArrayList<>();
        
        int maxHeightSoFar = 0;
        for(int i = 0; i < positions.length; ++i){
           // System.out.println(xToHeight);
            int left = positions[i][0];
            int right = left+positions[i][1];
            int height = positions[i][1];
            
            int leftFloorX = xToHeight.floorKey(left);
            SortedMap<Integer, Integer> tailView = xToHeight.tailMap(leftFloorX);
            int maxHeight = xToHeight.get(leftFloorX);
            for(int xVal : tailView.keySet()){
                if(xVal>= right){
                    break;
                }
                maxHeight = Math.max(maxHeight, tailView.get(xVal));
            }
            int myTotalHeight = maxHeight+height;
            int floorRightKey = xToHeight.floorKey(right);
            int floorRightVal = xToHeight.get(floorRightKey);
            while(xToHeight.ceilingKey(left)!=null){
                int nextKey = xToHeight.ceilingKey(left);
                if(nextKey >= right){
                    break;
                }
                xToHeight.remove(nextKey);
            }
            
            
            xToHeight.put(left, myTotalHeight);
            xToHeight.put(right, floorRightVal);
            maxHeightSoFar = Math.max(maxHeightSoFar, myTotalHeight);
            results.add(maxHeightSoFar);
            
           // System.out.println(xToHeight);
            
            
        }
        
        return results;
        
        
    }
}