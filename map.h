#ifndef PATH_POC_MAP_H
#define PATH_POC_MAP_H
#include "point.h"

struct Map{
    char* data;
    char* overlay;
    int width, height;
};

void clearMarks(struct Map* map);

struct Map* map_init(int w, int h);

void set(struct Map* map, struct Point* g, char v);

void mark(struct Map* map, struct Point* point, char v);

void unmark(struct Map* map, struct Point* point);

int hasMark(struct Map* map, struct Point* point);

int passable(struct Map* map, struct Point* point);

struct Map* readMap(char* filename);

void display(struct Map* map);

void free_map(struct Map* map);

#endif
