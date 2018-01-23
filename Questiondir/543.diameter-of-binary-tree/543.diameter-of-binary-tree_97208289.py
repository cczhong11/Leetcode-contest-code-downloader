# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        
        self.helper(root)
        return self.ans
        
    def helper(self, node):
        if not node: return 0
        
        l = self.helper(node.left)
        r = self.helper(node.right)
        
        self.ans = max(self.ans, l+r)
        
        return max(l,r)+1
        
        