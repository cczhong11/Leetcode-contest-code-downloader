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
        if d == 1:
            n = TreeNode(v)
            n.left = root
            return n
            
        def dfs(p, dd):
            if not p:
                return
            if d == dd + 1:
                n = TreeNode(v)
                n.left = p.left
                p.left = n
                
                n = TreeNode(v)
                n.right = p.right
                p.right = n
            dfs(p.left, dd+1)
            dfs(p.right, dd+1)
        
        dfs(root, 1)
        return root