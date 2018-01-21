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
        def dfs(p, L, R):
            if not p:
                return None
            p.left = dfs(p.left, L, R)
            p.right = dfs(p.right, L, R)
            if L <= p.val <= R:
                return p
            else:
                if not p.left:
                    return p.right
                return p.left
        return dfs(root, L, R)            