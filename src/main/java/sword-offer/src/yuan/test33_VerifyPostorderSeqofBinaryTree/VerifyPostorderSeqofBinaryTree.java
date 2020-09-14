package yuan.test33_VerifyPostorderSeqofBinaryTree;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 16:31
 * @description @link
 */
public class VerifyPostorderSeqofBinaryTree {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j)
            return true;

        int pivot = i;
        //确保mid左边的数都比root的小
        while (postorder[pivot] < postorder[j])
            pivot++;

        int mid = pivot;

        //确保mid右边的数都比root的大
        while (postorder[pivot] > postorder[j])
            pivot++;

        return pivot == j && recur(postorder, i, mid - 1) && recur(postorder, mid, j - 1);
    }

}