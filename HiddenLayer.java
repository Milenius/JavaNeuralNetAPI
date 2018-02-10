class HiddenLayer extends NeuronLayer{
  HiddenLayer(int argSize){
    size = argSize;
    neurons = new Matrix(size, 1);
  }
}
