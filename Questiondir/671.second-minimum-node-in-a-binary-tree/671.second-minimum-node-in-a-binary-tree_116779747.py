# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        rec = set()
        def dfs(p):
            if not p:
                return
            rec.add(p.val)
            dfs(p.left)
            dfs(p.right)
        dfs(root)
        g = sorted(list(rec))
        if len(g) <= 1:
            return -1
        return g[1]