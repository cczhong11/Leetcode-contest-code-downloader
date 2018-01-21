# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        
        if not root:
            return []
        
        result = []
        
        level = [root]
        
        while level:
            next = []
            
            values = []
            for node in level:
                values.append(node.val)
                if node.left:
                    next.append(node.left)
                    
                if node.right:
                    next.append(node.right)
                
            result.append(sum(values) * 1.0 / len(values))
            level = next
        return result
        