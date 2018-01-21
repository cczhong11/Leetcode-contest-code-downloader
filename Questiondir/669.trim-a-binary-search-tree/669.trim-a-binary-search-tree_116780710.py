# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def trimBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: TreeNode
        """
        
        def dfs(root):
            if not root:
                return None
            if root.val < L:
                return dfs(root.right)
            elif root.val > R:
                return dfs(root.left)
            root.left = dfs(root.left)
            root.right = dfs(root.right)
            return root
        
        return dfs(root)
        