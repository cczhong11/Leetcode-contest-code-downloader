class Solution(object):
    
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        def good(num):
            nList = map(int, str(num))
            for i in nList:
                if i == 0:
                    return False
                if num%i != 0:
                    return False
            return True
        ans = []
        for i in range(left, right+1):
            if good(i):
                ans.append(i)
        return ans