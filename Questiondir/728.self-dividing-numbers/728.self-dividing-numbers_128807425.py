class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        ans = []
        for x in range(left, right+1):
            if '0' in str(x):
                continue
            ok = True
            for d in str(x):
                if x % int(d) != 0:
                    ok = False
                    break
            if ok:
                ans.append(x)
        return ans
                
        