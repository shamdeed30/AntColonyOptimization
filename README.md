## Comparison of 3 three variants with varied number ants ant and number of cities:
Test done in the ACO_comparison.ipynb file. Refer to that for all the plots
* Set high and low number of ant; low = 5, high = 50
* Set high anf low number of city; low = 20, high = 80

# Rank-Based Ant System (ASrank)
In the Rank-based Ant System, all solutions generated by the ants are ranked according to a chosen criterion. Typically, the ranking is based on the quality of the solution, such as its length or cost. In some cases, where all paths have the same length, other factors can be considered, such as the number of constraints violated.

# Elitist Ant System
This system optimize the basic algorithm by strengthen current solution each iteration. In each iteration, the best solution will generate some pheromone whether there is an ant across.

# Max-Min Ant System (MMAS)
In the Max-Min system, there is a lower and upper limit (i.e lower=0.2, upper=2) of pheromone deposit in each path. This ensures that the algorithm doesn’t stagnate to a suboptimal solution. For each iteration, the algorithm limits the pheromone deposit in this ranges while updating the pheromone matrix. This gives the ant swarm more chances for exploration, hence, increasing the possibility of finding the best path.

![20230916_082706](https://github.com/shamdeed30/AntColonyOptimization/assets/117672677/4cebfee4-91ef-4939-beaf-3e367dbd904b)



# Files Expected

    .
    ├──README.md    - This file containing documentation for the assignment
    ├──CMakeLists.txt - This describes the project for the build system
    ├──Point.java   - This file contains an implementation of a 2D integer point
    ├──Map.java     - This file contains an implementation of a map
    ├──PriorityQueue.java - Simple priority queue implementation
    ├──WeightedPoint.java - Tuple needed for data in the queue
    ├──APath.java   - This file contains logic for an A* search
    ├──DPath.java   - This file contains logic for a depth first search
    ├──ADemo.java   - This file contains a program for checking with A* Search
    ├──DDemo.java   - This file contains a program for checking with DFS
    ├──map1.txt     - a sample map file
    ├──map2.txt     - a sample map file
    ├──map3.txt     - a sample map file
    ├──point.h      - This is the header for the point implementation
    ├──point.c      - This file contains a C implementation of a 2D integer ponit
    ├──map.h        - This is the header for the map implementation
    ├──map.c        - This file contains a C implementation of a map
    ├──path.h       - This is the header for the path finding. The same path.h is used by both apath.c and dpath.c
    ├──apath.c      - This contains the logic for A* search
    ├──dpath.c      - This contains the logic for depth first search
    ├──demo.c       - This file contains the logic for the main of both programs; A* vs DFS is handled via linking apath.c or dpath.c at compile time
    └──...          - You may have other files (e.g. priority_queue.c)... Or you might not of you place this logic in one of the other C files.
