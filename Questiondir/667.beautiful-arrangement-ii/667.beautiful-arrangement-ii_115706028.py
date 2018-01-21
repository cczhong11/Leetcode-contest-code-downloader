class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        from collections import deque
        
        Q=deque(range(1,k+2))
        
        List=[]
        while(Q):
            List.append(Q.popleft())
            if len(Q)==0:
                break
            List.append(Q.pop())
        T=[i for i in range(1,n-k)]
        
        if n-k>1:
            for i in range(0,k+1):
                List[i]+=T[-1]
        
        return T+List
            
