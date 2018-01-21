class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        arr = map(lambda t: (abs(t - x), t), arr)
        arr.sort()
        arr = arr[:k]
        arr = map(lambda t: t[1], arr)
        arr.sort()
        return arr

# print Solution().findClosestElements([1,2,3,4,5], 4, 5)