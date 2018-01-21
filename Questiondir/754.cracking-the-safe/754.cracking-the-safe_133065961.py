class Solution(object):
    
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        # 其实是生成一个字符串，保证这个字符串任意n位都是unique的
        # 字符串长度为k, 可能情况最多为4096，因此返回的串长度一定为k*k^n
        # 我们知道每个字符串的后继，需要找到一条路完整巡回所有可能的串
        
        import sys   
        sys.setrecursionlimit(100000)
    
        D = {}
        L = ['0']*n
        
        def GenerateString(L,k,n):
            if n>=0:
                for i in xrange(k):
                    L[n] = str(i)
                    D[''.join(L)] = -1
                    GenerateString(L,k,n-1)
        GenerateString(L,k,n-1)
        # print D
        count = len(D)
        step = 0
        t = '0'*n
        #print t
        R = []
        def DFS(t,k,step,count):
            
            if step == count:
                return True
            for i in xrange(k-1,-1,-1):
                if D[t[1:] + str(i)] == -1:
                    D[t[1:] + str(i)] = step
                    R.append(t[1:] + str(i))
                    M = DFS(t[1:] + str(i),k,step+1,count)
                    if not M:
                        R.pop()
                        D[t[1:] + str(i)] = -1 #回溯
                    else:
                        return True # 找到了，不往下走了
                    
        DFS(t,k,0,count)
        #print D
        #print R
        R = [x[-1] for x in R]
        R = '0'*(n-1) + ''.join(R)
        return R
        
                        
        
        