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
        def height(root):
            if root == None:
                return 0
            else:
                return 1 + max(height(root.left), height(root.right))
        if root == None:
            return 0
        else:
            return max(self.diameterOfBinaryTree(root.left), self.diameterOfBinaryTree(root.right), height(root.left) + height(root.right))