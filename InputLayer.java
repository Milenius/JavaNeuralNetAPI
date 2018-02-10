class InputLayer extends NeuronLayer{
  InputLayer(int argSize){
    size = argSize;
    neurons = new Matrix(size, 1);
  }
}
