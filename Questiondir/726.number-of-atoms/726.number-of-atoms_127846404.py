class Solution(object):
  def is_upper(self, s):
    return ord(s[0]) >= ord('A') and ord(s[0]) <= ord('Z')
  def is_digit(self, s):
    return ord(s[0]) >= ord('0') and ord(s[0]) <= ord('9')
  def is_bracket(self, s):
    return s == '(' or s == ')'

  def solve(self, index, dict):
    if index >= self.n:
      return (dict, index)
    if self.formula[index] == '(':
      (inner_dict, pos) = self.solve(index + 1, {})
      for key, value in inner_dict.iteritems():
        if key not in dict:
          dict[key] = 0
        dict[key] += value
      return self.solve(pos, dict)
    elif self.formula[index] == ')':
      index += 1
      ds = ''
      while index < self.n and self.is_digit(self.formula[index]):
        ds += self.formula[index]
        index += 1
      if ds != '':
        mul = int(ds)
        for key, value in dict.iteritems():
          dict[key] *= mul
      return (dict, index)
    else:
      mole = self.formula[index]
      ds = ''
      index += 1
      while index < self.n:
        ch = self.formula[index]
        if self.is_upper(ch) or self.is_bracket(ch):
          break
        elif self.is_digit(ch):
          ds += ch
        else:
          mole += ch
        index += 1
      cnt = 1
      if ds != '':
        cnt = int(ds)
      if mole not in dict:
        dict[mole] = 0
      dict[mole] += cnt
      return self.solve(index, dict)


  def countOfAtoms(self, formula):
    self.n = len(formula)
    self.formula = formula
    dict, _ = self.solve(0, {})
    ans = ""
    for key, value in sorted(dict.iteritems()):
      ans += key
      if value > 1:
        ans += str(value)
    return ans

