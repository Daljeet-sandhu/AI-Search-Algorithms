//Daljeet Singh
//105165075
//Assignment 1

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main{
	
	public static int random(){   
	int max = 200; 
    int min = 50;
	int range = (max - min) + 1;     
    return (int)(Math.random() * range) + min;
  }
	
	
	public static void main(String[] args){                   //main function

		//initialize the graph base on the Romania map
		Node n1 = new Node("Arad");
		Node n2 = new Node("Zerind");
		Node n3 = new Node("Oradea");
		Node n4 = new Node("Sibiu");
		Node n5 = new Node("Fagaras");
		Node n6 = new Node("Rimnicu Vilcea");
		Node n7 = new Node("Pitesti");
		Node n8 = new Node("Timisoara");                                //creating an instance
		Node n9 = new Node("Lugoj");
		Node n10 = new Node("Mehadia");
		Node n11 = new Node("Drobeta");
		Node n12 = new Node("Craiova");
		Node n13 = new Node("Bucharest");
		Node n14 = new Node("Giurgiu");
 
		//initialize the edges

		//Arad
		n1.adjacencies = new Edge[]{
			new Edge(n2,random()),
			new Edge(n4,random()),
			new Edge(n8,random())
		};
 		
 		//Zerind
		n2.adjacencies = new Edge[]{
			new Edge(n1,random()),
			new Edge(n3,random())
		};
 		

 		//Oradea
		n3.adjacencies = new Edge[]{
			new Edge(n2,random()),
			new Edge(n4,random())
		};
 		
 		//Sibiu
		n4.adjacencies = new Edge[]{
			new Edge(n1,random()),
			new Edge(n5,random()),
			new Edge(n3,random()),
			new Edge(n6,random()),
		};
 		

 		//Fagaras
		n5.adjacencies = new Edge[]{
			new Edge(n4,random()),

			//178
			new Edge(n13,random())
		};
 		
 		//Rimnicu Vilcea
		n6.adjacencies = new Edge[]{
			new Edge(n4,random()),
			new Edge(n7,random()),
			new Edge(n12,random())
		};
 		
 		//Pitesti
		n7.adjacencies = new Edge[]{
			new Edge(n6,random()),
			new Edge(n13,random()),
			new Edge(n12,random())
		};
 		
 		//Timisoara
		n8.adjacencies = new Edge[]{
			new Edge(n1,random()),
			new Edge(n9,random())
		};
 		
 		//Lugoj
		n9.adjacencies = new Edge[]{
			new Edge(n8,random()),
			new Edge(n10,random())
		};

 		//Mehadia
		n10.adjacencies = new Edge[]{
			new Edge(n9,random()),
			new Edge(n11,random())
		};
 		
 		//Drobeta
		n11.adjacencies = new Edge[]{
			new Edge(n10,random()),
			new Edge(n12,random())
		};

 		//Craiova
		n12.adjacencies = new Edge[]{
			new Edge(n11,random()),
			new Edge(n6,random()),
			new Edge(n7,random())
		};

		//Bucharest
		n13.adjacencies = new Edge[]{
			new Edge(n7,random()),
			new Edge(n14,random()),
			new Edge(n5,random())
		};
 		
 		//Giurgiu
		n14.adjacencies = new Edge[]{
			new Edge(n13,random())
		};

		UniformCostSearch(n1,n13);

		List<Node> path = printPath(n13);
        System.out.println("Uniform Cost Search:");
		System.out.println("Path: " + path);

	}

	public static void UniformCostSearch(Node source, Node goal){                 //main algo
		
		source.pathCost = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
			new Comparator<Node>(){
				public int compare(Node i, Node j){
					if(i.pathCost > j.pathCost){
						return 1;
					}

					else if (i.pathCost < j.pathCost){
						return -1;
					}

					else{
						return 0;
					}
				}
			}

		);
		
		queue.add(source);
		Set<Node> explored = new HashSet<Node>();
		boolean found = false;
		do{

			Node current = queue.poll();
			explored.add(current);
			if(current.value.equals(goal.value)){
				found = true;				
			}

			for(Edge e: current.adjacencies){
				Node child = e.target;
				double cost = e.cost;
				if(!explored.contains(child) && !queue.contains(child)){
					child.pathCost = current.pathCost + cost;
					child.parent = current;
					queue.add(child);}
				else if((queue.contains(child))&&(child.pathCost>(current.pathCost+cost))){
					child.parent=current;
					child.pathCost = current.pathCost + cost;
					queue.remove(child);
					queue.add(child);}
            }	
		}while(!queue.isEmpty()&& (found==false));

	}

	public static List<Node> printPath(Node target){                      //to print
		List<Node> path = new ArrayList<Node>();
		for(Node node = target; node!=null; node = node.parent){
			path.add(node);
		}
		Collections.reverse(path);
		return path;

	}

}

class Node{                                            //Node class

	public final String value;
	public double pathCost;
	public Edge[] adjacencies;
	public Node parent;

	public Node(String val){

		value = val;
		
	}

	public String toString(){
		return value;
	}

}

class Edge{                                              //edge class
	public final double cost;
	public final Node target;

	public Edge(Node targetNode, double costVal){
		cost = costVal;
		target = targetNode;

	}
}