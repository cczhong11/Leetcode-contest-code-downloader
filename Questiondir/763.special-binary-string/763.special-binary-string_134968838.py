import heapq
class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        if len(S)==0:
            return ""
        table,interest = [0],[0]
        for i,c in enumerate(S):
            if c=='1':
                table.append(table[-1]+1)
            else:
                table.append(table[-1]-1)
            if table[-1]==0:
                interest.append(i+1)
        ans = []
        def normalize(s,length):
            n = 0
            for i in xrange(length):
                if i<len(s):
                    n = n*2 + int(s[i])
                else:
                    n = n*2 + 1
            return n
        segs,length = [],0
        for i in xrange(len(interest)-1):
            mid = '1' + self.makeLargestSpecial(S[interest[i]+1:interest[i+1]-1]) + '0'
            segs.append(mid)
            length = max(length,len(mid))
        heap = []
        for seg in segs:
            heapq.heappush(heap,(-normalize(seg,length),seg))
        while len(heap)>0:
            _,seg = heapq.heappop(heap)
            ans.append(seg)
        return "".join(ans)
        