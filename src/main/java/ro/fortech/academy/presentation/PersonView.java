package ro.fortech.academy.presentation;

import ro.fortech.academy.persistance.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PersonView extends JFrame {

    private DefaultTableModel tableModel;
    private JButton refreshButton;

    private PersonController controller;

    public PersonView(List<Person> personList) {
        this();
        refreshTable(personList);
    }

    public PersonView() {
        super("Academy MVC with SWING");
        refreshButton = new JButton("Refresh");

        JPanel content = new JPanel();
        JScrollPane pane = getTablePane();
        content.add(pane);
        content.add(refreshButton);
        refreshButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.buttonRefreshPressed();
            }
        });
        this.setContentPane(content);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    private JScrollPane getTablePane(){
        String[] header = {"CNP", "First Name", "Last Name", "Address", "Phone", "Email"};
        tableModel = new DefaultTableModel(header, 0);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
        JScrollPane pane = new JScrollPane(table);
        return pane;
    }

    private void showMessage(){
        JOptionPane.showMessageDialog(this, "Am apasat butonul");
    }

    public PersonController getController() {
        return controller;
    }

    public void setController(PersonController controller) {
        this.controller = controller;
    }

    public void refreshTable (List<Person> personList){
        tableModel.setRowCount(0);
        for (Person person :personList) {
            tableModel.addRow(new Object [] {person.getCnp(), person.getFirstName(), person.getLastName(), person.getAddress(), person.getPhone(), person.getEmail()});
        }
    }

}
