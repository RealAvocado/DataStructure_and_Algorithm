package DataStructure.Exercise;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        if(width<=0||height<=0){
            throw new IllegalArgumentException("width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return "Rectangle(" +
                "width = " + width +
                ", height = " + height +
                ')';
    }

    public int calculateArea(){
        return width*height;
    }
    public int calculatePerimeter(){
        return 2*(width+height);
    }
    public Rectangle resize(double ratio){
        Rectangle rectangle=new Rectangle((int)Math.round(width*ratio),(int)Math.round(height*ratio));
        return rectangle;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(12,8);
        System.out.println(r.toString());
        System.out.println("area = " + r.calculateArea());
        System.out.println("perimeter = " + r.calculatePerimeter());
        r = r.resize(1.4);
        System.out.println(r.toString());
    }

}

