import java.util.Scanner;
import java.lang.Math;


class Matrix {
    protected int[][] matrix;
    protected int rows;
    protected int cols;


    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }


    public void readMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Метод для вычисления количества отрицательных значений f(xij)
    public int countNegative() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (f(matrix[i][j]) < 0) {
                    count++;
                }
            }
        }
        return count;
    }


    protected double f(int x) {
        return Math.sin(x);
    }
}

// Класс для подсчета строк с упорядоченными по возрастанию элементами
class OrderedRowsMatrix extends Matrix {

    public OrderedRowsMatrix(int rows, int cols) {
        super(rows, cols);
    }

    // Метод для подсчета строк, элементы которых упорядочены по возрастанию
    public int countOrderedRows() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            boolean isOrdered = true;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < matrix[i][j - 1]) {
                    isOrdered = false;
                    break;
                }
            }
            if (isOrdered) {
                count++;
            }
        }
        return count;
    }
}

// Основной класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк матрицы A:");
        int rowsA = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы A:");
        int colsA = scanner.nextInt();
        OrderedRowsMatrix matrixA = new OrderedRowsMatrix(rowsA, colsA);
        System.out.println("Введите элементы матрицы A:");
        matrixA.readMatrix();

        System.out.println("Введите количество строк матрицы B:");
        int rowsB = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы B:");
        int colsB = scanner.nextInt();
        OrderedRowsMatrix matrixB = new OrderedRowsMatrix(rowsB, colsB);
        System.out.println("Введите элементы матрицы B:");
        matrixB.readMatrix();

        int negativeCountA = matrixA.countNegative();
        int negativeCountB = matrixB.countNegative();

        OrderedRowsMatrix targetMatrix;
        if (negativeCountA > negativeCountB) {
            targetMatrix = matrixA;
        } else {
            targetMatrix = matrixB;
        }

        int orderedRowsCount = targetMatrix.countOrderedRows();
        System.out.println("Количество строк с упорядоченными по возрастанию элементами: " + orderedRowsCount);
    }
}