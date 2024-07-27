package Prototype;

public class Client {
    public static void main(String[] args) {
        NotebookRegistry registry = new NotebookRegistry();

        Notebook notebookRuledSmall = new Notebook();
        notebookRuledSmall.setHeight(10);
        notebookRuledSmall.setWidth(10);
        notebookRuledSmall.setType("ruled");
        notebookRuledSmall.setNoOfPages(100);
        registry.registerPrototype("ruledNotebookSmall", notebookRuledSmall);

        Notebook notebookRuledLarge = new Notebook();
        notebookRuledLarge.setHeight(20);
        notebookRuledLarge.setWidth(20);
        notebookRuledLarge.setType("ruled");
        notebookRuledLarge.setNoOfPages(80);
        registry.registerPrototype("notebookRuledLarge", notebookRuledLarge);


        Notebook notebookRuledSmall1 = registry.getPrototype("ruledNotebookSmall").clone();
        notebookRuledSmall1.setFrontpage("Flowers");
        notebookRuledSmall1.setBackpage("one FLower");

        Notebook notebookRuledSmall2 = registry.getPrototype("ruledNotebookSmall").clone();
        notebookRuledSmall2.setFrontpage("Animals");
        notebookRuledSmall2.setBackpage("one Animal");

        System.out.println(notebookRuledSmall1);
    }
}
