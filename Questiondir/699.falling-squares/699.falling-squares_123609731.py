class intervalNode(object):
    def __init__(self, start, end, height):
        self.start = start
        self.end = end
        self.height = height
        self.next = None

class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        self.root = intervalNode(-1, -1, -1)
        self.root.next = intervalNode(0, 1e10, 0)
        self.maxHeight = 0
        def drop(left, right, addH):
            cur = self.root.next
            prev = self.root
            while cur.end <= left:
                prev = cur
                cur = cur.next
            if cur.start < left:
                newNode = intervalNode(cur.start, left, cur.height)
                newNode.next = cur
                prev.next = newNode
                prev = newNode
                cur.start = left
            if cur.end > right:
                newNode = intervalNode(right, cur.end, cur.height)
                newNode.next = cur.next
                cur.next = newNode
                cur.end = right
                cur.height += addH
                if cur.height > self.maxHeight:
                    self.maxHeight = cur.height
                return
            elif cur.end == right:
                cur.height += addH
                if cur.height > self.maxHeight:
                    self.maxHeight = cur.height
                return
            else:
                localMaxHeight = cur.height
                newcur = cur.next
                newprev = cur
                # print "~", cur.start, cur.end, cur.height
                # print "~", newcur.start, newcur.end, newcur.height
                while newcur and newcur.start < right:
                    if newcur.height > localMaxHeight:
                        localMaxHeight = newcur.height
                    newprev = newcur
                    newcur = newcur.next
                if newprev.end > right:
                    newNode = intervalNode(right, newprev.end, newprev.height)
                    cur.next = newNode
                    newNode.next = newprev.next
                    cur.height = localMaxHeight + addH
                    cur.end = right
                    if cur.height > self.maxHeight:
                        self.maxHeight = cur.height
                    return
                elif newprev.end == right:
                    cur.next = newprev.next
                    cur.height = localMaxHeight + addH
                    cur.end = right
                    if cur.height > self.maxHeight:
                        self.maxHeight = cur.height
                    return
                else:
                    print "unexpected!"
                    return


        ans = []
        for curPos in positions:
            drop(curPos[0], curPos[0]+curPos[1], curPos[1])
            ans.append(self.maxHeight)
            cur = self.root
            # while cur is not None:
            #     print cur.start, cur.end, cur.height
            #     cur = cur.next
            # print
        return ans
