class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<flowers.length; i++){
            Integer next = set.higher(flowers[i]);
            Integer prev = set.lower(flowers[i]);
            
            if (next!=null && next-flowers[i]-1==k)
                return i+1;
            
            if (prev!=null && flowers[i]-prev-1==k)
                return i+1;
            
            set.add(flowers[i]);
        }
        
        return -1;
    }
}