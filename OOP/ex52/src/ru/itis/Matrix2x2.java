package ru.itis;

import ex49.Vector2D;

public class Matrix2x2 {
    private double[][] matrix = new double[1][1];

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix2x2() {
        this(0);
    }

    public Matrix2x2(double a) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = a;
            }
        }
    }

    public Matrix2x2(double[][] matrix) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix2x2(double a1, double a2, double a3, double a4) {
        matrix[0][0] = a1;
        matrix[0][1] = a2;
        matrix[1][0] = a3;
        matrix[1][1] = a4;
    }

    public Matrix2x2 add(Matrix2x2 matrix) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix2x2.matrix[i][j] = this.matrix[i][j] + matrix.matrix[i][j];
            }
        }
        return matrix2x2;
    }

    public void add2(Matrix2x2 matrix) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix.matrix[i][j] += this.matrix[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 matrix) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix2x2.matrix[i][j] = this.matrix[i][j] - matrix.matrix[i][j];
            }
        }
        return matrix2x2;
    }

    public void sub2(Matrix2x2 matrix) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix.matrix[i][j] -= this.matrix[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double a) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix2x2.matrix[i][j] = this.matrix[i][j] * a;
            }
        }
        return matrix2x2;
    }

    public void multNumber2(double a) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] *= a;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 matrix) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                double sum = 1.0;
                for (int k = 0; k < matrix.matrix[i].length; k++) {
                    sum += this.matrix[i][k] * matrix.matrix[k][j];
                }
                matrix2x2.matrix[i][j] = sum;
            }
        }
        return matrix2x2;
    }

    public void mult2(Matrix2x2 matrix) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                double sum = 1.0;
                for (int k = 0; k < matrix.matrix[i].length; k++) {
                    sum += this.matrix[i][k] * matrix.matrix[k][j];
                }
                matrix.matrix[i][j] = sum;
            }
        }
    }

    public double del() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public void transpon() {
        double t = matrix[0][1];
        matrix[0][1] = matrix[1][0];
        matrix[1][0] = t;
    }

    public void algebDop() {
        double t = matrix[0][0];
        matrix[0][0] = matrix[1][1];
        matrix[1][1] = t;
        t = matrix[0][1];
        matrix[0][1] = -1 * matrix[1][0];
        matrix[1][0] = -1 * t;
    }


    public Matrix2x2 inverseMatrix() {
        if (del() != 0) {
            algebDop();
            transpon();
        }
        return multNumber(del());

    }


    public Vector2D multVector(Vector2D vector){
        Vector2D vector2D = new Vector2D();
        vector2D.x = matrix[0][0] * vector.x + matrix[0][1] * vector.y;
        vector2D.y = matrix[1][0] * vector.x + matrix[1][1] * vector.y;
        return vector2D;
    }

}