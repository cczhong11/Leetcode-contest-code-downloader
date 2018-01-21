class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        if len(S) <= 4:
            return S
        number = 0
        splts = []
        for i in range(len(S)):
            if S[i] == '0':
                number -= 1
            else:
                number += 1
            if number == 0:
                splts.append(i+1)
        if len(splts) > 1:
            results = []
            last = 0
            for i in splts:
                results.append(self.makeLargestSpecial(S[last:i]))
                last = i
            return "".join(sorted(results, reverse=True))
            
        else:
            return "1" + self.makeLargestSpecial(S[1:-1]) + "0"
        