class Simulation {
  public static void main(String[] args) throws Exception{

    //Currently just testing area
    NeuralNet net = new NeuralNet(3, new int[]{8, 7}, 4);
    Matrix trainInput = new Matrix(new float[][]{{0.0f, 0.0f},
                                                 {0.0f, 1.0f},
                                                 {1.0f, 0.0f},
                                                 {1.0f, 1.0f}});

    Matrix trainOutput = new Matrix(new float[][]{{0.0f},
                                                  {1.0f},
                                                  {1.0f},
                                                  {0.0f}});

    net.randomizeSynapses();
    net.feedForward(trainInput);

    for (int i = 0; i < net.layer.length; i++) {
      net.layer[i].neurons.print();
    }

  }
}
