public class Rectangle implements Drawable, Countable{
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle ");
    }

    @Override
    public void printInfo() {
        System.out.println("Rectangle info");
    }
}
