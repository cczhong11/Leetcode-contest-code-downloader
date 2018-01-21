# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def checkEqualTree(self, root):
        sumD = {}
        def iterTree(root):
            if root==None: return 0 
            sumD[root] = iterTree(root.left) + iterTree(root.right) + root.val
            return sumD[root]
        iterTree(root)
        if sumD[root] %2 ==1: return False
        #print sumD[root]
        def check(root, sumT):
            if root==None: return False
            if sumD[root] == sumT/2: return True
            return check(root.left,sumT) or check(root.right, sumT)
        return check(root.left,sumD[root]) or check(root.right, sumD[root])
        