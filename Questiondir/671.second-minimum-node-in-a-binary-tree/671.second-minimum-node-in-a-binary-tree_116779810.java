	class Solution {
	    public int findSecondMinimumValue(TreeNode root) {
	    	TreeSet<Integer> ts = new TreeSet<>();
	        go(root, ts);
	        if(ts.size() < 2){
	        	return -1;
	        }
	        ts.pollFirst();
	        return ts.first();
	    }
	    
	    void go(TreeNode node, TreeSet<Integer> ts)
	    {
	    	if(node == null)return;
	    	ts.add(node.val);
	    	go(node.left, ts);
	    	go(node.right, ts);
	    }
	}	
