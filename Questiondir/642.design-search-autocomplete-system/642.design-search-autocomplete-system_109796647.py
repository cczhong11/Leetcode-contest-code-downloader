from collections import defaultdict


class AutocompleteSystem(object):
    def __init__(self, sentences, times):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        self.history = defaultdict(lambda: 0)
        for i in xrange(len(sentences)):
            self.history[sentences[i]] += times[i]
        self.cur = ""
        self.last_result = list(self.history.iterkeys())
        self.store = {}

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            self.history[self.cur] += 1
            self.cur = ""
            self.last_result = list(self.history.iterkeys())
            return []
        else:
            self.cur += c
            answer = []
            next_result = []
            for sentence in self.last_result:
                if sentence.startswith(self.cur):
                    next_result.append(sentence)
                    time = self.history[sentence]
                    answer.append((-time, sentence))
            self.last_result = next_result
            answer.sort()
            answer = answer[:3]
            answer = map(lambda x: x[1], answer)

            return answer


# s = AutocompleteSystem(["i love you", "island", "ironman", "i love leetcode"], [5, 3, 2, 2])
# print s.input('i')
# print s.input(' ')
# print s.input('#')
# print s.input('i')