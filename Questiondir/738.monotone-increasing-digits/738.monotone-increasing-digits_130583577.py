class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        num = map(int, str(N))
        good = False
        while not good:
            good = True
            for i in xrange(1, len(num)):
                if num[i] < num[i-1]:
                    num[i-1] -= 1
                    j = i-1
                    while num[j] == -1:
                        num[j] = 9
                        num[j-1] -= 1
                        j -= 1
                    good = False
                    for j in xrange(i, len(num)):
                        num[j] = 9
                    break
            print num
        return int(''.join(map(str, num)))
                
                
        