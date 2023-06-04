import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        int[][] matrix;
        int height, width;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ширину матриці (не більше 20):");
        width = scanner.nextInt();
        System.out.println("Введіть висоту матриці (не більше 20):");
        height = scanner.nextInt();

        if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Недопустимий розмір матриці!");
            return;
        }

        System.out.println("Як ви хочете створити матрицю? (1 - ручно, 2 - рандомно)");
        int choice = scanner.nextInt();

        if (choice == 1) {
            matrix = createMatrixManually(width, height, scanner);
        } else if (choice == 2) {
            matrix = createMatrixRandomly(width, height);
        } else {
            System.out.println("Недопустимий вибір!");
            return;
        }

        printMatrix(matrix);

        int min = findMinimum(matrix);
        int max = findMaximum(matrix);
        double average = calculateAverage(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricMean);
    }

    private static int[][] createMatrixManually(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] createMatrixRandomly(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMinimum(int[][] matrix) {
        int min = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }

        return min;
    }

    private static int findMaximum(int[][] matrix) {
        int max = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        int product = 1;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                product *= element;
                count++;
            }
        }

        return Math.pow(product, 1.0 / count);
    }
}
