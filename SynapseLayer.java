class SynapseLayer extends Matrix{

  SynapseLayer(NeuronLayer outLayer, NeuronLayer inLayer){
    super(outLayer.size-1, inLayer.size);
    print();
  }

  SynapseLayer(NeuronLayer outLayer, NeuronLayer inLayer, boolean outLayerOutput){
    super(outLayer.size, inLayer.size);
    print();
  }
}
