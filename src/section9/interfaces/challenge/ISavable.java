package section9.interfaces.challenge;

import java.util.List;

public interface ISavable {

    List<String> write();

    void read(List<String> savedValues);

}
