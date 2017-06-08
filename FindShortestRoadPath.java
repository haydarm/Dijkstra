import java.io.IOException;

public class FindShortestRoadPath {
	
	//java FindShortestRoadPath inputFile.co inputFile.gr sourceID targetID outputFileName

	public static void main(String[] args) throws IOException {

		CoordReader reader = new CoordReader();
		Graph graph = reader.createGraph(args[0],args[1]);
		Dijkstra dijkstra = new Dijkstra(graph, Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4]);
		dijkstra.shortestPath();

	}

}
