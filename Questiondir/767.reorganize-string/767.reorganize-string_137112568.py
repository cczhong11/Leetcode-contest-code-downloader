class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        counter = collections.Counter(S)
        
        h = []
        for c in counter:
            heapq.heappush(h, (-counter[c], c))
            
        res = ''
        while h:
            cnt1, c1 = heapq.heappop(h)          
            if h: 
                cnt2, c2 = heapq.heappop(h)
                res += c1 + c2
                if cnt2 != -1:
                    heapq.heappush(h, (cnt2+1, c2))
            else:
                res += c1           
            if cnt1 != -1:
                heapq.heappush(h, (cnt1+1, c1))  
        
        for i in range(len(res)-1):
            if res[i] == res[i+1]:
                return ''
        
        return res
        