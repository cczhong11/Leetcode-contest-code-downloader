# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return -1
        mini = root.val
        return self.Helper(root, mini)
        
            
    def Helper(self, root, mini):
        if not root:
            return -1
        if root.val == mini:
            l, r = self.Helper(root.left, mini), self.Helper(root.right, mini)
            if l == -1:
                return r
            elif r == -1:
                return l
            else:
                return min(l, r)
        else:
            return root.val
                
        