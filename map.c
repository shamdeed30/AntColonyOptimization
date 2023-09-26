#include "map.h"
#include "point.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void clearMarks(struct Map* map){
	for (int i=0; i<map->height*map->width; i++) {
        map->overlay[i] = '0';
    }
}

struct Map* map_init(int w, int h){
    struct Map* map = malloc(sizeof(struct Map));
    map->width = w;
    map->height = h;
    map->data = malloc(sizeof(char) * h*w);
    for (int i=0; i<h*w; i++) {
        map->data[i] = '#';
    }
    map->overlay = malloc(sizeof(char)*map->width*map->height);
    clearMarks(map);
    return map;
}

void set(struct Map *map, struct Point* point, char v){
    map->data[point->x+point->y*map->width] = v;
}

void mark(struct Map* map, struct Point* point, char v){
    map->overlay[point->x+point->y*map->width] = v;
}

void unmark(struct Map* map, struct Point* point){
    map->overlay[point->x+point->y*map->width] = '0';
}

int hasMark(struct Map* map, struct Point* point){
    return (map->overlay[point->x+point->y*map->width] != '0' ? 0  : 1);
}

int passable(struct Map* map, struct Point* point){
    return (map->data[point->x+point->y*map->width] != '#' ? 0  : 1);
}

struct Map* readMap(char* filename){
    FILE* f = fopen(filename,"r");
    char * line = NULL;
    size_t size = 0;
    ssize_t track;
	
    if (f == NULL) {
        return NULL;
    }

    int height, width;
    track = getline(&line, &size, f);
    const char splitter[2] = " ";
    width = atoi(strtok(line, splitter));
    height = atoi(strtok(NULL, splitter));

    struct Map* map = map_init(width, height);

    int y = 0;
    struct Point* point;
    while ((track = getline(&line, &size, f)) != -1) {
        for(int x=0; x<map->width; x++){
            point = point_init(x, y);
            set(map, point, line[x]);
	    free(point);
        }
        y++;
    }
    if(y!=height){
        return NULL;
    }
    display(map);

    free(line);
    fclose(f);
    return map;
}

void display(struct Map* map){
    printf("----------Reading Map----------\n");
    for(int y=0; y<map->height; y++) {
        for(int x=0; x<map->width; x++) {
            printf("%c", map->data[x+y*map->width]);
        }
        printf("\n");
    }
}

void free_map(struct Map* map){
    free(map->data);
    free(map->overlay);
    free(map);
}
