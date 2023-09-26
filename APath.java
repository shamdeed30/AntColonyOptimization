/** Implementation of an A* search
 *  <p>Like depth first search, A* search is guaranteed to find a path, if one 
 *  exists. Depth first search is easier to implement (no need for a priority
 *  queue) but A* search with a good hueristic tends to find a path faster.
 */
public class APath implements Path {
    private Map m;
    private PriorityQueue pq;

    public APath(Map m) {
        this.m = m;
    }

    public boolean pathExists(Point s, Point e) {
        pq = new PriorityQueue();
        m.clearMarks();
        if(!m.passible(s)) {
            return false;
        }
        pq.queue(new WeightedPoint(s.distance(e), s));
        // While there are locations left to check
        while(pq.size()>0) {
            // Get the next location to check
            s = pq.dequeue();
            // Check if we've been here before or the square is not passible
            if(m.hasMark(s) || !m.passible(s)) {
                continue;
            }
            m.mark(s, '*');
            // Check if we've reached the target
            if(s.x==e.x && s.y==e.y) {
                return true;
            }
            // Queue the neighboring locations
            Point u = new Point(s.x, s.y-1);
            Point d = new Point(s.x, s.y+1);
            Point r = new Point(s.x+1, s.y);
            Point l = new Point(s.x-1, s.y);
            pq.queue(new WeightedPoint(u.distance(e), u));
            pq.queue(new WeightedPoint(d.distance(e), d));
            pq.queue(new WeightedPoint(l.distance(e), l));
            pq.queue(new WeightedPoint(r.distance(e), r));
        }
        return false;
    }
}
