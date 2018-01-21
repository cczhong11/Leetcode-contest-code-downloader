class Solution(object):

    def ok(self, x, y, m, n):
        return x>=0 and x<m and y>=0 and y<n

    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        m, n = len(board), len(board[0])
        nb = [[0 for i in xrange(m)] for j in xrange(n)]
        for i in xrange(n):
            for j in xrange(m):
                nb[i][j] = board[m-j-1][i]
        while True:
            #print 'z'
            vis = [[False for i in xrange(m)] for j in xrange(n)]
            for i in xrange(n):
                for j in xrange(m):
                    if nb[i][j] == 0:
                        continue
                    k = 1
                    while k!=3:
                        if self.ok(i-k, j, n, m)==True and nb[i][j] == nb[i-k][j]:
                            k += 1
                        else:
                            break
                    if k == 3:
                        vis[i][j], vis[i-1][j], vis[i-2][j] = True, True, True
                    #print i, j, k, 
                    k = 1
                    while k != 3:
                        if self.ok(i, j-k, n, m)==True and nb[i][j] == nb[i][j-k]:
                            k += 1
                        else:
                            break
                    if k == 3:
                        vis[i][j], vis[i][j-1], vis[i][j-2] = True, True, True
                    #print k
            tag = False
            for i in xrange(n):
                for j in xrange(m):
                    if vis[i][j] == True:
                        #print i, j
                        tag = True 
                        nb[i][j] = 0
            if tag == False:
                break
            else:
                for i in xrange(n):
                    nb[i] = filter(lambda x: x!= 0, nb[i])
                    need = [0 for j in xrange(m - len(nb[i]))]
                    nb[i].extend(need)
        result = [[0 for i in xrange(n)] for j in xrange(m)]
        for i in xrange(m):
            for j in xrange(n):
                result[i][j] = nb[j][m-i-1]
        return result
