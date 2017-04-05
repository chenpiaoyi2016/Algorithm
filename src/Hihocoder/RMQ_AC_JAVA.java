package Hihocoder;

import java.util.Scanner;

public class RMQ_AC_JAVA {

    static class Node{
        int val;
        int idx;
        Node left;
        Node right;
        public Node(int val, int idx){
            this.val = val;
            this.idx = idx;
            left = null;
            right= null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] goods = new int[N+1];
        int i = 1;
        while (i <= N) {
            goods[i] = in.nextInt();
            ++i;
        }
        Node root = consTree(goods);
        int Q = in.nextInt();
        while(Q > 0) {
            if (in.nextInt() == 0) {
                //query
                int lf = in.nextInt();
                int rh = in.nextInt();
                System.out.println(searchR(root, lf, rh));
            }
            else {
                //adjust
                int idx = in.nextInt();
                int target = in.nextInt();
                adjust(root, target, idx);
            }
            --Q;
        }
        in.close();
    }

    private static int searchR(Node root, int lf, int rh){
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.idx < lf) {
            return searchR(root.right, lf, rh);
        }
        else {
            if (root.idx <= rh) {
                if (lf == rh) {
                    return root.val;
                }
                else {
                    return Math.min(root.val, Math.min(searchR(root.left, lf, root.idx-1), searchR(root.right, root.idx+1, rh)));
                }
            }
            else {
                return searchR(root.left, lf, rh);
            }

        }
    }

    private static void adjust(Node root, int target, int idx){
        if (root.idx == idx) {
            root.val = target;
        }
        else if (root.idx > idx) {
            adjust(root.left, target, idx);
        }
        else {
            adjust(root.right, target, idx);
        }
    }

    private static Node consTree(int[] goods){
        return consR(goods, 1, goods.length-1);
    }

    private static Node consR(int[] goods, int left, int right){
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new Node(goods[left], left);
        }
        else {
            int mid = left + ((right-left) >> 1);
            Node root = new Node(goods[mid], mid);
            root.left = consR(goods, left, mid-1);
            root.right = consR(goods, mid+1, right);
            return root;
        }
    }
}
