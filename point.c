#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "point.h"

struct Point* point_init(int x, int y){
    struct Point* p = malloc(sizeof(struct Point));
    p->x = x;
    p->y = y;
    return p;
}
int getX(struct Point* p) {
    return p->x;
}
int getY(struct Point* p) {
    return p->y;
}
char* toString(struct Point* p) {
    char* str = malloc(sizeof(char)*7);
    sprintf(str, "(%i, %i)", getX(p), getY(p));
    return str;
}
float point_distance(struct Point* p1, struct Point* p2) {
    int dx = getX(p1)-getX(p2);
    int dy = getY(p1)-getY(p2);
    return (float) sqrt(dx*dx + dy*dy);
}

int equals(struct Point* s, struct Point* e) {
    return ((s->x == e->x) && (s->y == e->y)) ? 0:1;
}
