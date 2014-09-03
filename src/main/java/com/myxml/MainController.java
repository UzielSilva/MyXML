package com.myxml;

import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TabPane tabContainer;
    @FXML
    private BorderPane mainPane;
    @FXML
    private TableControl<Node> nodesGrid;
    private List<Node> lstNodes = new ArrayList<>();
    private static Stage stage;

    public static void setStage(Stage theStage){
        stage = theStage;
    }
    @FXML
    private void closeApp() {
        stage.close();
    }
    @FXML
    private void addDoc() {
        Tab t = new Tab("New");
        tabContainer.getTabs().add(t);
    }
    @FXML
    private void draggable(){

    }

    private TableController<Node> controller = new TableController<Node>() {

        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            return new TableData(lstNodes, false, lstNodes.size());
        }

        @Override
        public List<Node> update(List<Node> records) {
            return records;
        }

        @Override
        public List<Node> insert(List<Node> newRecords) {
            lstNodes.addAll(newRecords);
            return newRecords;
        }
    };
    public void reload() {
        nodesGrid.reloadFirstPage();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lstNodes.add(new Node("name", "value"));
        nodesGrid.setRecordClass(Node.class);
        nodesGrid.setController(controller);
    }

    public static class Node {
        private String name;
        private String value;

        public Node(String name, String value) {
            this.name = name;
            this.value = value;
        }
        public Node(){
            this("a","b");
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

    }
}
