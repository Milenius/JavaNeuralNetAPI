class NeuronLayer{
  int size;
  Matrix neurons;

  static Matrix sigmoid(Matrix input){
    input.mul(-1);
    input.exp();
    input.add(1);
    input.pow(-1);
    return input;
  }
}
