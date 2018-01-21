import java.util.SortedMap;

class RangeModule {

    private final SortedMap<Integer, Integer> ranges; 
	public RangeModule() {
		ranges = new TreeMap<Integer, Integer>();
    }
    
    public void addRange(int left, int right) {
    	List<Integer> keysToRemove = new ArrayList<>();
    	int leftAdd = left;
    	int rightAdd = right;
    	for (Map.Entry<Integer, Integer> e : ranges.entrySet()) {
    		if (e.getKey() > right) {
    			break;
    		}
    		if (e.getValue() < left) {
    			continue;
    		}
    		keysToRemove.add(e.getKey());
    		leftAdd = Math.min(e.getKey(), leftAdd);
    		rightAdd = Math.max(e.getValue(), rightAdd);
    	}
    	for (int r : keysToRemove) {
    		ranges.remove(r);
    	}
    	ranges.put(leftAdd, rightAdd);
    }
    
    public boolean queryRange(int left, int right) {
        if (ranges.containsKey(left) && ranges.get(left) >= right) {
        	return true;
        }
        SortedMap<Integer, Integer> m = ranges.headMap(left);
        if (m.isEmpty()) {
        	return false;
        }
        return m.get(m.lastKey()) >= right;
    }
    
    public void removeRange(int left, int right) {
    	List<Integer> keysToRemove = new ArrayList<>();
    	int firstLeft = 0;
    	int secondRight = 0;
    	boolean addFirst = false;
    	boolean addSecond = false;
    	for (Map.Entry<Integer, Integer> e : ranges.entrySet()) {
    		if (e.getKey() > right) {
    			break;
    		}
    		if (e.getValue() < left) {
    			continue;
    		}
    		if (e.getKey() < left) {
    			firstLeft = e.getKey();
    			addFirst = true;
    		}
    		if (e.getValue() > right) {
				secondRight = e.getValue();
				addSecond = true;
			}
    		if (e.getKey() >= left) {
    			keysToRemove.add(e.getKey());
    		}
    	}
    	for (int r : keysToRemove) {
    		ranges.remove(r);
    	}
    	if (addFirst) {
    		ranges.put(firstLeft, left);
    	}
    	if (addSecond) {
    		ranges.put(right, secondRight);
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