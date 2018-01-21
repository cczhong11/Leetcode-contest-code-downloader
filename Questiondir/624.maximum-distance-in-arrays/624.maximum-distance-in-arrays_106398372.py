class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        Min=[(arrays[i][0],i) for i in range(0,len(arrays))]
        
        Max=[(arrays[i][-1],i) for i in range(0,len(arrays))]
        
        Min=sorted(Min,key=lambda item:item[0])
        
        Max=sorted(Max,key=lambda item:item[0])
        
        if Max[-1][1]!=Min[0][1]:
            return Max[-1][0]-Min[0][0]
        else:
            return max(Max[-1][0]-Min[1][0],Max[-2][0]-Min[0][0])