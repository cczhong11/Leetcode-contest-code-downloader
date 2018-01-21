# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        l, r = [], []
        def foo(p, d = 0, x = 0):
            if p:
                if d < len(l):
                    l[d] = min(l[d], x)
                else:
                    l.append(x)
                if d < len(r):
                    r[d] = max(r[d], x)
                else:
                    r.append(x)
                foo(p.left, d + 1, x << 1)
                foo(p.right, d + 1, (x << 1) + 1)
        foo(root)
        return max(map(operator.sub, r, l)) + 1