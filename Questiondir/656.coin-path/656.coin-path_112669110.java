public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer>[] paths = (List<Integer>[]) new List[A.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<>();
        }
        paths[0].add(1);
        
        int[] dists = new int[A.length];
        Arrays.fill(dists, -1);
        dists[0] = A[0];
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] == -1) continue;
            int minDist = Integer.MAX_VALUE;
            List<Integer> minPath = new ArrayList<>();
            for (int step = B; step >= 1; step--) {
                if (i - step >= 0 && dists[i - step] != -1 && dists[i - step] <= minDist) {
                    if (dists[i - step] < minDist) {
                        minDist = dists[i - step];
                        minPath = paths[i - step];
                    } else if (smaller(paths[i - step], minPath, i + 1)) {
                        minPath = paths[i - step];
                    }
                }
            }
            if (minDist != Integer.MAX_VALUE) {
                paths[i] = new ArrayList<>(minPath);
                paths[i].add(i + 1);
                dists[i] = minDist + A[i];
            } else {
                dists[i] = -1;
            }
            // System.out.println(Arrays.toString(dists));
            // for (int k : paths[i]) {
            //     System.out.print(k + " ");
            // }
            // System.out.println();
        }
        
        return paths[A.length - 1];
    }
    
    private boolean smaller(List<Integer> path1, List<Integer> path2, int end) {
        int i = 0, j = 0;
        path1.add(end);
        path2.add(end);
        while (i < path1.size() && j < path2.size() && path1.get(i) == path2.get(j)) {
            i++;
            j++;
        }
        if ((i < path1.size() && j < path2.size() && path1.get(i) < path2.get(j)) || (i == path1.size() && j < path2.size())) {
            path1.remove(path1.size() - 1);
            path2.remove(path2.size() - 1);
            return true;
        } else {
            path1.remove(path1.size() - 1);
            path2.remove(path2.size() - 1);
            return false;
        }
    }
}