# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        val1 = self.longestEqual(root.left, root.val) + self.longestEqual(root.right, root.val)
        val2 = self.longestUnivaluePath(root.left)
        val3 = self.longestUnivaluePath(root.right)
        return max(val1, max(val2, val3))
    
    
    def longestEqual(self, root, val):
        if root is None or root.val != val:
            return 0
        else:
            return 1 + max(self.longestEqual(root.left, val), self.longestEqual(root.right, val))