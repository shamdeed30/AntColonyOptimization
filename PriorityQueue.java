/** A priority queue is a tree-based data structure that can efficiently
 *  retreive the highest priority item... how this works internally is pretty
 *  interesting, but a topic for another course.
 *
 *  Provides O(log n) queue and dequeue operations
 */
public class PriorityQueue {
    private WeightedPoint[] points;
    private int size;

    public PriorityQueue() {
        points = new WeightedPoint[8];
        size = 0;
    }
    
    public int size() {
        return size;
    }

    private void swap(int i, int j) {
        WeightedPoint t = points[i];
        points[i] = points[j];
        points[j] = t;
    }

    private void swapUp(int i) {
        if(points[i].weight < points[(i-1)/2].weight) {
            swap(i, (i-1)/2);
            swapUp((i-1)/2);
        }
    }
    private void swapDown(int i) {
        int l = i*2+1;
        int r = i*2+2;
        // this index is a leaf in the tree, done
        if(l>=size) { return; }
        // this index only has a left child and might swap
        if( r>=size && points[i].weight > points[l].weight ) {
            swap(i,l);
            swapDown(l);
        }
        // no need to swap with left child
        if( points[i].weight < points[l].weight ) {
            if(points[i].weight > points[r].weight ) {
                // Need to swap right
                swap(i,r);
                swapDown(r);
            } 
        }
        // might swap left or right
        if( points[l].weight < points[r].weight ) {
            swap(i,l);
            swapDown(l);
        } else {
            swap(i,r);
            swapDown(r);
        }
    }

    public void queue(WeightedPoint wp) {
        // If the queue is out of space, make it bigger
        if(size==points.length) {
            WeightedPoint[] n = new WeightedPoint[size*2];
            for(int i=0; i<size; i++) {
                n[i] = points[i];
            }
            points = n;
        }
        // Actually add data to queue
        points[size] = wp;
        size++;
        swapUp(size-1);
    }
    public Point dequeue() {
        Point p = points[0].point;
        size--;
        swap(0,size);
        swapDown(0);
        return p;
    }
}
