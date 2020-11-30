package exercise9;

public class Ellipse {
    private Point startPoint;
    private double a;
    private double b;

    public Ellipse() {
        startPoint = new Point(0, 0);
        a = 1;
        b = 1;
    }

    public Ellipse(Point startPoint, double a, double b) {
        this.startPoint = new Point(startPoint);
        this.a = a;
        this.b = b;
    }

    public Ellipse(Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        this.a = otherEllipse.a;
        this.b = otherEllipse.b;
    }

    public boolean isValid() {
        return a > 0 && b > 0;
    }

     public void initialize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter a: ");
            this.a = Utils.INPUT.nextDouble();
            System.out.print("Enter b: ");
            this.b = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI*(3*(a+b)-Math.sqrt((3*a+b)*(a+3*b)));
    }

    public double calculateArea() {
        return a * b * Math.PI;
    }

    public String getType() {
        return (Utils.equals(a,b)) ? "Circle" : "Ellipse";
    }

    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, a, b, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equal(Ellipse otherEllipse) {
        boolean sameA = Utils.equals(this.a, otherEllipse.a);
        boolean sameB = Utils.equals(this.b, otherEllipse.b);
        boolean sameAReversed = Utils.equals(this.a, otherEllipse.b);
        boolean sameBReversed = Utils.equals(this.b, otherEllipse.a);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }


}
