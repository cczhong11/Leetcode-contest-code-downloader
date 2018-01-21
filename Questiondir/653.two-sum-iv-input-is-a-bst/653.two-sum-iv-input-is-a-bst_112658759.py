# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def helper(self, root, k):
        if root is None:
            return False
        
        if (k - root.val) in self.d:
            return True
        
        self.d.add(root.val)
        return self.helper(root.left, k) or self.helper(root.right, k)
    
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        self.d = set()
        return self.helper(root, k)
        