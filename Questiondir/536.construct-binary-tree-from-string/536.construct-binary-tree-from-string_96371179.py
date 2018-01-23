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
        if not s:
            return None
        def build(s):
            i = j = 0
            while i < len(s) and s[i] != '(':
                i += 1
            root = TreeNode(int(s[:i]))
            j = i
            if i < len(s):
                c = 1
                j = i + 1
                while j < len(s) and c != 0:
                    if s[j] == '(':
                        c += 1
                    elif s[j] == ')':
                        c -= 1
                    j += 1
                root.left = build(s[i+1:j-1])
            i = j
            if i < len(s):
                root.right = build(s[i+1:len(s)-1])
            return root

        return build(s)
