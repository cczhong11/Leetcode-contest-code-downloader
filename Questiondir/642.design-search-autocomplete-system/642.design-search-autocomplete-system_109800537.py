class PrefixTreeNode(object):
    def __init__(self, char):
        self.char = char,
        self.contents = {}
        self.children = {}

class PrefixTree(object):
    def __init__(self, sentences, counts):
        self.dict = {}
        for sentence, count in zip(sentences, counts):
            self.add(sentence, count)
                
    def add(self, sentence, count):
        node_dict = self.dict
        for char in sentence:
            if char not in node_dict:
                node_dict[char] = PrefixTreeNode(char)
            node = node_dict[char]
            node.contents[sentence] = count
            node_dict = node.children
            
    def inc(self, sentence):
        node_dict = self.dict
        for char in sentence:
            if char not in node_dict:
                node_dict[char] = PrefixTreeNode(char)
            node = node_dict[char]
            node.contents[sentence] =  node.contents.get(sentence, 0) + 1
            node_dict = node.children
            

class AutocompleteSystem(object):

    def __init__(self, sentences, times):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        self.tree = PrefixTree(sentences, times)
        self.dict = self.tree.dict
        self.s = []

    def p(self):
        queue = self.tree.dict.items()
        while queue:
            char, node = queue.pop()
            print(char, node.contents)
            queue.extend(node.children.items())

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            self.tree.inc(''.join(self.s))
            self.s = []
            self.dict = self.tree.dict
            # self.p()
            return []
        self.s.append(c)
        contents = self.find(c)
        return sorted(contents, key=lambda x: (-contents[x], x))[:3]
        
    def find(self, c):
        if c not in self.dict:
            self.dict = {}
            return {}
        node = self.dict[c]
        self.dict = node.children
        return node.contents
        
        


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)