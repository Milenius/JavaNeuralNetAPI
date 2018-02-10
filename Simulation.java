class Simulation {
  public static void main(String[] args) throws Exception{

    //Currently just testing area
    NeuralNet net = new NeuralNet(3, new int[]{4, 4}, 2);
    Matrix testInput = new Matrix(new float[][]{{1.0f},{1.0f},{1.0f}});

    net.randomizeSynapses();
    net.setGeneralActivationFunc("sigmoid");
    net.feedForward(testInput);

    for (int i = 0; i < net.layer.length; i++) {
      System.out.println("");
      net.layer[i].neurons.print();
      //net.syns[i].print();
    }

    //NeuronLayer.sigmoid(Matrix.matMul(net.syns[0], net.layer[0].getValues())).print();
  }
}
