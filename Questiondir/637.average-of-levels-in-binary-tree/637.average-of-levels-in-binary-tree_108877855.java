	public class Solution {
	    public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> sum = new ArrayList<>();
	        List<Integer> num = new ArrayList<>();
	        go(root, 0, sum, num);
	        for(int i = 0;i < num.size();i++){
	        	sum.set(i, sum.get(i) / num.get(i));
	        }
	        return sum;
	    }
	    
	    void go(TreeNode cur, int dep, List<Double> sum, List<Integer> num)
	    {
	    	if(cur == null)return;
	    	if(dep >= sum.size()){
	    		sum.add((double)cur.val);
	    		num.add(1);
	    	}else{
	    		sum.set(dep, sum.get(dep) + cur.val);
	    		num.set(dep, num.get(dep) + 1);
	    	}
	    	go(cur.left, dep+1, sum, num);
	    	go(cur.right, dep+1, sum, num);
	    };
	}	
