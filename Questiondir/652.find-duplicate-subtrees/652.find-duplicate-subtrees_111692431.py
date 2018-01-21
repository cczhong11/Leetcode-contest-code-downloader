# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        if not root:
            return []
        
        self.d={}
        self.a=[]
        
        def flatten(r):
            if not r:
                return '()'
            t=str(r.val)+flatten(r.left)+flatten(r.right)
            if t in self.d:
                if self.d[t]==1:
                    self.a.append(r)
                self.d[t]+=1
            else:
                self.d.setdefault(t,1)
            return '('+t+')' 
        
        flatten(root.left)
        flatten(root.right)
        return self.a