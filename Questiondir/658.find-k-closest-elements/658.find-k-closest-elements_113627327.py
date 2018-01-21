class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        pl = -1
        pr = len(arr)
        while pl < len(arr)-1 and arr[pl+1] <= x:
            pl += 1
        while pr > 0 and arr[pr-1] > x:
            pr -= 1
        els = []
        while len(els) < k:
            if pl >= 0 and ((pr < len(arr) and abs(arr[pl]-x) <= abs(arr[pr]-x)) or pr == len(arr)):
                els.append(arr[pl])
                pl -= 1
            else:
                els.append(arr[pr])
                pr += 1
        return sorted(els)
        