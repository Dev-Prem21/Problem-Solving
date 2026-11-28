class Solution {
    List<Integer> list;

    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);

        int prev = -1;
        int next = -1;

        for(int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);

            if(a > b) {
                if(prev == -1) {
                    prev = i;
                } else {
                    next = i;
                    break;
                }
            }
        }

        int x = list.get(prev);
        int y = (next == -1)
                ? list.get(prev + 1)
                : list.get(next + 1);

        fix(root, x, y);
    }

    private void dfs(TreeNode node) {
        if(node == null) return;

        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    private void fix(TreeNode node, int x, int y) {
        if(node == null) return;

        if(node.val == x) {
            node.val = y;
        } else if(node.val == y) {
            node.val = x;
        }

        fix(node.left, x, y);
        fix(node.right, x, y);
    }
}