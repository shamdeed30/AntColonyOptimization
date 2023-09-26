#include <stdio.h>
#include <stdlib.h>
#include "path.h"
#include "point.h"
#include "map.h"


int main(int argc, char** argv) {
    if (argc!=6){
        printf("Usage: <map> <x1> <y1> <x2> <y2>\n");
        printf("path: <x1>,<y1> and <x2>,<y2> on map <map>\n");
        return 1;
    }
    char* fname = argv[1];
    char *end;
    int x1 = strtol(argv[2], &end, 10);
    if (end == argv[2] || *end != '\0'){
        printf("wrong input!\n");
        return 1;
    }
    int y1 = strtol(argv[3], &end, 10);
    if (end == argv[3] || *end != '\0'){
        printf("wrong input!\n");
        return 1;
    }
    int x2 = strtol(argv[4], &end, 10);
    if (end == argv[4] || *end != '\0'){
        printf("wrong input!\n");
        return 1;
    }
    int y2 = strtol(argv[5], &end, 10);
    if (end == argv[5] || *end != '\0'){
        printf("wrong input!\n");
        return 1;
    }

    struct Point* p1 = point_init(x1, y1);
    struct Point* p2 = point_init(x2, y2);
    struct Map* m = readMap(fname);
    if (m==NULL){
        printf("Error reading file\n");
        return 1;
    }
    struct Path* pf = path_init(m);
    if((pathExists(pf, p1, p2) == 0)) {
        printf("Found forward path\n");
    } else {
        printf("No forward path detected\n");
    }
    display(m);
    if((pathExists(pf, p2, p1) == 0)) {
        printf("Found backward path\n");
    } else {
        printf("Backward path not detected\n");
    }
    display(m);
    free_path(pf);
    free(p1);
    free(p2);
    return 0;
}
