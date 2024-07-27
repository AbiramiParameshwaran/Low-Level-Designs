package Prototype;

public class Notebook implements Prototype<Notebook>{

    private int height;
    private int width;
    private int noOfPages;

    private String type;
    private String frontpage;
    private String backpage;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public String getType() {
        return type;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFrontpage(String frontpage) {
        this.frontpage = frontpage;
    }

    public void setBackpage(String backpage) {
        this.backpage = backpage;
    }

    public String getFrontpage() {
        return frontpage;
    }

    public String getBackpage() {
        return backpage;
    }

    Notebook() {}

    public Notebook(Notebook notebook) {
        this.height = notebook.height;
        this.width = notebook.width;
        this.noOfPages = notebook.noOfPages;
        this.type = notebook.type;
        this.frontpage = notebook.frontpage;
        this.backpage = notebook.backpage;
    }

    @Override
    public Notebook clone() {
        return new Notebook(this);
    }

    @Override
    public String toString() {
        return "Notebook: height="+height+" width="+width+" noOfPages="+noOfPages+" type="+type+" frontpage="+frontpage+" backpage="+backpage;
    }
}
