class Simulation {
  public static void main(String[] args) throws Exception{

    //Currently just testing area
    Matrix trainInput = new Matrix(new float[][]{{0.0f, 0.0f},
                                                 {0.0f, 0.2f},
                                                 {0.5f, 0.0f},
                                                 {1.0f, 1.0f}});

    Matrix trainOutput = new Matrix(new float[][]{{0.0f},
                                                  {1.0f},
                                                  {1.0f},
                                                  {0.0f}});

    NeuralNet net = new NeuralNet(2, new int[]{4}, 1);

    net.randomizeSynapses();
    //net.backprop(trainInput, trainOutput);

    for (int i = 0; i < net.layer.length; i++) {
      //net.layer[i].neurons.print();
    }

    //Matrix.matMul(trainInput, net.syns[0]).print();

  }
}
