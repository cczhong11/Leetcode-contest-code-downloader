class Solution(object):
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        licenseplate = licensePlate.lower()
        licenseplate = [x for x in licenseplate if 'a' <= x <= 'z']
        lp = {}
        for c in licenseplate:
            if c in lp:
                lp[c] += 1
            else:
                lp[c] = 1

        smallest = ""
        smallestlen = float("inf")
        for w in words:
            toget = dict(lp)
            for c in w:
                if c in toget:
                    toget[c] -= 1
                    if toget[c] == 0:
                        del toget[c]
                    if len(toget.items()) == 0:
                        if len(w) < smallestlen:
                            smallestlen = len(w)
                            smallest = w
                            break
        return smallest