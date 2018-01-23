# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.i = 0
    
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """
        return self.str2treeHelp(s)
        
    def str2treeHelp(self, s):
        if self.i == len(s):
            return None
        j = self.i + 1
        while j < len(s) and '0' <= s[j] <= '9':
            j += 1
        num = int(s[self.i:j])
        self.i = j
        node = TreeNode(num)
        if self.i < len(s) and s[self.i] == '(':
            self.i += 1
            node.left = self.str2treeHelp(s)
            self.i += 1
        if self.i < len(s) and s[self.i] == '(':
            self.i += 1
            node.right = self.str2treeHelp(s)
            self.i += 1
        return node
        