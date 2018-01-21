# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dfs(self, r):
        if r is None:
            return 0
        return r.val + self.dfs(r.left) + self.dfs(r.right)
    def f(self, r):
        if r is None:
            return 0
        v = r.val + self.f(r.left) + self.f(r.right)
        if v == self.target:
            self.ans = True
        return v
    def checkEqualTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        s = self.dfs(root)
        if s % 2 != 0:
            return False
        self.target = s / 2
        self.ans = False
        self.f(root.left)
        self.f(root.right)
        return self.ans
        