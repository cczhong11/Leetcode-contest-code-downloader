class Solution(object):
    ans = 0
    s = 0
    tree = []
    def pathSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == []:
            return 0
        self.tree = []
        for i in range(32):
            self.tree.append(-1)
        for i in nums:
            a = i/100
            b = i%100/10
            c = i%10
            self.tree[(1<<(a-1))+b-1] = c
            
        #print self.tree
        self.ans = 0
        self.s = self.tree[1]
        self.search(1)
        return self.ans
        
    def search(self, ad):
        if self.tree[ad*2] == -1 and self.tree[ad*2+1] == -1:
            self.ans += self.s
            return
        if self.tree[ad*2] != -1:
            self.s += self.tree[ad*2]
            self.search(ad*2)
            self.s -= self.tree[ad*2]
        if self.tree[ad*2+1] != -1:
            self.s += self.tree[ad*2+1]
            self.search(ad*2+1)
            self.s -= self.tree[ad*2+1]