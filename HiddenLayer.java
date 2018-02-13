class HiddenLayer extends NeuronLayer{
  HiddenLayer(int argSize){
    size = argSize;
    neurons = new Matrix(size, 1);
    neurons.setValue(size-1, 0, 1.0f);
  }
}
