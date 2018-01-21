class Solution(object):
    def decimalTo(self, num, n):
        new_num_str = ""
        while num != 0:
            remainder = num % n
            remainder_string = str(remainder)
            new_num_str = remainder_string+new_num_str
            num = num / n
        return int(new_num_str)
    
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        return self.decimalTo(n, 9)