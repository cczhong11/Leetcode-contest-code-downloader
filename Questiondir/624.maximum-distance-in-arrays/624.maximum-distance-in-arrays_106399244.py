class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        n=len(arrays)
        large=[0 for i in range(n)]
        largest=arrays[0][0]
        lind=[]
        small=[0 for i in range(n)]
        smallest=arrays[0][0]
        sind=[]
        for i in range(n):
            large[i]=max(arrays[i])
            if large[i]>largest:
                largest=large[i]
                lind=[i]
            elif large[i]==largest:
                lind.append(i)
            small[i]=min(arrays[i])
            if smallest>small[i]:
                smallest=small[i]
                sind=[i]
            elif small[i]==smallest:
                sind.append(i)
        if len(lind)>1 or len(sind)>1 or lind[0]!=sind[0]:
            return largest-smallest
        large.sort()
        small.sort()
        return max(largest-small[1],large[-2]-smallest)
        
            
            