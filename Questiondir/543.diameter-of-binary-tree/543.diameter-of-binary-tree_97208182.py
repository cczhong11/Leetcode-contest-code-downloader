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
        self.longest = 1
        self.helper(root)
        return self.longest-1
        
    # return longest
    def helper(self, node):
        if node is None:
            return 0
        l, r = self.helper(node.left), self.helper(node.right)
        self.longest = max(self.longest, l+r+1)
        return max(l, r)+1
