package com.akay.leecode;

/**
 * Created by Akay on 2016/10/3.
 * Title: 6. ZigZag Conversion
 * Linke: https://leetcode.com/problems/zigzag-conversion
 */

public class ZigZag_Conversion {
    public String convert(String s, int numRows) {
        String rs = "";
        char[][] as = null;
        char[] tmpCharArray = s.toCharArray();
        int numCols, len;        //算出一共有多少列
        int tmp1, tmp2;

        len = s.length();

        if (numRows == 1)
            return s;

        //计算总共有多少列
        tmp1 = len / (numRows * 2 - 2);
        tmp2 = len % (numRows * 2 - 2);

        numCols = tmp1 * (numRows - 1) + ((tmp2 <= numRows) ? 1 : (tmp2 - numRows + 1));
        if (len < numRows)
            numRows = len;

        as = new char[numRows][numCols];

        //初始化数组
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                as[i][j] = '\0';
            }
        }

        //将字符串填入数组响应位置(采用模拟的方法）
        boolean flag = false;  //标识符，判断是否递减
        int pos_col = 0, pos_row = 0;
        for (int pos = 0; pos < len; pos++) {

            as[pos_row][pos_col] = tmpCharArray[pos];

            if (flag) {
                pos_row -= 1;
                pos_col++;
            } else {
                pos_row += 1;
            }

            if (pos_row == (numRows - 1)) {
                flag = true;
            } else if (pos_row == 0) {
                flag = false;
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if(as[row][col] != '\0')
                rs += as[row][col];
            }
        }

        return rs;
    }


}
