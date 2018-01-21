class Solution(object):
    def minStickers(self, stickers, target):
        """
        :type stickers: List[str]
        :type target: str
        :rtype: int
        """
        c2i = dict()
        t_tar = list()
        for c in target:
            if c not in c2i:
                c2i[c] = len(t_tar)
                t_tar.append(1)
            else:
                t_tar[c2i[c]] += 1
        n = len(t_tar)
        l_stickers = list()
        n_found = set()
        for sticker in stickers:
            t = [0] * n
            for c in sticker:
                if c in c2i:
                    n_found.add(c)
                    t[c2i[c]] += 1
            l_stickers.append(t)
        if len(n_found) < n:
            return -1
        n_stickers = len(l_stickers)
        deleted = [False] * n_stickers
        for i in xrange(n_stickers):
            if deleted[i]:
                continue
            for j in xrange(i+1, n_stickers):
                if deleted[j]:
                    continue
                if self.le(l_stickers[i], l_stickers[j]):
                    deleted[i] = True
                elif self.le(l_stickers[j], l_stickers[i]):
                    deleted[j] = True
        stickers = list()
        for i in xrange(n_stickers):
            if not deleted[i]:
                stickers.append(l_stickers[i])
        #print stickers, t_tar
        q = collections.deque()
        q.append(t_tar)
        level = 0
        while q:
            n_temp = len(q)
            level += 1
            for i in xrange(n_temp):
                t = q.popleft()
                for s in stickers:
                    if self.le(t, s):
                        return level
                for s in stickers:
                    new_t = self.sub(t, s)
                    q.append(new_t)
        return -1

    def sub(self, t, s):
        n = len(t)
        ret = [0] * n
        for i in xrange(n):
            ret[i] = t[i] - s[i]
        return ret
        
        
        
                
    def le(self, s1, s2):
        n = len(s1)
        for i in xrange(n):
            if s1[i] > s2[i]:
                return False
        return True
                
        
        
        
        