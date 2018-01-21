class LogSystem(object):

    def __init__(self):
        self.d={}

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        t=timestamp.split(':')
        self.d.setdefault(id,t)
        

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        st=s.split(':')
        et=e.split(':')
        tag='Year:Month:Day:Hour:Minute:Second'.split(':')
        ms=[2000,1,1,0,0,0]
        me=[2017,12,31,23,59,59]
        for i in range(6):
            if gra==tag[i]:
                for j in range(i+1,6):
                    st[j]=-1
                    et[j]=-1
                break
        ans=[]
        
        def smaller(a,b):
            for i in range(6):
                if a[i]==-1 or b[i]==-1:
                    return True
                if a[i]<b[i]:
                    return True
                elif a[i]>b[i]:
                    return False
            return True
        
        for i in self.d.keys():
            if smaller(st,self.d[i]) and smaller(self.d[i],et):
                ans.append(i)
        return ans


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)