public class ADemo {
    public static void main(String[] args) {
        // check that the right number of arguments are given
        if(args.length!=5) {
            System.out.println("Usage: <map> <x1> <y1> <x2> <y2>");
            System.out.println("This program determines if a path exists between points <x1>,<y1> and <x2>,<y2> on map <map>");
            System.exit(1);
        }
        try {
            // check that the arguments parse correctly
            String fname = args[0];
            int x1 = Integer.parseInt(args[1]);
            int y1 = Integer.parseInt(args[2]);
            int x2 = Integer.parseInt(args[3]);
            int y2 = Integer.parseInt(args[4]);

            // Make the points
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            // Make the map instance
            Map m = Map.readMap(fname);
            if(m==null) {
                System.out.println("Map file could not be read!");
                System.exit(1);
            }
            // Compute forward and backward paths
            Path pf = new APath(m);
            if(pf.pathExists(p1,p2)) {
                System.out.println("Forward path detected!");
            } else {
                System.out.println("No forward path detected!");
            }
            m.display();
            if(pf.pathExists(p2,p1)) {
                System.out.println("Backward path detected!");
            } else {
                System.out.println("No backward path detected!");
            }
            m.display();
        } catch(NumberFormatException e) {
            System.out.println("Coordinates are not integer values... Exiting.");
            System.exit(1);
        }
    }
}
