class NeuralNet{

  NeuronLayer[]  layer;
  SynapseLayer[] syns;

  //Constructor
  NeuralNet(int inputs, int[] hidden, int outputs){
    //Sets amount of layer and synapse-layer
    layer    = new NeuronLayer[1 + hidden.length + 1];
    syns     = new SynapseLayer[layer.length-1];

    //Creates input and output layer
    layer[0]              = new InputLayer(inputs + 1);
    layer[layer.length-1] = new OutputLayer(outputs);

    //Creates all hidden layer
    for (int i = 1; i < layer.length-1; i++){
      layer[i] = new HiddenLayer(hidden[i-1] + 1);
    }

    //Creates synapse layer
    for (int i = 0; i < syns.length; i++){
      syns[i] = new SynapseLayer(layer[i+1], layer[i]);
    }
    syns[syns.length-1] = new SynapseLayer(layer[layer.length-1], layer[layer.length-2], true);

    //Console debugging
    System.out.println("\nNeuralNet created with: ");
    for (int i = 0; i < layer.length; i++ ){
      System.out.println(layer[i].getClass().getName() + " - Size: " + layer[i].size);
    }
    System.out.println("");
  }

  //Randomizes all Synapses (Random Value from -2 to 2)
  void randomizeSynapses(){
    randomizeSynapses(-2, 2);
  }

  //Randomizes all Synapses (Random Value is in a specific range)
  void randomizeSynapses(int minRand, int maxRand){
    for (int i = 0; i < syns.length; i++) {
      syns[i].randomize(minRand, maxRand);
    }
  }

  //Sets the activation function of all (but the input) layer
  void setGeneralActivationFunc(String actFunc) throws Exception{
    for (int i = 1; i < layer.length; i++) {
      layer[i].setActivationFunc(actFunc);
    }
  }

  //Feeds data through the network
  Matrix feedForward(Matrix input) throws Exception{
    layer[0].setValues(input);
    for (int i = 1; i < layer.length; i++) {
      layer[i].setValues(NeuronLayer.sigmoid(Matrix.matMul(syns[i-1], layer[i-1].getValues())));
    }
    return layer[layer.length-1].getValues();
  }

  void backprop(Matrix input, Matrix output) throws Exception{
    float[][] estArr = new float[output.rows][output.cols];
    Matrix estMat = new Matrix(estArr);

    /*float[][] inputArr = 
    for (int i = 0; input.length; i++) {
      est = feedForward();
    }*/
  }
}
