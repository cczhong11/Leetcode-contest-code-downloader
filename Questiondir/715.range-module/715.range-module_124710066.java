class RangeModule {
    // true value is start, false is end of range
    TreeMap<Integer, Boolean> rangeMap;

    public RangeModule() {
        rangeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer floor = rangeMap.floorKey(left);
        if (floor != null && floor == left) {
            if (!rangeMap.get(left)) rangeMap.remove(left);
        } else if (floor == null || !rangeMap.get(floor)) {
            rangeMap.put(left, true);
        }
        Integer ceiling = rangeMap.ceilingKey(right);
        if (ceiling != null && ceiling == right) {
            if (rangeMap.get(right)) rangeMap.remove(right);
        } else if (ceiling == null || rangeMap.get(ceiling)) {
            rangeMap.put(right, false);
        }
        Set<Integer> toRemove = new HashSet<>();
        for (Integer key : rangeMap.subMap(left, false, right, false).keySet()) {
            toRemove.add(key);
        }
        for (Integer key : toRemove) rangeMap.remove(key);
    }

    public boolean queryRange(int left, int right) {
        Integer floor = rangeMap.floorKey(left);
        Integer ceiling = rangeMap.ceilingKey(right);
        return floor != null && rangeMap.get(floor) && ceiling != null && !rangeMap.get(ceiling) && rangeMap.subMap(left, false, right, false).isEmpty();
    }

    public void removeRange(int left, int right) {
        Integer floor = rangeMap.floorKey(left);
        if (floor != null && floor == left) {
            if (rangeMap.get(left)) rangeMap.remove(left);
        } else if (floor != null && rangeMap.get(floor)) {
            rangeMap.put(left, false);
        }
        Integer ceiling = rangeMap.ceilingKey(right);
        if (ceiling != null && ceiling == right) {
            if (!rangeMap.get(right)) rangeMap.remove(right);
        } else if (ceiling != null && !rangeMap.get(ceiling)) {
            rangeMap.put(right, true);
        }
        Set<Integer> toRemove = new HashSet<>();
        for (Integer key : rangeMap.subMap(left, false, right, false).keySet()) {
            toRemove.add(key);
        }
        for (Integer key : toRemove) rangeMap.remove(key);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */