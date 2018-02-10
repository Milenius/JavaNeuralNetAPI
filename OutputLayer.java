class OutputLayer extends NeuronLayer{
  OutputLayer(int argSize){
    size = argSize;
    neurons = new Matrix(size, 1);
  }
}
