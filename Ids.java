//Daljeet Singh
//105165075
//Assignment 1
import java.util.*;

public class Main 
{
	static class Graph
	{
		int V;                                            //Number of Vertices
		LinkedList<Integer>[] adj;                      // adjacency lists
        Graph(int V)
		{
			this.V = V;
			adj = new LinkedList[V];
			
			for (int i = 0; i < adj.length; i++)
				adj[i] = new LinkedList<Integer>();
			
		}
		
		void addEdge(int v, int w)                         //to add edges
		{
			adj[v].add(w); 
		}
		


                 /*IDS*/
				 
		
		void IDSUtil(int s, Vector<Boolean> visited)                               //utility function
		{ 
			Stack<Integer> stack = new Stack<>();
			stack.push(s);
			while(stack.empty() == false)
			{
				s = stack.peek();
				stack.pop();
				if(visited.get(s) == false)
				{
					System.out.print(s + " ");
					visited.set(s, true);
				}
				Iterator<Integer> itr = adj[s].iterator();
				
				while (itr.hasNext())                                                        //while loop
				{
					int v = itr.next();
					if(!visited.get(v))
						stack.push(v);
				}
				
			}
		}
		void IDS()                            //main algo
		{
			Vector<Boolean> visited = new Vector<Boolean>(V);
			for (int i = 0; i < V; i++)
				visited.add(false);
	
			for (int i = 0; i < V; i++)
				if (!visited.get(i))
					IDSUtil(i, visited);
		} 
	}

	public static void main(String[] args)                          //main function
	{
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 4);                            //creating an instance
		g.addEdge(4, 0);
		
		System.out.println("Iterative Depth First Traversal:");
		System.out.print("Path: ");
		g.IDS();                                                         //calling back functions
	}
}
