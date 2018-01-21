# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def getTotalSum(self, root):
        if not root:
            return 0
        return self.getTotalSum(root.left) + self.getTotalSum(root.right) + root.val
    
    def traverse(self, root):
        if not root:
            return 0
        
        left_sum = self.traverse(root.left)
        right_sum = self.traverse(root.right)
        if (self.total == right_sum * 2 and root.right) or (self.total == left_sum * 2 and root.left):
            self.canPartition = True
        
        return root.val + left_sum + right_sum
    
    def checkEqualTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.canPartition = False
        self.total = self.getTotalSum(root)
        self.traverse(root)
        return self.canPartition