## Best Distance over Iteration
![Best Distance Over Iteration](images/best_distance_over_iteration.gif)

## Best Distance over No. of Citites for the three extensions
![Best Distance Over Number of Cities](images/best_distance_over_no_of_cities.png)

## Comparison of 3 three variants with varied number ants ant and number of cities:
Test done in the ACO_comparison.ipynb file. Refer to that for all the plots
* Set high and low number of ant; low = 5, high = 50
* Set high anf low number of city; low = 20, high = 80

We then compare for the following 4 cases:
* low ant, low city
![Low Ant vs Low City](images/lowAnt_lowCity.png)
* low ant, high city
![Low Ant vs High City](images/lowAnt_highCity.png)
* high ant, low city
![High Ant vs Low City](images/highAnt_lowCity.png)
* high ant, high city
![High Ant vs High City](images/highAnt_highCity.png)

Comparison basis:
Each algorithm gives us the best distance for the best path. So, we ran ran each algorithm 100 times for each of the 4 cases and plotted the distances to understand the emerging patterns.


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
