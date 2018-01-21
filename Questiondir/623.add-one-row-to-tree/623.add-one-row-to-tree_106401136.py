# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if not root: return None
        
        if d == 1:
            t = TreeNode(v)
            t.left = root
            return t
        
        self.dfs(root, 1, v, d)
        
        return root
        
    def dfs(self, node, depth, v, d):
        if not node:
            return 
        
        if depth == d - 1:
            t1 = TreeNode(v)
            t2 = TreeNode(v)
            t1.left = node.left
            t2.right = node.right
            node.left, node.right = t1, t2
            return
        
        self.dfs(node.left, depth + 1, v, d)
        self.dfs(node.right, depth + 1, v, d)
    
        