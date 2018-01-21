class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        digits = list(str(num))
        return int(''.join(self.Helper(digits)))
        
    def Helper(self, digits):
        if not len(digits):
            return []
        m = max(digits)
        if digits[0] < m:
            index = -digits[::-1].index(m)-1
            digits[0], digits[index] = digits[index], digits[0]
            return digits
        else:
            return [digits[0]] + self.Helper(digits[1:])
        