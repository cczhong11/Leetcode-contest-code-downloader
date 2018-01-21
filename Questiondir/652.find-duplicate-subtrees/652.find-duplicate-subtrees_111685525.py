# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        memo = set()
        included = set()
        result = []
        self.findMemo(root, memo, result, included)
        return result
    
    def findMemo(self, root, memo, result, included):
        if root == None:
            return ""
        
        left = self.findMemo(root.left, memo, result, included)
        right = self.findMemo(root.right, memo, result, included)
        val = str(root.val)
        total = "".join(["(", val, ",", left, ",", right, ")"])
        if total in memo and total not in included:
            result.append(root)
            included.add(total)
        memo.add(total)
        return total