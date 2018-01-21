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
            newroot = TreeNode(v)
            newroot.left = root
            return newroot
        
        def addrow(root, v, d):
            if not root:
                return
            if d == 2:
                newLeft = TreeNode(v)
                newLeft.left = root.left
                root.left = newLeft
                newRight = TreeNode(v)
                newRight.right = root.right
                root.right = newRight
            else:
                addrow(root.left, v, d - 1)
                addrow(root.right, v, d - 1)
        addrow(root, v, d)
        return root
                