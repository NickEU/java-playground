package tf.nick.specStatic;


public class Program2 {
    public static void main(String[] args) {
        Person.showAll();
        Person p1 = Person.create("Helen", 26);
        Person.showAll();
        Person p2 = Person.create("Rose", 47);
        Person p3 = Person.create("Ann", 34);
        Person.showAll();
        System.out.println(p3);
    }
}
