class Solution(object):

    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        if not root:
            return [""]

        def depth(root):
            if not root:
                return 0
            return max(depth(root.left), depth(root.right)) + 1

        d = depth(root)
        self.res = [[""] * (2**d - 1) for _ in xrange(d)]

        def set_val(node, d, pos):
            self.res[-d-1][pos] = str(node.val)
            if node.left:
                set_val(node.left, d - 1, pos - 2**(d - 1))
            if node.right:
                set_val(node.right, d - 1, pos + 2**(d - 1))

        set_val(root, d - 1, 2**(d - 1) - 1)
        return self.res