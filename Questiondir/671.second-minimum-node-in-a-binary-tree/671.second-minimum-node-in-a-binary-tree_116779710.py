# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        nums = set()
        def dfs(root):
            if not root:
                return
            nums.add(root.val)
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        nums = sorted(list(nums))
        if len(nums) < 2:
            return -1
        return nums[1]
        