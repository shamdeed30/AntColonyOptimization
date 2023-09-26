
public class Point {
    public final int x;
    public final int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Function to compute the distance between two points
     */
    public float distance(Point o) {
        int dx = this.x-o.x;
        int dy = this.y-o.y;
        return (float)Math.sqrt(dx*dx + dy*dy);
    }

    /** Function to compare two points */
    public boolean equals(Object o) {
        try { // C isn't really typed, so there is no way to implement this
              // try-catch in C
            Point p = (Point)o;
            return this.x==p.x && this.y==p.y;
        } catch(ClassCastException e) {
            return false;
        }
    }
            
}
