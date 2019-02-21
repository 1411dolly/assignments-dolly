class PointOne
{
    private Integer x;
    private Integer y;

    public PointOne(PointOne point){
        this.x = point.x;
        this.y = point.y;
    }
    public PointOne(int x,int y)
    {this.x=x;this.y=y;}
}
 class PointTwo extends PointOne
{
    private Integer z;

    public PointTwo(PointOne point,int z){
        super(point);
        this.z=z;
    }
}
public class Q5CopyConstructor {
    public static void main(String[] args) {
        PointOne one = new PointOne(1,2);
        PointTwo two = new PointTwo(one,3);

        PointOne clone1 = new PointOne(one);
        PointOne clone2 = new PointOne(two);

        //Let check for class types
        System.out.println(clone1.getClass());
        System.out.println(clone2.getClass());
    }
}
