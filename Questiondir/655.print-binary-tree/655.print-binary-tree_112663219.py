# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        row = self.maxDepth(root)
        col = (2**row)-1
        answer = [['' for _ in range(col)] for _ in range(row)]
        self.helper(root, 0, col/2, answer, col, 0)
        return answer

    def helper(self, node, row, col, answer, right, left):
        if node is None:
            return
        answer[row][col] = str(node.val)
        self.helper(node.left, row+1, (col+left)/2, answer, col, left)
        self.helper(node.right, row + 1, (right+col)/ 2, answer, right, col)

    def maxDepth(self, node):
        if node is None:
            return 0
        return max(self.maxDepth(node.left), self.maxDepth(node.right))+1

