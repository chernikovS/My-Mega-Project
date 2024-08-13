package app;

public class Main {

    static int sumOfEvenNums;
    static int sumOfOddNums;
    static long multipOfEvenNums = 1;
    static long multipOfOddNums = 1;

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1, 21, 19, 49},
                {33, 42, 15, 9},
                {26, 7, 38, 27},
                {12, 2, 17, 20}
        };

        if (isMagicSquare(matrix)) {
            System.out.println("Матриця є магічним квадратом.");
        }
        else {
            System.out.println("Матриця не є магічним квадратом.");
        }

        System.out.println("\nМатриця 4x4: ");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(" ");
        }


        for(int i = 0; i < matrix.length; i += 2) {
            for(int element : matrix[i]) {
                sumOfEvenNums += element;
                multipOfEvenNums *= element;
            }
        }
        System.out.println("\nСума елементів у парних рядках (рядок 0, 2): " +
                sumOfEvenNums + "\nДобуток елементів у парних стовпцях " +
                "(стовпець 0, 2): " + multipOfEvenNums);


        for(int i = 1; i < matrix.length; i += 2) {
            for(int element : matrix[i]) {
                sumOfOddNums += element;
                multipOfOddNums *= element;
            }
        }
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " +
                sumOfOddNums + "\nДобуток елементів у непарних стовпцях " +
                "(стовпець 1, 3): " + multipOfOddNums);
    }



    public static boolean isMagicSquare(int[][] matrix) {
        for (int[] row : matrix) {
            if (row.length != matrix.length) {
                return false;
            }
        }

        for (int[] ints : matrix) {
            if (sum(ints) != sum(matrix[0])) {
                return false;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            if (columnSum(matrix, j) != sum(matrix[0])) {
                return false;
            }
        }

        if (diagonalSum(matrix, true) != sum(matrix[0])) {
            return false;
        }
        return diagonalSum(matrix, false) == sum(matrix[0]);
    }


    public static int sum(int[] row) {
        int total = 0;
        for (int num : row) {
            total += num;
        }
        return total;
    }


    public static int columnSum(int[][] matrix, int columnIndex) {
        int total = 0;
        for (int[] row : matrix) {
            total += row[columnIndex];
        }
        return total;
    }


    public static int diagonalSum(int[][] matrix, boolean mainDiagonal) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (mainDiagonal) {
                total += matrix[i][i];
            } else {
                total += matrix[i][matrix.length - 1 - i]; // Побочная диагональ
            }
        }
        return total;
    }
}