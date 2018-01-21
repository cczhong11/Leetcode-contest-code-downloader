public class Solution {
    public int countArrangement(int N) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=1; j<=N; j++) {
                if(i%j==0 || j%i==0) {
                    list.add(j);
                }
            }
            lists.add(list);
        }

        HashSet<Integer> set = new HashSet<>();

        return countArrangement(lists, set, N, 0);
    }

    private int countArrangement( List<List<Integer>> lists , HashSet<Integer> set, int N, int index) {
        if(index==N) {
            return 1;
        }
        int count = 0;
        List<Integer> list = lists.get(index);
        for(Integer i: list) {
            if(!set.contains(i)) {
                set.add(i);
                count += countArrangement(lists, set, N, index+1);
                set.remove(i);
            }
        }

        return count;
    }
}