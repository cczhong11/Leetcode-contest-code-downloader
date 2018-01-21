public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        
        int index = -1;
        for (int v : arr) {
            index++;
            
            if (index < k) {
                list.addLast(v);
            } else {
                if (Math.abs(v - x) < Math.abs(list.peekFirst() - x)) {
                    list.removeFirst();
                    list.addLast(v);
                }
                
            }
        }
        
        return list;
    }
}