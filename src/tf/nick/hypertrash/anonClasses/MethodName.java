package tf.nick.hypertrash.anonClasses;

class CreateInstance {
    public static void main(String[] args) {
        SuperClass d = create();
        d.method2();
        d.method3();
    }


    public static SuperClass create() {

        return new SuperClass() {
            public void method2() {
                String name = Thread.currentThread().getStackTrace()[1].getMethodName();
                System.out.println(name);
            }

            public void method3() {
                String name = Thread.currentThread().getStackTrace()[1].getMethodName();
                System.out.println(name);
            }
        };
    }
}

abstract class SuperClass {

    public static void method1() { }

    public void method2() { }

    public abstract void method3();
}
