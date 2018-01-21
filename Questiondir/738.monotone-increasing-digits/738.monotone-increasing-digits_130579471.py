class Solution:
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        N = '0' + str(N)
        n = len(N)
        prefix = '0'
        while len(prefix) < n:
            # Decide what to add next
            for ch in '9876543210':
                candidate = prefix + ch * (n - len(prefix))
                if candidate <= N:
                    prefix += ch
                    break
        return int(prefix)