class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        def is_div(n):
            if n == 0:
                return False
            m = n
            while m > 0:
                k = m % 10
                if k == 0 or n % k != 0:
                    return False
                m /= 10
            return True

        return list(filter(is_div, range(left, right + 1)))
        