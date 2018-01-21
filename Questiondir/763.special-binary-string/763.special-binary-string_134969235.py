class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        
        return DomakeLargestSpecial(S)
    
    
from collections import defaultdict

def swap(S, start1, end1, start2, end2):
    return S[:start1] + S[start2:(end2+1)] + S[start1:(end1+1)] + S[(end2+1):]

def getMoves(S, seen):
    arr = []
    ones = 0
    for s in S:
        if s == '1':
            ones += 1
        zeros = 1+len(arr) - ones
        arr.append(ones-zeros)

    # S[i:j] is a special substring iff
    # arr[i:j] >= arr[i]. arr[i] == arr[j]
    
    options = defaultdict(list)
    for i in xrange(len(S)):
        options[i] = list()
        if S[i] == "0":
            continue
        for j in xrange(i+1, len(S)):
            if arr[j] < arr[i] - 1:
                break
            if (j-i) % 2 != 1 or arr[i] != arr[j] + 1:
                continue

            options[i].append(j)
    
    result = []
    for start, ends in options.items():
        for end in ends:
            if end == len(S) - 1:
                continue
            start2 = end+1
            for end2 in options[start2]:
                if S[start:end] > S[start2:end2]:
                    continue
                S2 = swap(S, start, end, start2, end2)
                h = S2
                if h not in seen:
                    result.append(S2)
                    seen.add(h)
    
    return result


def DomakeLargestSpecial(S):
    seen = set([S])
    maxS = S
    moves = getMoves(S, seen)
    while moves:
        S = moves.pop()
        if S > maxS:
            maxS = S
            moves.extend(getMoves(S, seen))
    return maxS

