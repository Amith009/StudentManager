package com.example.studentmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;



public class HelloController {

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField majorField;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    // ObservableList for storing students
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));


        studentTable.setItems(studentList);


        studentList.add(new Student(1, "Amith", "asd@gmail.com", "Computer Science"));
        studentList.add(new Student(2, "Amith2", "qwerty@example.com", "Electrical Engineering"));
    }

    @FXML
    private void handleAddButton() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String email = emailField.getText();
            String major = majorField.getText();


            Student newStudent = new Student(id, name, email, major);


            studentList.add(newStudent);


            clearFields();
        } catch (NumberFormatException e) {

            System.err.println("Invalid input for ID field: " + e.getMessage());

        }
    }


    @FXML
    private void handleUpdateButton() {

        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {

            selectedStudent.setId(Integer.parseInt(idField.getText()));
            selectedStudent.setName(nameField.getText());
            selectedStudent.setEmail(emailField.getText());
            selectedStudent.setMajor(majorField.getText());


            studentTable.refresh();


            clearFields();
        }
    }

    @FXML
    private void handleDeleteButton() {
        // Get selected student from TableView
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            // Remove from the observable list
            studentList.remove(selectedStudent);

            // Clear input fields
            clearFields();
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        emailField.clear();
        majorField.clear();
    }
}
