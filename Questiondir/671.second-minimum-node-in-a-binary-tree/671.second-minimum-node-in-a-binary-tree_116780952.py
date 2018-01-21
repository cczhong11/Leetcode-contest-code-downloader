# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSec(self, root, mn):
        if root is None:
            return -1
        if root.val > mn:
            return root.val
        l, r = self.findSec(root.left, mn), self.findSec(root.right, mn)
        if l != -1 and r != -1:
            return min(l, r)
        if l == -1:
            return r
        return l
    
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return -1
        mn = root.val
        snd = self.findSec(root, mn)
        return snd
        