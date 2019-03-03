interface Polygon
{
    void colorPolygon();
}
class Rectangle implements Polygon
{
    @Override
    public void colorPolygon() {
        System.out.println("color Rectangle");
    }
}
class Circle implements Polygon
{
    @Override
    public void colorPolygon() {
        System.out.println("color Circle");
    }
}
class Shape
{
    Polygon polygon;

    public Polygon getPolygon()
    {return polygon;}

    public void setPolygon(Polygon polygon)
    {
        this.polygon=polygon;
    }
}
class ShapeFactory
{
    public static Shape getShapefactory(String name)
    {
        Shape shape=new Shape();
        switch (name)
        {
            case "Rectangle": shape.setPolygon(new Rectangle());break;
            case "Circle": shape.setPolygon(new Circle());break;
        }
        return shape;
    }
}
public class Q2FactoryPolygonPattern {
    public static void main(String[] args) {
        Shape rectangle=ShapeFactory.getShapefactory("Rectangle");
        rectangle.getPolygon().colorPolygon();
        Shape circle=ShapeFactory.getShapefactory("Circle");
        circle.getPolygon().colorPolygon();

    }
}
