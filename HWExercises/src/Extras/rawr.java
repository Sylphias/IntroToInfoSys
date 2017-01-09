package Extras;

/**
 * Created by Ilya on 3/11/16.
 */
public class rawr {
    public static void main( String[] args ){
        Dog aDog = new Dog("Max");
        rawr.foo(aDog);

        if (aDog.getName().equals("Max")) { //true
            System.out.println( "Java passes by value." );

        } else if (aDog.getName().equals("Fifi")) {
            System.out.println( "Java passes by reference." );
        }
    }

    public static void foo(Dog d) {
        System.out.println(d.getName().equals("Max")); // true

        d.setName("Fifi");
        System.out.println(d.getName().equals("Fifi")); // true
    }
    static class Dog{
        String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
