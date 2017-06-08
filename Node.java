import java.util.ArrayList;

public class Node {
	
	private int identifier;
	private int longitude;	
	private int latitude;
	private int distance;
	private Node path;//The previous node to this one
	private ArrayList<Edge> edgeList;//The list of edges connected to the Node
	
	public Node() {
		this.identifier = 0;
		this.longitude = 0;
		this.latitude = 0;
		this.distance = Integer.MAX_VALUE;
		this.path = null;
		this.edgeList = new ArrayList();
	}
	
	public Node(int identifier, int x, int y) {
		this.identifier = identifier;
		this.longitude = x;
		this.latitude = y;
		this.distance = Integer.MAX_VALUE;
		this.path = null;
		this.edgeList = new ArrayList();
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Node getPath() {
		return path;
	}

	public void setPath(Node path) {
		this.path = path;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	
	public int getLongitude() {
		return longitude;
	}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public int getLatitude() {
		return latitude;
	}
	
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}
	
	public void setEdgeList(ArrayList<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	

}
