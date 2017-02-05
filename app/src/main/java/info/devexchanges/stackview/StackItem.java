package info.devexchanges.stackview;

public class StackItem {

    private int drawableId;
    private String imageName;

    public StackItem(int id, String imageName) {
        this.imageName = imageName;
        this.drawableId = id;
    }

    public String getImageName() {
        return imageName;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
