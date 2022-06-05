package DataStructure.SparseArray;

import java.util.Scanner;

public class SparseArray {

    public static void displayArray(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
       /* for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }*/
    }

    //transform a 2-dimensional array into a sparse array
    public static int[][] transformToSparse(int[][] arr) {
        //go through the 2-dimensional array and transform it i=to a sparse array
        //record the amount of 0 non-zero numbers
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //construct a corresponding sparse array
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //again go through the 2-dimensional array and put values of non-zero numbers in the sparse array
        int row = 0;
        for (int i = 0; i < arr.length; i++) {  //number of row
            for (int j = 0; j < arr[0].length; j++) {  //number of column
                if (arr[i][j] != 0) {
                    row++;
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    //transform a sparse array back to original 2-dimensional array
    public static int[][] restoreToOriginal(int[][] sparseArr) {
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];

        int[][] originalArr = new int[row][col];
        //go through the sparse array, assign the values to original array
        for (int i = 1; i < sparseArr.length; i++) {
            int m = sparseArr[i][0];
            int n = sparseArr[i][1];
            int value = sparseArr[i][2];
            originalArr[m][n] = value;
        }
        return originalArr;
    }

    public static void main(String[] args) {
        //0: no chess on this place; 1: black chess; 2: blue chess
//        System.out.println("请输入一个二维数组的行数和列数：");
//        System.out.println("行数：");
//        Scanner scanner = new Scanner(System.in);
//        int row = scanner.nextInt();
//        System.out.println("列数");
//        int col = scanner.nextInt();
//        int chessArr[][] = new int[row][col];
//        System.out.println("请给该二维数组的非零值赋值：");
//        int num = 0;
//
//        while (true) {
//            num++;
//            System.out.printf("给第%d个非零值辅助：\n", num);
//            System.out.println("所在行数：");
//            int m = scanner.nextInt();
//            if (m < 0 || m > row) {
//                num--;
//                System.out.println("m的值无效！请重新输入！");
//                System.out.println();
//                continue;
//            }
//            System.out.println("所在列数：");
//            int n = scanner.nextInt();
//            if (n < 0 || n > col) {
//                num--;
//                System.out.println("n的值无效！请重新输入！");
//                System.out.println();
//                continue;
//            }
//            System.out.println("值为：");
//            int val = scanner.nextInt();
//            chessArr[m - 1][n - 1] = val;
//            System.out.println("继续赋值？‘t’：继续；‘f’：停止。");
//            char flag = ' ';
//            flag = scanner.next().charAt(0);
//            if (flag == 't') {
//                continue;
//            } else {
//                break;
//            }
//        }
//
//        boolean loop = true;
//        char key = ' ';
//        while (loop) {
//            System.out.println("a：显示该二维数组");
//            System.out.println("b：将该二维数组转化为稀疏数组,并显示。");
//            System.out.println("c：退出。");
//            key = scanner.next().charAt(0);
//            switch (key) {
//                case 'a':
//                    displayArray(chessArr);
//                    break;
//                case 'b':
//                    int[][] sparseArr = transformToSparse(chessArr);
//                    displayArray(sparseArr);
//                    break;
//                case 'c':
//                    loop = false;
//                    break;
//                default:
//                    break;
//            }
//        }



        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //print the array
        System.out.println("Original two-dimensional array");
        displayArray(chessArr1);

        int[][] sparseArr = transformToSparse(chessArr1);
        System.out.println("The sparse array is:");
        displayArray(sparseArr);

        int[][] originalArr = restoreToOriginal(sparseArr);
        System.out.println("Transfer the sparse array back to original 2-dimensional array:");
        displayArray(originalArr);
    }
}
