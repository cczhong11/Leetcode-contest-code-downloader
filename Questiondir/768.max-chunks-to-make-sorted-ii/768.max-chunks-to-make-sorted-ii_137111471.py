import itertools
class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        arr_sorted = sorted(arr)
        rng_dict = dict()
        offset = 0
        for k,g in itertools.groupby(arr_sorted):
            rng_dict[k] = offset
            offset += len(list(g))
        ans = 0
        st = 0
        while st < n:
            # find ed
            val = arr[st]
            ed = rng_dict[val]
            rng_dict[val] += 1
            i = st + 1
            while i <= ed:
                val = arr[i]
                ed = max(ed, rng_dict[val])
                rng_dict[val] += 1
                i += 1
            ans += 1
            st = ed + 1
        return ans

