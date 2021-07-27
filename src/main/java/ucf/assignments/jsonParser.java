package ucf.assignments;

import java.io.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

public class jsonParser {
    public static void parse(TableView<taskTODO> tableView) {
        //Initialize items
        ObservableList<itemTODO> items = FXCollections.observableArrayList();
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open file");
            File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());
            //Initialize File reader
            FileReader fileReader = new FileReader(file);
            JsonElement fileElement = JsonParser.parseReader(fileReader);
            //Get file as json object
            JsonObject fileObject = fileElement.getAsJsonObject();

            //Get items from json file
            JsonArray jsonArrayofItems = fileObject.get("items").getAsJsonArray();
            //Get item values from json
            //Loop for number of items
            for(JsonElement productElement : jsonArrayofItems){
                //Get json product
                JsonObject productJsonObject = productElement.getAsJsonObject();

                //Get values
                String title = productJsonObject.get("title").getAsString();
                String description = productJsonObject.get("description").getAsString();
                String date = productJsonObject.get("date").getAsString();
                String status = productJsonObject.get("status").getAsString();

                //Create item
                taskTODO item = new taskTODO();
                //Add item
                tableView.getItems().add(item);
            }
        }
        //Error case
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
