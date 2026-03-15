import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        long x,y;
        Point(long x,long y){
            this.x=x;
            this.y=y;
        }

        public int compareTo(Point o){
            if(this.x==o.x) return Long.compare(this.y,o.y);
            return Long.compare(this.x,o.x);
        }
    }

    static long ccw(Point a, Point b, Point c){
        long val = (a.x*b.y + b.x*c.y + c.x*a.y)
                - (a.y*b.x + b.y*c.x + c.y*a.x);

        if(val>0) return 1;
        if(val<0) return -1;
        return 0;
    }

    static boolean intersect(Point a, Point b, Point c, Point d){

        long ab_c = ccw(a,b,c);
        long ab_d = ccw(a,b,d);
        long cd_a = ccw(c,d,a);
        long cd_b = ccw(c,d,b);

        if(ab_c*ab_d==0 && cd_a*cd_b==0){
            if(a.compareTo(b)>0){
                Point t=a; a=b; b=t;
            }
            if(c.compareTo(d)>0){
                Point t=c; c=d; d=t;
            }
            return a.compareTo(d)<=0 && c.compareTo(b)<=0;
        }

        return ab_c*ab_d<=0 && cd_a*cd_b<=0;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point a = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point b = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point c = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point d = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(intersect(a,b,c,d) ? 1 : 0);
    }
}