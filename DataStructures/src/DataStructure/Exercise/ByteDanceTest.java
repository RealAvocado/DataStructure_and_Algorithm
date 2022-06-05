package DataStructure.Exercise;

import java.util.Scanner;

/**
 * 字节跳动测试开发岗2022.3.27笔试题、
 * 一个公司做网页要在网页上投放广告，设定一个数k，必须保证每两个有广告的页之间间隔k页没有广告，这是为了优化用户浏览体验。
 * 用一个二维数组表示广告投放方案，int arr[m][n],n是页数，m是投放方案数，每一行代表一个投放方案，第n列数字为1表示这页有广告，为0表示这页没广告
 */
public class ByteDanceTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = 0;
        int m = 0;
        int k = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
        }
        int[][] arr =new int[m][n];
        int input = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                while(in.hasNextInt()){
                    input = in.nextInt();
                    arr[m][n] = input;
                }
            }
        }
        int isOK = 1;
        //遍历数组开始检查
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int index = -1;
                int nextIndex = 0;
                int totalOneNum = 0;
                //如果遇到1
                if(arr[i][j]==1){
                    totalOneNum++;
                    if(totalOneNum < 3){
                        if(index == -1){
                            index = j;
                        }else{
                            nextIndex = j;
                        }
                    }else{
                        index = nextIndex;
                        nextIndex = j;
                    }
                    //判断间隔是否
                    if(nextIndex != 0 && nextIndex - index < k+1 ){
                        isOK = 0;
                    }
                }
            }
            System.out.print(isOK);
        }
    }
}
