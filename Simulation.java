class Simulation {
  public static void main(String[] args) throws Exception{

    //Currently just testing area
    NeuralNet net = new NeuralNet(3, new int[]{4, 4}, 2);
    net.randomizeSynapses();
  }
}
