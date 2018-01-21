from collections import defaultdict

class AutocompleteSystem(object):

    def __init__(self, sentences, times):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        self.d = defaultdict(lambda: 0)
        for i in range(len(sentences)):
            self.d[sentences[i]] = times[i]
        self.c = ''

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            self.d[self.c] += 1
            self.c = ''
            return []

        if self.c == '':
            self.x = self.d.items()

        self.c += c
        tmp = []
        dd = [False] * len(self.x)
        for i in range(len(self.x)):
            s, t = self.x[i]
            if len(s) >= len(self.c) and s[len(self.c)-1] == c:
            #if s.startswith(self.c):
                tmp += [(-t, s)]
            else:
                dd[i] = True
        x2 = []
        for i in range(len(self.x)):
            if not dd[i]:
                x2.append(self.x[i])
        self.x = x2

        tmp.sort()
        return [x[1] for x in tmp][:3]
