
public class Edge {
	
	private Node origin;
	private Node destination;
	private int weight;
	
	public Edge() {
		this.origin = null;
		this.destination = null;
		this.weight = 0;
	}
	
	public Edge(Node origin, Node destination, int weight) {
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
	}

	public Node getOrigin() {
		return origin;
	}

	public void setOrigin(Node origin) {
		this.origin = origin;
	}

	public Node getDestination() {
		return destination;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
