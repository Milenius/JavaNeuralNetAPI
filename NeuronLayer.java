abstract class NeuronLayer{
  int size;
  Matrix neurons;
  String activationFunc = "sigmoid";
  String[] availibleFuncs = new String[] {"sigmoid", "tanh"};

  //Sigmoid activation function
  static Matrix sigmoid(Matrix input){
    input.mul(-1);
    input.exp();
    input.add(1);
    input.pow(-1);
    return input;
  }

  //Tanh activation function
  static Matrix tanh(Matrix input){
    input.tanh();
    return input;
  }

  //Checks if the activation function is availible
  boolean checkIfAvailible(String actFunc){
    for (int i = 0; i < availibleFuncs.length; i++) {
      if (availibleFuncs[i] == actFunc){
        return true;
      }
    }
    return false;
  }

  //Sets the activation function of the corresponding layer
  void setActivationFunc(String actFunc) throws Exception{
    if (!checkIfAvailible(actFunc)) throw new neuralNetException("Activation function not found");
    activationFunc = actFunc;
  }

  //Get layer values
  void setValues(Matrix input){
    for (int i = 0; i < input.rows; i++) {
      neurons.setValue(i, 0, input.getValue(i, 0));
    }
  }

  //Get layer values
  Matrix getValues(){
    return neurons;
  }
}
