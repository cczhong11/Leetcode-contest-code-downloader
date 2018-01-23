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
        self.cum = 0
        self.helper(root)
        return root
        
    def helper(self, node):
        if node is None:
            return
        self.helper(node.right)
        this_val = node.val
        node.val += self.cum
        self.cum += this_val
        self.helper(node.left)