class Matrix {
  int rows;
  int cols;
  float[][] matrix;

  //Constructor from 2 size declarations
  Matrix(int argRows, int argCols) {
    rows = argRows;
    cols = argCols;
    matrix = new float[rows][cols];
  }

  //Constructor from 2D float Array
  Matrix(float[][] argMatrix) {
    matrix = argMatrix;
    rows = argMatrix.length;
    cols = argMatrix[0].length;
  }

  //Prints the matrix
  void print(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + "  ");
      }
      System.out.println(" ");
    }
    System.out.println();
  }

  //Sets a specific value in the matrix
  void setValue(int x, int y, Number argValue){
    matrix[x][y] = argValue.floatValue();
  }

  //Gets a specific value from the matrix
  float getValue(int x, int y){
    return matrix[x][y];
  }

  //Randomizes the matrix with values of n, where: 0 <= n < 1
  void randomize(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (float) Math.random();
      }
    }
  }

  //Randomizes the matrix with values of n, where: 0 <= n < maxValue
  void randomize(int maxValue){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (float) Math.random() * maxValue;
      }
    }
  }

  //Randomizes the matrix with values of n, where: minValue <= n < maxValue
  void randomize(int minValue, int maxValue){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (float) (Math.random() * (maxValue-minValue)) + minValue;
      }
    }
  }

  //Fills each entry with a zero
  void fillZero(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = 0.0f;
      }
    }
  }

  //Transposes the matrix
  void transpose(){
    float[][] tempMatrix = new float[cols][rows];
    int tempRows;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        tempMatrix[j][i] = matrix[i][j];
      }
    }

    tempRows = rows;
    rows = cols;
    cols = tempRows;
    matrix = tempMatrix;
  }

  //Multiplies two matricies with each other
  static Matrix matMul(Matrix argMat1, Matrix argMat2) throws Exception{
    if (argMat1.cols != argMat2.rows) throw new matrixSizeException("not compatible matrix sizes");

    Matrix outputMatrix = new Matrix(argMat1.rows, argMat2.cols);

    for (int i = 0; i < outputMatrix.rows; i++) {
      for (int j = 0; j < outputMatrix.cols; j++) {

        float curOutputCell = 0.0f;
        for (int k = 0; k < argMat1.cols; k++) {
          curOutputCell += argMat1.getValue(i, k) * argMat2.getValue(k, j);
          outputMatrix.setValue(i, j, curOutputCell);
        }

      }
    }
    return outputMatrix;
  }

  static Matrix pow(Number n, Matrix mat){
    Matrix result = new Matrix(mat.rows, mat.cols);

    for (int i = 0; i < mat.rows; i++) {
      for (int j = 0; j < mat.cols; j++) {
        result.setValue(i, j, (float) Math.pow(n.floatValue(), mat.getValue(i, j)));
      }
    }

    return result;
  }

  static Matrix exp(Matrix mat){
    Matrix result = new Matrix(mat.rows, mat.cols);

    for (int i = 0; i < mat.rows; i++) {
      for (int j = 0; j < mat.cols; j++) {
        result.setValue(i, j, (float) Math.exp(mat.getValue(i, j)));
      }
    }

    return result;
  }

  //------------------------------MATH FUNCTIONS------------------------------//
  //---------------------DANGER : A LOT OF REDUNDANT CODE---------------------//
  //--------------------------------------------------------------------------//
  //---------------------REALLY. NO NEED TO LOOK AT IT------------------------//

  //Multiplies each entry with n
  void mul(Number n) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] *= n.floatValue();
      }
    }
  }

  //Divides each entry with n
  void div(Number n) {
    mul(1/n.floatValue());
  }

  //Adds to each entry a value n
  void add(Number n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] += n.floatValue();
      }
    }
  }

  //Subtracts to each entry a value n
  void sub(Number n){
    add(-n.floatValue());
  }

  //Calculates the power of n for each entry
  void pow(Number n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (float) Math.pow(matrix[i][j], n.floatValue());
      }
    }
  }

  //Exponentiates each entry
  void exp(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (float) Math.exp(matrix[i][j]);
      }
    }
  }

  void tanh(){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (float) Math.tanh(matrix[i][j]);
      }
    }
  }

  //Multiplies a specific entry with n
  void mul(int x, int y, Number n) {
    matrix[x][y] *= n.floatValue();
  }

  //Divides a specific entry with n
  void div(int x, int y, Number n) {
    mul(x, y, 1/n.floatValue());
  }

  //Adds to a specific entry a value n
  void add(int x, int y, Number n){
    matrix[x][y] += n.floatValue();
  }

  //Subtracts a specific entry with a value n
  void sub(int x, int y, Number n){
    add(x, y, -n.floatValue());
  }

  //Calculates the power of n for each entry
  void pow(int x, int y, Number n){
    matrix[x][y] = (float) Math.pow(matrix[x][y], n.floatValue());
  }

  //Exponentiates a specific entry
  void exp(int x, int y){
    matrix[x][y] = (float) Math.exp(matrix[x][y]);
  }
}
