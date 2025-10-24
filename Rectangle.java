public class Rectangle
{
    Point A,B,C,D;
    double width, length;

    public static boolean is_Rectangle(Point A, Point B, Point C, Point D) 
    {
        double center_x = (A.x + B.x + C.x + D.x)/4;
        double center_y = (A.y + B.y + C.y + D.y)/4;
        Point center = new Point(center_x, center_y);

        double distance = center.distance(A);
        return distance == center.distance(B) && 
                distance == center.distance(C) &&
                 distance == center.distance(D);
    }

    public Rectangle(Point A, Point B, Point C, Point D) throws Lab5Exception
    {
        if (!Rectangle.is_Rectangle(A, B, C, D)) throw new Lab5Exception("Given points does not form an rectangle");

        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        int max_distance_index = 0;
        double[] distance_arr = new double[]{A.distance(B), A.distance(C), A.distance(D)};

        for (int i = 0; i < distance_arr.length; i++)
        {
            if (distance_arr[i] > distance_arr[max_distance_index]) max_distance_index = i;
        }
        switch (max_distance_index)
        {
            case 0:
                this.width = distance_arr[1];
                this.length = distance_arr[2];
                break;
            case 1:
                this.width = distance_arr[0];
                this.length = distance_arr[2];
                break;
            case 2:
                this.width = distance_arr[0];
                this.length = distance_arr[2];
                break;
        }        
    }

    public double perimeter()
    {
        return 2*(this.width + this.length);
    }

    public double area()
    {
        return (this.width * this.length);
    }

    public boolean is_square()
    {
        return this.width == this.length;
    }
    
}