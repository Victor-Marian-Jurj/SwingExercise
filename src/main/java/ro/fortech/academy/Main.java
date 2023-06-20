package ro.fortech.academy;

import ro.fortech.academy.business.PersonService;
import ro.fortech.academy.persistance.PersonDaoRandomGeneratorImpl;
import ro.fortech.academy.presentation.PersonModel;
import ro.fortech.academy.presentation.PersonView;


public class Main {
    public static void main(String[] args) {

        PersonService service = new PersonService(new PersonDaoRandomGeneratorImpl());
        PersonModel model = new PersonModel(service.getAllPersons());

        PersonView view = new PersonView(model.getPersonList());

        PersonView.PersonController controller = new PersonView.PersonController() {
            @Override
            public void buttonRefreshPressed() {

            }

            @Override
            public void loadData() {

            }

            @Override
            public void updateUIFromData() {

            }
        };
        view.setController(controller);
    }
}