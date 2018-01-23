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
        self.s = 0
        
        def go(r):
            if not r:
                return
            go(r.right)
            self.s = r.val = self.s + r.val
            go(r.left)

        go(root)
        return root