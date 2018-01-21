_trie = lambda: collections.defaultdict(_trie)
END = False
class AutocompleteSystem(object):
    
    def __init__(self, sentences, times):
        self.trie = _trie()
        self.map = {}
        self.search = ''
        self.curnode = self.trie
        
        for sentence, time in zip(sentences, times):
            self.map[sentence] = time
            cur = self.trie
            for letter in sentence:
                cur = cur[letter]
            cur[END] = sentence
            
    def input(self, C):
        if C == '#':
            if self.search in self.map:
                self.map[self.search] += 1
            else:
                cur = self.trie
                for letter in self.search:
                    cur = cur[letter]
                cur[END] = self.search
                self.map[self.search] = 1
            
            self.search = ''
            self.curnode = self.trie
            return []
        
        self.search += C
        if self.curnode is None:
            return []
        if C not in self.curnode:
            self.curnode = None
            return []
        self.curnode = self.curnode[C]
        
        def dfs(node):
            if END in node:
                s = node[END]
                attempts.append((self.map[s], s))
            for nei in node:
                if nei != END:
                    dfs(node[nei])
                        
        attempts = []
        dfs(self.curnode)
        attempts.sort(key = lambda (t, s): (-t, s))
        ans = attempts[:3]
        return [y for x,y in ans]


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)