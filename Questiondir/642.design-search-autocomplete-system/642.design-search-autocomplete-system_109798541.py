class AutocompleteSystem(object):

    def __init__(self, sentences, times):
        self.count = dict((s, t) for s, t in zip(sentences, times))
        self.order()
        
        
    def order(self):
        self.l = sorted(self.count.keys(), key = lambda x: [[-self.count[x], x]])
        self.p = 0
        self.temp = ''
        self.match = self.l

    def input(self, c):
        if c == '#':
            if self.temp in self.count:
                self.count[self.temp] += 1
                self.order()
            else:
                self.count[self.temp] = 1
                self.order()
            return []
        else:
            self.match = filter(lambda x: len(x) > self.p and x[self.p] == c, self.match)
            self.temp += c
            self.p += 1
            return self.match[:3]

# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)