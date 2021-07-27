package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FXMLController implements Initializable{
    @FXML
    public TableView<taskTODO> tableView;
    @FXML
    public TableColumn<itemTODO, String> title;
    @FXML
    public TableColumn<itemTODO, String> description;
    @FXML
    public TableColumn<itemTODO, String> date;
    @FXML
    public TableColumn<itemTODO, String> status;

    //Initialize three text field and datePicker for adding a new item
    @FXML
    public TextField titleTextField;
    @FXML
    public TextField descriptionTextField;
    @FXML
    public DatePicker dateTextField;
    @FXML
    public TextField statusTextField;

    //Initialize Observable Todo list
    public ObservableList<taskTODO> item_list = FXCollections.observableArrayList();

    //Initialize file chooser
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize cellValueFactory of cells of tableview
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        //Initialize allowing multiple selection mode
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Set our tableView to empty item list
        tableView.setItems(item_list);

        //Set tableView to be editable
        tableView.setEditable(true);

        //Initialize text fields of cells of tableview
        title.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    @FXML
    public void DisplayAllButtonClicked(ActionEvent actionEvent) {
        tableView.setItems(item_list);
    }


    @FXML
    public void DisplayIncompleteButtonClicked(ActionEvent actionEvent) {

        FilteredList<taskTODO> items = filterListIncomplete(item_list);
        tableView.setItems(items);
    }

    @FXML
    public FilteredList<taskTODO> filterListIncomplete(ObservableList<taskTODO> item_lists){
        FilteredList<taskTODO> items = new FilteredList<>(item_lists,b -> true);
        items.setPredicate(taskTODO -> {
            return taskTODO.getStatus().equals("I") || taskTODO.getStatus().equals("i");
        });
        return items;
    }

    @FXML
    public void DisplayCompletedButtonClicked(ActionEvent actionEvent) {

        FilteredList<taskTODO> items = new FilteredList<>(item_list,b -> true);
        items.setPredicate(taskTODO -> {
            return taskTODO.getStatus().equals("C") || taskTODO.getStatus().equals("c");
        });
        tableView.setItems(items);
    }

    @FXML
    public void AddItemButtonClicked(ActionEvent actionEvent){

        taskTODO new_item = new taskTODO();
        tableView.setItems(item_list);
        tableView.getItems().add(new_item);
    }

    public String format_date(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTextField.getValue().format(formatter);
    }

    @FXML
    public void RemoveItemButtonClicked(ActionEvent actionEvent) {

        ObservableList<taskTODO> selectedRows, allItems;
        tableView.setItems(item_list);
        allItems = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        if(selectedRows != null)
            allItems.removeAll(selectedRows);

    }

    @FXML
    public void ClearAllButtonClicked(ActionEvent actionEvent) {

        ObservableList<taskTODO> allItems, all;
        tableView.setItems(item_list);
        allItems = tableView.getItems();
        all = tableView.getItems();
        allItems.removeAll(all);
    }

    @FXML
    public void SaveButtonClicked(ActionEvent actionEvent) {

        tableView.setItems(item_list);
        exporting exporter = new exporting();
        exporter.export((ObservableList<taskTODO>) item_list);
    }

    @FXML
    public void LoadButtonClicked(ActionEvent actionEvent){
        tableView.setItems(item_list);
        exporting exporter = new exporting();
    }


    @FXML
    public void ChangeTitleCell(TableColumn.CellEditEvent newCell) {

        taskTODO item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setTitle(newCell.getNewValue().toString());
    }

    @FXML
    public void ChangeDescriptionCell(TableColumn.CellEditEvent newCell) {

        taskTODO item_selected = tableView.getSelectionModel().getSelectedItem();
        String user_input = newCell.getNewValue().toString();
        if(user_input.length() < 1){
        }
        else if(user_input.length() > 256){
            String cutString = user_input.substring(1, 256);
            item_selected.setDescription(cutString);
        }
        else{
            item_selected.setDescription(user_input);
        }
    }

    @FXML
    public void ChangeDateCell(TableColumn.CellEditEvent newCell) {

        taskTODO item_selected = tableView.getSelectionModel().getSelectedItem();
        if(is_date_valid(newCell.getNewValue().toString()))
            item_selected.setDate(newCell.getNewValue().toString());
    }

    public boolean is_date_valid(String user_date){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(user_date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    @FXML
    public void ChangeStatusCell(TableColumn.CellEditEvent newCell) {

        taskTODO item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setStatus(newCell.getNewValue().toString());
    }

}
