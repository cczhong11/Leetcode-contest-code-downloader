class Solution(object):
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        def foo(b):
            a = copy.deepcopy(b)
            m, n = map(len, [b, b[0]])
            for i in xrange(m - 2):
                for j in xrange(n):
                    if b[i][j] == b[i + 1][j] == b[i + 2][j]:
                        a[i][j] = a[i + 1][j] = a[i + 2][j] = 0
            for i in xrange(m):
                for j in xrange(n - 2):
                    if b[i][j] == b[i][j + 1] == b[i][j + 2]:
                        a[i][j] = a[i][j + 1] = a[i][j + 2] = 0
            a = map(lambda c: filter(None, c), zip(*a))
            a = [[0] * (m - len(c)) + list(c) for c in a]
            a = map(list, zip(*a))
            return a
        ans = foo(board)
        while ans != board:
            board = ans
            ans = foo(board)
        return ans