
class treeArray(object):
    def lowbit(self,i):
        #return i&(-i)
        return i&(i^(i-1));

    def update(self,index,value):
        self.list_a[index] =  self.list_a[index] + value;
        while index< len(self.list_a):
            self.list_c[index] = self.list_c[index]+value;
            index = index+ self.lowbit(index+1) 

    def __init__(self,list_a):
        self.list_a = [0]*len(list_a); 
        self.list_c = [0]*len(list_a)
        self.length = len(list_a)
        #print self.length
        # for i in range(self.length):
        #    self.update(i,list_a[i])

    def query(self,index):
        ss = 0 
        if index >= self.length:
            return 0;
        while index >= 0:
            ss = ss + self.list_c[index]
            # index = index - (index+1)&((index+1)^(index))
            index = index - self.lowbit(index+1)
            
        return ss 

    def output(self):
        k = self.length;
        print("list_a: ")
        print(self.list_a)
        return True


class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        tree = treeArray([0]*(len(flowers)))

        for day in range(len(flowers)):
            curPos = flowers[day]-1
            tree.update(curPos, 1)
            if curPos-k-1>=0 and tree.list_a[curPos-k-1]==1:
                if tree.query(curPos-1) == tree.query(curPos-k-1):
                    return day+1
            if curPos+k+1<len(flowers) and tree.list_a[curPos+k+1]==1:
                if tree.query(curPos) == tree.query(curPos+k):
                    return day+1
        return -1

