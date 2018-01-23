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
        n= len(s)
        def parseStr(s, i):
            #if i < n:
                #print s[i:]
            if i >= n or s[i] == ")":
                return  (i+1, None)
            v = 0
            if s[i] == "-":
                negative = True
                i+=1
            else:
                negative = False
            while(i< n and s[i].isdigit()):
                v = v* 10 +int(s[i])
                i += 1
            if negative:
                v = -v
            #print s[i:]
            p = TreeNode(v)
            if i< n and s[i] == "(":
                i, p.left = parseStr(s, i + 1)
            if i<n and s[i] == "(":
                i, p.right = parseStr(s, i + 1)
            return i + 1, p

        i, root = parseStr(s, 0)
        return root
