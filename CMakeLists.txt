cmake_minimum_required(VERSION 3.0)

# Create the project and tell cmake that this is a C only project...
#   by default cmake will want to have both a C and C++ compiler but
#   a C++ compiler isn't currently installed on b8cp275
project(path_poc, C)

# Tell cmake which source files are needed for each of the binaries to build
add_executable(dfs_demo demo.c dpath.c map.c point.c)
add_executable(search_demo demo.c dpath.c map.c point.c)

# point.c will probably need sqrt, which means we need to tell cmake
# to include the math library (-lm) when creating the binary
target_link_libraries(dfs_demo m)
target_link_libraries(search_demo m)
