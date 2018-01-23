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
        self.sum = 0
        self.dfs(root)
        return root
        
    def dfs(self, node):
        if not node: return
        self.dfs(node.right)
        
        self.sum += node.val
        node.val = self.sum
        
        self.dfs(node.left)