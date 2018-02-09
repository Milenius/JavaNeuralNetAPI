class SynapseLayer extends Matrix{

  SynapseLayer(NeuronLayer inLayer, NeuronLayer outLayer){
    super(inLayer.size, outLayer.size);
    print();
    /*
    rows = outLayer.size;
    cols = inLayer.size;
    Matrix synapseLayer = new Matrix(rows, cols);*/
  }
}
