package section_09_inner_abstractclasses_interfaces.interfaces.challenge;

import java.util.List;

public interface ISavable {

    List<String> write();

    void read(List<String> savedValues);

}
