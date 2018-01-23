# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        s = [0]
        def f(root):
            if not root:
                return
            f(root.right)
            v = root.val
            root.val += s[0]
            s[0] += v
            f(root.left)
        f(root)
        return root