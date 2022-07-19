/**
 * BipartateGraph
 * This algorithm check weather a graph is Bipartate or not by coloring all adjacent nodes with different colors.
 * 
 * Input    --> Take a graph in form of Adj. Matrix (ArrayList) 
 * Output    -> Outputs if the graph is bipartate
 */
import java.util.*;
public interface BipartateGraph {
    public static boolean isBipartateGraph(ArrayList<ArrayList<Integer>> graph) {
        // ArrayDeque for implementing BFS
        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        // Check if the nodes are visited or not
        boolean [] visited = new boolean [graph.size()];
        // Storing color for each element 
        boolean [] color = new boolean [graph.size()];
        for(int node = 0 ; node<graph.size() ; node++)
        {
            // Node Visited then go ahead
            if(visited[node]) continue;
            
            // Add the current node to queue
            bfs.add(node);

            // Perform BFS in current node and making color of adjacent node different than current node , Bipartate graph does not need more than two color.
            
            while (!bfs.isEmpty()) {
                int current = bfs.removeFirst();
                for(int adj : graph.get(current))
                {
                    if(!visited[adj])
                    {
                        visited[adj] = true;
                        color[adj] = !color[current];
                        bfs.add(adj);
                    }
                    else if(color[current] == color[adj]) return false;
                }
            }
        }
        return true;
    }
}