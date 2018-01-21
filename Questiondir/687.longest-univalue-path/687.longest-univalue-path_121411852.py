class Solution(object):
	def longestUnivaluePath(self, root):
		if root is None: return 0
		return max(self.dfs(root.left, root.val) + self.dfs(root.right, root.val), \
			self.longestUnivaluePath(root.left), self.longestUnivaluePath(root.right))

	def dfs(self, root, val):
		if root is None or root.val != val: return 0
		return max(self.dfs(root.left, val), self.dfs(root.right, val)) + 1
        