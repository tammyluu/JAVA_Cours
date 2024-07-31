package org.example.view;

import org.example.dao.DepartmentDaoImpl;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Role;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class EmployeeView extends JDialog {
    private final EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();

    private List<Department> departments;
    private final DepartmentDaoImpl departmentDao=new DepartmentDaoImpl();
    private final JTextField firstnameInput=new JTextField(15);
    private final JTextField lastnameInput=new JTextField(15);
    private final JComboBox<String> roleInput=new JComboBox<>();

    private final ButtonGroup departmentInput=new ButtonGroup();
    private final JLabel firstnameLabel=new JLabel("Prénom:");
    private final JLabel lastnameLabel=new JLabel("Nom:");
    private final JLabel roleLabel=new JLabel("Rôle");
    private final JLabel departmentLabel=new JLabel("departmentLabel");

    public EmployeeView(JFrame frame){
        setLocationRelativeTo(frame);
        setSize(350,250);
        departments=departmentDao.getAll();
    }

    public void addView(){
        getContentPane().removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setTitle("Ajouté salarié");

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.NONE;
        add(firstnameLabel, constraints);

        constraints.gridx++;
        add(firstnameInput, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        add(lastnameLabel, constraints);

        constraints.gridx++;
        add(lastnameInput, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        add(roleLabel, constraints);

        constraints.gridx++;
        for(Role role:Role.values()){
            roleInput.addItem(role.toString());
        }
        add(roleInput, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        add(departmentLabel, constraints);

        constraints.gridx++;
        JPanel departmentPanel = new JPanel(new FlowLayout());

        for(Department department : departments){
            JRadioButton radioButton = new JRadioButton(department.getName());
            radioButton.setActionCommand(String.valueOf(department.getId()));
            departmentInput.add(radioButton);
            departmentPanel.add(radioButton);
        }
        add(departmentPanel, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JButton button=new JButton("Valider");
        button.addActionListener(e->addEmployee());
        add(button, constraints);

        setModal(true);
        setVisible(true);
    }


    private void addEmployee(){
        String firstname=firstnameInput.getText();
        String lastname=lastnameInput.getText();
        Role role=Role.valueOf((String) roleInput.getSelectedItem());
        Department department=departmentDao.getById(Long.parseLong(departmentInput.getSelection().getActionCommand()));
        if(!firstname.isEmpty() && !lastname.isEmpty() && department!=null){
            Employee employee=Employee.builder().
                    firstname(firstname).
                    lastname(lastname).
                    role(role).
                    department(department).
                    build();

            employeeDao.create(employee);
            firstnameInput.setText("");
            lastnameInput.setText("");
            dispose();
        }
    }

    public void editView(long idEmployee){
        Employee employee=employeeDao.getById(idEmployee);
        getContentPane().removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setTitle("Modifié salarié");

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.NONE;
        add(firstnameLabel, constraints);

        constraints.gridx++;
        firstnameInput.setText(employee.getFirstname());
        add(firstnameInput, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        add(lastnameLabel, constraints);

        constraints.gridx++;
        lastnameInput.setText(employee.getLastname());
        add(lastnameInput, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        add(roleLabel, constraints);

        constraints.gridx++;
        for(Role role:Role.values()){
            roleInput.addItem(role.toString());
        }
        roleInput.setSelectedItem(employee.getRole().toString());
        add(roleInput, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        add(departmentLabel, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JButton button=new JButton("Valider");
        button.addActionListener(e->editEmployee(employee));
        add(button, constraints);

        setModal(true);
        setVisible(true);
    }

    private void editEmployee(Employee employee){
        String firstname=firstnameInput.getText();
        String lastname=lastnameInput.getText();
        Role role=Role.valueOf((String) roleInput.getSelectedItem());
        if(!firstname.isEmpty()&&!lastname.isEmpty()){
            employee.setFirstname(firstname);
            employee.setLastname(lastname);
            employee.setRole(role);
            employeeDao.edit(employee);
            dispose();
        }
    }
    
}
