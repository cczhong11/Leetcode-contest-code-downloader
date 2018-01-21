from collections import defaultdict

class Solution(object):
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """
        def getDict(formula):
            cur = 0
            answer = defaultdict(lambda : 0)
            while cur < len(formula):
                if formula[cur] == '(':
                    i = cur + 1
                    depth = 1
                    while depth > 0:
                        if formula[i] == '(':
                            depth += 1
                        elif formula[i] == ')':
                            depth -= 1
                        i += 1
                    numIndex = i
                    while i < len(formula) and formula[i].isdigit():
                        i += 1
                    nextIndex = i
                    times = 1 if numIndex == nextIndex else int(formula[numIndex:nextIndex])
                    subDict = getDict(formula[cur + 1: numIndex - 1])
                    for k, v in subDict.items():
                        answer[k] += v * times
                    cur = nextIndex
                else:
                    i = cur + 1
                    while i < len(formula) and formula[i].islower():
                        i += 1
                    numIndex = i
                    while i < len(formula) and formula[i].isdigit():
                        i += 1
                    nextIndex = i
                    times = 1 if numIndex == nextIndex else int(formula[numIndex:nextIndex])
                    element = formula[cur:numIndex]
                    answer[element] += times
                    cur = nextIndex
            return answer
        d = getDict(formula)
        items = sorted(d.items())
        answer = []
        for k, v in items:
            answer.append(k)
            if v > 1:
                answer.append(str(v))
        return ''.join(answer)


# print Solution().countOfAtoms("K4(ON(SO3)2)2")