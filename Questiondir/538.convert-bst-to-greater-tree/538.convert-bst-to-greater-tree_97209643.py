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
        if root == None:
            return None
        
        def convertNode(s, root):
            if root.right != None:
                s = convertNode(s, root.right)
            root.val += s
            s = root.val
            if root.left != None:
                s = convertNode(s, root.left)
            return s
        convertNode(0, root)
        return root