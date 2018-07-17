package com.gluonapplication.views;

import com.gluonapplication.models.Student;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;

public class SecondaryPresenter {
    private double COL_WIDTH = 300.0;

    @FXML
    private JFXTreeTableView tableView;
    @FXML
    private View secondary;

    public void initialize() {
        secondary.setShowTransitionFactory(BounceInRightTransition::new);

        FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> System.out.println("Info"));
        fab.showOn(secondary);

        secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();

                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Secondary");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e ->
                        System.out.println("Favorite")));
            }
        });

        initTreeTableView();
    }


    private void initTreeTableView() {
        JFXTreeTableColumn<Student, String> firstNameCol = new JFXTreeTableColumn<>("First Name");

        firstNameCol.setPrefWidth(COL_WIDTH);
        firstNameCol.setCellValueFactory(studentStringCellDataFeatures ->
                studentStringCellDataFeatures.getValue().getValue().firstName);

        JFXTreeTableColumn<Student, String> lastNameCol = new JFXTreeTableColumn<>("Last Name");

        lastNameCol.setPrefWidth(COL_WIDTH);
        lastNameCol.setCellValueFactory(studentStringCellDataFeatures ->
                studentStringCellDataFeatures.getValue().getValue().lastName);

        JFXTreeTableColumn<Student, String> dobCol = new JFXTreeTableColumn<>("DOB");

        dobCol.setPrefWidth(COL_WIDTH);
        dobCol.setCellValueFactory(studentStringCellDataFeatures ->
                studentStringCellDataFeatures.getValue().getValue().dob);

        JFXTreeTableColumn<Student, String> hostelCol = new JFXTreeTableColumn<>("Hostel");

        hostelCol.setPrefWidth(COL_WIDTH);
        hostelCol.setCellValueFactory(studentStringCellDataFeatures ->
                studentStringCellDataFeatures.getValue().getValue().hostel);

        ObservableList<Student> students = Student.getSampleStudents();
        final TreeItem root = new RecursiveTreeItem<Student>(students, RecursiveTreeObject::getChildren);
        tableView.getColumns().addAll(firstNameCol, lastNameCol, dobCol, hostelCol);

        tableView.setRoot(root);

        tableView.setShowRoot(false);

    }
}
