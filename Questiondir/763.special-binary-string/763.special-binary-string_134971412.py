class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        if (len(S)<=2):
            return S
        ints = []
        ss = []
        st = 0
        lasti = -1
        for i in xrange(len(S)):
            if S[i] == '1':
                st += 1
            else:
                st -= 1
                if (st == 0):
                    ints.append(i)
                    #print(S[lasti+2:i])
                    ss.append("1"+self.makeLargestSpecial(S[lasti+2:i])+"0")
                    lasti = i
        ss.sort(reverse=True)
        return "".join(ss)
        