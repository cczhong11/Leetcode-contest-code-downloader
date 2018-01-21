class Solution(object):
    def minStickers(self, stickers, target):
        """
        :type stickers: List[str]
        :type target: str
        :rtype: int
        """

        
        key = [0 for _ in range(26)]
        for c in target:
            key[ord(c) - 97] += 1
            
        queue = [key]
        visited = set()
        visited.add(tuple(key))
        
        sticker_key = [{} for _ in range(len(stickers))]
        for i in range(len(stickers)):
            for c in stickers[i]:
                sticker_key[i][ord(c) - 97] = sticker_key[i].get(ord(c)-97, 0) + 1
                
        answer = 0
        while queue:
            next = []
            for curr in queue:
                for i in range(len(stickers)):
                    new_l = list(curr)
                    for j in sticker_key[i]:
                        new_l[j] -= min(new_l[j], sticker_key[i][j])
                        
                    if sum(new_l) == 0:
                        return answer + 1
                        
                    if tuple(new_l) not in visited:
                        visited.add(tuple(new_l))
                        next.append(new_l)

            answer += 1
            queue = next
        
        return -1
        
    def old(self, stickers, target):
        freq = {}
        for c in target:
            freq[c] = freq.get(c, 0) + 1
        
        st_freq = []
        for i in range(len(stickers)):
            st_freq.append({})
            for c in stickers[i]:
                st_freq[i][c] = st_freq[i].get(c, 0) + 1
                
        answer = 0
        while freq:
            max_index, max_chars = -1, 0
            for i, df in enumerate(st_freq):
                tmp = 0
                for c in freq:
                    if c in df:
                        tmp += min(freq[c], df[c])
                if tmp > max_chars:
                    max_index = i
                    max_chars = tmp
                    
            if max_index == -1:
                return -1
            
            for c in st_freq[max_index]:
                if c in freq:
                    freq[c] -= min(freq[c], st_freq[max_index][c])
                    if freq[c] == 0:
                        del freq[c]
            print(stickers[max_index], max_chars)
            answer += 1
            
        return answer
                    
        
        