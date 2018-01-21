class Solution(object):
    def bin(self, num):
        if num == 0:
            return '0'
        result = ''
        res = num
        while res > 0:
            result = str(res % 2) + result
            res /= 2
        return result
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0:
            return 1
        if num == 1:
            return 2
        if num == 2:
            return 3
        if num == 3:
            return 3
        binnum = self.bin(num)
        dp = [1, 2]
        for index in range(2, len(binnum)):
            dp.append(dp[-2] + dp[-1])
        result = dp[-1]
        last = '1'
        for index in range(1, len(binnum)):
            if binnum[index] == '0':
                last = '0'
                continue
            elif binnum[index] == '1':
                if last == '1':
                    return result + dp[- index - 1]
                else:
                    result += dp[- index - 1]
                    last = '1'
        return result + 1        
                    
        
            
        