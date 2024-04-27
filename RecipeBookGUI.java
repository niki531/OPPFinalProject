import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RecipeBookGUI extends JFrame{
    private ArrayList<Recipe> recipeBook;
    private JButton btnExit;
    private JTextArea textArea;
    private int checktimes;

    public RecipeBookGUI(int checktimes, RecipeBook rb) {
    	this.checktimes = checktimes;
        this.recipeBook = rb.getRecipes();
        setSize(800,600);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout()); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        btnExit = new JButton("Exit");
        textArea = new JTextArea(300, 200);
        textArea.setEditable(false);
        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });        
    }

    public void displayAll() {
        StringBuilder allRecipes = new StringBuilder();
        for (Recipe recipe : recipeBook) {
            allRecipes.append(recipe.displayRecipe());
        }
        textArea.setText(allRecipes.toString());
    }

    public void displayPart() {
        StringBuilder partRecipes = new StringBuilder();
        for (Recipe recipe : recipeBook) {
            partRecipes.append(recipe.displayPartRecipe());
        }
        textArea.setText(partRecipes.toString());
    }

    public void display() {
    	if (checktimes == 0) {
    		this.displayAll();
    	}
    	else {
    		this.displayPart();
    	}
    	
    	textArea.setWrapStyleWord(true);
    	textArea.setLineWrap(true);
    	textArea.setEditable(false); 
    	textArea.setOpaque(false); 
    	textArea.setMargin(new Insets(10, 30, 10, 30)); 
    	
    	add(textArea, BorderLayout.CENTER);
        add(btnExit, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    private void exitClicked() {
        System.exit(0);
    }
  
}
