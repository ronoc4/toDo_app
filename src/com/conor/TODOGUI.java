package com.conor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by conor on 4/7/16.
 */
public class TODOGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField newToDoTextField;
    private JButton addToDoButton;
    private JList<String> toDoList;
    private JButton removeButton;

    private DefaultListModel<String> listModel;
    

    TODOGUI() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));
        
        listModel = new DefaultListModel<String>();
        //Create new listModel, it will start empty

        toDoList.setModel(listModel);
        
        addListeners();
        
        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void addListeners() {
        addToDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newToDo  = newToDoTextField.getText(); //Get text from box
                newToDo = newToDo.trim(); //remove whitespace ...

                //Check to see if empty
                if(newToDo.length() == 0) {
                    return;
                }

                listModel.addElement(newToDo); //add data to list model, as you can't add to list directly
                newToDoTextField.setText(""); //clear JText field
            }
        });

        //Button to remove selected item from the list box
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectEdIndex = toDoList.getSelectedIndex();
                if(selectEdIndex != -1) {
                    listModel.remove(selectEdIndex);
                }
            }
        });

    }
}
