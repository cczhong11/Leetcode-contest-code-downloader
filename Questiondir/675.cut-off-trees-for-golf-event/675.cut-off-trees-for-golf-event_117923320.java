class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        Node[][] matrix = new Node[forest.size()][forest.get(0).size()];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // Map<Node, Set<Node>> adj = new HashMap<>();
        for (int i = 0; i < forest.size(); ++i) {
            for (int j = 0; j < forest.get(i).size(); ++j) {
                if (forest.get(i).get(j) != 0) {
                    Node n = new Node(i, j, forest.get(i).get(j));
                    // adj.put(n, new HashSet<Node>());
                    matrix[i][j] = n;
                    if (n.val > 1) {
                        pq.add(n);
                    }
                }
            }
        }
        // for (int i = 0; i < matrix.length; ++i) {
        //     for (int j = 0; j < matrix[0].length; ++j) {
        //         if (matrix[i][j] != null) {
        //             Node n = matrix[i][j];
        //             if (i - 1 >= 0 && matrix[i - 1][j] != null) {
        //                 adj.get(n).add(matrix[i - 1][j]);
        //             }
        //             if (i + 1 < matrix.length && matrix[i + 1][j] != null) {
        //                 adj.get(n).add(matrix[i + 1][j]);
        //             }
        //             if (j - 1 >= 0 && matrix[i][j - 1] != null) {
        //                 adj.get(n).add(matrix[i][j - 1]);
        //             }
        //             if (j + 1 < matrix[i].length && matrix[i][j + 1] != null) {
        //                 adj.get(n).add(matrix[i][j + 1]);
        //             }
        //         }
        //     }
        // }
        
        Node curr = matrix[0][0];
        int dist = 0;
        while (!pq.isEmpty()) {
            Node n = pq.remove();
            int newDist = search(curr, n, matrix);
            if (newDist == -1) {
                return -1;
            } else {
                dist += newDist;
            }
            curr = n;
        }
        return dist;
        
    }
    
    public int search(Node u, Node v, Node[][] matrix) {
        if (u == null) return -1;
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        q.offerLast(u);
        visited[u.row][u.col] = true;
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node n = q.removeFirst();
                if (n.equals(v)) return dist;
                if (n.row - 1 >= 0 && !visited[n.row - 1][n.col] && matrix[n.row - 1][n.col] != null) {
                    q.addLast(matrix[n.row - 1][n.col]);
                    visited[n.row - 1][n.col] = true;
                }
                if (n.row + 1 < matrix.length && !visited[n.row + 1][n.col] && matrix[n.row + 1][n.col] != null) {
                    q.addLast(matrix[n.row + 1][n.col]);
                    visited[n.row + 1][n.col] = true;
                }
                if (n.col - 1 >= 0 && !visited[n.row][n.col - 1] && matrix[n.row][n.col - 1] != null) {
                    q.addLast(matrix[n.row][n.col - 1]);
                    visited[n.row][n.col - 1] = true;
                }
                if (n.col + 1 < matrix[0].length && !visited[n.row][n.col + 1] && matrix[n.row][n.col + 1] != null) {
                    q.addLast(matrix[n.row][n.col + 1]);
                    visited[n.row][n.col + 1] = true;
                }
            }
            ++dist;
        }
        return -1;
    }
    
    private class Node implements Comparable<Node> {
        public int row;
        public int col;
        public int val;
        public Node(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
        public int compareTo(Node o) {
            return this.val - o.val;
        }
        public int hashCode() {
            return row + col + val;
        }
        public boolean equals(Object o) {
            if (!(o instanceof Node)) {
                return false;
            }
            Node n = (Node) o;
            return row == n.row && col == n.col && val == n.val;
        }
    }
}