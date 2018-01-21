public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        if(A.length == 0) return new ArrayList<>();
        int[] costs = new int[A.length];
        int[] choice = new int[A.length];

        costs[A.length - 1] = A[A.length - 1];
        choice[A.length - 1] = A.length - 1;

        for(int i = A.length - 2;i>=0;i--){
            if(A[i] == -1){
                costs[i] = -1;
                choice[i] = -1;
                continue;
            }


            int min = -1,minChoice = -1;
            for(int j = 1;j<=B;j++){
                if(i + j >= A.length) break;
                if(costs[i + j] != -1){
                    if(min == -1 || min > costs[i + j] + A[i]){
                        min = costs[i + j] + A[i];
                        minChoice = j + i;
                    }
                }
            }

            costs[i] = min;
            choice[i] = minChoice;
        }


        int cur = 0;
        List<Integer> path = new ArrayList<>();
        path.add(1);
        while (cur < A.length - 1){
            if(choice[cur] == -1) break;
            path.add(choice[cur] + 1);
            cur = choice[cur];
        }

        if(cur < A.length - 1) return new ArrayList<>();
        return path;
    }
}