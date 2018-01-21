import bisect
class RangeModule:
    def __init__(self):
        self.core = []

    def addRange(self, left, right):
        pos_l = bisect.bisect_left(self.core, left)
        pos_r = bisect.bisect_right(self.core, right)
        if pos_l == pos_r:
            if pos_l % 2 == 1:
                return
            else:
                self.core.insert(pos_l, left)
                self.core.insert(pos_l + 1, right)
        else:
            del self.core[pos_l: pos_r]
            if pos_l % 2 == 0:
                self.core.insert(pos_l, left)
                pos_l += 1
            if pos_r % 2 == 0:
                self.core.insert(pos_l, right)

    def queryRange(self, left, right):
        if len(self.core) == 0: return False
        pos_l = bisect.bisect_right(self.core, left)
        pos_r = bisect.bisect_left(self.core, right)
        if pos_l % 2 == 1 and pos_l == pos_r:
            return True
        else: return False
    def removeRange(self, left, right):
        pos_l = bisect.bisect_left(self.core, left)
        pos_r = bisect.bisect_right(self.core, right)
        if pos_l == pos_r:
            if pos_l % 2 == 0:
                return
            else:
                self.core.insert(pos_l, left)
                self.core.insert(pos_l + 1, right)
        else:
            del self.core[pos_l: pos_r]
            if pos_l % 2 == 1:
                self.core.insert(pos_l, left)
                pos_l += 1
            if pos_r % 2 == 1:
                self.core.insert(pos_l, right)
