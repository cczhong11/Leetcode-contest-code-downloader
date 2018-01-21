	public class Solution {
	    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
	    	Collections.sort(arr, new Comparator<Integer>() {
				public int compare(Integer a, Integer b) {
					int ad = Math.abs(a - x);
					int bd = Math.abs(b - x);
					if(ad != bd)return ad - bd;
					return a - b;
				}
			});
	    	arr = new ArrayList<>(arr.subList(0, Math.min(k, arr.size())));
	    	Collections.sort(arr);
	    	return arr;
	    }
	}	