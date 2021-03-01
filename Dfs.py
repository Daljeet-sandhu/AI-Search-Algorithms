# Daljeet Singh
# 105165075
# Assignment 1


print ("Depth First Traversal:")
print("Path:", end =" ")                    #printing result
graph = {
    'S' : ['A','B'],
    'A' : ['B', 'D'],
    'B' : ['C', 'D'],                       #declaring an instance
    'C' : ['D', 'G'],
    'D' : ['G'],
    'G' : ['G']
}

visited = set()                               # Set to keep track of visited nodes.

def dfs(visited, graph, node):
    if node not in visited:
        print (node, end =" ")                                         #main algo
        visited.add(node)
        for neighbour in graph[node]:
            dfs(visited, graph, neighbour)

# Driver Code
dfs(visited, graph, 'S')