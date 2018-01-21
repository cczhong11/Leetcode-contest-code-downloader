class Solution(object):
    def ipToCIDR(self, ip, ran):
        """
        :type ip: str
        :type range: int
        :rtype: List[str]
        """

        res = []
        n = self.ipToNum(ip)

        while ran > 0:
            temp = n
            c0 = 0
            if n == 0:
                c0 = 32
            else:
                while temp > 0:
                    if temp % 2 == 0:
                        c0 += 1
                        temp = temp // 2
                    else:
                        break
            if c0 == 0:
                res.append(self.numToIp(n) + "/32")
                n += 1
                ran -= 1
                continue
            else:
                for i in range(c0, -1, -1):
                    step = pow(2, i)
                    if ran >= step:
                        res.append(self.numToIp(n) + "/" + str(32 - i))
                        n += step
                        ran -= step
                        break

        return res

    def ipToNum(self, ip):
        tokens = ip.split('.')
        res = 0
        step = 1
        for i in range(3, -1, -1):
            res += step * int(tokens[i])
            step *= 256
        return res

    def numToIp(self, num):
        res = []
        for i in range(4):
            res.insert(0, num % 256)
            num = num // 256
        return '.'.join(map(str, res))

