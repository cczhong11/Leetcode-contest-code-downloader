class AutocompleteSystem(object):

    def __init__(self, sentences, times):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        import collections as co
        self.um, self.s, self.r = co.defaultdict(list), '', set()
        for s, t in zip(sentences, times):
            self.r |= {s}
            for i in range(len(s)):
                self.um[s[:i+1]].append([-t, s])
        

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            if self.s in self.r:
                for i in range(len(self.s)):
                    for j in range(len(self.um[self.s[:i+1]])):
                        if self.um[self.s[:i+1]][j][-1] == self.s:
                            self.um[self.s[:i+1]][j][0] -= 1
                            break
            else:
                self.r |= {self.s}
                for i in range(len(self.s)):
                    self.um[self.s[:i+1]].append([-1, self.s])
            self.s = ''
            return []
        import operator as op, heapq as hq
        self.s += c
        return map(op.itemgetter(-1), hq.nsmallest(3, self.um[self.s]))


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)