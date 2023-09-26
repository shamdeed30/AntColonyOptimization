This is the last assignment where you will port JAVA code. The program involves
porting multiple JAVA objects to C. 

Where there will be multiple C files that need to be linked together, this 
project is complex enough to start using a build system. ...I kind of hate 
CMake but it seems like CMake is overtaking autotools in adoption. The build
system is also required since I don't know all the files you'll be making and
therefore can't know what the command to compile from the command line would
be.


# Compilation
The following commands will be run to compile your software:
```
mkdir build
cd build
cmake ..
cmake --build .
```

The build script should produce two executable binaries:
    - dfs_demo    -> executable using depth first search
    - search_demo -> executable using A* search

# Implementation Notes
The provided JAVA codebase implements both A* search and Depth First Search 
(DFS) algorithms. You only need to implement one of the algorithms for full 
credit, but it is suggested that you try implementing both if you can 
find the time. DFS is a little less code since the activation records take care 
of the bookkeeping. In A* Search, a priority queue (aka min-heap) is required to
keep track of which location to check next.

An initial CMakeLists.txt has been provided and demo.c has been stubbed out.

There's no need to reimplement point and map abstractions completely from scratch... you should be able to reuse much of the code from the previous assignment for these.

# Test script
The test script for this assignment is `test_path` and it works just like the test scripts for the previous assignments.

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
