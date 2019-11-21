package section_09_inner_abstractclasses_interfaces.abstractclasses.challenge;

public interface NodeList {

    ListItem getRoot();

    boolean addItem(ListItem newItem);

    boolean removeItem(ListItem item);

    void traverse(ListItem root);

}
