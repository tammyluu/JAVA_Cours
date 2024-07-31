package org.example.controller;

import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.view.EmployeeView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmployeeController  extends JFrame {
    private final EmployeeDaoImpl dao = new EmployeeDaoImpl();
    private final DefaultTableModel model=new DefaultTableModel(new String[]{"Id", "Prénom", "Nom", "Rôle", "Département"},0);

    private final EmployeeView ui = new EmployeeView(this);
    private JTable table;

    public EmployeeController() {
        setTitle("Gestion des employés");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<Employee> salaries = dao.getAll();

        for (Employee salary : salaries) {
            long id = salary.getId();
            String firstname = salary.getFirstname();
            String lastname = salary.getLastname();
            Role role = salary.getRole();
            String department = salary.getDepartment().getName();
            Object[] rowData = {id, firstname, lastname, role, department};
            model.addRow(rowData);

        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Ajouter");
        JButton editButton = new JButton("Modifier");
        JButton deleteButton = new JButton("Supprimer");
        JButton switchButton = new JButton("Departement");

        addButton.addActionListener(e -> {
            ui.addView();
            refreshTable();
        });

        editButton.addActionListener(e->{
            int selectedRow=table.getSelectedRow();
            if(selectedRow>-1){
                long id= (long) table.getValueAt(selectedRow,0);
                ui.editView(id);
                refreshTable();
            }
        });

        deleteButton.addActionListener(e->{
            int selectedRow=table.getSelectedRow();
            if(selectedRow>-1){
                long id= (long) table.getValueAt(selectedRow,0);
                dao.remove(id);
                refreshTable();
            }
        });

        switchButton.addActionListener(e->{
            dispose();
            new DepartmentController();
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(switchButton);


        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<Employee> updateSalaries = dao.getAll();
        for (Employee salary : updateSalaries) {
            long id = salary.getId();
            String firstname = salary.getFirstname();
            String lastname = salary.getLastname();
            Role role = salary.getRole();
            String department = salary.getDepartment().getName();
            Object[] rowData = {id, firstname, lastname, role, department};
            model.addRow(rowData);
        }
    }


}