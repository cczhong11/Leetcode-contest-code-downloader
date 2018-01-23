# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """
        
        if (s == ""):
            return None
        
        firstP = False
        secondP = 0
        p = 0
        isLeft = True;
        root = TreeNode(0)
        for i in range(len(s)):
            c = s[i]
            if (c == "(" and not firstP):
                root.val = int(s[0:i])
                firstP = i
            if (c == "("):
                p += 1
            if (c == ")"):
                p -= 1
                
            if (p == 0 and secondP):
                root.right = self.str2tree(s[secondP+1:len(s)-1])
                
            if (p == 0 and firstP and isLeft):
                root.left = self.str2tree(s[firstP+1:i])
                isLeft = False
                secondP = i+1
            
        if (not firstP):
            return TreeNode(int(s))
        return root
                