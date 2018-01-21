class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        revTemp = temperatures[::-1]
        revRet = list()
        higher = list()
        
        for i, t in enumerate(revTemp):
            while len(higher) > 0 and revTemp[higher[-1]] <= t:
                higher.pop()
            
            if len(higher) == 0:
                revRet.append(0)
            else:
                revRet.append(i-higher[-1])
            
            higher.append(i)
        
        return revRet[::-1]