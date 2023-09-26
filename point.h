#ifndef PATH_POC_POINT_H
#define PATH_POC_POINT_H

struct Point{
    int x, y;
};

struct Point* point_init(int x, int y);

int getX(struct Point* p);

int getY(struct Point* p);
char* toString(struct Point* p);

float point_distance(struct Point* p1, struct Point* p2);

int equals(struct Point* s, struct Point* e);

#endif
