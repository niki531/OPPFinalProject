import java.util.ArrayList;
import java.util.List;

public class LevelManager implements CustomerManager {
    private ArrayList<LevelGUI> levels;
    private static LevelManager instance;

    private LevelManager() {
        this.levels = new ArrayList<>();
        LevelGUI level1 = new LevelGUI(CustomerManager.getLevelCustomers(1), 10, 60,1);
        LevelGUI level2 = new LevelGUI(CustomerManager.getLevelCustomers(2), 25, 90,2);
        LevelGUI level3 = new LevelGUI(CustomerManager.getLevelCustomers(3), 35, 120,3);
        LevelGUI level4 = new LevelGUI(CustomerManager.getLevelCustomers(4), 55, 150,4);
        LevelGUI level5 = new LevelGUI(CustomerManager.getLevelCustomers(5), 75, 180,5);
        LevelGUI level6 = new LevelGUI(CustomerManager.getLevelCustomers(6), 100, 210,6);

        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
    }
    
    public static LevelManager getInstance() {
        if (instance == null) {
            synchronized (LevelManager.class) {
                if (instance == null) {
                    instance = new LevelManager();
                }
            }
        }
        return instance;
    }

    public void displayLevel (int currentLevel){
       LevelGUI a = levels.get(currentLevel-1);
       a.visibleLevel();
    }
}
