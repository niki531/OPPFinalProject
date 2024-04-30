import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RecipeBookGUI extends JFrame {
    private ArrayList<Recipe> recipeBook;
    private JButton btnExit;
    private JPanel recipePanel; 
    private JTextArea[] textAreas; 
    private JFrame previousGUI; 

    public RecipeBookGUI(int checktimes, RecipeBook rb, JFrame previousGUI) {
        this.recipeBook = rb.getRecipes();
        this.previousGUI = previousGUI; 

        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnExit = new JButton("Return");
        recipePanel = new JPanel(new GridLayout(1, 3, 10, 10)); 
        textAreas = new JTextArea[3];

        for (int i = 0; i < textAreas.length; i++) {
            textAreas[i] = new JTextArea(10, 30);
            textAreas[i].setEditable(false);
            textAreas[i].setWrapStyleWord(true);
            textAreas[i].setLineWrap(true);
            textAreas[i].setOpaque(false);
            textAreas[i].setMargin(new Insets(10, 30, 10, 30));
            JScrollPane scrollPane = new JScrollPane(textAreas[i]);
            recipePanel.add(scrollPane);
        }

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });

        add(recipePanel, BorderLayout.CENTER);
        add(btnExit, BorderLayout.SOUTH);

        setVisible(true);

        // Load recipes based on the checktimes
        if (checktimes == 0) {
            displayAll();
        } else {
            displayPart();
        }
    }

    public void displayAll() {
        int perColumn = (int) Math.ceil(recipeBook.size() / 3.0);
        for (int i = 0, col = 0; i < recipeBook.size(); i++) {
            if (i > 0 && i % perColumn == 0 && col < 2) col++;  
            textAreas[col].append(recipeBook.get(i).displayRecipe() + "\n\n");
        }
    }
    
    public void displayPart() {
        int partSize = Math.min(recipeBook.size(), 10); 
        int perColumn = (int) Math.ceil(partSize / 3.0);
        for (int i = 0, col = 0; i < partSize; i++) {
            if (i > 0 && i % perColumn == 0 && col < 2) col++;  
            textAreas[col].append(recipeBook.get(i).displayPartRecipe() + "\n\n");
        }
    }    

    private void exitClicked() {
        this.dispose();
        if (previousGUI != null) {
            previousGUI.setVisible(true);
        }
    }
}

