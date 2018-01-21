# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def helper(self, nums, start, end):
        if start >= end:
            return None
        
        mi = start
        i = start + 1
        while i < end:
            if nums[i] > nums[mi]:
                mi = i
            i += 1
        
        res = TreeNode(nums[mi])
        res.left = self.helper(nums, start, mi)
        res.right = self.helper(nums, mi + 1, end)
        return res
    
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.helper(nums, 0, len(nums))
        