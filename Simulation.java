class Simulation {
  public static void main(String[] args) throws Exception{

    Matrix mat1 = new Matrix(4, 5);
    Matrix mat2 = new Matrix(5, 3);

    mat1.randomize(-2, 2);
    mat2.randomize(-2, 2);

    Matrix mat3 = Matrix.matMul(mat1, mat2);

    System.out.println("Matrix #1");
    mat1.print();

    System.out.println("Matrix #2");
    mat2.print();

    System.out.println("Matrix #3");
    mat3.print();

    mat3.mul(5);

    System.out.println("Matrix #3.1");
    mat3.print();
  }
}
