# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def expand(self, s):
        if not s:
            return ''
        i, balance = 0, 0
        while i < len(s):
            if s[i] == '(': balance += 1
            if s[i] == ')': balance -= 1
            if not balance:
                break
            i += 1
        return s[1:i]
        
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """
        if not s:
            return None
        i = 0
        while i < len(s) and (s[i].isdigit() or s[i] == '-'):
            i += 1
        value = int(s[ :i ])
        l = self.expand( s[i:] )
        r = self.expand( s[i + len(l) + 2:] )
        root = TreeNode(value)
        root.left = self.str2tree(l)
        root.right = self.str2tree(r)
        return root
        