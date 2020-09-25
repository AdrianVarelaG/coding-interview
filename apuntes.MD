# Tree And Graphs

## Types of Trees

### Binary tree
Is a tree which each node has up to two children. A node is called **leaf** node if it has no children.

### Binary Search Tree
A binary search tree is a binary tree in witch every node fit a specific ordering property: 

> all left descendents <= n < all right descendents

### Complete Binary trees
A complete binary tree is a binary tree in which every level of the tree is fully filled, except for perhaps the last level. To the extend that the last level is filled, it is filled left to right.

### Full binary trees
A full binary tree is a binary tree in which every node has either zero or two children. 

### Perfect Binary Trees
A perfect binary tree is one that is both full and complete

## Binary Tree Traversal
### In-order Traversal
In-order traversal mean to "visit" (often, print) the left branch, then the current node, and finally, the right branch

```java
void inOrderTraversal(TreeNode node) {
    if(node != null) {
        inOrderTraversal(node.left);
        visit(node);
        inOrderTraversal(node.right);
    }
} 
```
### Pre-order Traversal
Pre-order traversal visit the current node before its child nodes.
```java
void preOrderTraversal(TreeNode node) {
    if(node != null) {
        visit(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
} 
```
### Post-order Traversal
Post-order Traversal visit the current node after its child nodes
```java
void postOrderTraversal(TreeNode node) {
    if(node != null) {
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        visit(node);
    }
} 
```
## Binary Heaps

A **min-heap** is a complete binary tree (that is totally filled other than the rightmost elements on the last level) where each node is smaller that its children. The root, therefore, is the minimum element in the tree.

## Tries (Prefix Trees)
A trie is a variant of an n-ary tree in which characters are stored at each node. Each path down the tree may represent a word.

The __*__ node (some times called "null nodes") are often used to indicate complete words.

Many problems involving list of valid words leverage a trie as an optimization. In situations when we search through the tree o related prefixes repeatedly, we might pass around a reference to the current node in the tree. 

## Graphs
A tree is is actually a type of graph, but not all graph are trees.

A graph is simply a collection of nodes with edges between them.
* Graphs can be either directed or undirected.While directed edges are like a one-way street, undirected edges are like a two-way street.
* The graph might consist of multiple isolated subgraphs. If there is a path to every pair of vertices, it is called a "Connected graph".
* The graph can also have cycles (or not). An "acyclic graph" is one without cycles.

## Adjacency list
A simple calss definition for a graph node could look essentially the same as a tree node.

```java
class Graph {
    public Node[] nodes;
}

class Node {
    public String name;
    public Node[] children;
}
```
## Graph Search
The two common ways to search a graph are depth-first-search and breadth-first search.

In *depth-first search (DFS)*, we start at the root (or another arbitrarily selected node) and explore each branch completely before moving on the next branch. That is, we go deep first before we go wide.

In *breadth-first search (BFS)*, we start at the root (or another arbitrarily selected node) and explore each neighbor before going on to any of their children. That is, we go wide before we go deep.

### *Depth-First Search (DFS)*
The pseudocode below implements DFS.
```
void search(Node root) {
    if(root == null) return;
    visit(root);
    root.visited = true;
    for each (Node n in root.adjacent) {
        if (n.visited == false) {
            search(n);
        }
    }
}
```

### *Breadth-First Search (BFS)*
BFS is a bit less intuitive, The main tripping point is the (false) assumption that that BFS is recursive . It's not instead, it uses a queue.
```
void search(Node root) {
    Queue queue = new Queue();
    root.marked = true;

    queue.enqueue(root); //Add to the end of queue

    while(!queue.isEmpty()){
        Node r = queue.dequeue(); //Remove from the front of the queue
        visit(r);
        foreach(Node n in r.adjacent) {
            if(n.marked == false) {
                n.marked = true;
                queue.enqueue(n);
            }
        }
    }
}
```
### Bidirectional search
