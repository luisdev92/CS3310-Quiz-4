import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
	public static void main(String[] args) {
		TopologicalOrdering topoSort = new TopologicalOrdering();
		
		List<Vertex> graph = new ArrayList<>();
		
		graph.add(new Vertex("a"));
		graph.add(new Vertex("b"));
		graph.add(new Vertex("c"));
		graph.add(new Vertex("d"));
		graph.add(new Vertex("e"));
		graph.add(new Vertex("f"));
		
		graph.get(0).addNeighbour(graph.get(3));
		graph.get(1).addNeighbour(graph.get(3));
		
		graph.get(5).addNeighbour(graph.get(1));
		graph.get(5).addNeighbour(graph.get(0));


		graph.get(3).addNeighbour(graph.get(2));
				
		for (int i = 0; i < graph.size(); ++i) {
			if (!graph.get(i).isVisited()) {
				topoSort.dfs(graph.get(i));
			}
		}
		
		Stack<Vertex> stack = topoSort.getStack();
		
		for (int i = 0; i < graph.size(); ++i) {
			Vertex vertex = stack.pop();
			System.out.print(vertex);
		}
		

	}
}
