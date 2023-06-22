package ro.fortech.academy.presentation;

import ro.fortech.academy.business.PersonService;
import ro.fortech.academy.persistance.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PersonView extends JFrame {

    private DefaultTableModel tableModel;
    private JMenuBar menuBar;
    private JMenuItem refreshMenuItem;
    private JMenuItem loadDataMenuItem;
    private JMenuItem updateUIFromDataMenuItem;

    private PersonController controller;

    public PersonView(List<Person> personList) {
        this();
        refreshTable(personList);
    }

    public PersonView() {
        super("Academy MVC with SWING");

        // Create menu items
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        refreshMenuItem = new JMenuItem("Refresh");
        loadDataMenuItem = new JMenuItem("Load Data");
        updateUIFromDataMenuItem = new JMenuItem("Update UI from Data");

        // Add menu items to menu
        fileMenu.add(refreshMenuItem);
        fileMenu.add(loadDataMenuItem);
        fileMenu.add(updateUIFromDataMenuItem);

        // Add menu to menu bar
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Add action listeners to menu items
        refreshMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.buttonRefreshPressed();
                }
            }
        });

        loadDataMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.loadData();
                }
            }
        });

        updateUIFromDataMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.updateUIFromData();
                }
            }
        });

        JPanel content = new JPanel();
        JScrollPane pane = getTablePane();
        content.add(pane);
        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private JScrollPane getTablePane() {
        String[] header = {"CNP", "First Name", "Last Name", "Address", "Phone", "Email"};
        tableModel = new DefaultTableModel(header, 0);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
        JScrollPane pane = new JScrollPane(table);
        return pane;
    }

    public void setController(PersonController controller) {
        this.controller = controller;
    }

    public void refreshTable(List<Person> personList) {
        tableModel.setRowCount(0);
        for (Person person : personList) {
            tableModel.addRow(new Object[]{person.getCnp(), person.getFirstName(), person.getLastName(),
                    person.getAddress(), person.getPhone(), person.getEmail()});
        }
    }


}
