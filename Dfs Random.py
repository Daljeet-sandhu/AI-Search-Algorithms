# Daljeet Singh
# 105165075
# Assignment 1

import random
random_letter = random.choice('ABCDGS')


print ("Depth First Traversal:")
print("Path:", end =" ")                    #printing result
graph = {
    'S' : [random_letter, random_letter],
    'A' : [random_letter, random_letter],
    'B' : [random_letter, random_letter],                       #declaring an instance
    'C' : [random_letter, random_letter],
    'D' : [random_letter],
    'G' : [random_letter]
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