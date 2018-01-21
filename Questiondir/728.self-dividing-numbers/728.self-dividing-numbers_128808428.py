class Solution:
    def isSelfDividing(self, num):
        t = num
        while t > 0:
            digit = t % 10
            if digit == 0: return False
            if num % digit != 0: return False
            t //= 10
        return True
        
            
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        result = []
        for n in range(left, right+1):
            if self.isSelfDividing(n):
                result.append(n)
        return result