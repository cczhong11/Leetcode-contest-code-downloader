# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
def fun(s):
    if s == '':
        return None
    i = s.find('(')
    if i == -1:
        return TreeNode(int(s))
    root = TreeNode(int(s[:i]))
    i += 1
    ls = i
    count = 1
    while count != 0:
        if s[i] == '(':
            count += 1
        elif s[i] == ')':
            count -= 1
        i += 1
    root.left = fun(s[ls:i-1])
    root.right = fun(s[i+1:len(s)-1])
    return root

class Solution(object):
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """
        return fun(s)
            