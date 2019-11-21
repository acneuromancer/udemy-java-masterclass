package section_11_naming_packages_static_final.scopevisibility;

public class Main {

    public static void main(String[] args) {
        String varFour = "this is varFour to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.userInner();

//        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        System.out.println("varThree is not accessible here if that is private: " + innerClass.varThree);

        System.out.println("scopeInstance privateVar is " + scopeInstance.getVarOne());
        System.out.println(varFour);
        scopeInstance.timesTwo();
        System.out.println("**************************************");

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }

}
