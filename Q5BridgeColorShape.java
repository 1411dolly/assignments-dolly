interface Color
{
    void applyColor();
}
abstract class Shapes
{
    Color color;

    public Shapes(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}
class Triangle extends Shapes
{

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle with color::");
        color.applyColor();
    }
}
class Square extends Shapes
{

    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Square with color::");
        color.applyColor();
    }
}
class Blue implements Color
{

    @Override
    public void applyColor() {
        System.out.println("blue.");
    }
}
class Red implements Color
{

    @Override
    public void applyColor() {
        System.out.println("red.");
    }
}
class Pink implements Color
{

    @Override
    public void applyColor() {
        System.out.println("pink.");
    }
}
//BlueSquare, RedSquare, PinkTriangle
public class Q5BridgeColorShape {
    public static void main(String[] args) {
        Shapes blueSquare =new Square(new Blue());
        blueSquare.applyColor();
        Shapes redSquare=new Square(new Red());
        redSquare.applyColor();
        Shapes pinkTriangle=new Triangle(new Pink());
        pinkTriangle.applyColor();
    }
}
