class AutocompleteSystem(object):

    def __init__(self, ss, ts):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        self.mp = {}
        self.cnt = {}
        self.ip = ""
        for i, s in enumerate(ss):
            for l in range(1, len(s)+1):
                if s[:l] not in self.mp:
                    self.mp[s[:l]] = []
                self.mp[s[:l]].append(s)
            self.cnt[s] = ts[i]
        # print self.mp

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            if self.ip not in self.cnt:
                self.cnt[self.ip] = 0
                for l in range(1, len(self.ip)+1):
                    # print self.ip[:l], '+'
                    if self.ip[:l] not in self.mp:
                        self.mp[self.ip[:l]] = []
                    self.mp[self.ip[:l]].append(self.ip)
            self.cnt[self.ip] += 1
            self.ip = ''
            return []
        self.ip += c
        # print '-', self.ip
        if self.ip not in self.mp:
            return []
        res = []
        for s in self.mp[self.ip]:
            res.append((-self.cnt[s], s))
        res.sort()
        # print [c, self.ip, res[:3]]
        # print res
        # print '---'
        return map(lambda x: x[1], res[:3])


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)