class Solution(object) :
    def printTree(self, root) :

        def get_depth(node, deep) :
            if node is None : return deep
            return max(get_depth(node.left, deep + 1), get_depth(node.right, deep + 1))

        def solve(node, h, s, e) :
            if node is None : return
            mi = s + e >> 1
            mat[h][mi] = str(node.val)
            solve(node.left, h + 1, s, mi - 1)
            solve(node.right, h + 1, mi + 1, e)

        n, m = get_depth(root, 0), 0
        for i in xrange(n) : m = m << 1 | 1

        mat = [['' for i in xrange(m)] for j in xrange(n)]
        solve(root, 0, 0, m - 1)
        return mat

