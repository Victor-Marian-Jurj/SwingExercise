package ro.fortech.academy.persistance;

import ro.fortech.academy.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static ro.fortech.academy.util.RandomUtil.getRandomInteger;

public class PersonDaoRandomGeneratorImpl implements PersonDao {
    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<50; i++){
            String cnp = String.valueOf(getRandomInteger());
            String firstName = RandomUtil.getRandomString(20);
            String lastName = RandomUtil.getRandomString(25);
            String address = RandomUtil.getRandomString(50);
            String phone = String.valueOf(RandomUtil.getRandomInteger());
            String email = RandomUtil.getRandomString(30);
            persons.add(new Person(cnp, firstName, lastName, address, phone, email));
        }
        return persons;
    }
}
