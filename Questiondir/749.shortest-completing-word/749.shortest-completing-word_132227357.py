class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        target = {}
        for x in licensePlate:
            if(x >='a' and x<='z'):
                temp = ord(x)-ord('a')
                if(temp not in target):
                    target[temp] = 0
                target[temp] += 1
            elif(x >='A' and x<='Z'):
                temp = ord(x)-ord('A')
                if(temp not in target):
                    target[temp] = 0
                target[temp] += 1
        _min = float('inf')
        res = None
        for x in words:
            temp = {}
            l = len(x)
            for c in x:
                if(c >='a' and c<='z'):
                    temp1 = ord(c)-ord('a')
                    if(temp1 not in temp):
                        temp[temp1] = 0
                    temp[temp1] += 1
                elif(c >='A' and c<='Z'):
                    temp1 = ord(c)-ord('A')
                    if(temp1 not in temp):
                        temp[temp1] = 1
                    temp[temp1] += 1
            flag = True
            for c in target:
                if(c not in temp or temp[c] < target[c]):
                    flag = False
                    break
            if(flag):
                if(l < _min):
                    res = x
                    _min = l
        return res