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
    rows = argMatrix[0].length;
    cols = argMatrix.length;
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
  void setValue(int x, int y, float argValue){
    matrix[x][y] = argValue;
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
  void randomize(int maxValue, int minValue){
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


  //------------------------------MATH FUNCTIONS------------------------------//
  //---------------------DANGER : A LOT OF REDUNDANT CODE---------------------//
  //--------------------------------------------------------------------------//
  //---------------------REALLY. NOT NEED TO LOOK AT IT-----------------------//

  //Multiplies each entry with an integer n
  void mul(int n) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) * n;
      }
    }
  }

  //Multiplies each entry with an float n
  void mul(float n) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) * n;
      }
    }
  }

  //Multiplies each entry with an double n
  void mul(double n) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] =  getValue(i, j) * (float) n;
      }
    }
  }

  //Adds to each entry an integer value n
  void add(int n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) + n;
      }
    }
  }

  //Adds to each entry a float value n
  void add(float n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) + n;
      }
    }
  }

  //Adds to each entry a double value n
  void add(double n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) + (float) n;
      }
    }
  }

  //Subtracts to each entry an integer value n
  void sub(int n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) - n;
      }
    }
  }

  //Subtracts to each entry a float value n
  void sub(float n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) - n;
      }
    }
  }

  //Subtracts to each entry a double value n
  void sub(double n){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = getValue(i, j) - (float) n;
      }
    }
  }

  //Multiplies a specific entry with an integer n
  void mul(int x, int y, int n) {
    setValue(x, y, getValue(x, y) * n);
  }

  //Multiplies a specific entry with an float n
  void mul(int x, int y, float n) {
    setValue(x, y, getValue(x, y) * n);
  }

  //Multiplies a specific entry with an double n
  void mul(int x, int y, double n) {
    setValue(x, y, getValue(x, y) * (float) n);
  }

  //Adds to a specific entry an integer value n
  void add(int x, int y, int n){
    setValue(x, y, getValue(x, y) + n);
  }

  //Adds to a specific entry a float value n
  void add(int x, int y, float n){
    setValue(x, y, getValue(x, y) + n);
  }

  //Adds to a specific entry a double value n
  void add(int x, int y, double n){
    setValue(x, y, getValue(x, y) + (float) n);
  }

  //Subtracts a specific entry with an integer value n
  void sub(int x, int y, int n){
    setValue(x, y, getValue(x, y) - n);
  }

  //Subtracts a specific entry with a float value n
  void sub(int x, int y, float n){
    setValue(x, y, getValue(x, y) - n);
  }

  //Subtracts a specific entry with a double value n
  void sub(int x, int y, double n){
    setValue(x, y, getValue(x, y) - (float) n);
  }

}
