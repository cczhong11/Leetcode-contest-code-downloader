# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def go(r):
            if not r:
                return (0, 0)
            d = 0
            h1 = -1
            h2 = -1
            if r.left:
                x, y = go(r.left)
                d = max(d, x)
                h1 = 1 + y
            if r.right:
                x, y = go(r.right)
                d = max(d, x)
                h2 = 1 + y
            if h1 >= 0 and h2 >= 0:
                d = max(d, h1 + h2)
            return (max(d, h1, h2), max(0, h1, h2))
            
        return go(root)[0]
        