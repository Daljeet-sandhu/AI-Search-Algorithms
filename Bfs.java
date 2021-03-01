//Daljeet Singh
//105165075
//Assignment 1
import java.io.*;
import java.util.*;

class Main {
	private int V;                                          // No. of vertices
	private LinkedList<Integer> adj[];

	Main(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w)                             	// Function to add an edge into the graph
	{
		adj[v].add(w); 
	}
	
	

                 /*BFS*/
				 
		
	void BFS(int s)
	{
		boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s]=true;
		queue.add(s);
		while (queue.size() != 0)
		{
			s = queue.poll();
			System.out.print(s+" ");
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				if (!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}


	public static void main(String args[])                      //Main Function
	{
		Main g = new Main(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);                            //creating an instance
		g.addEdge(3, 3);

		System.out.println();
		System.out.println("Breadth First Traversal:");
		System.out.print("Path: ");
		g.BFS(2);                                                           //calling back functions
	}
}
