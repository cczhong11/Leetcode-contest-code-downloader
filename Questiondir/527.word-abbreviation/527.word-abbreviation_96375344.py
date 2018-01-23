class Solution(object):
    def wordsAbbreviation(self, dict):
        answer = []
        for i in range(len(dict)):
            word = dict[i]
            if len(word) <= 3:
                answer.append(word)
            else:
                for k in reversed(range(2, len(word) - 1)):
                    preffix = len(word) - k - 1
                    error = False
                    for j in range(len(dict)):
                        if i != j:
                            word2 = dict[j]
                            if len(word) == len(word2) and word[:preffix] == word2[:preffix] and word[-1] == word2[-1]:
                                error = True
                                break
                    if not error:
                        answer.append( word[:preffix] + str(k) + word[-1] )
                        break
                    elif k == 2:
                        answer.append(word)
        return answer