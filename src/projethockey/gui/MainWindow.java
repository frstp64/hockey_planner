package projethockey.gui;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import projethockey.domain.Controller;
import projethockey.domain.sportSubscribable;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import projethockey.domain.projetHockeyInterface;
import javax.swing.DefaultCellEditor;
import javax.swing.SwingUtilities;

/**
 *
 * @author Frederic St-Pierre
 */
public class MainWindow extends javax.swing.JFrame implements projetHockeyInterface {
    /**
     * Creates new form MainWindow
     */

    private Controller myController;
    private boolean mousePressedBool;
    public MainWindow() {
        initComponents();

        // A reference to the controller is given.
        this.mousePressedBool = false;
        // subscription of every item that needs to be subscriber here.
    }

    public void setController(Controller theController) {
        this.myController = theController;
    }

    public void publishExistingSports(String[] plistSportsNames) {
        this.jListExistingSports.setListData(plistSportsNames);
        
        // change strategy tab values
        this.jComboBoxChooseStrategySport.setModel(new javax.swing.DefaultComboBoxModel(plistSportsNames));
    }

    public void publishSportName(String pSportName) {
        this.jTextFieldSportName.setText(pSportName);
    }

    public void publishDimensions(Float pdimX, Float pdimY){
        this.jTextFieldHorizontalSize.setText(pdimX.toString());
        this.jTextFieldVerticalSize.setText(pdimY.toString());
    }

    public void publishUnits(String punits){
        this.jTextFieldFieldUnits.setText(punits);
    }

    public void publishPlayerNumber(int playerNumber){
        this.jSpinnerSportPlayerMax.setValue(playerNumber);
        ((DefaultTableModel) this.jTableStrategyTeams.getModel()).setRowCount(playerNumber);
    }
    public void publishObjectTypeNumber(int objectTypeNumber){
        //this.jSpinnerObjectTypeNumber.setValue(objectTypeNumber);
        //((DefaultTableModel) this.jTableSportsItems.getModel()).setRowCount(objectTypeNumber);
    }

    public void publishSportIsUnlimited(boolean isUnlimited){
        this.jCheckBoxUnlimitedPlayer.setSelected(isUnlimited);
    }

    public void publishFieldPicture(BufferedImage thePicture) {

                // first, reset image to empty
        this.jLabelSportField.setIcon(null);
        this.jLabelSportField.revalidate();

        // if passed img is not null, draw it.
        if (thePicture != null) {
            // ideally we would extend a jpanel to accomodate all that image presentation spaghetti into a nice jlabel-inside-jframe class
            int imHeight = thePicture.getHeight();
            int imWidth = thePicture.getWidth();
            int fieldHeight = this.jPanelSportFieldViewer.getHeight();
            int fieldWidth = this.jPanelSportFieldViewer.getWidth();

            float imAspectRatio = ((float) imHeight)/imWidth;
            float fieldAspectRatio = ((float) fieldHeight)/fieldWidth;

            Icon fieldIcon;
            // image is large horizontally aspect-wise
            if (imAspectRatio < fieldAspectRatio) {
                fieldIcon = new ImageIcon(thePicture.getScaledInstance(fieldWidth-2, -1, -1));
            }
            else {
                fieldIcon = new ImageIcon(thePicture.getScaledInstance(-1, fieldHeight-2, -1));
            }
            this.jLabelSportField.setIcon(fieldIcon);
        }


    }

    public void publishCategoryPlayerIcon(BufferedImage thePicture) {

        // first, reset image to empty
        this.jLabelCategoryPlayerIcon.setIcon(null);
        this.jLabelCategoryPlayerIcon.revalidate();

        // if passed img is not null, draw it.
        if (thePicture != null) {

            // ideally we would extend a jpanel to accomodate all that image presentation spaghetti into a nice jlabel-inside-jframe class
            int imHeight = thePicture.getHeight();
            int imWidth = thePicture.getWidth();
            int fieldHeight = this.jPanelCategoryPicture.getHeight();
            int fieldWidth = this.jPanelCategoryPicture.getWidth();

            float imAspectRatio = ((float) imHeight)/imWidth;
            float fieldAspectRatio = ((float) fieldHeight)/fieldWidth;

            Icon fieldIcon;
            // image is large horizontally aspect-wise
            if (imAspectRatio < fieldAspectRatio) {
                fieldIcon = new ImageIcon(thePicture.getScaledInstance(fieldWidth-2, -1, -1));
            }
            else {
                fieldIcon = new ImageIcon(thePicture.getScaledInstance(-1, fieldHeight-2, -1));
            }
            this.jLabelCategoryPlayerIcon.setIcon(fieldIcon);

        }

    }

    public void publishCategoryPlayerName(String pCategoryPlayerName) {
        this.jTextFieldCategoryName.setText(pCategoryPlayerName);
    }

    public void publishExistingCategoryPlayer(String[] plistCategoryPlayer) {
        this.jListExistingCategories.setListData(plistCategoryPlayer);
        
        this.jComboBoxPlayerCategory.setModel(new javax.swing.DefaultComboBoxModel(plistCategoryPlayer));
    }


    // ---------------- categoryObstacle -----------------
    public void publishCategoryObstacleIcon(BufferedImage thePicture) {

        // first, reset image to empty
        this.jLabelCategoryObstacleIcon.setIcon(null);
        this.jLabelCategoryObstacleIcon.revalidate();

        // if passed img is not null, draw it.
        if (thePicture != null) {

            // ideally we would extend a jpanel to accomodate all that image presentation spaghetti into a nice jlabel-inside-jframe class
            int imHeight = thePicture.getHeight();
            int imWidth = thePicture.getWidth();
            int fieldHeight = this.jPanelObstacleIcon.getHeight();
            int fieldWidth = this.jPanelObstacleIcon.getWidth();

            float imAspectRatio = ((float) imHeight)/imWidth;
            float fieldAspectRatio = ((float) fieldHeight)/fieldWidth;

            Icon fieldIcon;
            // image is large horizontally aspect-wise
            if (imAspectRatio < fieldAspectRatio) {
                fieldIcon = new ImageIcon(thePicture.getScaledInstance(fieldWidth-2, -1, -1));
            }
            else {
                fieldIcon = new ImageIcon(thePicture.getScaledInstance(-1, fieldHeight-2, -1));
            }
            this.jLabelCategoryObstacleIcon.setIcon(fieldIcon);

        }

    }

    public void publishCategoryObstacleDimensions(Float pdimX, Float pdimY){
        this.jTextFieldObjectDimensionX.setText(pdimX.toString());
        this.jTextFieldObjectDimensionY.setText(pdimY.toString());
    }

    public void publishCategoryObstacleName(String pCategoryObstacleName) {
        this.jTextFieldObjectName.setText(pCategoryObstacleName);
    }

    public void publishExistingCategoryObstacle(String[] plistCategoryObstacle) {
        this.jListExistingObstacle.setListData(plistCategoryObstacle);
    }
    
    public void publishCategoryObstacleIsGameObject(Boolean pGameObject) {
        this.jCheckBoxIsAGameObstacle.setSelected(pGameObject);
    }


    public String requestFilePath() {
        javax.swing.JFileChooser fc;
        fc = new javax.swing.JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Images files", "png", "jpg", "PNG", "JPG", "jpeg", "JPEG");
        fc.setFileFilter(imgFilter);
        int fileChooserStatus = fc.showOpenDialog(this);
        if (fileChooserStatus == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file.getAbsolutePath();
        }
        else
            return "";
    }
    
    
    public void publishStrategyName(String pStrategyName) {
        this.jTextFieldChooseStrategyName.setText(pStrategyName);
    }
    
    public void publishStrategyPlayers(String[] plistStrategyPlayers){
        this.jListStrategyPlayers.setListData(plistStrategyPlayers);
    }
    
    public void publishStrategyObjects(String[] plistStrategyObjects) {
        this.jListStrategyObjects.setListData(plistStrategyObjects);
    }
    
    public void publishExistingStrategies(String[] plistStrategy) {
        this.jListExistingStrategies.setListData(plistStrategy);
    }
    
    public void publishStrategyTeams(ArrayList<String> pTeamNames){
        // edit number of columns in table (and number selector)
        this.jSpinnerSportEquipes.setValue(pTeamNames.size());
        
        // change values to our array.
        int nRow = pTeamNames.size(); // this.jTableTeamPlayers.getRowCount();
        ((DefaultTableModel) this.jTableStrategyTeams.getModel()).setRowCount(nRow);
        for (int i = 0; i < nRow; i++) {
            this.jTableStrategyTeams.setValueAt(pTeamNames.get(i), i, 0);
        }
    }
    
    public void publishPlayerName(String pPlayerName) {
        this.jTextFieldPlayerName.setText(pPlayerName);
    }

    public void publishExistingPlayers(String[] plistPlayer) {
        this.jListExistingPlayers.setListData(plistPlayer);
        
        // edit comboBox list (team selection)
        this.jComboBoxTeamPlayer.setModel(new javax.swing.DefaultComboBoxModel(plistPlayer));
    }

    public void publishPlayerCategoryName(String pPlayerCategoryName) {
        this.jComboBoxPlayerCategory.setSelectedItem(pPlayerCategoryName);

    }
    
