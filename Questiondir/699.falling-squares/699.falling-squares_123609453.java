class Solution {

public List<Integer> fallingSquares(int[][] positions) {
return new TaskE().fallingSquares(positions);
}

static class TaskE {
//     void solve() {
//      Truth.assertEquals(fallingSquares(new int[][]{
//              new int[]{1, 2},
//              new int[]{2, 3},
//              new int[]{6, 1}
//          }),
//          new int[]{2, 5, 5});
//      Truth.assertEquals(fallingSquares(new int[][]{
//              new int[]{100, 100},
//              new int[]{200, 100},
//          }),
//          new int[]{100, 100});
//
//    }

List<Integer> fallingSquares(int[][] positions) {
int n = positions.length;
List<Integer> res = new ArrayList<>(n);
if (n == 0) return res;
IntArrayList dis = new IntArrayList(n << 1);
for (int[] position : positions) {
dis.add(position[0]);
dis.add(position[0] + position[1]);
}
dis.sortAndUnique();
IntMinITSupportSet itree = new IntMinITSupportSet(dis.size - 1);
for (int[] position : positions) {
int lower = dis.lowerBound(position[0]);
int upper = dis.lowerBound(position[0] + position[1]);
int height = -itree.calc(lower, upper) + position[1];
itree.update(lower, upper, -height);
res.add(-itree.calc(0, dis.size - 1));
}
return res;
}
}

static class IntUtils {

public static boolean isPow2(int n) {
return n > 0 && (n & (n - 1)) == 0;
}

public static int nextPow2(int n) {
if (n < 1) return 1;
return isPow2(n) ? n : Integer.highestOneBit(n) << 1;
}
}

static class IntMinITSupportSet extends AbstractITWithLazyP {
int[] mv;
boolean[] ts;
int[] sv;
int uv;

IntMinITSupportSet(int leafC) {
super(leafC, true);
}

void createStorage(int nodeC) {
mv = new int[nodeC];
ts = new boolean[nodeC];
sv = new int[nodeC];
}


void initLeaf(int iit, int idx) {
mv[iit] = 0;
}


void assignFakeLazyP() {
ts[0] = true;
sv[0] = uv;
}


void pushLazyP(int fromIit, int toIit) {
if (ts[fromIit]) {
ts[toIit] = true;
sv[toIit] = sv[fromIit];
mv[toIit] = sv[toIit];
}
}


void clearLazyP(int iit) {
ts[iit] = false;
}


void merge(int leftIit, int rightIit, int iit) {
mv[iit] = Math.min(mv[leftIit], mv[rightIit]);
}


void copyForCalc(int fromIit, int toIit) {
mv[toIit] = mv[fromIit];
}


void clearNodeForCalc(int iit) {
mv[iit] = Integer.MAX_VALUE;
}

void update(int lower, int upper, int uv) {
this.uv = uv;
updateRange(lower, upper);
}

int calc(int lower, int upper) {
calcRange(lower, upper);
return mv[0];
}

}

static class IntArrayList {
int[] values;
int size;

IntArrayList(int c) {
values = new int[IntUtils.nextPow2(c)];
clear();
}

void clear() {
size = 0;
}

void add(int value) {
ensureC(size + 1);
addInternal(value);
}

void addAll(IntArrayList values) {
ensureC(size + values.size);
for (int i = 0; i < values.size; ++i) {
addInternal(values.get(i));
}
}

int get(int idx) {
if (idx >= size) throw new ArrayIndexOutOfBoundsException();
return values[idx];
}

void sort() {
IntArrayUtils.sort(values, 0, size);
}

void unique() {
size = IntArrayUtils.unique(values, 0, size);
}

void sortAndUnique() {
sort();
unique();
}

int lowerBound(int value) {
return IntArrayUtils.lowerBound(values, 0, size, value);
}

void reverse() {
IntArrayUtils.reverse(values, 0, size);
}

void ensureC(int c) {
if (c <= values.length) return;
int[] newValues = new int[IntUtils.nextPow2(c)];
for (int i = 0; i < size; ++i) {
newValues[i] = values[i];
}
values = newValues;
}

void addInternal(int value) {
values[size++] = value;
}

}

static class IntArrayUtils {
static final Random RANDOM = new Random(1000000007);

static void reverse(int[] values, int fromIdx, int toIdx) {
for (int i = fromIdx, j = toIdx - 1; i < j; ++i, --j) {
swap(values, i, j);
}
}

static int unique(int[] values, int fromIdx, int toIdx) {
if (fromIdx == toIdx) return 0;
int res = 1;
for (int i = fromIdx + 1; i < toIdx; ++i) {
if (values[i - 1] != values[i]) {
values[fromIdx + res++] = values[i];
}
}
return res;
}

static void sort(int[] values, int fromIdx, int toIdx) {
shuffle(values, fromIdx, toIdx);
Arrays.sort(values, fromIdx, toIdx);
}

static int lowerBound(int[] values, int fromIdx, int toIdx, int value) {
int res = toIdx;
for (int lower = fromIdx, upper = toIdx - 1; lower <= upper; ) {
int medium = (lower + upper) >> 1;
if (value <= values[medium]) {
res = medium;
upper = medium - 1;
} else {
lower = medium + 1;
}
}
return res;
}

static void swap(int[] values, int uIdx, int vIdx) {
if (uIdx == vIdx) return;
values[uIdx] ^= values[vIdx];
values[vIdx] ^= values[uIdx];
values[uIdx] ^= values[vIdx];
}

static void shuffle(int[] values, int fromIdx, int toIdx) {
for (int i = toIdx - fromIdx - 1; i > 0; --i) {
swap(values, i + fromIdx, RANDOM.nextInt(i + 1) + fromIdx);
}
}

}

static abstract class AbstractITWithLazyP {
int nodeC;
int leafCnt;
int[] rangeLower;
int[] rangeUpper;
IntArrayList iitToUpdate;
IntArrayList iitToUpdateAppendix;

abstract void createStorage(int nodeC);

abstract void initLeaf(int iit, int idx);

abstract void assignFakeLazyP();

abstract void pushLazyP(int fromIit, int toIit);

abstract void clearLazyP(int iit);

abstract void merge(int leftIit, int rightIit, int iit);

abstract void copyForCalc(int fromIit, int toIit);

abstract void clearNodeForCalc(int iit);

AbstractITWithLazyP(int leafC, boolean initialize) {
int height = 32 - Integer.numberOfLeadingZeros(leafC);
iitToUpdate = new IntArrayList(height << 1);
iitToUpdateAppendix = new IntArrayList(height);
nodeC = leafC << 1;
rangeLower = new int[nodeC + 2];
rangeUpper = new int[nodeC + 2];
createStorage(nodeC + 2);
if (initialize) init(leafC);
}

void init(int leafCnt) {
this.leafCnt = leafCnt;
for (int i = 0; i < leafCnt; ++i) {
rangeLower[i + leafCnt] = i;
rangeUpper[i + leafCnt] = i + 1;
initLeaf(i + leafCnt, i);
clearLazyP(i);
clearLazyP(i + leafCnt);
}
for (int i = leafCnt - 1; i >= 0; --i) {
int left = i << 1, right = left | 1;
if (rangeUpper[left] == rangeLower[right]) {
rangeLower[i] = rangeLower[left];
rangeUpper[i] = rangeUpper[right];
merge(left, right, i);
} else {
rangeLower[i] = leafCnt;
rangeUpper[i] = -1;
}
}
}

void updateRange(int lower, int upper) {
assignFakeLazyP();
pushLazyPToRange(lower, upper);
boolean calcLeft = false, calcRight = false;
for (lower += leafCnt, upper += leafCnt; lower < upper; lower >>= 1, upper >>= 1) {
if (calcLeft) merge(lower - 1);
if (calcRight) merge(upper);
if ((lower & 1) > 0) {
pushLazyP(0, lower++);
calcLeft = true;
}
if ((upper & 1) > 0) {
pushLazyP(0, --upper);
calcRight = true;
}
}
for (--lower; upper > 0; lower >>= 1, upper >>= 1) {
if (calcLeft) merge(lower);
if (calcRight && (!calcLeft || lower != upper)) merge(upper);
}
}

void calcRange(int lower, int upper) {
if (lower >= upper) {
clearNodeForCalc(0);
return;
}
pushLazyPToRange(lower, upper);
iitToUpdate.clear();
iitToUpdateAppendix.clear();
for (lower += leafCnt, upper += leafCnt; lower < upper; lower >>= 1, upper >>= 1) {
if ((lower & 1) > 0) {
if (isValid(lower)) iitToUpdate.add(lower);
++lower;
}
if ((upper & 1) > 0) {
if (isValid(--upper)) iitToUpdateAppendix.add(upper);
}
}
iitToUpdateAppendix.reverse();
iitToUpdate.addAll(iitToUpdateAppendix);
int iit = iitToUpdate.get(0);
int resIit = nodeC;
copyForCalc(iit, resIit);
rangeLower[resIit] = rangeLower[iit];
rangeUpper[resIit] = rangeUpper[iit];
for (int i = 1; i < iitToUpdate.size; ++i, resIit ^= 1) {
iit = iitToUpdate.get(i);
merge(resIit, iit, resIit ^ 1);
rangeLower[resIit ^ 1] = rangeLower[resIit];
rangeUpper[resIit ^ 1] = rangeUpper[iit];
}
copyForCalc(resIit, 0);
}

boolean isValid(int iit) {
return rangeLower[iit] < rangeUpper[iit];
}

void merge(int iit) {
merge(iit << 1, (iit << 1) | 1, iit);
}

void pushLazyPToRange(int lower, int upper) {
lower = (lower + leafCnt) >> 1;
upper = (upper - 1 + leafCnt) >> 1;
for (iitToUpdate.clear(); lower < upper; lower >>= 1, upper >>= 1) {
if (isValid(lower)) iitToUpdate.add(lower);
if (isValid(upper)) iitToUpdate.add(upper);
}
for (; lower > 0 && isValid(lower); lower >>= 1) {
iitToUpdate.add(lower);
}
for (int i = iitToUpdate.size - 1; i >= 0; --i) {
pushLazyP(iitToUpdate.values[i]);
}
}

void pushLazyP(int iit) {
pushLazyP(iit, iit << 1);
pushLazyP(iit, (iit << 1) | 1);
clearLazyP(iit);
}

}

}

