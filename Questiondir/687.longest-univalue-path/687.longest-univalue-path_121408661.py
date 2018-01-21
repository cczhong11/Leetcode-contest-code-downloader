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
        self.rv = 1
        self.visit(root)
        return self.rv - 1
    
    def visit(self, node):
        if node is None:
            return 0
        
        rv = 1
        left = self.visit(node.left)
        right = self.visit(node.right)
        if node.left and node.left.val == node.val:
            rv = max(rv, left+1)
        if node.right and node.right.val == node.val:
            rv = max(rv, right+1)
            
        if node.left and node.right and node.left.val == node.val == node.right.val:
            self.rv = max(self.rv, rv, left+right+1)
        else:
            self.rv = max(self.rv, rv)
        
        return rv