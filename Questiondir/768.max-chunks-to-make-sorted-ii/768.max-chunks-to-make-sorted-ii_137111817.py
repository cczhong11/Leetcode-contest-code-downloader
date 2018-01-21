class Solution:
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        N = len(arr)
        idx = list(range(N))
        idx.sort(key=lambda x: arr[x])
        # print(idx)

        seg = 0
        rChk = 0
        for i in range(N):
            if idx[i] > seg:
                seg = idx[i]
            elif i == seg:
                rChk += 1
                seg = i+1
        return rChk