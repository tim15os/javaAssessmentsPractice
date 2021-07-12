package rumit.figure;

public interface Shape {
    void area();
    void perimeter();
}

class Rectangle implements Shape {
    int a;
    int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void area() {
        System.out.println(a*b);
    }

    @Override
    public void perimeter() {
        System.out.println((a+b)*2);
    }
}

class RightTriangle implements Shape{
    int a;
    int b;

    public RightTriangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void area() {
        System.out.println((a*b)/2);
    }

    @Override
    public void perimeter() {
        double c = Math.sqrt((a*a)+(b*b));
        System.out.println(a+b+c);
    }

}

class TestFigure{
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,4);
        RightTriangle rightTriangle = new RightTriangle(5,4);
        System.out.println("=== Rrctangle ===");
        rectangle.area();
        rectangle.perimeter();
        System.out.println("=== RightTriangle ===");
        rightTriangle.area();
        rightTriangle.perimeter();
    }
}