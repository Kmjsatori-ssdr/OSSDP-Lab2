package com.game_of_life;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class Solution19Test {
    /*
     * 测试用例等价类划分标准：
     * 规则分类：
     * 活细胞周围少于两个；
     * 活细胞周围两三个；
     * 活细胞周围多于三个；
     * 死细胞周围正好三个；
     * 
     * 面版大小：1*1，3*3，9*9（小中大）
     */
    @Test
    public void test1x1() {
        Solution s = new Solution();
        int[][] board = { { 1 } };
        int[][] result = s.gameOfLife(board);
        int[][] excepted = { { 0 } };
        assertArrayEquals(excepted, result);
        int[][] board2 = { { 0 } };
        int[][] result2 = s.gameOfLife(board2);
        int[][] excepted2 = { { 0 } };
        assertArrayEquals(excepted2, result2);
    }

    @Test
    public void test3x3() {
        // 活细胞周围大于三个，正好三个
        Solution s = new Solution();
        int[][] board = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        int[][] result = s.gameOfLife(board);
        int[][] excepted = {
                { 1, 0, 1 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };
        assertArrayEquals(excepted, result);
        // 活细胞周围两三个，死细胞周围三个
        int[][] board2 = {
                { 1, 1, 1 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        int[][] result2 = s.gameOfLife(board2);
        int[][] excepted2 = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        assertArrayEquals(excepted2, result2);
        // 活细胞周围少于两个或四个，死细胞周围三个
        int[][] board3 = {
                { 1, 0, 1 },
                { 0, 1, 0 },
                { 1, 0, 1 }
        };
        int[][] result3 = s.gameOfLife(board3);
        int[][] excepted3 = {
                { 0, 1, 0 },
                { 1, 0, 1 },
                { 0, 1, 0 }
        };
        assertArrayEquals(excepted3, result3);
    }

    @Test
    public void test9x9() {
        // 检查大面板能否正常工作
        Solution s = new Solution();
        int[][] board = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, // 活细胞有四个活邻居
                { 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0 }, // 死者复生区
                { 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0 }// 一个稳定岛
        };
        int[][] result = s.gameOfLife(board);
        int[][] excepted = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0, 0, 0, 0 }, // 活细胞有四个活邻居
                { 0, 1, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 1 }, // 死者复生区
                { 0, 0, 0, 0, 0, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0 }// 一个稳定岛
        };
        assertArrayEquals(excepted, result);
    }
}
