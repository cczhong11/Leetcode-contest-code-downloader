class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        res = -2 ** 31
        
        tmp_min , tmp_max = min(arrays[0]), max(arrays[0])
        
        for lst in arrays[1:]:
            res = max(res, abs(max(lst) - tmp_min), abs(min(lst) - tmp_max))
            tmp_min = min(tmp_min, min(lst))
            tmp_max = max(tmp_max, max(lst))
        
        return res