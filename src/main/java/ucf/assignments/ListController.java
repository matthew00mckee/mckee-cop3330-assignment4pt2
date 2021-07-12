/*
 *  UCF COP3330 Summer 2021 Assignment 4 Part 2 Solution
 *  Copyright 2021 Matthew McKee
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class ListController {
    @FXML
    private TextField printListTitle;
    private TextField printItemTitle;
    private TextField printItemDescription;
    private TextField printDueDate;

    @FXML
    public void viewList(ActionEvent action) {
        showList();
    }

    public void showList() {
        // Check which list is marked
        // Find the To do List
        // print the To do List in new GUI
    }

    @FXML
    public void editList(ActionEvent action) {
        listEdit();
    }

    public void listEdit() {
        // get the user input for which list the user selected
        // if nothing is selected, ignore
        // if there is something selected find and replace with the new title
        // print the new title in the text field
    }

    @FXML
    public void deleteList(ActionEvent action) {
        listDeletinator();
    }

    public void listDeletinator() {
        // Check which list is selected by the user
        // is nothing is selected, ignore
        // find and delete whole list from the to do lists
    }

    @FXML
    public void newList(ActionEvent action) {
        addList();
    }

    public void addList() {
        // Create a new list in GUI with the Title, and Check Box
        // Ask for Title
        // call addTask() to fill out to do list
        // Display list
    }

    @FXML
    public void listSelector(ActionEvent action) {
        isListSelected();
    }

    public void isListSelected() {
        // Find which list has been highlighted by being clicked on
        // if list/s are selected, return true.
        // if no list is checked, ignore input
    }

    @FXML
    public void saveList(ActionEvent action) {
        listSave();
    }

    public void listSave() {
        // Check which list is marked with the checkListMarked()
        // Ask User what they want to name the new file
        // Write Selected Lists to file
    }
}

