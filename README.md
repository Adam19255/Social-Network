# Graph and Social Network Java Project
Authored by Adam Shay

This Java project provides a simple implementation of a generic graph structure (`Graph<E>`) and a social network class (`SocialNetwork`) using this graph structure.
The project is designed to handle vertices (nodes) and edges (connections) between them.

## Graph Class
The `Graph<E>` class includes the following methods:

### Constructor:
Graph(): Initializes an empty graph.

### Vertex Management:
* **addVertex(E ver):** Adds a vertex to the graph.
* **addEdge(E ver1, E ver2):** Adds an edge between two vertices.

### Graph Information:
* **getEdges(E ver):** Returns a list of edges for a given vertex.
* **getVertices():** Returns a list of all vertices in the graph.

### Graph Traversal:
* **bfs(E from, E to):** Performs Breadth-First Search to find a path between two vertices.

### Utility Methods:
* **checkIfExist(E ver):** Checks if a vertex exists in the graph.

## SocialNetwork Class
The `SocialNetwork` class utilizes the `Graph<String>` class to represent a social network.
It includes the following methods:

### Constructor:
* **SocialNetwork():** Initializes an empty social network.

### User Management:
* **addUser(String user):** Adds a new user to the social network.
* **addFriends(String user1, String user2):** Establishes a friendship connection between two users.

### User Interaction:
* **knows(String user1, String user2):** Checks if two users know each other in the social network.

#### Exception Handling:
* **VertexExistException:** Thrown when attempting to add a vertex that already exists.
* **VertexNotExistException:** Thrown when attempting operations on a non-existent vertex.
* **UserExistException:** Thrown when attempting to add a user that already exists.
* **UserNotFoundException:** Thrown when attempting operations on a non-existent user.
