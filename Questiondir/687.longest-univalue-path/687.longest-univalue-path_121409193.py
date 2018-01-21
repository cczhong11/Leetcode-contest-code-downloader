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
        self.ret = 0
        self.longest(root)
        return self.ret
        
    def longest(self,  root):
        if not root: return 0
        depthL = self.longest(root.left)
        depthR = self.longest(root.right)
        if root.left and root.left.val == root.val:
            depthL += 1
        else:
            depthL = 0
        if root.right and root.right.val == root.val:
            depthR += 1
        else:
            depthR = 0
        self.ret = max(self.ret, depthL+depthR)
        return max(depthL, depthR)