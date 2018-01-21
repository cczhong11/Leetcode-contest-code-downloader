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
            node = TreeNode(v)
            node.left = root
            return node
        else:
            return self.helper(root,v,d)
            #node = TreeNode(root.val)
            #node.left = self.helper(root.left,v,d-1)
            #node.right = self.helper(root.right,v,d-1)
    
    def helper(self,root,v,d):
        if d == 2:
            node = TreeNode(root.val)
            node.left = TreeNode(v)
            node.left.left = root.left
            node.right = TreeNode(v)
            node.right.right = root.right
            return node
        else:
            node = TreeNode(root.val)
            if root.left is not None:
                node.left = self.helper(root.left,v,d-1)
            if root.right is not None:
                node.right = self.helper(root.right,v,d-1)
            return node