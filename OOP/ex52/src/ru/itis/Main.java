package ru.itis;

public class Main {

    public static void main(String[] args) {
	double [][] matrix = {{1,4},{3,5}};
	Matrix2x2 matrix2x2 = new Matrix2x2(matrix);
	matrix2x2.inverseMatrix();
        System.out.println(matrix2x2);





    }
}
