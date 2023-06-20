package ro.fortech.academy;

import ro.fortech.academy.business.PersonService;
import ro.fortech.academy.persistance.PersonDaoRandomGeneratorImpl;
import ro.fortech.academy.presentation.PersonController;
import ro.fortech.academy.presentation.PersonModel;
import ro.fortech.academy.presentation.PersonView;

public class Main {
    public static void main(String[] args) {

    PersonService service = new PersonService(new PersonDaoRandomGeneratorImpl());
    PersonModel model = new PersonModel(service.getAllPersons());

    PersonView view = new PersonView(model.getPersonList());

    PersonController controller = new PersonController(view, model, service);
    view.setController(controller);
    }
}