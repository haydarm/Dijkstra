import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Dijkstra {
	
	private Graph graph;
	private Node startNode;
	private Node endNode;
	private MyQueue2<Node> nodesToTraverse;
	private String file;
	public Writer writer;
	
	public Dijkstra(Graph graph, int startNode, int endNode, String file) {
		this.graph = graph;
		this.startNode = this.graph.getNodeList().get(startNode);
		this.endNode = this.graph.getNodeList().get(endNode);
		this.nodesToTraverse = new MyQueue2();
		this.file = file;
	}
	
	//Dijkstra's algorithm
	public void shortestPath() throws IOException {
		startNode.setDistance(0);
		
		Node tempNode;//The current node that has been dequeued
		Node futureNode;//Nodes adjacent to tempNode
		int oneJumpDistance;//Distance from tempNode to adjacent nodes
		
		nodesToTraverse.enqueue(startNode);
		
		while (!nodesToTraverse.isEmpty()) {
			tempNode = nodesToTraverse.dequeue();
			
			//For the tempNode's adjacent nodes, if the new path from the
			//startNode is shorter than the current path, queue the adjacent nodes
			//and update their new path distances
			for (int i = 0; i < tempNode.getEdgeList().size(); i++)
			{
				futureNode = tempNode.getEdgeList().get(i).getDestination();
				oneJumpDistance = tempNode.getEdgeList().get(i).getWeight();
				if (tempNode.getDistance() + oneJumpDistance < futureNode.getDistance()) {
					futureNode.setDistance(tempNode.getDistance() + oneJumpDistance);
					futureNode.setPath(tempNode);
					nodesToTraverse.enqueue(futureNode);
				}
			}
		}
		
		writeToFile();
		
	}
	
	//Method writes the path from one node to another in the specified file
	private void writeToFile() throws IOException {
		
		//Write to the specified file and display the source and destination nodes
	    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file), "utf-8"));
	    String path = "From: " + startNode.getIdentifier() + " To: " + endNode.getIdentifier() + " Distance: " + endNode.getDistance();
		Node node = endNode;
		writer.write(path + System.getProperty("line.separator"));
		
		//Write out the path, line by line
		int identifier;
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (node.getIdentifier() != startNode.getIdentifier()) {
			while (node.getPath().getIdentifier() != startNode.getIdentifier()) {
			identifier = node.getIdentifier();
			node = node.getPath();
			list.add(identifier);
			}
		}
		identifier = startNode.getIdentifier();
		list.add(identifier);
		path = null;
		for (int i = list.size()-1; i >=0; i--) {
			path = "" + list.get(i);
			writer.write(path + System.getProperty("line.separator"));
		}
		writer.close();
	    
	}

}
