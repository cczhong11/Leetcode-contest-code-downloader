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
        if d==1:
            nr=TreeNode(v)
            nr.left=root
            return nr
        
        def search(r,v,d):
            if not r:
                return
            
            if d>2:
                search(r.left,v,d-1)
                search(r.right,v,d-1)
            elif d==2:
                #if r.left:
                nl=TreeNode(v)
                nl.left=r.left
                r.left=nl
                #if r.right:
                nr=TreeNode(v)
                nr.right=r.right
                r.right=nr
        
        search(root,v,d)
        return root