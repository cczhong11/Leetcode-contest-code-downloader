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
        stk = [TreeNode(0)]
        pre = 0
        cur = 0
        n = len(s)
        while cur < n:
            #print stk
            pre = cur
            while cur < n and not s[cur] in ['(',')']:
                cur += 1
            newNode = TreeNode(int(s[pre:cur]))
            if stk[-1].left:
                stk[-1].right = newNode
            else:
                stk[-1].left = newNode
            stk.append(newNode)
            while cur < n and s[cur] == ')':
                stk.pop()
                cur += 1
            if cur < n and s[cur] == '(':
                cur += 1
        return stk[0].left