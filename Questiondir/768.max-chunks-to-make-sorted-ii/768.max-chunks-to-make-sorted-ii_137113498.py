class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        sarr = sorted(arr)
        dic = {}
        cur = 0
        res = 0
        for i in range(len(sarr)):
            if sarr[i] != arr[i]:
                if sarr[i] not in dic:
                    dic[sarr[i]] = 0
                dic[sarr[i]] += 1
                if dic[sarr[i]] == 1:
                    cur += 1
                elif dic[sarr[i]] == 0:
                    cur -= 1

                if arr[i] not in dic:
                    dic[arr[i]] = 0
                dic[arr[i]] -= 1
                if dic[arr[i]] == -1:
                    cur += 1
                elif dic[arr[i]] == 0:
                    cur -= 1
            if cur == 0:
                res += 1
        return res