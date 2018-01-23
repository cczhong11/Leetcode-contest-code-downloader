public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size() - 1; i++) {
            if(timePoints.get(i).equals(timePoints.get(i+1))) return 0;
            String[] split1 = timePoints.get(i).split(":"), split2 = timePoints.get(i+1).split(":");
            int[] first = new int[]{Integer.parseInt(split1[0]), Integer.parseInt(split1[1])}, second = new int[]{Integer.parseInt(split2[0]), Integer.parseInt(split2[1])};
            diff = Math.min(diff, Math.min(second[1] - first[1] + 60*(second[0] - first[0]), first[1] - second[1] + 60*(first[0] + 24 - second[0])));
        }
        String[] split1 = timePoints.get(0).split(":"), split2 = timePoints.get(timePoints.size() -1).split(":");
            int[] first = new int[]{Integer.parseInt(split1[0]), Integer.parseInt(split1[1])}, second = new int[]{Integer.parseInt(split2[0]), Integer.parseInt(split2[1])};
            diff = Math.min(diff, Math.min(second[1] - first[1] + 60*(second[0] - first[0]), first[1] - second[1] + 60*(first[0] + 24 - second[0])));
            return diff;
    }
}