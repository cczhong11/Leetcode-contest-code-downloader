class Solution {
	private static class Number {
		public long value1 , value2;
		public Number(long value1 , long value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
		public Number add(Number num) {
			long next1 = this.value1 * num.value2 + this.value2 * num.value1;
			long next2 = this.value2 * num.value2;
			return new Number(next1 , next2);
		}
		public Number minus(Number num) {
			long next1 = this.value1 * num.value2 - this.value2 * num.value1;
			long next2 = this.value2 * num.value2;
			return new Number(next1 , next2);
		}
		public Number mul(Number num) {
			long next1 = this.value1 * num.value1;
			long next2 = this.value2 * num.value2;
			return new Number(next1 , next2);
		}
		public Number divide(Number num) {
			long next1 = this.value1 * num.value2;
			long next2 = this.value2 * num.value1;
			return new Number(next1 , next2);
		}
		public boolean isZero() {
			return this.value1 == 0 ? true : false;
		}
		public boolean check() {
			if (this.value1 == 0) {
				return false;
			} else {
                long temp1 = Math.abs(value1);
                long temp2 = Math.abs(value2);
                if (temp1 % temp2 == 0) {
                    long result = value1 / value2;
                    return result == 24;
                } else {
                    return false;
                }
			}
		}
	}
	
    public boolean judgePoint24(int[] nums) {
     
    	List<Number> list = new ArrayList<>();
    	for (int value : nums) {
    		list.add(new Number(value , 1));
    	}
    	return check(list);
    	
    }
    
    private boolean check(List<Number> list) {
    	
    	if (list.size() == 1) {
    		return list.get(0).check();
    	} else {
    		int i , j , k , n = list.size();
    		for (i = 0;i < n;i ++) {
    			for (j = 0;j < n;j ++) {
    				if (i != j) {
	    				List<Number> next = new ArrayList<>();
	    				for (k = 0;k < n;k ++) {
	    					if (k != i && k != j) {
	    						next.add(list.get(k));
	    					}
	    				}
	    				next.add(list.get(i).add(list.get(j)));
	    				if (check(next)) {
	    					return true;
	    				}
	    				next.remove(next.size() - 1);
	    				
	    				next.add(list.get(i).minus(list.get(j)));
	    				if (check(next)) {
	    					return true;
	    				}
	    				next.remove(next.size() - 1);
	    				
	    				next.add(list.get(i).mul(list.get(j)));
	    				if (check(next)) {
	    					return true;
	    				}
	    				next.remove(next.size() - 1);
	    				
	    				if (list.get(j).isZero() == false) {
		    				next.add(list.get(i).divide(list.get(j)));
		    				if (check(next)) {
		    					return true;
		    				}
		    				next.remove(next.size() - 1);
	    				}
    				}
    			}
    		}
    		return false;
    	}
    	
    }
}