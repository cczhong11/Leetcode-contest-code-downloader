
from collections import defaultdict
import operator
class Top3List(object):
    def __init__(self):
        self.data = []
    def update(self, key, value):
        updated = False
        for i in range(len(self.data)):
            if self.data[i][0] == key:
                self.data[i][1] = value
                updated = True
                break
        if not updated:
            self.data.append([key, value])
        self.data = sorted(self.data
                , cmp=(lambda a,b: (cmp(b[1],a[1]) if a[1] != b[1] else cmp(a[0],b[0]))))
        self.data = self.data[:3]

class AutocompleteSystem(object):
    def __init__(self, sentences, times):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        self.dic = dict()
        for s, t in zip(sentences, times):
            node = self.dic
            for ch in s:
                if ch not in node:
                    node[ch] = dict()
                node = node[ch]
            node['time'] = t
            node = self.dic
            for ch in s:
                node = node[ch]
                if 'links' not in node:
                    node['links'] = Top3List()
                node['links'].update(s, t)
        self.state = self.dic
        self.path = ''

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            if 'time' in self.state:
                t = self.state['time'] + 1
            else:
                t = 1
            self.state['time'] = t
            node = self.dic
            for ch in self.path:
                node = node[ch]
                if 'links' not in node:
                    node['links'] = Top3List()
                node['links'].update(self.path, t)
            self.state = self.dic
            self.path = ''
            return []
        if c not in self.state:
            self.state[c] = dict()
        self.state = self.state[c]
        self.path += c
        if not 'links' in self.state:
            return []
        ret = self.state['links'].data
        ret = [k for k,v in ret]
        return ret

