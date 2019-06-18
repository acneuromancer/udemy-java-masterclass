package section9.abstractclasses.challenge;

public interface NodeList {

    ListItem getRoot();

    boolean addItem(ListItem newItem);

    boolean removeItem(ListItem item);

    void traverse(ListItem root);

}
