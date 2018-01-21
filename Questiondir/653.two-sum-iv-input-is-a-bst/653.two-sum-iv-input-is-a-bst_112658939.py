# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        d = {}
        def trav(root):
            if (root == None):
                return
            d[root.val] = d.get(root.val,0) + 1
            trav(root.left)
            trav(root.right)
        trav(root)
        for x in d:
            if (k-x != x and k-x in d):
                return True
            if (k-x == x and d[x] >= 2):
                return True
        return False
        