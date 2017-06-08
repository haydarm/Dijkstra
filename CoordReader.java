import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoordReader {
	
	private Graph graph = new Graph();
	
	//Takes in a node file and edge file and returns a graph
	public Graph createGraph(String nodeFile, String edgeFile) throws FileNotFoundException
	{
			createNodes(nodeFile);
			assignEdges(edgeFile);
			return this.graph;
	}
	
	//Method that adds nodes to the graph
	public void createNodes(String filename) throws FileNotFoundException
	{
		//Convert filename to type File
		File file = new File(filename);
		
		//Create a file scanner
		Scanner scanner;
		scanner = new Scanner(file);
		
		//Create strings to store file lines and tokens
		String fileLine = null;
		String voidString = null;
		
		//While file scanner has has yet to reach node data in the file, ignore
		//the data in the file (except for first node in file)
		while (scanner.hasNextLine()) {
			fileLine = scanner.nextLine();
			if (fileLine.charAt(0) == 'v') {
				Scanner lineScanner = new Scanner(fileLine);
				voidString = lineScanner.next();
				Node node = new Node(lineScanner.nextInt(), lineScanner.nextInt(), lineScanner.nextInt());
				graph.getNodeList().add(node);
				break;
			}
		}

		//While file has a next line, read in the node data and add it to the graph
		while (scanner.hasNextLine()) {
			fileLine = scanner.nextLine();
			Scanner lineScanner = new Scanner(fileLine);
			voidString = lineScanner.next();
			Node node = new Node(lineScanner.nextInt(), lineScanner.nextInt(), lineScanner.nextInt());
			graph.getNodeList().add(node);
		}
		
	}
	
	//Method that assigns edges to each node
	public void assignEdges (String filename) throws FileNotFoundException
	{
		//Convert filename to type File
		File file = new File(filename);
		
		//Create a file scanner
		Scanner scanner = new Scanner(file);
		
		//Create strings to store file lines and tokens
		String fileLine = null;
		String voidString = null;
		
		//While file scanner has has yet to reach edge data in the file, ignore
		//the data in the file (except for first edge in file)
		while (scanner.hasNextLine()) {
			fileLine = scanner.nextLine();
			if (fileLine.charAt(0) == 'a') {
				Scanner lineScanner = new Scanner(fileLine);
				voidString = lineScanner.next();
				Edge edge = new Edge(graph.getNodeList().get(lineScanner.nextInt()), graph.getNodeList().get(lineScanner.nextInt()), lineScanner.nextInt());
				graph.getNodeList().get(edge.getOrigin().getIdentifier()).getEdgeList().add(edge);
				break;
			}
		}
		
		//While file has a next line, read in edge data and assign it to appropriate
		//node. This is essentially a hash. Smart, right?
		while (scanner.hasNextLine()) {
			fileLine = scanner.nextLine();
			Scanner lineScanner = new Scanner(fileLine);
			voidString = lineScanner.next();
			Edge edge = new Edge(graph.getNodeList().get(lineScanner.nextInt()), graph.getNodeList().get(lineScanner.nextInt()), lineScanner.nextInt());
			graph.getNodeList().get(edge.getOrigin().getIdentifier()).getEdgeList().add(edge);
		}
	}

}