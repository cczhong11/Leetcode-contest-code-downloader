class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N < 10:
            return N
        
        digits = list(str(N))
        
        for i in range(len(digits))[:0:-1]:
            if digits[i-1] > digits[i]:
                digits[i-1] = chr(ord(digits[i-1]) - 1)
                for j in range(i, len(digits)):
                    digits[j] = '9'
            
        return int("".join(digits))
        