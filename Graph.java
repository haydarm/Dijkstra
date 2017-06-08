import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Node> nodeList;
	
	public Graph() {
		nodeList = new ArrayList();
		this.nodeList.add(null);
	}

	public void setNodeList(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

}
