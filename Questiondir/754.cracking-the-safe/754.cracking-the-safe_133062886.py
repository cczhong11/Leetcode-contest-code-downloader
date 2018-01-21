class Solution(object):
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        
        if n==1:
            ans=''
            for i in range(k):
                ans+=str(i)
            return ans
        self.d={'0'*n:1}
        tar=pow(k,n)+n-1
        self.ans=None
        def search(cur):
            if len(cur)==tar:
                self.ans= cur
            for j in range(k):
                s=cur+str(j)
                t=s[-n:]
                if t not in self.d:
                    self.d[t]=1
                    search(s)
                    if self.ans:
                        return
                    del self.d[t]
        search('0'*n)
        return self.ans