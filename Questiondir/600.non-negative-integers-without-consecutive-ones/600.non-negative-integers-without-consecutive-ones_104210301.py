class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num < 40:
            ans = 0
            for i in xrange(num+1):
                c = bin(i)[2:]
                if '11' not in c:
                    ans += 1
            return ans
        a = [1]
        b = [1]
        c = bin(num)[2:]
        for i in xrange(1,len(c)):
            a.append(a[-1]+b[-1])
            b.append(a[-2])
        #print a,b,c
        ans = a[-2] + b[-2] + 1
        #print ans
        #c = c[::-1]
        k = 1
        p = c[0]
        a = [1] + a
        b = [0] + b
        #print c,p,k,c[k]
        while k < len(c):
            if p == c[k] == '1':
                k += 2
                while k <= len(c):
                    #print k
                    ans += a[-k-1] + b[-k-1]
                    k += 2
                break
            elif c[k] == '1':
                ans += a[-k-2] + b[-k-2]
                
            if k >= len(c):
                break
            p = c[k]
            k += 1
            #print k,ans,p
        return ans