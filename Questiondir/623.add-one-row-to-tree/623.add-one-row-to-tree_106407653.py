# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

def add(root, v, d):
    if not root:
        return
    if d == 1:
        oldLeft = root.left
        newLeft = TreeNode(v)
        newLeft.left = oldLeft
        root.left = newLeft
        oldRight = root.right
        newRight = TreeNode(v)
        newRight.right = oldRight
        root.right = newRight
        return
    add(root.left, v, d - 1)
    add(root.right, v, d - 1)

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            newNode = TreeNode(v)
            newNode.left = root
            return newNode
        add(root, v, d - 1)
        return root
    
    
            