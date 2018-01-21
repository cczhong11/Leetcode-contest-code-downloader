class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        subsum = 0
        parsum = 0
        cnt = 0
        for i in range(len(arr)):
            subsum += arr[i]
            parsum += i
            if subsum == parsum:
                cnt += 1
        return cnt