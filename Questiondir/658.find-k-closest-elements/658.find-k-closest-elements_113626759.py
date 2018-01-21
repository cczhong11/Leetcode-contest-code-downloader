class Solution(object):
    def findClosestElements(self, a, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        b = sorted((abs(x - t), t) for t in a)
        ans = sorted(map(lambda x: x[1], b[0:k]))
        return ans
        
        