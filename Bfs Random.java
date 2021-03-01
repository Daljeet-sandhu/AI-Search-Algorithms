//Daljeet Singh
//105165075
//Assignment 1
import java.io.*;
import java.util.*;
import java.lang.Math; 

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
	public static int random(){   
	int max = 4; 
    int min = 0;
	int range = (max - min) + 1;     
    return (int)(Math.random() * range) + min;
  }


	public static void main(String args[])                      //Main Function
	{
		Main g = new Main(5);
		
		int a,b;
		
		a=random();
		b=random();
		System.out.println("Matrix:");
		g.addEdge(a, b);
		System.out.println(a + " " + b);
		a=random();
		b=random();
		g.addEdge(a, b);
		System.out.println(a + " " + b);
		a=random();
		b=random();
		g.addEdge(a, b);
		System.out.println(a + " " + b);
		a=random();
		b=random();
		g.addEdge(a, b);
		System.out.println(a + " " + b);
		

		System.out.println();
		System.out.println("Breadth First Traversal:");
		System.out.print("Path: ");
		g.BFS(2);                                                           //calling back functions
	}
}
