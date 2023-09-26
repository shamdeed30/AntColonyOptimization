#include "path.h"
#include "map.h"
#include "point.h"
#include <stdio.h>
#include <stdlib.h>

struct Path* path_init(struct Map* map){
    struct Path* path = malloc(sizeof(struct Path));
    path->map = map;
    return path;
}
int recPathExists(struct Path* path, struct Point* s, struct Point* e){
    if ((passable(path->map, s) == 0) || (hasMark(path->map, s) == 1)){
        return 1;
    }
    mark(path->map, s, '0');
    if(equals(s, e) == 0) {
        return 0;
    }
    struct Point* u = point_init(s->x, s->y-1);
    struct Point* d = point_init(s->x, s->y+1);
    struct Point* r = point_init(s->x+1, s->y);
    struct Point* l = point_init(s->x-1, s->y);
    int result = recPathExists(path, u, e);
    free(u);
    if(result == 0) {
        return 0;
    }
    
    result = recPathExists(path, d, e);
    free(d);
    if(result == 0) {
        return 0;
    }
    result = recPathExists(path, l, e);
    free(l);
    if(result == 0) {
        return 0;
    }
    result = recPathExists(path, r, e);
    free(r);
    if(result == 0) {
        return 0;
    }
    return 1;
}
int pathExists(struct Path* path, struct Point* s, struct Point* e){
    clearMarks(path->map);
    return recPathExists(path, s, e);
}
void free_path(struct Path* path){
    free_map(path->map);
    free(path);
}
