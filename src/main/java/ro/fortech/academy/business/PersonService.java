package ro.fortech.academy.business;

import ro.fortech.academy.persistance.Person;
import ro.fortech.academy.persistance.PersonDao;

import java.util.List;

public class PersonService {

    private PersonDao personDao;

    public PersonService (PersonDao personDao){
        this.personDao = personDao;
    }
    public List<Person> getAllPersons(){
    return personDao.getAllPersons();
    }

}
