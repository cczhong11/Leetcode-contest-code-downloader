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
        if root is None:
            return []
        
        self.repo = {}
        self.nodes = {}
        self.buildSub(root)
        
        rv = []
        for k, v in self.nodes.iteritems():
            if len(v)>1:
                rv.append(v[0])
                
        return rv
        
                
    def buildSub(self, node):
        if node is None:
            return 'N'
        
        if id(node) in self.repo:
            return self.repo[id(node)]
        
        self.repo[id(node)] = (node.val, self.buildSub(node.left), self.buildSub(node.right))
        self.nodes.setdefault(self.repo[id(node)], []).append(node)
        return self.repo[id(node)]
        
    