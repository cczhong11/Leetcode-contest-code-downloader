class Solution(object):
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        pairs.sort()
        
        ans = 0 
        cur = -2**32
        for a, b in pairs:
            if a > cur:
                ans += 1
                cur = b
            else:
                cur = min(b, cur)
        return ans
        
        
        