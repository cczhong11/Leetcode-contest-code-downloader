# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def checkEqualTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def getSum(p):
            tot = p.val
            if p.left:
                tot += getSum(p.left)
            if p.right:
                tot += getSum(p.right)
            return tot
        if not root:
            return False
        tot = [getSum(root)]
        if tot[0] % 2:
            return False
        tot[0] /= 2
        res = [False]
        def dfs(p):
            now = p.val
            if p.left:
                tmp = dfs(p.left)
                if tmp == tot[0]:
                    res[0] = True
                    return now
                now += tmp
            if p.right:
                tmp = dfs(p.right)
                if tmp == tot[0]:
                    res[0] = True
                    return now
                now += tmp
            return now
        dfs(root)
        return res[0]
                