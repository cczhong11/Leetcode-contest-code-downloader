# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dfs(self, root, fromAbove):
        if fromAbove + 1 > self.best:
            self.best = fromAbove + 1

        if root.left is None and root.right is None:
            return 1
        curRtn = 1
        if root.left is not None:
            if root.left.val == root.val:
                ll = self.dfs(root.left, fromAbove + 1)
                if curRtn < ll + 1:
                    curRtn = ll + 1
            else:
                self.dfs(root.left, 0)
                ll = 0
        else:
            ll = 0
        if root.right is not None:
            if root.right.val == root.val:
                rr = self.dfs(root.right, fromAbove + 1)
                if curRtn < rr + 1:
                    curRtn = rr + 1
            else:
                self.dfs(root.right, 0)
                rr = 0
        else:
            rr = 0
        if self.best < fromAbove + ll + 1:
            self.best = fromAbove + ll + 1
        if self.best < fromAbove + rr + 1:
            self.best = fromAbove + rr + 1
        if self.best < ll + rr + 1:
            self.best = ll + rr + 1
        return curRtn
            
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        self.best = 0
        self.dfs(root, 0)
        return self.best - 1