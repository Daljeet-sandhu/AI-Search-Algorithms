#Daljeet Singh
#105165075
#Assignment 2 Part 1

from collections import deque

class Graph:                                            #graph class

    def __init__(self, adjacency_list):
        self.adjacency_list = adjacency_list

    def get_neighbors(self, v):
        return self.adjacency_list[v]


    def h(self, n):
        H = {
            'S': 1,
            'A': 1,                             # heuristic function with equal values for all nodes
            'B': 1,
            'C': 1,
            'D': 1,
            'E': 1,
            'G': 1
        }

        return H[n]

    def a_star_algorithm(self, start_node, stop_node):                             #main algorithm
        open_list = set([start_node])
        closed_list = set([])

        g = {}

        g[start_node] = 0

        parents = {}
        parents[start_node] = start_node

        while len(open_list) > 0:                                        #while loop
            n = None 

            for v in open_list:
                if n == None or g[v] + self.h(v) < g[n] + self.h(n):
                    n = v;

            if n == None:
                print('Path does not exist!')
                return None                                                     #if path does not exit

            if n == stop_node:
                reconst_path = []

                while parents[n] != n:
                    reconst_path.append(n)
                    n = parents[n]

                reconst_path.append(start_node)

                reconst_path.reverse()

                print('Path found: {}'.format(reconst_path))
                return reconst_path

            for (m, weight) in self.get_neighbors(n):
                if m not in open_list and m not in closed_list:                            #for loop
                    open_list.add(m)
                    parents[m] = n
                    g[m] = g[n] + weight

                else:
                    if g[m] > g[n] + weight:
                        g[m] = g[n] + weight                                          #if else condition
                        parents[m] = n

                        if m in closed_list:
                            closed_list.remove(m)
                            open_list.add(m)

            open_list.remove(n)
            closed_list.add(n)

        print('Path does not exist!')
        return None
        
Graph_a = {
    'S': [('A', 3), ('B', 2)],
    'A': [('B', 1), ('D', 5)],
    'B': [('C', 2), ('D', 3)], 
    'C': [('D', 3), ('G', 4)],                                   #an instance for graph a
    'D': [('G', 1)],
    'G': [('G', 1)]
}

Graph_b = {
    'S': [('A', 6), ('B', 5), ('C', 10)],
    'A': [('D', 6)],
    'B': [('D', 6), ('E', 7)],                               #an instance for graph b
    'C': [('E', 6)],
    'D': [('C', 4), ('G', 4)],
    'E': [('A', 6), ('G', 6)],
    'G': [('G', 1)]
}
print("Graph a:")
graph1 = Graph(Graph_a)
graph1.a_star_algorithm('S', 'G')                               #printing result for graph a

print("Graph b:")
graph1 = Graph(Graph_b)                              #printing result for graph b
graph1.a_star_algorithm('S', 'G')
