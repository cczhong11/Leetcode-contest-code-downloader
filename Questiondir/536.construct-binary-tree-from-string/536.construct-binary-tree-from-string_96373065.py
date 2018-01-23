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
        s = '(' + s + ')'
        def next_token():
            val, neg, has_val = 0, 1, False
            for i in range(len(s)):
                if s[i] == '(' or s[i] == ')':
                    if has_val:
                        yield val * neg
                        val, neg, has_val = 0, 1, False
                    yield s[i]
                elif s[i] == '-':
                    has_val = True
                    neg = -1
                else:
                    has_val = True
                    val = val*10 + int(s[i])
            if has_val:
                yield val * neg
        dummy_root = TreeNode(0)
        stack = [dummy_root]
        for token in next_token():
            if token == '(':
                stack.append(TreeNode(None))
            elif token == ')':
                child = stack.pop()
                if child.val is not None:
                    if stack[-1].left is None:
                        stack[-1].left = child
                    else:
                        stack[-1].right = child
            else:
                stack[-1].val = token
        return dummy_root.left

