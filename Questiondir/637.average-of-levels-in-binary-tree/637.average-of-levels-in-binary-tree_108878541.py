# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        if root==None:
            return []
        res = []
        que = [root]
        l,r = 0,1
        while l<r:
            s = 0
            n = r-l
            while l<r:
                p = que[l]
                s += p.val
                if p.left!=None:
                    que.append(p.left)
                if p.right!=None:
                    que.append(p.right)
                l += 1
            res.append(s/float(n))
            r = len(que)
        return res