package section_09.interfaces.phones;

public interface ITelephone {
    // We create just the signatures (return type, name, parameters), we do not define the actual code itself.
    // That goes into the classes that implement this interface.
    // The default access modifier is public, it does not need writing explicitly.

    void powerOn();

    void dial(int phoneNumber);

    void answer();

    boolean callPhone(int phoneNumber);

    boolean isRinging();

}
