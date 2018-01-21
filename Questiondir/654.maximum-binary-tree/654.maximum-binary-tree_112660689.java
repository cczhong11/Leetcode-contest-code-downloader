	  public class Solution {
		    public TreeNode constructMaximumBinaryTree(int[] nums) {
		    	return go(nums, 0, nums.length);
		    }
		    
		    TreeNode go(int[] a, int l, int r)
		    {
		    	if(l >= r)return null;
		    	int max = a[l];
		    	int arg = l;
		    	for(int i = l;i < r;i++){
		    		if(a[i] > max){
		    			max = a[i];
		    			arg = i;
		    		}
		    	}
		        TreeNode root = new TreeNode(max);
		        root.left = go(a, l, arg);
		        root.right = go(a, arg+1, r);
		        return root;
		    }
	  }
