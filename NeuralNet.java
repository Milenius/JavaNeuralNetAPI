class NeuralNet{
  /*
  Matrix[] synapseLayer;

  NeuralNet(int inputs, int[] hidden, int outputs){

    synapseLayer = new Matrix[hidden.length+1];

    for (int i = 0; i < synapseLayer.length; i++){
      if (i == 0) {
        synapseLayer[0] = new Matrix(hidden[0], inputs);
        synapseLayer[0].randomize();
      } else if (i != synapseLayer.length-1) {
        synapseLayer[i] = new Matrix(hidden[i], hidden[i-1]);
        synapseLayer[i].randomize();
      } else {
        synapseLayer[synapseLayer.length-1] = new Matrix(outputs, hidden[i-1]);
        synapseLayer[synapseLayer.length-1].randomize();
      }
    }
  }

  Matrix feedForward(Matrix inputs) throws Exception{
    Matrix tempResult = new Matrix(1,1);

    tempResult = Matrix.matMul(synapseLayer[0], inputs);
    tempResult = Matrix.matMul(synapseLayer[1], tempResult);
    return tempResult;
  }
  */

  NeuronLayer[]  layer;
  SynapseLayer[] syns;

  //Constructor
  NeuralNet(int inputs, int[] hidden, int outputs){
    //Sets amount of layer and synapse-layer
    layer    = new NeuronLayer[1 + hidden.length + 1];
    syns     = new SynapseLayer[layer.length-1];

    //Creates input and output layer
    layer[0]              = new InputLayer(inputs);
    layer[layer.length-1] = new OutputLayer(outputs);

    //Creates all hidden layer
    for (int i = 1; i < layer.length-1; i++){
      layer[i] = new HiddenLayer(hidden[i-1]);
    }

    //Creates synapse layer
    for (int i = 0; i < syns.length; i++){
      syns[i] = new SynapseLayer(layer[i], layer[i+1]);
    }

    //Console debugging
    System.out.println("\nNeuralNet created with: ");
    for (int i = 0; i < layer.length; i++ ){
      System.out.println(layer[i].getClass().getName() + " - Size: " + layer[i].size);
    }
    System.out.println("");
  }

  void randomizeSynapses(){
    randomizeSynapses(-2, 2);
  }

  void randomizeSynapses(int minRand, int maxRand){
    for (int i = 0; i < syns.length; i++) {
        syns[i].randomize(minRand, maxRand);
        syns[i].print();
    }
  }


}
