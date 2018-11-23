package com.css.ghostben.lt.topmenu.design;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;

/**
 * !! DO NOT EDIT THIS FILE !!
 * <p>
 * This class is generated by Vaadin Designer and will be overwritten.
 * <p>
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class AbstractTopMenu extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Image cssLogo;
    private Button mainPage;
    private ComboBox<String> mainFuc;
    private TextField searchTxt;
    private Button bellnav;
    private Button todoList;
    private ComboBox<String> accountNav;

    public AbstractTopMenu() {
        Design.read(this);
    }

    public VerticalLayout getMainLayout() {
        return mainLayout;
    }

    public Image getCssLogo() {
        return cssLogo;
    }

    public Button getMainPage() {
        return mainPage;
    }

    public ComboBox<String> getMainFuc() {
        return mainFuc;
    }

    public TextField getSearchTxt() {
        return searchTxt;
    }

    public Button getBellnav() {
        return bellnav;
    }

    public Button getTodoList() {
        return todoList;
    }

    public ComboBox<String> getAccountNav() {
        return accountNav;
    }

}
