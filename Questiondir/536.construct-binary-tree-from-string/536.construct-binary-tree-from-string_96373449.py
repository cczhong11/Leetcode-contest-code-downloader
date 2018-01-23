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
        s = '(' + s
        stack = []
        hi = len(s)
        i = len(s)-1
        while i>=0:
            if s[i] == ')':
                stack.append(')')
                hi = i
            elif s[i] == '(':
                n = int(s[i+1:hi])
                node = TreeNode(n)
                j = 0
                while stack and stack[-1] != ')':
                    kid = stack.pop()
                    if j == 0:
                        node.left = kid
                    else:
                        node.right = kid
                    j += 1
                if stack:
                    stack.pop()
                stack.append(node)
                hi = i
            #print(s[i], stack)
            i -= 1
        return stack[0]