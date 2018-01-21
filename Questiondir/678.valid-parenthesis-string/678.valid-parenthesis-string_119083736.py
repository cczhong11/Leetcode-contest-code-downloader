class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = set([0])
        for si in s:
            st = set()
            if si == '(':
                for sti in stack:
                    st.add(sti+1)
                stack = st
            elif si == '*':
                for sti in stack:
                    st.add(sti+1)
                    st.add(sti)
                    if sti >=1:
                        st.add(sti-1)
                stack = st
            else:
                for sti in stack:
                    if sti>=1:
                        st.add(sti-1)
                stack = st
        return 0 in stack
                
                
        