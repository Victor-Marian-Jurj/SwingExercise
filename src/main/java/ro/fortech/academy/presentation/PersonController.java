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
        loadData();
        updateUIFromData();
    }

    public void loadData() {
        model.setPersonList(service.getAllPersons());
    }

    public void updateUIFromData() {
        view.refreshTable(model.getPersonList());
    }
}


