def letter_to_num(c):
    return reduce(lambda x, y: 26*x+ord(y)-64, c, 0)
def num_to_letter(x):
    ans = []
    while x > 0:
        ans.append(chr((x-1)%26+ord('A')))
        x = (x-1)/26
    return "".join(ans[::-1])
    
class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        self.cells = {}
        cnum = letter_to_num(W)
        for c in xrange(1, cnum+1):
            clet = num_to_letter(c)
            for r in xrange(1, H+1):
                self.cells[clet+ str(r)] = '0'

    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        k = c+str(r) 
        self[k] = v
        
    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        k = c+str(r) 
        return self[k]
        
    def __setitem__(self, k, v):
        self.cells[k] = str(v)

    def __getitem__(self, k):
        return eval(self.cells[k], {}, self)
        
    def sum(self, r, c, strs):
        k = c + str(r)
        squares = []
        for f in strs:
            if ':' not in f:
                for i,u in enumerate(f):
                    if u.isdigit(): break
                clet = f[:i]
                cnum = int(f[i:])
                squares.append(clet + str(cnum))
            else:
                left,_,right = f.partition(':')
                for i,u in enumerate(left):
                    if u.isdigit(): break
                left_c = letter_to_num(left[:i])
                left_n = int(left[i:])
                for i,u in enumerate(right):
                    if u.isdigit(): break
                right_c = letter_to_num(right[:i])
                right_n = int(right[i:])
                for c in xrange(left_c, right_c+1):
                    clet = num_to_letter(c)
                    for n in xrange(left_n, right_n+1):
                        squares.append(clet + str(n))
        
        self.cells[k] = "+".join(squares)
        return self[k]
