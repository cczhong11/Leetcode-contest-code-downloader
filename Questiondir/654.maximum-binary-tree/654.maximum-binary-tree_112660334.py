class Solution(object) :
    def constructMaximumBinaryTree(self, nums) :

        def build(v) :
            if not v : return None
            idx = 0
            n, m = len(v), max(v)
            for i in xrange(n) :
                if (v[i] == m) :
                    idx = i
                    break
            node = TreeNode(m)
            node.left = build(v[:idx])
            node.right = build(v[idx + 1:])
            return node

        return build(nums)
