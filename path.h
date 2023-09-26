#ifndef PATH_POC_PATH_H
#define PATH_POC_PATH_H
#include "map.h"
#include "point.h"

struct Path{
    struct Map *map;
};

struct Path* path_init(struct Map* map);
int pathExists(struct Path* path, struct Point* s, struct Point* e);
int recPathExists(struct Path* path, struct Point* s, struct Point* e);
void free_path(struct Path* path);

#endif
