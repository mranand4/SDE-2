# Intro

- Graph is a collection of nodes and edges.
- G = {E, V}
- Nodes are also called vertex, vertices. 
- Edges of are also called connections, relationships.

## Degree of a node

- Degree = number of nodes to which a given node is connected to.
- Incoming degree is number of incoming edges to a given node.
- Outgoing degree is number of outgoing edges froma  given node.

## Types of graph

**1. Finite Graph**

- A graph G=(V,E) is called a finite graph if the number of nodes and edges is limited in number. e.g. Graph connecting all the countries in the world.

**2. Infinite Graph**

- A graph G=(V,E) is called an inifinite graph if there's no limit to the number of nodes and edges which it can have. e.g. Graph connecting all the sites of the world as number of sites is ever growing.

**3. Simple graph**

- A graph G=(V,E) is called a simple graph if there's only one connection between any given pair of nodes. e.g. a network of friends, between two friends there'll be only one connection denoting friendship.

**4. Multi graph**

- A graph G=(V,E) is called a multi graph if there are more than one connections between any given pair of nodes. e.g. graph of roads and cities.

**5. Trivial graph**

- A graph G=(V,E) is a trivial graph if it has just one node and no connections.

**6. Null graph**

- A graph G=(V,E) is called a null graph if it's none of it's nodes are connected to each other.

**7. Pseudo graph**

- A graph G=(V,E) is called a pseduo graph is one or more of it's node has a connection to itself(self-loop).

**8. Regular graph**

- A graph G=(V,E) is called a regular graph is each nodes have same degree.

**9. Weighted graph**

- A graph G=(V,E) is called a labeled/weighted graph if it's edges has some value. This value represents cost of going from node A to node B. e.g. network of cities wherein edges represent nodes and length of the nodes.

- Graph whose edges don't have weight are called unweighted or unlabelled graph.

**10. Directed graph**

- A graph G=(V,E) is called directed graph if it's edges have a direction(to or from) in which traversal can happen.

- Graphs which don't have direction info are called undirected graph.

**11. Complete graph**

- A graph G=(V,E) is called a complete graph if each node is connected to every other node. Degree of node n in complete graph is n - 1.

**12. Connected graph**

- A graph in which one node can be reached from another directly or indirectly.

- Graphs in which one node/component cannot be from one(any one of the ...) othrer nodes either directly or indirectly.

**13. Cyclic graph**

- Graph which has at least one cycle i.e. if we start traversal from a node then there's a path which brings us back to that node.

- Graph without cycles are called acyclic.

**14. Directed acyclic graph**

- DAG: Directed acyclic graph are directed graphs without any cycles.

**15. Sub graph**

- A certain portion of a graph.

## Graph Representation

### 1. Adjacency Matrix

![Adjacency Matrix](../../Images/graph_adj_matrix.png)