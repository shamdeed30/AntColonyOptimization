/** Implementation of a depth first search
 */
public class DPath implements Path {
    private Map m;

    public DPath(Map m) {
        this.m = m;
    }

    public boolean pathExists(Point s, Point e) {
        m.clearMarks();
        return recPathExists(s, e);
    }
    private boolean recPathExists(Point s, Point e) {
        // Can't move here (impassable or already visited)
        if(!m.passible(s) || m.hasMark(s)) {
            return false;
        }
        // Note that we are visiting this location
        m.mark(s, '*');
        // Return true if we reached the end
        if(s.equals(e)) {
            return true;
        }
        // Try all the neighboring locations
        Point u = new Point(s.x, s.y-1);
        Point d = new Point(s.x, s.y+1);
        Point r = new Point(s.x+1, s.y);
        Point l = new Point(s.x-1, s.y);
        if(recPathExists(u, e)) {
            return true;
        }
        if(recPathExists(d, e)) {
            return true;
        }
        if(recPathExists(l, e)) {
            return true;
        }
        if(recPathExists(r, e)) {
            return true;
        }
        // Can't reach the end from any neighbors...
        return false;
    }
}
