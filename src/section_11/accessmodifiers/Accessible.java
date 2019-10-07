package section_11.accessmodifiers;

interface Accessible { // visibility: package private
    int SOME_CONSTANT = 100; // public static final

    public void methodA(); // public

    void methodB(); // public

    boolean methodC(); // public
}
