class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        arrdif = [(abs(i-x), i) for i in arr]
        arrdif.sort()
        topk = [i[1] for i in arrdif[:k]]
        topk.sort()
        return topk
        