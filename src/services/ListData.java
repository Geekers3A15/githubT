/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sawssen Gharbi
 */
public class ListData {

    private ObservableList<user> users = FXCollections.observableArrayList();

    public ListData() {
        userService us = userService.getInstance();
        users = us.getAllUsersObservable();
    }
    public ObservableList<user> getUsers(){
        return users;
    }

}
