package dirk;

import com.codepoetics.radioactive.Accessor;
import com.codepoetics.radioactive.Mapper;

public class Main {

    public static void main(String ...args) {

        final Accessor<Person, String> NAME1 = Accessor.of(Person::getName, Person::setName);
        final Accessor<Person, String> NAME2 = Accessor.of(Person.class, "name");

        Person person1 = new Person();
        person1.setName("Antigone");

        System.out.println(NAME2.get(person1));

        Knight bean2 = Mapper.from(Person::getName).via(String::toUpperCase).to(Knight::setName)
                .creatingWith(Knight::new)
                .apply(person1);

        System.out.println(bean2.getName());
    }

    static public class Person {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    static public class Knight {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
