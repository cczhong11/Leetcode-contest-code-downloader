# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def ht(self, root):
        if root is None:
            return 0
        return 1 + max(self.ht(root.left), self.ht(root.right))
    
    def helper(self, root, level, start, end):
        if root is None:
            return
        mid = (end + start) / 2
        
        self.res[level][mid] = str(root.val)
        
        self.helper(root.left, level+1, start, mid-1)
        self.helper(root.right, level+1, mid+1, end)
    
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        h = self.ht(root)
        w = 1
        for i in range(1, h):
            w = (w * 2 + 1)
        
        self.res = [['' for _ in range(w)] for _ in range(h)]
        self.helper(root, 0, 0, w-1)
        return self.res
        