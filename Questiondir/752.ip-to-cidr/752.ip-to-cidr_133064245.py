class Solution:
    def translate(self, num):
        rtn = []
        for i in range(4):
            curr = 0
            for j in range(8):
                curr = curr * 2
                curr += int(num[i * 8 + j])
            rtn.append(str(curr))
        rtn = '.'.join(rtn)
        return rtn
    
    def ipToCIDR(self, ip, n):
        # Convert to binary
        ipDigits = list(map(int, ip.split('.')))
        ipStr = []
        for i in range(4):
            tmp = []
            ipDigit = ipDigits[i]
            for j in range(8):
                tmp.append(ipDigit % 2)
                ipDigit //= 2
            ipStr += tmp[::-1]
        ipStrs = []
        for _ in range(n):
            ipStrs.append(ipStr[:])
            index = 31
            while index and ipStr[index] == 1:
                index -= 1
            ipStr[index] = 1
            for j in range(index + 1, 32):
                ipStr[j] = 0
        rtn = []
        # Write the results
        currIndex = 0
        while currIndex < n:
            # Check how many stuff can I write
            curr = ipStrs[currIndex]
            translatedCurr = self.translate(curr)
            nZeros = 0
            while nZeros < 32 and curr[31 - nZeros] == 0 and currIndex + 2 ** (nZeros + 1) <= n:
                nZeros += 1
            nCommon = 2 ** nZeros
            rtn.append(translatedCurr + '/' + str(32 - nZeros))
            currIndex += nCommon
        return rtn