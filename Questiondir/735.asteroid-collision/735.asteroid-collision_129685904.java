class Solution {
public int[] asteroidCollision(int[] asteroids) {
        List<Integer> resList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int aster : asteroids) {
            if (aster > 0) {
                rightList.add(aster);
            } else {
                int val = -aster;
                int i = rightList.size() - 1;
                for (; i >= 0; i--) {
                    if (rightList.get(i) < val) {
                        rightList.remove(i);
                    } else if (rightList.get(i) == val) {
                        rightList.remove(i);
                        break;
                    } else {
                        break;
                    }
                }
                if (i < 0) {
                    resList.add(aster);
                }
            }
        }
        resList.addAll(rightList);
    
        int res[] = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}