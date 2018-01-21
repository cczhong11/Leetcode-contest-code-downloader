# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    nums = []
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.nums = []
        self.search(root)
        self.nums.sort()
        if len(self.nums) > 1:
            for i in self.nums:
                if i != self.nums[0]:
                    return i
        return -1
        
    def search(self, root):
        if root == None:
            return
        self.nums.append(root.val)
        self.search(root.left)
        self.search(root.right)
         