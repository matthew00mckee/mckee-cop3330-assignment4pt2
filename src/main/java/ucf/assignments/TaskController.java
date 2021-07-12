/*
 *  UCF COP3330 Summer 2021 Assignment 4 Part 2 Solution
 *  Copyright 2021 Matthew McKee
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class TaskController {
    @FXML
    public void editTask(ActionEvent action) {
        taskEditor();
    }

    public void taskEditor() {
        // Check if a task is selected with the checktaskSelected()
        // change the title
        // change the task description
        // change the due date of the item
        // print the new task
    }

    @FXML
    public void deleteTask(ActionEvent action) {
        taskDeletinator();
    }

    public void taskDeletinator() {
        // Check which task is selected with the checkTaskSelected()
        // delete item from list and GUI
    }

    @FXML
    public void checkTaskSelected(ActionEvent action) {
        SelectedTask();
    }

    public void SelectedTask() {
        // if any lists are checked off, return true.
        // if nothing is checked, ignore input
    }

    @FXML
    public void saveTask(ActionEvent action) {
        taskSaver();
    }

    public void taskSaver() {
        // Check which task is marked with the checkTaskSelected()
        // write just title, description and due date to file for the task to the gui
    }

    @FXML
    public void newTask(ActionEvent action) {
        addTask();
    }

    public void addTask() {
        // Generate a new item in the list as a loop until there are no more items
        // ask for item title
        // ask for description
        // ask for due date
    }

    @FXML
    public void markCompleted(ActionEvent action) {
        taskCompletor();
    }

    public void taskCompletor() {
        // Check which item is selected with the checkTaskSelected()
        // set value 'complete' to item and show on the gui
    }
}
