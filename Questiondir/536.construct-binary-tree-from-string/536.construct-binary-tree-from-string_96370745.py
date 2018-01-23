# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def str2tree(self, s):
        if not s: return None
        if '(' in s:
            ix = s.index('(')
            root = TreeNode(int(s[:ix]))
            s = s[ix:]
        else:
            root = TreeNode(int(s))
            return root
        b = 0
        for i, x in enumerate(s):
            if x == '(': b+=1
            if x == ')': b-=1
            if b == 0:
                break
        else:
            return root
        root.left = self.str2tree(s[1:i])
        s = s[i+1:]
        if not s:
            return root
        root.right = self.str2tree(s[1:-1])
        return root
        