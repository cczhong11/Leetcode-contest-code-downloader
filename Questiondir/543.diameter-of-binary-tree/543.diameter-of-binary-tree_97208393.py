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
        maxL = [0]
        def f(root):
            if not root:
                return 0
            ll = f(root.left)
            lr = f(root.right)
            maxL[0] = max(maxL[0], 1+ll+lr)
            return 1+max(ll, lr)
        f(root)
        return max(0, maxL[0]-1)