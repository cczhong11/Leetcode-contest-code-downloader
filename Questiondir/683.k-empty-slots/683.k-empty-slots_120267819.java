class Solution {
    public int kEmptySlots(int[] flowers, int k) {
                TreeSet<Integer> set = new TreeSet<>();
        int i=0;
        for (int n:flowers){
            set.add(n);
            int prev=n-k-1,next=n+k+1;

            if (set.contains(prev)){
                Integer prevNext=set.ceiling(prev+1);
                if (prevNext!=null&&prevNext==n)return set.size();
            }
            if (set.contains(next)){
                Integer nextPrev=set.floor(next-1);
                if (nextPrev!=null&&nextPrev==n)return set.size();
            }
        }
        return -1;
    }
}