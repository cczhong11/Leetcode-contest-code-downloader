# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def postOrder(self, node, cur, d, res):
            
            if node:
                self.postOrder(node.left, cur, d, res)
                self.postOrder(node.right, cur, d, res)
                cur.append(str(node.val))
                
                # key = ','.join(cur)
                # if key in d:
                #     print key
                #     res.append(node)
                # else:
                #     d[key] = node
            else:
                cur.append('#')
    
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        if not root:
            return []
        d = {}
        res = set()
        def helper(node, d, res):
            cur = []
            self.postOrder(node, cur, d, res)
            key = ','.join(cur)
            if key in d:
                res.add(d[key])
            else:
                d[key] = node
            if node.left:
                helper(node.left, d, res)
            if node.right:
                helper(node.right, d, res)
                
            
         
            
        helper(root, d, res)
        
        return list(res)
            