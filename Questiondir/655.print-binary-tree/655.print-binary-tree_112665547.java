/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	private static class Element {
		public TreeNode node;
		public int index;
		public Element(TreeNode node , int index) {
			this.node = node;
			this.index = index;
		}
	}
	
	private Map<TreeNode , Integer> map = new HashMap<>();
	private static String[][] array = new String[1010][1010];
	private int maxHeight = 0;
    
    public List<List<String>> printTree(TreeNode root) {
    	
    	if (root == null) {
    		return Arrays.asList();
    	} else {
    		maxHeight = 0;
    		dfs(root , 0);
    		int n = map.get(root) * 2 + 1;
    		for (int i = 0;i < maxHeight;i ++) {
    			for (int j = 0;j < n;j ++) {
    				array[i][j] = null;
    			}
    		}
    		fill(root , 0 , map.get(root) * 2 , 0);
    		List<List<String>> ans = new ArrayList<>();
    		for (int i = 0;i < maxHeight;i ++) {
    			List<String> list = new ArrayList<>();
    			for (int j = 0;j < n;j ++) {
    				if (array[i][j] == null) {
    					list.add("");
    				} else {
    					list.add(array[i][j]);
    				}
    			}
    			ans.add(list);
    		}
    		return ans;
    	}
        
    }
    
    private void fill(TreeNode root , int from , int to , int height) {
    	
    	int mid = (from + to) / 2;
    	array[height][mid] = Integer.toString(root.val);
    	if (root.left != null) {
    		fill(root.left , from , mid - 1 , height + 1);
    	}
    	if (root.right != null) {
    		fill(root.right , mid + 1 , to , height + 1);
    	}
    	
    }
    
    private int dfs(TreeNode root , int h) {
    	
    	if (root == null) {
    		return 0;
    	} else {
    		h ++;
    		if (h > maxHeight) {
    			maxHeight = h;
    		}
    		if (root.left == null && root.right == null) {
    			map.put(root , 0);
    			return 1;
    		} else {
    			int width1 = dfs(root.left , h);
    			int width2 = dfs(root.right , h);
    			map.put(root , Math.max(width1 , width2));
    			return Math.max(width1 , width2) * 2 + 1;
    		}
    	}
    	
    }
}