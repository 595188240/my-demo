package com.my.demo.leetcode.array.medium;

/**
 * @author ffdeng2
 */
public class T36 {

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                        , {'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int [][]box  =new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j< 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (row[i][num] == 1) {
                    return false;
                }
                if (col[j][num] == 1) {
                    return false;
                }
                // 9x9 计算3x3 为一行
                if (box[j /3 + (i / 3) * 3][num] == 1) {
                    return false;
                }
                row[i][num] = 1;
                col[j][num] = 1;
                box[j /3 + (i / 3) * 3][num] = 1;
            }
        }
        return true;
    }

}
