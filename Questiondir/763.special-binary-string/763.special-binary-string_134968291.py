import collections
class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
    
        S = list(S)
        i = 0
        while i < len(S):
            if S[i] == "0":
                # find a special substring ending in S
                j = i-1
                count = -1
                while j >= 0:
                    if S[j] == "1":
                        count += 1
                    else:
                        count -= 1
                    if count == 0:
                        break
                    j -= 1
                if count == 0:
                    start = j
                    end = i+1
                    ss = S[start:end]
                    if end == len(S) or S[end] == "0":
                        i += 1
                        continue
                    # Find a special string  starting here
                    secs = end
                    sece = secs+1
                    count = 1
                    while sece < len(S):
                        count += 1 if S[sece] == "1" else -1
                        if count == 0:
                            break
                        sece += 1
                    if count == 0:
                        sece += 1
                        second = S[secs:sece]
                        #print(ss," and ", second)
                        if(ss+second < second+ss):
                            # Swap these
                            temp = ss
                            #print(S)
                            #print(S[start:end] , S[secs:sece])
                            S = S[:start] + S[secs:sece] + S[start:end] + S[sece:]
                            return "".join(self.makeLargestSpecial(S))
            i += 1
        return "".join(S)
