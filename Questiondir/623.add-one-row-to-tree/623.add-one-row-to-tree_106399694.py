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
        def iterTree(root,depth):
            if root==None: return
            if depth==d-1:
                L,R = TreeNode(v), TreeNode(v)
                L.left = root.left
                R.right = root.right
                root.left = L
                root.right =R
                return
            iterTree(root.left,depth+1)
            iterTree(root.right,depth+1)
        if d==1:
            R = TreeNode(v)
            R.left = root
            return R
        iterTree(root,1)
        return root