    public void publishTeamNumber(int number) {
        this.jSpinnerSportEquipes.setValue(number);
    }
    
    public void publishTeamName(String pTeamName) {
        this.jTextFieldTeamName.setText(pTeamName);
    }

    public void publishExistingTeams(String[] plistTeam) {
        this.jListExistingTeams.setListData(plistTeam);
        
                // edit comboBox list (team selection)
        this.jComboBoxStrategyTeam.setModel(new javax.swing.DefaultComboBoxModel(plistTeam));
    }
    
    public void publishTeamPlayers(ArrayList<String> pPlayerNames) {
        // edit number of columns in table (and number selector)
        this.jSpinnerPlayerNumber1.setValue(pPlayerNames.size());
        
        // change values to our array.
        int nRow = this.jTableTeamPlayers.getRowCount();
        for (int i = 0; i < nRow; i++) {
            this.jTableTeamPlayers.setValueAt(pPlayerNames.get(i), i, 0);
        }
        
    }
    
    public void publishScene(Image pSceneImage) {
        this.jLabelStrategyEditorPicture.setIcon(new ImageIcon(pSceneImage));
        this.jLabelStrategyEditorPicture.revalidate();
        this.jLabelStrategyEditorPicture.paintImmediately(0, 0, this.jLabelStrategyEditorPicture.getWidth(), this.jLabelStrategyEditorPicture.getHeight());
        
    }

    public void publishMousePosition(String position) {
        this.jLabelCurrentPosition.setText(position);
    }
    
    public void publishCurrentTime(float timeInSeconds) {
        this.jTextFieldStrategyViewerTime.setText(Float.toString(timeInSeconds));
        this.jTextFieldStrategyViewerTime.paintImmediately(0, 0, 100, 100);
        
        
        // TODO modify slider time with setValue(int)
    }
    
    public void publishCurrentSliderTime(long currentTime, long biggestTime){
        float _time;
        
        int newTime = 0;
        
        if (biggestTime == 0) { newTime = 0;}
        else{
            _time = currentTime * this.jSliderStrategyTime.getMaximum() / biggestTime;
            newTime = Math.round(_time);
        }
        
        this.jSliderStrategyTime.setValue(newTime);
    }
    
