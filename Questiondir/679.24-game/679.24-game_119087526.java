class Solution {
    private boolean result = false;
    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length != 4) {
            return false;
        }
        Arrays.sort(nums);
        // get all permutation of nums
        List<List<Integer>> resList = new ArrayList<>();
        getNext(nums, resList, new ArrayList<>(), new boolean[4]);
        
        for (int j = 0; j < resList.size(); j++) {
            double[] arrs = new double[4];
            for (int i = 0; i < 4; i++) {
                arrs[i] = (double) resList.get(j).get(i);
            }
            result = dfs(arrs, 0, 3);    
            if (result) return true;
        }
        
        
        return result;
    }
    
    private void getNext(int[] nums, List<List<Integer>> resList, List<Integer> tmpList, boolean[] visited) {
        if (tmpList.size() == 4) {
            resList.add(new ArrayList<>(tmpList));
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (visited[i]) continue;
            if (i != 0 && (!visited[i - 1] && nums[i] == nums[i - 1])) continue;
            visited[i] = true;
            tmpList.add(nums[i]);
            getNext(nums, resList, tmpList, visited);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }
    
    // find if there are any operations can get to 24
    private boolean dfs(double[] arrs, int left, int right) {
        if (result) {
            return result;
        }
        
        for (int i = 0; i < 4; i++) {
            List<Double> lefts = op(arrs, 0, i);
            List<Double> rights = op(arrs, i + 1, 3);
            for (int m = 0; m < lefts.size(); m++) {
                for (int n = 0; n < rights.size(); n++) {
                    double res = lefts.get(m) * rights.get(n);
                    if (Math.abs(res - 24) <= 0.000004) {
                        return true;
                    }
                    res = lefts.get(m) + rights.get(n);
                    if (Math.abs(res - 24) <= 0.000004) {
                        return true;
                    }
                    res = lefts.get(m) / rights.get(n);
                    if (Math.abs(res - 24) <= 0.000004) {
                        return true;
                    }
                    res = lefts.get(m) - rights.get(n);
                    if (Math.abs(res - 24) <= 0.000004) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private List<Double> op(double[] arrs, int left, int right) {
        List<Double> resList = new ArrayList<>();
        if (left == right) {
            resList.add(arrs[left]);
            return resList;
        }
        
        if (left + 1 == right) {
            resList.add(arrs[left] + arrs[right]);
            resList.add(arrs[left] - arrs[right]);
            resList.add(arrs[left] * arrs[right]);
            resList.add(arrs[left] / arrs[right]);
        }
        
        if (left + 2 == right) {
            List<Double> lefts = op(arrs, left, left + 1);
            for (int i = 0; i < lefts.size(); i++) {
                resList.add(lefts.get(i) + arrs[right]);
                resList.add(lefts.get(i) - arrs[right]);
                resList.add(lefts.get(i) * arrs[right]);
                resList.add(lefts.get(i) / arrs[right]);
            }
            List<Double> rights = op(arrs, left + 1, right);
            for (int i = 0; i < rights.size(); i++) {
                resList.add(arrs[left] + rights.get(i));
                resList.add(arrs[left] - rights.get(i));
                resList.add(arrs[left] * rights.get(i));
                resList.add(arrs[left] / rights.get(i));
            }
        }
        return resList;
    }
}