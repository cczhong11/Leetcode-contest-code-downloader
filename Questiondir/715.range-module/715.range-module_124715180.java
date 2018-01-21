class RangeModule {
    // insert and remove interval
    private TreeSet<int[]> treeSet;
    public RangeModule() {
        treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
    }
    
    public void addRange(int left, int right) {
        int[] cur = new int[]{left, right};
        int[] low1 = treeSet.floor(new int[]{left, left});
        int[] low2 = treeSet.ceiling(new int[]{left, left});
        int[] high1 = treeSet.floor(new int[]{right, right});
        int[] high2 = treeSet.ceiling(new int[]{right, right});
        if (low1 == null && low2 == null && high1 == null && high2 == null) {
            treeSet.add(cur);
        } else {
            Set<int[]> set = treeSet.subSet(low1 == null ? low2 : low1, true, high2 == null ? high1 : high2, true);
            List<int[]> list = new ArrayList<>();
            for (int[] node : set) {
                list.add(node);
            }
            for (int[] node : list) {
                treeSet.remove(node);
            }
            for (int i = 0; i < list.size(); i++) {
                if (cur[0] > list.get(i)[1] || cur[1] < list.get(i)[0]) {
                    treeSet.add(list.get(i));
                } else {
                    cur[0] = Math.min(cur[0], list.get(i)[0]);
                    cur[1] = Math.max(cur[1], list.get(i)[1]);
                }
            }
            treeSet.add(cur);
        }
    }
    
    public boolean queryRange(int left, int right) {
        int[] cur = new int[]{left, right};
        int[] tmp = treeSet.floor(cur);
        return tmp != null && tmp[1] >= cur[1];
    }
    
    public void removeRange(int left, int right) {
        int[] cur = new int[]{left, right};
        int[] low1 = treeSet.floor(new int[]{left, left});
        int[] low2 = treeSet.ceiling(new int[]{left, left});
        int[] high1 = treeSet.floor(new int[]{right, right});
        int[] high2 = treeSet.ceiling(new int[]{right, right});
        if (low1 == null && low2 == null && high1 == null && high2 == null) {
        } else {
            Set<int[]> set = treeSet.subSet(low1 == null ? low2 : low1, true, high2 == null ? high1 : high2, true);
            List<int[]> list = new ArrayList<>();
            for (int[] node : set) {
                list.add(node);
            }
            for (int[] node : list) {
                treeSet.remove(node);
            }
            for (int i = 0; i < list.size(); i++) {
                if (cur[0] > list.get(i)[1] || cur[1] < list.get(i)[0]) {
                    treeSet.add(list.get(i));
                } else {
                    if (cur[0] > list.get(i)[0]) {
                        treeSet.add(new int[]{list.get(i)[0], cur[0]});
                    }
                    if (cur[1] < list.get(i)[1]) {
                        treeSet.add(new int[]{cur[1], list.get(i)[1]});
                    }
                }
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */