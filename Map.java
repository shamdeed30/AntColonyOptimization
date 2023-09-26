import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    char[] data;
    char[] overlay;
    int width;
    int height;

    public Map(int w, int h) {
        width = w;
        height = h;
        data = new char[h*w];
        for(int i=0; i<width*height; i++) {
            data[i] = '#';
        }
        clearMarks();
    }

    public static Map readMap(String filename) {
        File f = new File(filename);
        BufferedReader fin;
        String line;
        try {
            fin = new BufferedReader(new FileReader(f));
            line = fin.readLine();
        } catch (IOException e1) {
            return null;
        }
        String[] parts = line.split("\\s+");
        int w  = Integer.parseInt(parts[0]);
        int h = Integer.parseInt(parts[1]);
        Map m = new Map(w,h);
        for(int i=0; i<h; i++) {
            try {
                line = fin.readLine();
            } catch (IOException e2) {
                return null;
            }
            for(int j=0; j<w; j++) {
                m.set(new Point(j, i), line.charAt(j));
            }
        }
        return m;
    }

    public void mark(Point p, char v) {
        overlay[p.x+p.y*width] = v;
    }
    public boolean hasMark(Point p) {
        return overlay[p.x+p.y*width] != 0;
    }
    public void unmark(Point p) {
        overlay[p.x+p.y*width] = 0;
    }
    public void clearMarks() {
        // JAVA always zeros memory when allocating
        overlay = new char[width*height];
    }
    public void set(Point p, char v) {
        data[p.x+p.y*width] = v;
    }
    public boolean passible(Point p) {
        return data[p.x+p.y*width] != '#';
    }

    public void display() {
        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                if(overlay[x+y*width]==0) {
                    System.out.print(data[x+y*width]);
                } else {
                    System.out.print(overlay[x+y*width]);
                }
            } 
            System.out.println("");
        }
    }
}
