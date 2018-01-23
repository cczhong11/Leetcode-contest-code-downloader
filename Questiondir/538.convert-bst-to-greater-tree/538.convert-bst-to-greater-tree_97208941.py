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
        self.tot = 0
        def calc_tot(root):
            if not root:
                return
            self.tot += root.val
            calc_tot(root.left)
            calc_tot(root.right)
        calc_tot(root)
        def toGT(root):
            if not root:
                return
            toGT(root.left)
            self.tot -= root.val
            root.val += self.tot
            toGT(root.right)
        toGT(root)
        return root