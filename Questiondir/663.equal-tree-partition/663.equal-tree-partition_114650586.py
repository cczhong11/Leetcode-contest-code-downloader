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
        ss = set()
        def foo(p, r=True):
            if p:
                s = p.val + foo(p.left) + foo(p.right)
                if r:
                    ss.add(s)
                return s
            return 0
        s = foo(root, False)
        return s % 2 == 0 and s >> 1 in ss