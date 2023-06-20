package ro.fortech.academy.presentation;

import ro.fortech.academy.business.PersonService;

public class PersonController {

    private PersonView view;

    private PersonModel model;

    private PersonService service;

    public PersonController(PersonView view, PersonModel model, PersonService service) {
        this.view = view;
        this.model = model;
        this.service = service;
    }

    public void buttonRefreshPressed() {
        model.setPersonList(service.getAllPersons());
        view.refreshTable(model.getPersonList());
    }

}
