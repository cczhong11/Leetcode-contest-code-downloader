class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        sub = [abs(item - x) for item in arr]
        lis = list(zip(sub, arr))
        lis = sorted(lis, key=lambda x: x[0])
        ans = [a[1] for a in lis[0:k]]
        ans = sorted(ans)
        return ans