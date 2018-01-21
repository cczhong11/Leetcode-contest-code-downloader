# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        nums = [(nums[i],i) for i in xrange(len(nums))]
        def constructTree(nums, l, r):
            if (l>r):
                return None
            x,i = max(nums[l:r+1])
            root = TreeNode(x)
            root.left = constructTree(nums, l, i-1)
            root.right = constructTree(nums, i+1, r)
            return root
        return constructTree(nums,0,len(nums)-1)
            
        