    public void publishPreview(Image previewImage) {
        this.jLabelStrategyPreview.setIcon(new ImageIcon(previewImage.getScaledInstance(this.jPanelStrategyPreview.getWidth()-2, this.jPanelStrategyPreview.getHeight()-2, -1)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jComboBoxTeamPlayer = new javax.swing.JComboBox<>();
        jComboBoxStrategyTeam = new javax.swing.JComboBox<>();
        jTabbedPaneRoot = new javax.swing.JTabbedPane();
        jPanelCategories = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jButtonNewCategory = new javax.swing.JButton();
        jButtonSaveCategory = new javax.swing.JButton();
        jLabelCategoryImage = new javax.swing.JLabel();
        jPanelCategoryPicture = new javax.swing.JPanel();
        jLabelCategoryPlayerIcon = new javax.swing.JLabel();
        jLabelCategoryInformation = new javax.swing.JLabel();
        jLabelCategoryName = new javax.swing.JLabel();
        jTextFieldCategoryName = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListExistingCategories = new javax.swing.JList<>();
        jLabelExistingCategories = new javax.swing.JLabel();
        jButtonDeleteCategory = new javax.swing.JButton();
        jButtonChooseCategoryPicture = new javax.swing.JButton();
        jPanelPlayer = new javax.swing.JPanel();
        jButtonNewPlayer1 = new javax.swing.JButton();
        jButtonSavePlayer1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListExistingPlayers = new javax.swing.JList<>();
        jTextFieldPlayerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonDestroyPlayer1 = new javax.swing.JButton();
        jComboBoxPlayerCategory = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanelTeam = new javax.swing.JPanel();
        jButtonNewTeam = new javax.swing.JButton();
        jButtonSaveTeam = new javax.swing.JButton();
        jTextFieldTeamName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButtonDeleteTeam = new javax.swing.JButton();
        jLabelPlayerNumber1 = new javax.swing.JLabel();
        jSpinnerPlayerNumber1 = new javax.swing.JSpinner();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTeamPlayers = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListExistingTeams = new javax.swing.JList<>();
        jPanelSport = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jButtonSaveSport = new javax.swing.JButton();
        jButtonNewSport = new javax.swing.JButton();
        jPanelSportFieldViewer = new javax.swing.JPanel();
        jLabelSportField = new javax.swing.JLabel();
        jLabelFieldSize = new javax.swing.JLabel();
        jTextFieldHorizontalSize = new javax.swing.JTextField();
        jButtonLoadFieldImage = new javax.swing.JButton();
        jTextFieldVerticalSize = new javax.swing.JTextField();
        jLabelSportName = new javax.swing.JLabel();
        jTextFieldSportName = new javax.swing.JTextField();
        jLabelFieldText = new javax.swing.JLabel();
        jLabelPlayerNumber = new javax.swing.JLabel();
        jSpinnerSportPlayerMax = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListExistingSports = new javax.swing.JList<>();
        jButtonDestroySelectedSport = new javax.swing.JButton();
        jLabelExistingSportTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFieldUnits = new javax.swing.JTextField();
        jCheckBoxUnlimitedPlayer = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerSportEquipes = new javax.swing.JSpinner();
        jPanelObstacle = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonNewGameObstacle = new javax.swing.JButton();
        jButtonSaveGameObstacle = new javax.swing.JButton();
        jLabelObstacleInformation = new javax.swing.JLabel();
        jLabelObstacleName = new javax.swing.JLabel();
        jLabelChosenObstacleImage = new javax.swing.JLabel();
        jPanelObstacleIcon = new javax.swing.JPanel();
        jLabelCategoryObstacleIcon = new javax.swing.JLabel();
        jButtonChooseObstaclePicture = new javax.swing.JButton();
        jCheckBoxIsAGameObstacle = new javax.swing.JCheckBox();
        jLabelExistingObjects = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListExistingObstacle = new javax.swing.JList<>();
        jButtonDeleteGameObstacle = new javax.swing.JButton();
        jLabelObstacleSize = new javax.swing.JLabel();
        jTextFieldObjectDimensionX = new javax.swing.JTextField();
        jTextFieldObjectName = new javax.swing.JTextField();
        jTextFieldObjectDimensionY = new javax.swing.JTextField();
        jPanelCreateLoadStrategy = new javax.swing.JPanel();
        jButtonCreateStrategy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListExistingStrategies = new javax.swing.JList<>();
        jLabelChooseSport = new javax.swing.JLabel();
        jLabelChooseNameStrategy = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabelStrategyCreationZoneTitle = new javax.swing.JLabel();
        jLabelAvailableStrategies = new javax.swing.JLabel();
        jComboBoxChooseStrategySport = new javax.swing.JComboBox<>();
        jButtonDeleteStrategy = new javax.swing.JButton();
        jTextFieldChooseStrategyName = new javax.swing.JTextField();
        jLabelPlayersTableTitle = new javax.swing.JLabel();
        jScrollPanePlayers = new javax.swing.JScrollPane();
        jTableStrategyTeams = new javax.swing.JTable();
        jPanelStrategyPreview = new javax.swing.JPanel();
        jLabelStrategyPreview = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelStrategyEditor = new javax.swing.JPanel();
        jScrollPaneModificationMode = new javax.swing.JScrollPane();
        jListTypeModificationType = new javax.swing.JList<>();
        jScrollPanePlayerSelection = new javax.swing.JScrollPane();
        jListStrategyPlayers = new javax.swing.JList<>();
        jScrollPaneObjectSelection = new javax.swing.JScrollPane();
        jListStrategyObjects = new javax.swing.JList<>();
        jLabelObjectsToSelect = new javax.swing.JLabel();
        jLabelPlayerToSelect = new javax.swing.JLabel();
        jLabelModificationModeToSelect = new javax.swing.JLabel();
        jButtonSaveStrategy = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonZoom = new javax.swing.JButton();
        jButtonNextFrameForImageMode = new javax.swing.JButton();
        jLabelCursorPosition = new javax.swing.JLabel();
        jLabelCurrentPosition = new javax.swing.JLabel();
        jTextFieldTimeInterval = new javax.swing.JTextField();
        jLabelTimeInterval = new javax.swing.JLabel();
        jButtonModificationVisualize = new javax.swing.JButton();
        jButtonStepBackTime = new javax.swing.JButton();
        jButtonStepForwardTime = new javax.swing.JButton();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();
        jButtonExport = new javax.swing.JButton();
        jPanelStrategyEditorLocation = new javax.swing.JPanel();
        jLabelStrategyEditorPicture = new javax.swing.JLabel();
        jToggleButtonRotationMode = new javax.swing.JToggleButton();
        jTextFieldStrategyViewerTime = new javax.swing.JTextField();
        jLabelStrategyViewerTime = new javax.swing.JLabel();
        jCheckBoxInfoSupp = new javax.swing.JCheckBox();
        jSliderStrategyTime = new javax.swing.JSlider();
        jLabelExportationSize = new javax.swing.JLabel();
        jTextFieldExportSizeX = new javax.swing.JTextField();
        jTextFieldExportSizeY = new javax.swing.JTextField();
        jButtonRewind = new javax.swing.JButton();
        jButtonSwitchToRemoval = new javax.swing.JButton();

        jComboBoxTeamPlayer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Créer joueur avant!" }));

        jComboBoxStrategyTeam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Créer équipe avant" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logiciel de stratégie");
        setSize(new java.awt.Dimension(0, 0));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPaneRoot.setMinimumSize(new java.awt.Dimension(0, 0));
        jTabbedPaneRoot.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneRootStateChanged(evt);
            }
        });

        jPanelCategories.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelCategories.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelCategories.add(jSeparator8, gridBagConstraints);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanelCategories.add(jSeparator9, gridBagConstraints);

        jButtonNewCategory.setText("Nouveau");
        jButtonNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewCategoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelCategories.add(jButtonNewCategory, gridBagConstraints);

        jButtonSaveCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveCategory.setText("Enregistrer");
        jButtonSaveCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCategoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelCategories.add(jButtonSaveCategory, gridBagConstraints);

        jLabelCategoryImage.setText("Image de catégorie choisie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        jPanelCategories.add(jLabelCategoryImage, gridBagConstraints);

        jPanelCategoryPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCategoryPicture.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelCategoryPicture.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanelCategoryPicture.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelCategoryPicturePropertyChange(evt);
            }
        });
        jPanelCategoryPicture.setLayout(new java.awt.BorderLayout());

        jLabelCategoryPlayerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCategoryPlayerIconMouseClicked(evt);
            }
        });
        jPanelCategoryPicture.add(jLabelCategoryPlayerIcon, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelCategories.add(jPanelCategoryPicture, gridBagConstraints);

        jLabelCategoryInformation.setText("Informations sur la catégorie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCategories.add(jLabelCategoryInformation, gridBagConstraints);

        jLabelCategoryName.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCategories.add(jLabelCategoryName, gridBagConstraints);

        jTextFieldCategoryName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCategoryNameFocusLost(evt);
            }
        });
        jTextFieldCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCategoryNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelCategories.add(jTextFieldCategoryName, gridBagConstraints);

        jListExistingCategories.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListExistingCategories.setFixedCellHeight(10);
        jListExistingCategories.setFixedCellWidth(150);
        jListExistingCategories.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jListExistingCategoriesFocusLost(evt);
            }
        });
        jListExistingCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListExistingCategoriesMouseClicked(evt);
            }
        });
        jListExistingCategories.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListExistingCategoriesPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(jListExistingCategories);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelCategories.add(jScrollPane4, gridBagConstraints);

        jLabelExistingCategories.setText("Catégories existantes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        jPanelCategories.add(jLabelExistingCategories, gridBagConstraints);

        jButtonDeleteCategory.setText("Supprimer");
        jButtonDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCategoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        jPanelCategories.add(jButtonDeleteCategory, gridBagConstraints);

        jButtonChooseCategoryPicture.setText("Charger une image...");
        jButtonChooseCategoryPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseCategoryPictureActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanelCategories.add(jButtonChooseCategoryPicture, gridBagConstraints);

        jTabbedPaneRoot.addTab("Catégories", jPanelCategories);

        jPanelPlayer.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelPlayer.setLayout(new java.awt.GridBagLayout());

        jButtonNewPlayer1.setText("Nouveau");
        jButtonNewPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPlayer1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanelPlayer.add(jButtonNewPlayer1, gridBagConstraints);

        jButtonSavePlayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSavePlayer1.setText("Enregistrer");
        jButtonSavePlayer1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSavePlayer1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSavePlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePlayer1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelPlayer.add(jButtonSavePlayer1, gridBagConstraints);

        jListExistingPlayers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Aucun joueur existant" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListExistingPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListExistingPlayersMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jListExistingPlayers);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelPlayer.add(jScrollPane7, gridBagConstraints);

        jTextFieldPlayerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPlayerNameFocusLost(evt);
            }
        });
        jTextFieldPlayerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlayerNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelPlayer.add(jTextFieldPlayerName, gridBagConstraints);

        jLabel4.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelPlayer.add(jLabel4, gridBagConstraints);

        jLabel6.setText("Catégorie:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelPlayer.add(jLabel6, gridBagConstraints);

        jButtonDestroyPlayer1.setText("Supprimer");
        jButtonDestroyPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDestroyPlayer1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        jPanelPlayer.add(jButtonDestroyPlayer1, gridBagConstraints);

        jComboBoxPlayerCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Créer Catégorie avant" }));
        jComboBoxPlayerCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPlayerCategoryItemStateChanged(evt);
            }
        });
        jComboBoxPlayerCategory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxPlayerCategoryFocusLost(evt);
            }
        });
        jComboBoxPlayerCategory.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxPlayerCategoryPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.9;
        jPanelPlayer.add(jComboBoxPlayerCategory, gridBagConstraints);

        jLabel3.setText("Joueurs existants");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanelPlayer.add(jLabel3, gridBagConstraints);

        jTabbedPaneRoot.addTab("Joueur", jPanelPlayer);

        jPanelTeam.setLayout(new java.awt.GridBagLayout());

        jButtonNewTeam.setText("Nouveau");
        jButtonNewTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewTeamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelTeam.add(jButtonNewTeam, gridBagConstraints);

        jButtonSaveTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveTeam.setText("Enregistrer");
        jButtonSaveTeam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveTeam.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveTeamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelTeam.add(jButtonSaveTeam, gridBagConstraints);

        jTextFieldTeamName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTeamNameFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelTeam.add(jTextFieldTeamName, gridBagConstraints);

        jLabel2.setText("Nom de l'équipe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelTeam.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelTeam.add(jSeparator1, gridBagConstraints);

        jLabel5.setText("Équipes existantes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanelTeam.add(jLabel5, gridBagConstraints);

        jButtonDeleteTeam.setText("Supprimer");
        jButtonDeleteTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteTeamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        jPanelTeam.add(jButtonDeleteTeam, gridBagConstraints);

        jLabelPlayerNumber1.setText("Nombre de joueurs:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelTeam.add(jLabelPlayerNumber1, gridBagConstraints);

        jSpinnerPlayerNumber1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerPlayerNumber1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPlayerNumber1StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanelTeam.add(jSpinnerPlayerNumber1, gridBagConstraints);

        jTableTeamPlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Joueur"
            }
        ));
        jTableTeamPlayers.setCellEditor(new DefaultCellEditor(jComboBoxTeamPlayer));
        jTableTeamPlayers.setRequestFocusEnabled(false);
        jTableTeamPlayers.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableTeamPlayersPropertyChange(evt);
            }
        });
        jScrollPane5.setViewportView(jTableTeamPlayers);
        if (jTableTeamPlayers.getColumnModel().getColumnCount() > 0) {
            jTableTeamPlayers.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jComboBoxTeamPlayer));
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelTeam.add(jScrollPane5, gridBagConstraints);

        jListExistingTeams.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Créer une équipe avant" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListExistingTeams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListExistingTeamsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jListExistingTeams);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelTeam.add(jScrollPane8, gridBagConstraints);

        jTabbedPaneRoot.addTab("Équipe", jPanelTeam);

        jPanelSport.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelSport.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSport.add(jSeparator7, gridBagConstraints);

        jButtonSaveSport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveSport.setText("Enregistrer");
        jButtonSaveSport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveSport.setIconTextGap(2);
        jButtonSaveSport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveSportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jButtonSaveSport, gridBagConstraints);

        jButtonNewSport.setText("Nouveau");
        jButtonNewSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewSportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanelSport.add(jButtonNewSport, gridBagConstraints);

        jPanelSportFieldViewer.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSportFieldViewer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSportFieldViewer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelSportFieldViewerPropertyChange(evt);
            }
        });
        jPanelSportFieldViewer.setLayout(new java.awt.BorderLayout());

        jLabelSportField.setMinimumSize(new java.awt.Dimension(10, 10));
        jPanelSportFieldViewer.add(jLabelSportField, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        jPanelSport.add(jPanelSportFieldViewer, gridBagConstraints);

        jLabelFieldSize.setText("Taille du terrain:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jLabelFieldSize, gridBagConstraints);

        jTextFieldHorizontalSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldHorizontalSizeFocusLost(evt);
            }
        });
        jTextFieldHorizontalSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorizontalSizeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.05;
        jPanelSport.add(jTextFieldHorizontalSize, gridBagConstraints);

        jButtonLoadFieldImage.setText("Charger une image...");
        jButtonLoadFieldImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadFieldImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jButtonLoadFieldImage, gridBagConstraints);

        jTextFieldVerticalSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVerticalSizeFocusLost(evt);
            }
        });
        jTextFieldVerticalSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVerticalSizeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.05;
        jPanelSport.add(jTextFieldVerticalSize, gridBagConstraints);

        jLabelSportName.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jLabelSportName, gridBagConstraints);

        jTextFieldSportName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSportNameFocusLost(evt);
            }
        });
        jTextFieldSportName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSportNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelSport.add(jTextFieldSportName, gridBagConstraints);

        jLabelFieldText.setText("Terrain");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        jPanelSport.add(jLabelFieldText, gridBagConstraints);

        jLabelPlayerNumber.setText("Nombre de joueurs maximum:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jLabelPlayerNumber, gridBagConstraints);

        jSpinnerSportPlayerMax.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerSportPlayerMax.setMinimumSize(new java.awt.Dimension(0, 0));
        jSpinnerSportPlayerMax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSportPlayerMaxStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelSport.add(jSpinnerSportPlayerMax, gridBagConstraints);

        jListExistingSports.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListExistingSports.setFixedCellHeight(10);
        jListExistingSports.setFixedCellWidth(150);
        jListExistingSports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListExistingSportsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListExistingSports);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelSport.add(jScrollPane1, gridBagConstraints);

        jButtonDestroySelectedSport.setText("Supprimer");
        jButtonDestroySelectedSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDestroySelectedSportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanelSport.add(jButtonDestroySelectedSport, gridBagConstraints);

        jLabelExistingSportTitle.setText("Les sports existants");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelSport.add(jLabelExistingSportTitle, gridBagConstraints);

        jLabel1.setText("Unités:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jLabel1, gridBagConstraints);

        jTextFieldFieldUnits.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFieldUnitsFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelSport.add(jTextFieldFieldUnits, gridBagConstraints);

        jCheckBoxUnlimitedPlayer.setText("Nombre de joueurs illimité");
        jCheckBoxUnlimitedPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUnlimitedPlayerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jCheckBoxUnlimitedPlayer, gridBagConstraints);

        jLabel7.setText("Nombre d'équipes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelSport.add(jLabel7, gridBagConstraints);

        jSpinnerSportEquipes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSportEquipesStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelSport.add(jSpinnerSportEquipes, gridBagConstraints);

        jTabbedPaneRoot.addTab("Sport", jPanelSport);

        jPanelObstacle.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelObstacle.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelObstacle.add(jSeparator3, gridBagConstraints);

        jButtonNewGameObstacle.setText("Nouveau");
        jButtonNewGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameObstacleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jButtonNewGameObstacle, gridBagConstraints);

        jButtonSaveGameObstacle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveGameObstacle.setText("Enregistrer");
        jButtonSaveGameObstacle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveGameObstacle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGameObstacleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jButtonSaveGameObstacle, gridBagConstraints);

        jLabelObstacleInformation.setText("Informations sur l'objet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        jPanelObstacle.add(jLabelObstacleInformation, gridBagConstraints);

        jLabelObstacleName.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jLabelObstacleName, gridBagConstraints);

        jLabelChosenObstacleImage.setText("Image d'objet choisi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 9;
        jPanelObstacle.add(jLabelChosenObstacleImage, gridBagConstraints);

        jPanelObstacleIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelObstacleIcon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelObstacleIconPropertyChange(evt);
            }
        });
        jPanelObstacleIcon.setLayout(new java.awt.BorderLayout());
        jPanelObstacleIcon.add(jLabelCategoryObstacleIcon, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelObstacle.add(jPanelObstacleIcon, gridBagConstraints);

        jButtonChooseObstaclePicture.setText("Choisir image...");
        jButtonChooseObstaclePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseObstaclePictureActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jButtonChooseObstaclePicture, gridBagConstraints);

        jCheckBoxIsAGameObstacle.setText("Objet de jeu? (sinon, obstacle)");
        jCheckBoxIsAGameObstacle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCheckBoxIsAGameObstacleFocusLost(evt);
            }
        });
        jCheckBoxIsAGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIsAGameObstacleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jCheckBoxIsAGameObstacle, gridBagConstraints);
        jCheckBoxIsAGameObstacle.getAccessibleContext().setAccessibleDescription("");

        jLabelExistingObjects.setText("Objets existants");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelObstacle.add(jLabelExistingObjects, gridBagConstraints);

        jListExistingObstacle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListExistingObstacleMouseClicked(evt);
            }
        });
        jListExistingObstacle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListExistingObstaclePropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(jListExistingObstacle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jScrollPane3, gridBagConstraints);

        jButtonDeleteGameObstacle.setText("Supprimer");
        jButtonDeleteGameObstacle.setMaximumSize(null);
        jButtonDeleteGameObstacle.setMinimumSize(null);
        jButtonDeleteGameObstacle.setName(""); // NOI18N
        jButtonDeleteGameObstacle.setPreferredSize(null);
        jButtonDeleteGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteGameObstacleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jButtonDeleteGameObstacle, gridBagConstraints);

        jLabelObstacleSize.setText("Taille:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelObstacle.add(jLabelObstacleSize, gridBagConstraints);

        jTextFieldObjectDimensionX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldObjectDimensionXFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelObstacle.add(jTextFieldObjectDimensionX, gridBagConstraints);

        jTextFieldObjectName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldObjectNameFocusLost(evt);
            }
        });
        jTextFieldObjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObjectNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelObstacle.add(jTextFieldObjectName, gridBagConstraints);

        jTextFieldObjectDimensionY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldObjectDimensionYFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanelObstacle.add(jTextFieldObjectDimensionY, gridBagConstraints);

        jTabbedPaneRoot.addTab("Objets de jeu", jPanelObstacle);

        jPanelCreateLoadStrategy.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelCreateLoadStrategy.setLayout(new java.awt.GridBagLayout());

        jButtonCreateStrategy.setText("Sauvegarder une nouvelle stratégie");
        jButtonCreateStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jButtonCreateStrategy, gridBagConstraints);

        jListExistingStrategies.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Créer d'abord une stratégie." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListExistingStrategies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListExistingStrategiesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListExistingStrategies);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        jPanelCreateLoadStrategy.add(jScrollPane2, gridBagConstraints);

        jLabelChooseSport.setText("Sport:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelChooseSport, gridBagConstraints);

        jLabelChooseNameStrategy.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelChooseNameStrategy, gridBagConstraints);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanelCreateLoadStrategy.add(jSeparator11, gridBagConstraints);

        jLabelStrategyCreationZoneTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelStrategyCreationZoneTitle.setText("Création de stratégie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelStrategyCreationZoneTitle, gridBagConstraints);

        jLabelAvailableStrategies.setText("Stratégies disponibles pour ce sport");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelAvailableStrategies, gridBagConstraints);

        jComboBoxChooseStrategySport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hockey", "Hockey Spécial", "Soccer" }));
        jComboBoxChooseStrategySport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChooseStrategySportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jComboBoxChooseStrategySport, gridBagConstraints);

        jButtonDeleteStrategy.setText("Supprimer");
        jButtonDeleteStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanelCreateLoadStrategy.add(jButtonDeleteStrategy, gridBagConstraints);

        jTextFieldChooseStrategyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldChooseStrategyNameFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 187;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jTextFieldChooseStrategyName, gridBagConstraints);

        jLabelPlayersTableTitle.setText("Les équipes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 0, 0);
        jPanelCreateLoadStrategy.add(jLabelPlayersTableTitle, gridBagConstraints);

        jTableStrategyTeams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Équipe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableStrategyTeams.getTableHeader().setReorderingAllowed(false);
        jTableStrategyTeams.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableStrategyTeamsPropertyChange(evt);
            }
        });
        jScrollPanePlayers.setViewportView(jTableStrategyTeams);
        if (jTableStrategyTeams.getColumnModel().getColumnCount() > 0) {
            jTableStrategyTeams.getColumnModel().getColumn(0).setResizable(false);
            jTableStrategyTeams.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jComboBoxStrategyTeam));
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelCreateLoadStrategy.add(jScrollPanePlayers, gridBagConstraints);

        jPanelStrategyPreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelStrategyPreview.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanelStrategyPreview.setLayout(new java.awt.BorderLayout());

        jLabelStrategyPreview.setAlignmentY(0.0F);
        jLabelStrategyPreview.setMaximumSize(null);
        jLabelStrategyPreview.setMinimumSize(null);
        jLabelStrategyPreview.setOpaque(true);
        jPanelStrategyPreview.add(jLabelStrategyPreview, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.6;
        jPanelCreateLoadStrategy.add(jPanelStrategyPreview, gridBagConstraints);

        jLabel8.setText("Aperçu de la stratégie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        jPanelCreateLoadStrategy.add(jLabel8, gridBagConstraints);

        jTabbedPaneRoot.addTab("Créer/charger stratégie", jPanelCreateLoadStrategy);

        jPanelStrategyEditor.setLayout(new java.awt.GridBagLayout());

        jScrollPaneModificationMode.setMinimumSize(null);
        jScrollPaneModificationMode.setName(""); // NOI18N

        jListTypeModificationType.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Image par image", "Temps réel" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListTypeModificationType.setMaximumSize(null);
        jListTypeModificationType.setMinimumSize(null);
        jListTypeModificationType.setName(""); // NOI18N
        jListTypeModificationType.setPreferredSize(null);
        jListTypeModificationType.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListTypeModificationTypeValueChanged(evt);
            }
        });
        jScrollPaneModificationMode.setViewportView(jListTypeModificationType);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.33;
        jPanelStrategyEditor.add(jScrollPaneModificationMode, gridBagConstraints);

        jScrollPanePlayerSelection.setMinimumSize(null);
        jScrollPanePlayerSelection.setName(""); // NOI18N

        jListStrategyPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListStrategyPlayersMouseClicked(evt);
            }
        });
        jScrollPanePlayerSelection.setViewportView(jListStrategyPlayers);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.16;
        jPanelStrategyEditor.add(jScrollPanePlayerSelection, gridBagConstraints);

        jScrollPaneObjectSelection.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPaneObjectSelection.setPreferredSize(new java.awt.Dimension(0, 0));

        jListStrategyObjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListStrategyObjectsMouseClicked(evt);
            }
        });
        jScrollPaneObjectSelection.setViewportView(jListStrategyObjects);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.33;
        jPanelStrategyEditor.add(jScrollPaneObjectSelection, gridBagConstraints);

        jLabelObjectsToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObjectsToSelect.setText("Objets");
        jLabelObjectsToSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelObjectsToSelect, gridBagConstraints);

        jLabelPlayerToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayerToSelect.setText("Joueurs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelPlayerToSelect, gridBagConstraints);

        jLabelModificationModeToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModificationModeToSelect.setText("Mode");
        jLabelModificationModeToSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanelStrategyEditor.add(jLabelModificationModeToSelect, gridBagConstraints);

        jButtonSaveStrategy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveStrategy.setText("Enregistrer");
        jButtonSaveStrategy.setAlignmentY(5.0F);
        jButtonSaveStrategy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveStrategy.setIconTextGap(2);
        jButtonSaveStrategy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonSaveStrategy, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelStrategyEditor.add(jSeparator2, gridBagConstraints);

        jButtonZoom.setText("Zoom");
        jButtonZoom.setToolTipText("Sélectionner la zone de zoom désirée avec deux points");
        jButtonZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZoomActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonZoom, gridBagConstraints);

        jButtonNextFrameForImageMode.setText("image suivante");
        jButtonNextFrameForImageMode.setDefaultCapable(false);
        jButtonNextFrameForImageMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextFrameForImageModeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 0, 0);
        jPanelStrategyEditor.add(jButtonNextFrameForImageMode, gridBagConstraints);

        jLabelCursorPosition.setText("position du curseur: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelCursorPosition, gridBagConstraints);

        jLabelCurrentPosition.setText("positionActuelle");
        jLabelCurrentPosition.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelCurrentPositionPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelCurrentPosition, gridBagConstraints);

        jTextFieldTimeInterval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimeIntervalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jTextFieldTimeInterval, gridBagConstraints);

        jLabelTimeInterval.setText("Intervalle(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        jPanelStrategyEditor.add(jLabelTimeInterval, gridBagConstraints);

        jButtonModificationVisualize.setText("Visualiser");
        jButtonModificationVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificationVisualizeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonModificationVisualize, gridBagConstraints);

        jButtonStepBackTime.setText("Reculer");
        jButtonStepBackTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepBackTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonStepBackTime, gridBagConstraints);

        jButtonStepForwardTime.setText("Avancer");
        jButtonStepForwardTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepForwardTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        jPanelStrategyEditor.add(jButtonStepForwardTime, gridBagConstraints);

        jButtonUndo.setText("Annuler");
        jButtonUndo.setMaximumSize(new java.awt.Dimension(73, 25));
        jButtonUndo.setMinimumSize(new java.awt.Dimension(73, 25));
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonUndo, gridBagConstraints);

        jButtonRedo.setText("Refaire");
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonRedo, gridBagConstraints);

        jButtonExport.setText("Exporter");
        jButtonExport.setMaximumSize(null);
        jButtonExport.setMinimumSize(null);
        jButtonExport.setPreferredSize(null);
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonExport, gridBagConstraints);

        jPanelStrategyEditorLocation.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanelStrategyEditorLocation.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelStrategyEditorLocationPropertyChange(evt);
            }
        });
        jPanelStrategyEditorLocation.setLayout(new java.awt.BorderLayout());

        jLabelStrategyEditorPicture.setAlignmentY(0.0F);
        jLabelStrategyEditorPicture.setMaximumSize(null);
        jLabelStrategyEditorPicture.setMinimumSize(null);
        jLabelStrategyEditorPicture.setName(""); // NOI18N
        jLabelStrategyEditorPicture.setOpaque(true);
        jLabelStrategyEditorPicture.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelStrategyEditorPictureMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelStrategyEditorPictureMouseDragged(evt);
            }
        });
        jLabelStrategyEditorPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelStrategyEditorPictureMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelStrategyEditorPictureMouseReleased(evt);
            }
        });
        jPanelStrategyEditorLocation.add(jLabelStrategyEditorPicture, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelStrategyEditor.add(jPanelStrategyEditorLocation, gridBagConstraints);

        jToggleButtonRotationMode.setText("mode rotation");
        jToggleButtonRotationMode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonRotationModeStateChanged(evt);
            }
        });
        jToggleButtonRotationMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRotationModeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jToggleButtonRotationMode, gridBagConstraints);

        jTextFieldStrategyViewerTime.setText("0");
        jTextFieldStrategyViewerTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStrategyViewerTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jTextFieldStrategyViewerTime, gridBagConstraints);

        jLabelStrategyViewerTime.setText("Temps (s):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanelStrategyEditor.add(jLabelStrategyViewerTime, gridBagConstraints);

        jCheckBoxInfoSupp.setText("Information supplémentaire");
        jCheckBoxInfoSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxInfoSuppActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        jPanelStrategyEditor.add(jCheckBoxInfoSupp, gridBagConstraints);

        jSliderStrategyTime.setSnapToTicks(true);
        jSliderStrategyTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderStrategyTimeMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelStrategyEditor.add(jSliderStrategyTime, gridBagConstraints);

        jLabelExportationSize.setText("Taille de l'exportation (pixels)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelExportationSize, gridBagConstraints);

        jTextFieldExportSizeX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldExportSizeXFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jTextFieldExportSizeX, gridBagConstraints);

        jTextFieldExportSizeY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldExportSizeYFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jTextFieldExportSizeY, gridBagConstraints);

        jButtonRewind.setText("Aller au début");
        jButtonRewind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRewindActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonRewind, gridBagConstraints);

        jButtonSwitchToRemoval.setText("Enlever un objet/joueur");
        jButtonSwitchToRemoval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSwitchToRemovalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelStrategyEditor.add(jButtonSwitchToRemoval, gridBagConstraints);

        jTabbedPaneRoot.addTab("Édition et visualisation de stratégie", jPanelStrategyEditor);

        getContentPane().add(jTabbedPaneRoot, java.awt.BorderLayout.CENTER);
        this.jTabbedPaneRoot.setEnabledAt(6, false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxIsAGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIsAGameObstacleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxIsAGameObstacleActionPerformed

    private void jButtonNewGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameObstacleActionPerformed
        myController.resetPlaceHolderCategoryObstacle();
    }//GEN-LAST:event_jButtonNewGameObstacleActionPerformed

    private void jButtonDeleteStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteStrategyActionPerformed
        this.myController.removeSelectedStrategy(this.jListExistingStrategies.getSelectedValue());
        this.jTabbedPaneRoot.setEnabledAt(6, false);
        
    }//GEN-LAST:event_jButtonDeleteStrategyActionPerformed

    private void jButtonDestroySelectedSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDestroySelectedSportActionPerformed
        this.myController.removeSport();
    }//GEN-LAST:event_jButtonDestroySelectedSportActionPerformed

    private void jButtonSaveSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSportActionPerformed
        this.myController.saveSport();
    }//GEN-LAST:event_jButtonSaveSportActionPerformed

    private void jButtonCreateStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateStrategyActionPerformed
        this.myController.createStrategy();
    }//GEN-LAST:event_jButtonCreateStrategyActionPerformed

    private void jButtonNewSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewSportActionPerformed
        myController.resetPlaceHolderSport();
    }//GEN-LAST:event_jButtonNewSportActionPerformed

    private void jButtonLoadFieldImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadFieldImageActionPerformed
        myController.getSportImage();
    }//GEN-LAST:event_jButtonLoadFieldImageActionPerformed

    private void jButtonSaveGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGameObstacleActionPerformed
        this.myController.saveCategoryObject();
    }//GEN-LAST:event_jButtonSaveGameObstacleActionPerformed

    private void jButtonChooseObstaclePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseObstaclePictureActionPerformed
        myController.getCategoryObstacleImage();
    }//GEN-LAST:event_jButtonChooseObstaclePictureActionPerformed

    private void jButtonDeleteGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteGameObstacleActionPerformed
        this.myController.removeCategoryObstacle();
    }//GEN-LAST:event_jButtonDeleteGameObstacleActionPerformed

    private void jComboBoxChooseStrategySportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChooseStrategySportActionPerformed
        this.myController.setStrategySportName((String)this.jComboBoxChooseStrategySport.getSelectedItem());
        
        this.myController.publishStrategyNames();
    }//GEN-LAST:event_jComboBoxChooseStrategySportActionPerformed

    private void jListExistingObstaclePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListExistingObstaclePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListExistingObstaclePropertyChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jPanelSportFieldViewerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelSportFieldViewerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelSportFieldViewerPropertyChange

    private void jPanelObstaclePicturePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelObstaclePicturePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelObstaclePicturePropertyChange

    private void jTextFieldSportNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSportNameFocusLost
        myController.setSportName(this.jTextFieldSportName.getText());
    }//GEN-LAST:event_jTextFieldSportNameFocusLost

    private void jTextFieldHorizontalSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldHorizontalSizeFocusLost
        try {
            myController.setSportHorizontalSize(Float.parseFloat(this.jTextFieldHorizontalSize.getText()));
            this.jTextFieldHorizontalSize.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldHorizontalSize.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldHorizontalSizeFocusLost

    private void jTextFieldFieldUnitsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFieldUnitsFocusLost
        myController.setSportUnits(this.jTextFieldFieldUnits.getText());
    }//GEN-LAST:event_jTextFieldFieldUnitsFocusLost

    private void jTextFieldVerticalSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVerticalSizeFocusLost
        try {
            myController.setSportVerticalSize(Float.parseFloat(this.jTextFieldVerticalSize.getText()));
            this.jTextFieldVerticalSize.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldVerticalSize.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldVerticalSizeFocusLost

    private void jListExistingSportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListExistingSportsMouseClicked
    try {
        if (jListExistingSports.getSelectedValue() != null & myController != null) {
            myController.setSelectedSport(jListExistingSports.getSelectedValue());
        }
        else if (myController != null) {
            String empty = "";
            myController.setSelectedSport(empty);
        }
        } catch (Exception Ex) {

        }
    }//GEN-LAST:event_jListExistingSportsMouseClicked

    private void jSpinnerSportPlayerMaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerSportPlayerMaxStateChanged

        if (this.myController != null) {
            this.myController.setSportPlayerNumber((int) this.jSpinnerSportPlayerMax.getModel().getValue());
        }
    }//GEN-LAST:event_jSpinnerSportPlayerMaxStateChanged

    private void jTableStrategyTeamsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableStrategyTeamsPropertyChange
        
        // we get the  teams
        ArrayList<String> tmpTeamArray = new ArrayList();
        int rowNumber = jTableStrategyTeams.getModel().getRowCount();
        Boolean allCorrect = true;
        for (int i = 0; i < rowNumber; i++) {
            String theTeamName = (String) jTableStrategyTeams.getModel().getValueAt(i, 0);
            if (theTeamName != null && !theTeamName.equals("")) {
                tmpTeamArray.add(theTeamName);
            }
            else {
                allCorrect = false;
            }

        }
        
        // if everything is ok, we set the teams
        if (allCorrect == true) {
        if (this.myController != null) {
            this.myController.setStrategyTeam(tmpTeamArray);
        }
        }
    }//GEN-LAST:event_jTableStrategyTeamsPropertyChange

    private void jTextFieldSportNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSportNameActionPerformed
        // TODO add your andling code here:
    }//GEN-LAST:event_jTextFieldSportNameActionPerformed

    private void jTextFieldHorizontalSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorizontalSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHorizontalSizeActionPerformed

    private void jPanelObstacleIconPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelObstacleIconPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelObstacleIconPropertyChange

    private void jListExistingObstacleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListExistingObstacleMouseClicked
        try {
        if (jListExistingObstacle.getSelectedValue() != null & myController != null) {
            myController.setSelectedCategoryObstacle(jListExistingObstacle.getSelectedValue());
        }
        else if (myController != null) {
            String empty = "";
            myController.setSelectedCategoryObstacle(empty);
        }
        } catch (Exception Ex) {

        }
    }//GEN-LAST:event_jListExistingObstacleMouseClicked

    private void jCheckBoxIsAGameObstacleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCheckBoxIsAGameObstacleFocusLost
        this.myController.setObstacleIsGameObject(this.jCheckBoxIsAGameObstacle.isSelected());
    }//GEN-LAST:event_jCheckBoxIsAGameObstacleFocusLost

    private void jCheckBoxUnlimitedPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUnlimitedPlayerActionPerformed
        this.myController.setPlayerLimit(jCheckBoxUnlimitedPlayer.isSelected());
    }//GEN-LAST:event_jCheckBoxUnlimitedPlayerActionPerformed

    private void jTextFieldStrategyViewerTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStrategyViewerTimeActionPerformed
        this.myController.setTime((long) (Float.parseFloat(this.jTextFieldStrategyViewerTime.getText())*1000));
        this.myController.drawCurrentFrame();
    }//GEN-LAST:event_jTextFieldStrategyViewerTimeActionPerformed

    private void jToggleButtonRotationModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRotationModeActionPerformed
        if (this.jToggleButtonRotationMode.isSelected()) {
            this.myController.initiateRotationMode();
        }
        else {
            this.myController.stopRotationMode();
        }
    }//GEN-LAST:event_jToggleButtonRotationModeActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        // TODO add your handling code here:
        String pathToUse = requestFilePath();
        this.myController.exportStrategy(pathToUse);
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jButtonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedoActionPerformed
        // TODO add your handling code here:
        this.myController.tryRedo();
    }//GEN-LAST:event_jButtonRedoActionPerformed

    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed
        // TODO add your handling code here:
        this.myController.tryUndo();
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jButtonStepForwardTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepForwardTimeActionPerformed
        this.myController.playStepFowardTimeFrame();
    }//GEN-LAST:event_jButtonStepForwardTimeActionPerformed

    private void jButtonStepBackTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepBackTimeActionPerformed
        this.myController.playStepBackTimeFrame();
    }//GEN-LAST:event_jButtonStepBackTimeActionPerformed

    private void jButtonModificationVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificationVisualizeActionPerformed
        Thread t1 = new Thread(new Runnable() {
            public void run() {
        myController.toggleStrategyPlay();
            }
        });
        t1.start();
    }//GEN-LAST:event_jButtonModificationVisualizeActionPerformed

    private void jTextFieldTimeIntervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimeIntervalActionPerformed
        // TODO add your handling code here:
        try {
            this.myController.setIntervalTime(Float.parseFloat(this.jTextFieldTimeInterval.getText()));
        } catch (Exception ex) {
            //pass
        }
    }//GEN-LAST:event_jTextFieldTimeIntervalActionPerformed

    private void jLabelCurrentPositionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelCurrentPositionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCurrentPositionPropertyChange

    private void jButtonNextFrameForImageModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFrameForImageModeActionPerformed
        // TODO add your handling code here:
        this.myController.switchToNextFrame();
    }//GEN-LAST:event_jButtonNextFrameForImageModeActionPerformed

    private void jButtonZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZoomActionPerformed
        this.myController.switchZoomMode();
    }//GEN-LAST:event_jButtonZoomActionPerformed

    private void jButtonSaveStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveStrategyActionPerformed
        this.myController.saveStrategy();        
    }//GEN-LAST:event_jButtonSaveStrategyActionPerformed

    private void jTextFieldVerticalSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVerticalSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVerticalSizeActionPerformed

    private void jButtonNewTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewTeamActionPerformed
        myController.resetPlaceHolderTeam();
    }//GEN-LAST:event_jButtonNewTeamActionPerformed

    private void jButtonSaveTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveTeamActionPerformed
        // save table data to placeHolder
        int nRow = this.jTableTeamPlayers.getRowCount();
        
        String[] tableData = new String[nRow];
        for (int i = 0; i < nRow; i++) {
            // TODO, check if already selected?
            tableData[i] = (String)this.jTableTeamPlayers.getValueAt(i, 0);
        }
        
        this.myController.setTeamPlayerArray(tableData);
        
        
        this.myController.saveTeam();
    }//GEN-LAST:event_jButtonSaveTeamActionPerformed

    private void jButtonDeleteTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteTeamActionPerformed
        this.myController.removeTeam();
    }//GEN-LAST:event_jButtonDeleteTeamActionPerformed

    private void jSpinnerPlayerNumber1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPlayerNumber1StateChanged

        ((DefaultTableModel) this.jTableTeamPlayers.getModel()).setRowCount((int)this.jSpinnerPlayerNumber1.getValue());
        
        
    }//GEN-LAST:event_jSpinnerPlayerNumber1StateChanged

    private void jButtonSavePlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePlayer1ActionPerformed
        this.myController.savePlayer();
    }//GEN-LAST:event_jButtonSavePlayer1ActionPerformed

    private void jButtonNewPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPlayer1ActionPerformed
        myController.resetPlaceHolderPlayer();
    }//GEN-LAST:event_jButtonNewPlayer1ActionPerformed

    private void jTextFieldPlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlayerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlayerNameActionPerformed

    private void jButtonDestroyPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDestroyPlayer1ActionPerformed
        this.myController.removePlayer();
    }//GEN-LAST:event_jButtonDestroyPlayer1ActionPerformed

    private void jButtonDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCategoryActionPerformed
        this.myController.removeCategoryPlayer();
    }//GEN-LAST:event_jButtonDeleteCategoryActionPerformed

    private void jListExistingCategoriesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListExistingCategoriesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListExistingCategoriesPropertyChange

    private void jListExistingCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListExistingCategoriesMouseClicked
        try {
            if (jListExistingCategories.getSelectedValue() != null & myController != null) {
                myController.setSelectedCategoryPlayer(jListExistingCategories.getSelectedValue());
            }
            else if (myController != null) {
                String empty = "";
                myController.setSelectedCategoryPlayer(empty);
            }
        } catch (Exception Ex) {

        }
    }//GEN-LAST:event_jListExistingCategoriesMouseClicked

    private void jListExistingCategoriesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListExistingCategoriesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jListExistingCategoriesFocusLost

    private void jTextFieldCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCategoryNameActionPerformed

    private void jTextFieldCategoryNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCategoryNameFocusLost
        myController.setCategoryPlayerName(this.jTextFieldCategoryName.getText());
    }//GEN-LAST:event_jTextFieldCategoryNameFocusLost

    private void jButtonSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCategoryActionPerformed
        this.myController.saveCategoryPlayer();
    }//GEN-LAST:event_jButtonSaveCategoryActionPerformed

    private void jButtonNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewCategoryActionPerformed
        myController.resetPlaceHolderCategoryPlayer();
    }//GEN-LAST:event_jButtonNewCategoryActionPerformed

    private void jPanelCategoryPicturePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelCategoryPicturePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCategoryPicturePropertyChange

    private void jLabelCategoryPlayerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoryPlayerIconMouseClicked
        double X = evt.getX();
        double Y = evt.getY();
        System.out.println("X: " + X + "Y: " + Y);
    }//GEN-LAST:event_jLabelCategoryPlayerIconMouseClicked

    private void jTabbedPaneRootStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneRootStateChanged
        
        int tabNumber = jTabbedPaneRoot.getSelectedIndex();
        // TODO add your handling code here:
        System.out.println("Changement de panel vers le numéro: " + tabNumber);
        if (tabNumber == 5) {
            this.myController.setStrategySportName((String)this.jComboBoxChooseStrategySport.getSelectedItem());
        }
        else if (tabNumber == 6) {
            int y = this.jPanelStrategyEditorLocation.getHeight() - 2;
            int x = this.jPanelStrategyEditorLocation.getWidth() - 2;
            
            this.myController.setSceneSize(x, y);
            this.myController.setSceneBackground();
            
            this.myController.drawCurrentFrame();
        }
        
        if(tabNumber == 5) //Tab strategy
            this.myController.publishStrategyNames();
    }//GEN-LAST:event_jTabbedPaneRootStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        //System.out.println("changement de taille!");
        if (jTabbedPaneRoot.getSelectedIndex() == 6) {
            int y = this.jPanelStrategyEditorLocation.getHeight() - 2;
            int x = this.jPanelStrategyEditorLocation.getWidth() - 2;
            //System.out.println("Mouse position : X = " + x + " y = " + y);
            
            this.myController.setSceneSize(x, y);
            this.myController.setSceneBackground();            
            this.myController.drawCurrentFrame();
        }
    }//GEN-LAST:event_formComponentResized

    private void jLabelStrategyEditorPictureMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStrategyEditorPictureMouseMoved
        int X = evt.getX();
        int Y = evt.getY();
        //System.out.println("mousemovedevent");
        
        this.myController.mouseMoved(X, Y, mousePressedBool);
        this.myController.displayMouseCoordinates(X, Y);
        //publishMousePosition("X: " + X + "Y: " + Y);
        
        //System.out.println("X: " + X + "Y: " + Y);
    }//GEN-LAST:event_jLabelStrategyEditorPictureMouseMoved

    private void jButtonChooseCategoryPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseCategoryPictureActionPerformed
        myController.getCategoryPlayerImage();
    }//GEN-LAST:event_jButtonChooseCategoryPictureActionPerformed

    private void jTextFieldPlayerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPlayerNameFocusLost
        myController.setPlayerName(this.jTextFieldPlayerName.getText());
    }//GEN-LAST:event_jTextFieldPlayerNameFocusLost

    private void jListExistingPlayersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListExistingPlayersMouseClicked
        try {
            if (jListExistingPlayers.getSelectedValue() != null & myController != null) {
                myController.setSelectedPlayer(jListExistingPlayers.getSelectedValue());
            }
            else if (myController != null) {
                String empty = "";
                myController.setSelectedPlayer(empty);
            }
        } catch (Exception Ex) {

        }
    }//GEN-LAST:event_jListExistingPlayersMouseClicked

    private void jTextFieldTeamNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTeamNameFocusLost
        myController.setTeamName(this.jTextFieldTeamName.getText());
    }//GEN-LAST:event_jTextFieldTeamNameFocusLost

    private void jListExistingTeamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListExistingTeamsMouseClicked
        try {
            if (jListExistingTeams.getSelectedValue() != null & myController != null) {
                myController.setSelectedTeam(jListExistingTeams.getSelectedValue());
            }
            else if (myController != null) {
                String empty = "";
                myController.setSelectedTeam(empty);
            }
        } catch (Exception Ex) {
            System.out.println("something wrong happened while trying to set the teams");

        }
    }//GEN-LAST:event_jListExistingTeamsMouseClicked

    private void jSpinnerSportEquipesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerSportEquipesStateChanged
        ((DefaultTableModel) this.jTableStrategyTeams.getModel()).setRowCount((int)this.jSpinnerSportEquipes.getValue());
        myController.setTeamNumber((int)this.jSpinnerSportEquipes.getValue());
    }//GEN-LAST:event_jSpinnerSportEquipesStateChanged

    private void jListExistingStrategiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListExistingStrategiesMouseClicked
        try {
            if (jListExistingStrategies.getSelectedValue() != null & myController != null) {
                myController.setSelectedStrategy(jListExistingStrategies.getSelectedValue());
                myController.loadSelectedStrategy(); // copies it into the strategyinedition object
                this.jTabbedPaneRoot.setEnabledAt(6, true);
                this.myController.showPreview(this.jPanelStrategyPreview.getWidth()-2, this.jPanelStrategyPreview.getHeight()-2);
            }
        } catch (Exception Ex) {
            System.out.println("An error happened while trying to set the selected strategy!");
         }
    }//GEN-LAST:event_jListExistingStrategiesMouseClicked

    private void jComboBoxPlayerCategoryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxPlayerCategoryPropertyChange

    }//GEN-LAST:event_jComboBoxPlayerCategoryPropertyChange

    private void jComboBoxPlayerCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPlayerCategoryItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPlayerCategoryItemStateChanged

    private void jComboBoxPlayerCategoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxPlayerCategoryFocusLost
        this.myController.setPlayerCategory( (String)this.jComboBoxPlayerCategory.getSelectedItem());
    }//GEN-LAST:event_jComboBoxPlayerCategoryFocusLost

    private void jTableTeamPlayersPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableTeamPlayersPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableTeamPlayersPropertyChange

    private void jToggleButtonRotationModeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonRotationModeStateChanged
        
    }//GEN-LAST:event_jToggleButtonRotationModeStateChanged

    private void jLabelStrategyEditorPictureMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStrategyEditorPictureMousePressed
        int X = evt.getX();
        int Y = evt.getY();
        this.mousePressedBool = true;
        //System.out.println("mousepressedevent");
        this.myController.mouseMoved(X, Y, true);
    }//GEN-LAST:event_jLabelStrategyEditorPictureMousePressed

    private void jLabelStrategyEditorPictureMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStrategyEditorPictureMouseReleased
        int X = evt.getX();
        int Y = evt.getY();
        
        this.mousePressedBool = false;
        
        this.myController.mouseMoved(X, Y, false);
    }//GEN-LAST:event_jLabelStrategyEditorPictureMouseReleased

    private void jPanelStrategyEditorLocationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelStrategyEditorLocationPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelStrategyEditorLocationPropertyChange

    private void jListStrategyPlayersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListStrategyPlayersMouseClicked
        // TODO add your handling code here:
        String playerString = this.jListStrategyPlayers.getSelectedValue();
        this.myController.playerAddMode(playerString);
    }//GEN-LAST:event_jListStrategyPlayersMouseClicked

    private void jLabelStrategyEditorPictureMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStrategyEditorPictureMouseDragged
        int X = evt.getX();
        int Y = evt.getY();
        //System.out.println("mousemovedevent");
        
        this.myController.mouseMoved(X, Y, mousePressedBool);
        this.myController.displayMouseCoordinates(X, Y);
        //publishMousePosition("X: " + X + "Y: " + Y);
        
        //System.out.println("X: " + X + "Y: " + Y);
    }//GEN-LAST:event_jLabelStrategyEditorPictureMouseDragged

    private void jCheckBoxInfoSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxInfoSuppActionPerformed
        this.myController.setShowStringOption(this.jCheckBoxInfoSupp.isSelected());
    }//GEN-LAST:event_jCheckBoxInfoSuppActionPerformed

    private void jListTypeModificationTypeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListTypeModificationTypeValueChanged
        // TODO add your handling code here:
        try {
            this.myController.setModificationMode(this.jListTypeModificationType.getSelectedValue());
        } catch (Exception Ex) {
            System.out.println("mmmmm");
        }
    }//GEN-LAST:event_jListTypeModificationTypeValueChanged

    private void jTextFieldObjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObjectNameActionPerformed

    private void jTextFieldObjectNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObjectNameFocusLost
        myController.setCategoryObstacleName(this.jTextFieldObjectName.getText());        
    }//GEN-LAST:event_jTextFieldObjectNameFocusLost

    private void jTextFieldObjectDimensionXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObjectDimensionXFocusLost
        myController.setCategoryObstacleHorizontalSize(Float.parseFloat(this.jTextFieldObjectDimensionX.getText()));
    }//GEN-LAST:event_jTextFieldObjectDimensionXFocusLost

    private void jTextFieldObjectDimensionYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObjectDimensionYFocusLost
        myController.setCategoryObstacleVerticalSize(Float.parseFloat(this.jTextFieldObjectDimensionY.getText()));
    }//GEN-LAST:event_jTextFieldObjectDimensionYFocusLost

    private void jTextFieldChooseStrategyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChooseStrategyNameFocusLost
        // TODO add your handling code here:
        myController.setStrategyName(this.jTextFieldChooseStrategyName.getText());
    }//GEN-LAST:event_jTextFieldChooseStrategyNameFocusLost

    private void jSliderStrategyTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderStrategyTimeMouseReleased
   
        this.myController.setTimeFromSlider(jSliderStrategyTime.getValue(), jSliderStrategyTime.getMaximum());
        
    }//GEN-LAST:event_jSliderStrategyTimeMouseReleased

    private void jButtonRewindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRewindActionPerformed
        // TODO add your handling code here:
        this.myController.setTime(0);
        this.myController.drawCurrentFrame();
    }//GEN-LAST:event_jButtonRewindActionPerformed

    private void jTextFieldExportSizeXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldExportSizeXFocusLost
        // TODO add your handling code here:
        try {
        this.myController.setExportSizeX(Integer.parseInt(this.jTextFieldExportSizeX.getText()));
        } catch (Exception e) {
                // badly formatted, do nothing
                }
    }//GEN-LAST:event_jTextFieldExportSizeXFocusLost

    private void jTextFieldExportSizeYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldExportSizeYFocusLost
        // TODO add your handling code here:
        try {
        this.myController.setExportSizeY(Integer.parseInt(this.jTextFieldExportSizeY.getText()));
        } catch (Exception e) {
                // badly formatted, do nothing
                }
    }//GEN-LAST:event_jTextFieldExportSizeYFocusLost

    private void jButtonSwitchToRemovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSwitchToRemovalActionPerformed
        this.myController.toggleRemovalMode();
    }//GEN-LAST:event_jButtonSwitchToRemovalActionPerformed

    private void jListStrategyObjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListStrategyObjectsMouseClicked
        // TODO add your handling code here:
        String objectString = this.jListStrategyObjects.getSelectedValue();
        this.myController.objectAddMode(objectString);
    }//GEN-LAST:event_jListStrategyObjectsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChooseCategoryPicture;
    private javax.swing.JButton jButtonChooseObstaclePicture;
    private javax.swing.JButton jButtonCreateStrategy;
    private javax.swing.JButton jButtonDeleteCategory;
    private javax.swing.JButton jButtonDeleteGameObstacle;
    private javax.swing.JButton jButtonDeleteStrategy;
    private javax.swing.JButton jButtonDeleteTeam;
    private javax.swing.JButton jButtonDestroyPlayer1;
    private javax.swing.JButton jButtonDestroySelectedSport;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonLoadFieldImage;
    private javax.swing.JButton jButtonModificationVisualize;
    private javax.swing.JButton jButtonNewCategory;
    private javax.swing.JButton jButtonNewGameObstacle;
    private javax.swing.JButton jButtonNewPlayer1;
    private javax.swing.JButton jButtonNewSport;
    private javax.swing.JButton jButtonNewTeam;
    private javax.swing.JButton jButtonNextFrameForImageMode;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonRewind;
    private javax.swing.JButton jButtonSaveCategory;
    private javax.swing.JButton jButtonSaveGameObstacle;
    private javax.swing.JButton jButtonSavePlayer1;
    private javax.swing.JButton jButtonSaveSport;
    private javax.swing.JButton jButtonSaveStrategy;
    private javax.swing.JButton jButtonSaveTeam;
    private javax.swing.JButton jButtonStepBackTime;
    private javax.swing.JButton jButtonStepForwardTime;
    private javax.swing.JButton jButtonSwitchToRemoval;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JButton jButtonZoom;
    private javax.swing.JCheckBox jCheckBoxInfoSupp;
    private javax.swing.JCheckBox jCheckBoxIsAGameObstacle;
    private javax.swing.JCheckBox jCheckBoxUnlimitedPlayer;
    private javax.swing.JComboBox<String> jComboBoxChooseStrategySport;
    private javax.swing.JComboBox<String> jComboBoxPlayerCategory;
    private javax.swing.JComboBox<String> jComboBoxStrategyTeam;
    private javax.swing.JComboBox<String> jComboBoxTeamPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAvailableStrategies;
    private javax.swing.JLabel jLabelCategoryImage;
    private javax.swing.JLabel jLabelCategoryInformation;
    private javax.swing.JLabel jLabelCategoryName;
    private javax.swing.JLabel jLabelCategoryObstacleIcon;
    private javax.swing.JLabel jLabelCategoryPlayerIcon;
    private javax.swing.JLabel jLabelChooseNameStrategy;
    private javax.swing.JLabel jLabelChooseSport;
    private javax.swing.JLabel jLabelChosenObstacleImage;
    private javax.swing.JLabel jLabelCurrentPosition;
    private javax.swing.JLabel jLabelCursorPosition;
    private javax.swing.JLabel jLabelExistingCategories;
    private javax.swing.JLabel jLabelExistingObjects;
    private javax.swing.JLabel jLabelExistingSportTitle;
    private javax.swing.JLabel jLabelExportationSize;
    private javax.swing.JLabel jLabelFieldSize;
    private javax.swing.JLabel jLabelFieldText;
    private javax.swing.JLabel jLabelModificationModeToSelect;
    private javax.swing.JLabel jLabelObjectsToSelect;
    private javax.swing.JLabel jLabelObstacleInformation;
    private javax.swing.JLabel jLabelObstacleName;
    private javax.swing.JLabel jLabelObstacleSize;
    private javax.swing.JLabel jLabelPlayerNumber;
    private javax.swing.JLabel jLabelPlayerNumber1;
    private javax.swing.JLabel jLabelPlayerToSelect;
    private javax.swing.JLabel jLabelPlayersTableTitle;
    private javax.swing.JLabel jLabelSportField;
    private javax.swing.JLabel jLabelSportName;
    private javax.swing.JLabel jLabelStrategyCreationZoneTitle;
    private javax.swing.JLabel jLabelStrategyEditorPicture;
    private javax.swing.JLabel jLabelStrategyPreview;
    private javax.swing.JLabel jLabelStrategyViewerTime;
    private javax.swing.JLabel jLabelTimeInterval;
    private javax.swing.JList<String> jListExistingCategories;
    private javax.swing.JList<String> jListExistingObstacle;
    private javax.swing.JList<String> jListExistingPlayers;
    private javax.swing.JList<String> jListExistingSports;
    private javax.swing.JList<String> jListExistingStrategies;
    private javax.swing.JList<String> jListExistingTeams;
    private javax.swing.JList<String> jListStrategyObjects;
    private javax.swing.JList<String> jListStrategyPlayers;
    private javax.swing.JList<String> jListTypeModificationType;
    private javax.swing.JPanel jPanelCategories;
    private javax.swing.JPanel jPanelCategoryPicture;
    private javax.swing.JPanel jPanelCreateLoadStrategy;
    private javax.swing.JPanel jPanelObstacle;
    private javax.swing.JPanel jPanelObstacleIcon;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JPanel jPanelSport;
    private javax.swing.JPanel jPanelSportFieldViewer;
    private javax.swing.JPanel jPanelStrategyEditor;
    private javax.swing.JPanel jPanelStrategyEditorLocation;
    private javax.swing.JPanel jPanelStrategyPreview;
    private javax.swing.JPanel jPanelTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPaneModificationMode;
    private javax.swing.JScrollPane jScrollPaneObjectSelection;
    private javax.swing.JScrollPane jScrollPanePlayerSelection;
    private javax.swing.JScrollPane jScrollPanePlayers;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSlider jSliderStrategyTime;
    private javax.swing.JSpinner jSpinnerPlayerNumber1;
    private javax.swing.JSpinner jSpinnerSportEquipes;
    private javax.swing.JSpinner jSpinnerSportPlayerMax;
    private javax.swing.JTabbedPane jTabbedPaneRoot;
    private javax.swing.JTable jTableStrategyTeams;
    private javax.swing.JTable jTableTeamPlayers;
    private javax.swing.JTextField jTextFieldCategoryName;
    private javax.swing.JTextField jTextFieldChooseStrategyName;
    private javax.swing.JTextField jTextFieldExportSizeX;
    private javax.swing.JTextField jTextFieldExportSizeY;
    private javax.swing.JTextField jTextFieldFieldUnits;
    private javax.swing.JTextField jTextFieldHorizontalSize;
    private javax.swing.JTextField jTextFieldObjectDimensionX;
    private javax.swing.JTextField jTextFieldObjectDimensionY;
    private javax.swing.JTextField jTextFieldObjectName;
    private javax.swing.JTextField jTextFieldPlayerName;
    private javax.swing.JTextField jTextFieldSportName;
    private javax.swing.JTextField jTextFieldStrategyViewerTime;
    private javax.swing.JTextField jTextFieldTeamName;
    private javax.swing.JTextField jTextFieldTimeInterval;
    private javax.swing.JTextField jTextFieldVerticalSize;
    private javax.swing.JToggleButton jToggleButtonRotationMode;
    // End of variables declaration//GEN-END:variables
}
