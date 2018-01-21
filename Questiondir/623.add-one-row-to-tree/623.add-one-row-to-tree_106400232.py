# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            new = TreeNode(v)
            new.left = root
            return new
        elif d == 2:
            newleft = TreeNode(v)
            newright = TreeNode(v)
            newleft.left = root.left
            newright.right = root.right
            root.left = newleft
            root.right = newright
            return root
        else:
            if root.left is not None:
                root.left = self.addOneRow(root.left, v, d-1)
            if root.right is not None:
                root.right = self.addOneRow(root.right, v, d-1)
            return root