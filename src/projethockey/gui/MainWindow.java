package projethockey.gui;
import java.awt.Color;
import java.awt.image.BufferedImage;
import projethockey.domain.Controller;
import projethockey.domain.sportSubscribable;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import projethockey.domain.projetHockeyInterface;

/**
 *
 * @author znuxor
 */
public class MainWindow extends javax.swing.JFrame implements projetHockeyInterface {
    /**
     * Creates new form MainWindow
     */

    private Controller myController;

    public MainWindow() {
        initComponents();

        // A reference to the controller is given.

        // subscription of every item that needs to be subscriber here.
    }

    public void setController(Controller theController) {
        this.myController = theController;
    }

    public void publishExistingSports(String[] plistSportsNames) {
        this.jListExistingSports.setListData(plistSportsNames);
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
        this.jSpinnerPlayerNumber.setValue(playerNumber);
        ((DefaultTableModel) this.tableSportPlayers.getModel()).setRowCount(playerNumber);
    }
    public void publishObjectTypeNumber(int objectTypeNumber){
        this.jSpinnerObjectTypeNumber.setValue(objectTypeNumber);
        ((DefaultTableModel) this.jTableSportsItems.getModel()).setRowCount(objectTypeNumber);
    }

    public void publishSportIsUnlimited(boolean isUnlimited){
        this.jCheckBoxUnlimitedPlayer.setSelected(isUnlimited);
    }

    public void publishPlayers() {

    }

    public void publishPlayerCategories(ArrayList<String> pPlayerCategoryList) {
        javax.swing.JComboBox sportCellComboBox = new javax.swing.JComboBox();
        javax.swing.table.TableColumn categoryColumn = tableSportPlayers.getColumnModel().getColumn(0);
        // Dummy items, please remove later
        for (String aCategory : pPlayerCategoryList) {
            sportCellComboBox.addItem(aCategory);
        }
        sportCellComboBox.addItem("Frontier Pierrien");
        sportCellComboBox.addItem("Ailier Picardier");
        sportCellComboBox.addItem("Gardien Röckenfelleur");
        sportCellComboBox.addItem("Lutteur Avant-gardissien");
        categoryColumn.setCellEditor(new javax.swing.DefaultCellEditor(sportCellComboBox));

    }

    public void publishObjects() {

    }

    public void publishFieldPicture(BufferedImage thePicture) {

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
        //JLabel myIconLabel = new JLabel(fieldIcon);
        //System.out.println(thePicture.getHeight());
        //System.out.println(thePicture.getWidth());
        //myIconLabel.s
        //this.jPanelSport.add(myIconLabel);
        //this.jPanelSportFieldViewer.paintComponents(this.jPanelSportFieldViewer.getGraphics());
        //this.jPanelSportFieldViewer.getGraphics().drawImage(thePicture, 0, 0, null);
        //this.jPanelSport.repaint();


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

    public void publishCategoryPlayerDimensions(Float pdimX, Float pdimY){
        this.jTextFieldCategorySizeHorizontal.setText(pdimX.toString());
        this.jTextFieldCategorySizeVertical.setText(pdimY.toString());
    }

    public void publishCategoryPlayerName(String pCategoryPlayerName) {
        this.jTextFieldCategoryName.setText(pCategoryPlayerName);
    }

    public void publishExistingCategoryPlayer(String[] plistCategoryPlayer) {
        this.jListExistingCategories.setListData(plistCategoryPlayer);
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
        this.jTextFieldObstacleSizeHorizontal.setText(pdimX.toString());
        this.jTextFieldObstacleSizeVertical.setText(pdimY.toString());
    }

    public void publishCategoryObstacleName(String pCategoryObstacleName) {
        this.jTextFieldObstacleName.setText(pCategoryObstacleName);
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
        this.jTextFieldStrategyName.setText(pStrategyName);
    }
    
    public void publishExistingStrategies(String[] plistStrategy) {
        this.jListExistingStrategy.setListData(plistStrategy);
    }
    
    public void publishScene(BufferedImage pSceneImage) {
        this.jLabelStrategyEditorPicture.setIcon(new ImageIcon(pSceneImage));
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

        jTabbedPanePlayerCategory = new javax.swing.JTabbedPane();
        jPanelCategories = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jButtonNewCategory = new javax.swing.JButton();
        jButtonSaveCategory = new javax.swing.JButton();
        jLabelCategoryImage = new javax.swing.JLabel();
        jPanelCategoryPicture = new javax.swing.JPanel();
        jLabelCategoryPlayerIcon = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabelCategoryOnTerrain = new javax.swing.JLabel();
        jPanelCategoryOnTerrain = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCategoryName = new javax.swing.JLabel();
        jLabelCategorySize = new javax.swing.JLabel();
        jLabelCategoryUnits = new javax.swing.JLabel();
        jTextFieldCategoryName = new javax.swing.JTextField();
        jTextFieldCategorySizeHorizontal = new javax.swing.JTextField();
        jTextFieldCategorySizeVertical = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListExistingCategories = new javax.swing.JList<>();
        jLabelExistingCategories = new javax.swing.JLabel();
        jButtonDeleteCategory = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanelObstacle = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonNewGameObstacle = new javax.swing.JButton();
        jButtonSaveGameObstacle = new javax.swing.JButton();
        jLabelObstacleInformation = new javax.swing.JLabel();
        jLabelObstacleName = new javax.swing.JLabel();
        jLabelObstacleSize = new javax.swing.JLabel();
        jLabelObstacleUnits = new javax.swing.JLabel();
        jLabelChosenObstacleImage = new javax.swing.JLabel();
        jLabelObstacleOnTerrain = new javax.swing.JLabel();
        jPanelObstacleOnTerrain = new javax.swing.JPanel();
        jPanelObstacleIcon = new javax.swing.JPanel();
        jLabelCategoryObstacleIcon = new javax.swing.JLabel();
        jTextFieldObstacleName = new javax.swing.JTextField();
        jTextFieldObstacleSizeHorizontal = new javax.swing.JTextField();
        jTextFieldObstacleSizeVertical = new javax.swing.JTextField();
        jButtonChooseObstaclePicture = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jCheckBoxIsAGameObstacle = new javax.swing.JCheckBox();
        jLabelExistingObjects = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListExistingObstacle = new javax.swing.JList<>();
        jButtonDeleteGameObstacle = new javax.swing.JButton();
        jPanelCreateLoadStrategy = new javax.swing.JPanel();
        jButtonCreateStrategy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListExistingStrategy = new javax.swing.JList<>();
        jButtonLoadStrategy = new javax.swing.JButton();
        jLabelChooseSport = new javax.swing.JLabel();
        jLabelChooseNameStrategy = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabelStrategyCreationZoneTitle = new javax.swing.JLabel();
        jLabelAvailableStrategies = new javax.swing.JLabel();
        jComboBoxChooseStrategySport = new javax.swing.JComboBox<>();
        jButtonDeleteStrategy = new javax.swing.JButton();
        jTextFieldChooseStrategyName = new javax.swing.JTextField();
        jPanelStrategyEditor = new javax.swing.JPanel();
        jScrollPaneModificationMode = new javax.swing.JScrollPane();
        jListTypeModificationType = new javax.swing.JList<>();
        jScrollPanePlayerSelection = new javax.swing.JScrollPane();
        jListPlayers = new javax.swing.JList<>();
        jScrollPaneObjectSelection = new javax.swing.JScrollPane();
        jListObjects = new javax.swing.JList<>();
        jLabelObjectsToSelect = new javax.swing.JLabel();
        jLabelStrategyName = new javax.swing.JLabel();
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
        jTextFieldStrategyName = new javax.swing.JTextField();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();
        jButtonExport = new javax.swing.JButton();
        jPanelStrategyEditorLocation = new javax.swing.JPanel();
        jLabelStrategyEditorPicture = new javax.swing.JLabel();
        jLabelSportsUnit = new javax.swing.JLabel();
        jLabelPlayBackSpeedTitle = new javax.swing.JLabel();
        jToggleButtonRotationMode = new javax.swing.JToggleButton();
        jTextFieldStrategyViewerTime = new javax.swing.JTextField();
        jTextFieldPlaybackSpeed = new javax.swing.JTextField();
        jLabelStrategyViewerTime = new javax.swing.JLabel();
        jPanelPlayer = new javax.swing.JPanel();
        jButtonNewPlayer1 = new javax.swing.JButton();
        jButtonSavePlayer1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextFieldPlayerCategory = new javax.swing.JTextField();
        jTextFieldPlayerName = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextFieldPlayerTeam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonDestroyPlayer1 = new javax.swing.JButton();
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
        jScrollPanePlayers = new javax.swing.JScrollPane();
        tableSportPlayers = new javax.swing.JTable();
        jLabelPlayerNumber = new javax.swing.JLabel();
        jLabelPlayersTableTitle = new javax.swing.JLabel();
        jSpinnerPlayerNumber = new javax.swing.JSpinner();
        jScrollPaneSportObjects = new javax.swing.JScrollPane();
        jTableSportsItems = new javax.swing.JTable();
        jSpinnerObjectTypeNumber = new javax.swing.JSpinner();
        jLabelObjectTypeNumber = new javax.swing.JLabel();
        jLabelObjectTableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListExistingSports = new javax.swing.JList<>();
        jButtonDestroySelectedSport = new javax.swing.JButton();
        jLabelExistingSportTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFieldUnits = new javax.swing.JTextField();
        jCheckBoxUnlimitedPlayer = new javax.swing.JCheckBox();
        jButtonRefreshSport = new javax.swing.JButton();
        jPanelTeam = new javax.swing.JPanel();
        jButtonNewTeam = new javax.swing.JButton();
        jButtonSaveTeam = new javax.swing.JButton();
        jTextFieldTeamName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jListTeam = new java.awt.List();
        jLabel5 = new javax.swing.JLabel();
        jButtonTeamDelete = new javax.swing.JButton();
        jLabelPlayerNumber1 = new javax.swing.JLabel();
        jSpinnerPlayerNumber1 = new javax.swing.JSpinner();
        jCheckBoxUnlimitedPlayer1 = new javax.swing.JCheckBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logiciel de stratégie");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setSize(new java.awt.Dimension(1024, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPanePlayerCategory.setFocusable(false);
        jTabbedPanePlayerCategory.setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanelCategories.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPanelCategories.add(jSeparator8, gridBagConstraints);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 572;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 12, 0, 0);
        jPanelCategories.add(jSeparator9, gridBagConstraints);

        jButtonNewCategory.setText("Nouveau");
        jButtonNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewCategoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCategories.add(jButtonSaveCategory, gridBagConstraints);

        jLabelCategoryImage.setText("Image de catégorie choisie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelCategories.add(jLabelCategoryImage, gridBagConstraints);

        jPanelCategoryPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCategoryPicture.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelCategoryPicture.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanelCategoryPicture.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelCategoryPicturePropertyChange(evt);
            }
        });

        jLabelCategoryPlayerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCategoryPlayerIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoryPictureLayout = new javax.swing.GroupLayout(jPanelCategoryPicture);
        jPanelCategoryPicture.setLayout(jPanelCategoryPictureLayout);
        jPanelCategoryPictureLayout.setHorizontalGroup(
            jPanelCategoryPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoryPictureLayout.createSequentialGroup()
                .addComponent(jLabelCategoryPlayerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 440, Short.MAX_VALUE))
        );
        jPanelCategoryPictureLayout.setVerticalGroup(
            jPanelCategoryPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoryPictureLayout.createSequentialGroup()
                .addComponent(jLabelCategoryPlayerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 100, 10);
        jPanelCategories.add(jPanelCategoryPicture, gridBagConstraints);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 572;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPanelCategories.add(jSeparator10, gridBagConstraints);

        jLabelCategoryOnTerrain.setText("Image telle que vue sur le terrain");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelCategories.add(jLabelCategoryOnTerrain, gridBagConstraints);

        jPanelCategoryOnTerrain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCategoryOnTerrain.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelCategoryOnTerrain.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanelCategoryOnTerrain.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelCategoryOnTerrainPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoryOnTerrainLayout = new javax.swing.GroupLayout(jPanelCategoryOnTerrain);
        jPanelCategoryOnTerrain.setLayout(jPanelCategoryOnTerrainLayout);
        jPanelCategoryOnTerrainLayout.setHorizontalGroup(
            jPanelCategoryOnTerrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        jPanelCategoryOnTerrainLayout.setVerticalGroup(
            jPanelCategoryOnTerrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 100, 10);
        jPanelCategories.add(jPanelCategoryOnTerrain, gridBagConstraints);

        jLabel3.setText("Informations sur la catégorie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 25, 0, 0);
        jPanelCategories.add(jLabel3, gridBagConstraints);

        jLabelCategoryName.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 25, 0, 0);
        jPanelCategories.add(jLabelCategoryName, gridBagConstraints);

        jLabelCategorySize.setText("Taille:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 25, 0, 0);
        jPanelCategories.add(jLabelCategorySize, gridBagConstraints);

        jLabelCategoryUnits.setText("(unités):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 0, 0);
        jPanelCategories.add(jLabelCategoryUnits, gridBagConstraints);

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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 0);
        jPanelCategories.add(jTextFieldCategoryName, gridBagConstraints);

        jTextFieldCategorySizeHorizontal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCategorySizeHorizontalFocusLost(evt);
            }
        });
        jTextFieldCategorySizeHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCategorySizeHorizontalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 0);
        jPanelCategories.add(jTextFieldCategorySizeHorizontal, gridBagConstraints);

        jTextFieldCategorySizeVertical.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCategorySizeVerticalFocusLost(evt);
            }
        });
        jTextFieldCategorySizeVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCategorySizeVerticalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 0);
        jPanelCategories.add(jTextFieldCategorySizeVertical, gridBagConstraints);

        jListExistingCategories.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Frontier Pierrien", "Ailier Picardier", "Gardien Röckenfelleur", "Lutteur Avant-Gardissien" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 146;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelCategories.add(jScrollPane4, gridBagConstraints);

        jLabelExistingCategories.setText("Catégories existantes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanelCategories.add(jLabelExistingCategories, gridBagConstraints);

        jButtonDeleteCategory.setText("Supprimer");
        jButtonDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCategoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        jPanelCategories.add(jButtonDeleteCategory, gridBagConstraints);

        jScrollPane6.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanelCategories.add(jScrollPane6, gridBagConstraints);

        jTabbedPanePlayerCategory.addTab("Catégories", jPanelCategories);

        jPanelObstacle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelObstacle.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 129, 1629, 1));

        jButtonNewGameObstacle.setText("Nouveau");
        jButtonNewGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameObstacleActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jButtonNewGameObstacle, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 111, 99));

        jButtonSaveGameObstacle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveGameObstacle.setText("Enregistrer");
        jButtonSaveGameObstacle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveGameObstacle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGameObstacleActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jButtonSaveGameObstacle, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 12, 120, 99));

        jLabelObstacleInformation.setText("Informations sur l'objet");
        jPanelObstacle.add(jLabelObstacleInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 177, -1, -1));

        jLabelObstacleName.setText("Nom:");
        jPanelObstacle.add(jLabelObstacleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 212, -1, -1));

        jLabelObstacleSize.setText("Taille");
        jPanelObstacle.add(jLabelObstacleSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 239, -1, -1));

        jLabelObstacleUnits.setText("(unités):");
        jPanelObstacle.add(jLabelObstacleUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 239, -1, -1));

        jLabelChosenObstacleImage.setText("Image d'objet choisi");
        jPanelObstacle.add(jLabelChosenObstacleImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 191, -1, 24));

        jLabelObstacleOnTerrain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObstacleOnTerrain.setText("Objet tel que vu sur le terrain");
        jLabelObstacleOnTerrain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelObstacle.add(jLabelObstacleOnTerrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 195, 278, -1));

        jPanelObstacleOnTerrain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelObstacleOnTerrain.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelObstacleOnTerrainPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelObstacleOnTerrainLayout = new javax.swing.GroupLayout(jPanelObstacleOnTerrain);
        jPanelObstacleOnTerrain.setLayout(jPanelObstacleOnTerrainLayout);
        jPanelObstacleOnTerrainLayout.setHorizontalGroup(
            jPanelObstacleOnTerrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        jPanelObstacleOnTerrainLayout.setVerticalGroup(
            jPanelObstacleOnTerrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jPanelObstacle.add(jPanelObstacleOnTerrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 222, -1, -1));

        jPanelObstacleIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelObstacleIcon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelObstacleIconPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelObstacleIconLayout = new javax.swing.GroupLayout(jPanelObstacleIcon);
        jPanelObstacleIcon.setLayout(jPanelObstacleIconLayout);
        jPanelObstacleIconLayout.setHorizontalGroup(
            jPanelObstacleIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategoryObstacleIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        jPanelObstacleIconLayout.setVerticalGroup(
            jPanelObstacleIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategoryObstacleIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanelObstacle.add(jPanelObstacleIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 221, -1, -1));

        jTextFieldObstacleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldObstacleNameFocusLost(evt);
            }
        });
        jTextFieldObstacleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObstacleNameActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jTextFieldObstacleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 210, 179, -1));

        jTextFieldObstacleSizeHorizontal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldObstacleSizeHorizontalFocusLost(evt);
            }
        });
        jTextFieldObstacleSizeHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObstacleSizeHorizontalActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jTextFieldObstacleSizeHorizontal, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 237, 53, -1));

        jTextFieldObstacleSizeVertical.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldObstacleSizeVerticalFocusLost(evt);
            }
        });
        jTextFieldObstacleSizeVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObstacleSizeVerticalActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jTextFieldObstacleSizeVertical, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 237, 53, -1));

        jButtonChooseObstaclePicture.setText("Choisir image...");
        jButtonChooseObstaclePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseObstaclePictureActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jButtonChooseObstaclePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 518, -1, -1));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelObstacle.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 148, 51, 477));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelObstacle.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 148, 27, 477));

        jCheckBoxIsAGameObstacle.setText("Objet de jeu? (association à un joueur possible)");
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
        jPanelObstacle.add(jCheckBoxIsAGameObstacle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 285, -1, -1));
        jCheckBoxIsAGameObstacle.getAccessibleContext().setAccessibleDescription("");

        jLabelExistingObjects.setText("Objets existants");
        jPanelObstacle.add(jLabelExistingObjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 12, -1, -1));

        jListExistingObstacle.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Gourde-ballon", "Lure", "Objet parfaitement générique", "Oblongoïde" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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

        jPanelObstacle.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 33, -1, 78));

        jButtonDeleteGameObstacle.setText("Supprimer");
        jButtonDeleteGameObstacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteGameObstacleActionPerformed(evt);
            }
        });
        jPanelObstacle.add(jButtonDeleteGameObstacle, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 33, -1, -1));

        jTabbedPanePlayerCategory.addTab("Objets de jeu", jPanelObstacle);

        jPanelCreateLoadStrategy.setLayout(new java.awt.GridBagLayout());

        jButtonCreateStrategy.setText("Créer une nouvelle stratégie");
        jButtonCreateStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jButtonCreateStrategy, gridBagConstraints);

        jListExistingStrategy.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tour du chapeau", "Stratégie des Oursons" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListExistingStrategy);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 188;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelCreateLoadStrategy.add(jScrollPane2, gridBagConstraints);

        jButtonLoadStrategy.setText("Charger une stratégie");
        jButtonLoadStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jButtonLoadStrategy, gridBagConstraints);

        jLabelChooseSport.setText("Sport:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelChooseSport, gridBagConstraints);

        jLabelChooseNameStrategy.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelChooseNameStrategy, gridBagConstraints);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 349;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jSeparator11, gridBagConstraints);

        jLabelStrategyCreationZoneTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelStrategyCreationZoneTitle.setText("Création de stratégie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jLabelStrategyCreationZoneTitle, gridBagConstraints);

        jLabelAvailableStrategies.setText("Stratégies disponibles");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 30, 0, 0);
        jPanelCreateLoadStrategy.add(jLabelAvailableStrategies, gridBagConstraints);

        jComboBoxChooseStrategySport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hockey", "Hockey Spécial", "Soccer" }));
        jComboBoxChooseStrategySport.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxChooseStrategySportFocusLost(evt);
            }
        });
        jComboBoxChooseStrategySport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChooseStrategySportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jComboBoxChooseStrategySport, gridBagConstraints);

        jButtonDeleteStrategy.setText("Supprimer");
        jButtonDeleteStrategy.setEnabled(false);
        jButtonDeleteStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanelCreateLoadStrategy.add(jButtonDeleteStrategy, gridBagConstraints);

        jTextFieldChooseStrategyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldChooseStrategyNameFocusLost(evt);
            }
        });
        jTextFieldChooseStrategyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldChooseStrategyNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 187;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelCreateLoadStrategy.add(jTextFieldChooseStrategyName, gridBagConstraints);

        jTabbedPanePlayerCategory.addTab("Créer/charger stratégie", jPanelCreateLoadStrategy);

        jPanelStrategyEditor.setRequestFocusEnabled(false);
        jPanelStrategyEditor.setLayout(new java.awt.GridBagLayout());

        jListTypeModificationType.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Image par image", "Temps réel" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListTypeModificationType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListTypeModificationTypePropertyChange(evt);
            }
        });
        jScrollPaneModificationMode.setViewportView(jListTypeModificationType);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanelStrategyEditor.add(jScrollPaneModificationMode, gridBagConstraints);

        jListPlayers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Joueur1", "Joueur2", "Joueur3", "Joueur4", "Joueur5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListPlayers.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListPlayersPropertyChange(evt);
            }
        });
        jScrollPanePlayerSelection.setViewportView(jListPlayers);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.ipady = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanelStrategyEditor.add(jScrollPanePlayerSelection, gridBagConstraints);

        jListObjects.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Plot", "Ballon" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListObjects.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListObjectsPropertyChange(evt);
            }
        });
        jScrollPaneObjectSelection.setViewportView(jListObjects);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.ipady = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanelStrategyEditor.add(jScrollPaneObjectSelection, gridBagConstraints);

        jLabelObjectsToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObjectsToSelect.setText("Objets");
        jLabelObjectsToSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanelStrategyEditor.add(jLabelObjectsToSelect, gridBagConstraints);

        jLabelStrategyName.setText("Nom de la stratégie:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanelStrategyEditor.add(jLabelStrategyName, gridBagConstraints);

        jLabelPlayerToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayerToSelect.setText("Joueurs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 115;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanelStrategyEditor.add(jLabelPlayerToSelect, gridBagConstraints);

        jLabelModificationModeToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModificationModeToSelect.setText("Mode");
        jLabelModificationModeToSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanelStrategyEditor.add(jLabelModificationModeToSelect, gridBagConstraints);

        jButtonSaveStrategy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveStrategy.setText("Enregistrer");
        jButtonSaveStrategy.setAlignmentY(5.0F);
        jButtonSaveStrategy.setEnabled(false);
        jButtonSaveStrategy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveStrategy.setIconTextGap(2);
        jButtonSaveStrategy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveStrategyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonSaveStrategy, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanelStrategyEditor.add(jSeparator2, gridBagConstraints);

        jButtonZoom.setText("Zoom");
        jButtonZoom.setToolTipText("Sélectionner la zone de zoom désirée avec deux points");
        jButtonZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZoomActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
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
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 1, 0, 0);
        jPanelStrategyEditor.add(jButtonNextFrameForImageMode, gridBagConstraints);

        jLabelCursorPosition.setText("position du curseur: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelStrategyEditor.add(jLabelCursorPosition, gridBagConstraints);

        jLabelCurrentPosition.setText("positionActuelle");
        jLabelCurrentPosition.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelCurrentPositionPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelCurrentPosition, gridBagConstraints);

        jTextFieldTimeInterval.setText("1s");
        jTextFieldTimeInterval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimeIntervalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jTextFieldTimeInterval, gridBagConstraints);

        jLabelTimeInterval.setText("Intervalle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanelStrategyEditor.add(jLabelTimeInterval, gridBagConstraints);

        jButtonModificationVisualize.setText("Visualiser");
        jButtonModificationVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificationVisualizeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonModificationVisualize, gridBagConstraints);

        jButtonStepBackTime.setText("Reculer");
        jButtonStepBackTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepBackTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonStepBackTime, gridBagConstraints);

        jButtonStepForwardTime.setText("Avancer");
        jButtonStepForwardTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepForwardTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        jPanelStrategyEditor.add(jButtonStepForwardTime, gridBagConstraints);

        jTextFieldStrategyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStrategyNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 131;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanelStrategyEditor.add(jTextFieldStrategyName, gridBagConstraints);

        jButtonUndo.setText("Annuler");
        jButtonUndo.setEnabled(false);
        jButtonUndo.setMaximumSize(new java.awt.Dimension(73, 25));
        jButtonUndo.setMinimumSize(new java.awt.Dimension(73, 25));
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        jPanelStrategyEditor.add(jButtonUndo, gridBagConstraints);

        jButtonRedo.setText("Refaire");
        jButtonRedo.setEnabled(false);
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        jPanelStrategyEditor.add(jButtonRedo, gridBagConstraints);

        jButtonExport.setText("Exporter");
        jButtonExport.setEnabled(false);
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 87;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jButtonExport, gridBagConstraints);

        jPanelStrategyEditorLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelStrategyEditorLocation.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelStrategyEditorLocationPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelStrategyEditorLocationLayout = new javax.swing.GroupLayout(jPanelStrategyEditorLocation);
        jPanelStrategyEditorLocation.setLayout(jPanelStrategyEditorLocationLayout);
        jPanelStrategyEditorLocationLayout.setHorizontalGroup(
            jPanelStrategyEditorLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelStrategyEditorPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 1666, Short.MAX_VALUE)
        );
        jPanelStrategyEditorLocationLayout.setVerticalGroup(
            jPanelStrategyEditorLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelStrategyEditorPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1219;
        gridBagConstraints.ipady = 377;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jPanelStrategyEditorLocation, gridBagConstraints);

        jLabelSportsUnit.setText("Unités");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        jPanelStrategyEditor.add(jLabelSportsUnit, gridBagConstraints);

        jLabelPlayBackSpeedTitle.setText("Vitesse de jeu: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelPlayBackSpeedTitle, gridBagConstraints);

        jToggleButtonRotationMode.setText("mode rotation");
        jToggleButtonRotationMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRotationModeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jToggleButtonRotationMode, gridBagConstraints);

        jTextFieldStrategyViewerTime.setText("0");
        jTextFieldStrategyViewerTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStrategyViewerTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jTextFieldStrategyViewerTime, gridBagConstraints);

        jTextFieldPlaybackSpeed.setToolTipText("Multiple de la vitessse normale, de 0.01 à 10");
        jTextFieldPlaybackSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlaybackSpeedActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanelStrategyEditor.add(jTextFieldPlaybackSpeed, gridBagConstraints);

        jLabelStrategyViewerTime.setText("Temps (s):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelStrategyEditor.add(jLabelStrategyViewerTime, gridBagConstraints);

        jTabbedPanePlayerCategory.addTab("Édition et visualisation de stratégie", jPanelStrategyEditor);

        jPanelPlayer.setLayout(new java.awt.GridBagLayout());

        jButtonNewPlayer1.setText("Nouveau");
        jButtonNewPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPlayer1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 34, 0, 0);
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 21, 0, 0);
        jPanelPlayer.add(jButtonSavePlayer1, gridBagConstraints);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 485;
        gridBagConstraints.ipady = 144;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(32, 30, 0, 0);
        jPanelPlayer.add(jScrollPane7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 21, 0, 0);
        jPanelPlayer.add(jTextFieldPlayerCategory, gridBagConstraints);

        jTextFieldPlayerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlayerNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(75, 21, 0, 0);
        jPanelPlayer.add(jTextFieldPlayerName, gridBagConstraints);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 545;
        gridBagConstraints.ipady = 144;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(32, 18, 0, 0);
        jPanelPlayer.add(jScrollPane8, gridBagConstraints);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Équipe", "Catégorie", "Nom/Rôle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setMaximumSize(new java.awt.Dimension(0, 0));
        jTable2.setMinimumSize(new java.awt.Dimension(0, 0));
        jTable2.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane10.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1259;
        gridBagConstraints.ipady = 435;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(75, 20, 76, 76);
        jPanelPlayer.add(jScrollPane10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 21, 0, 0);
        jPanelPlayer.add(jTextFieldPlayerTeam, gridBagConstraints);

        jLabel4.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(75, 87, 0, 0);
        jPanelPlayer.add(jLabel4, gridBagConstraints);

        jLabel6.setText("Catégorie:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 85, 0, 0);
        jPanelPlayer.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Équipe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 85, 0, 0);
        jPanelPlayer.add(jLabel7, gridBagConstraints);

        jButtonDestroyPlayer1.setText("Supprimer");
        jButtonDestroyPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDestroyPlayer1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 28, 0, 76);
        jPanelPlayer.add(jButtonDestroyPlayer1, gridBagConstraints);

        jTabbedPanePlayerCategory.addTab("Joueur", jPanelPlayer);

        jPanelSport.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 23;
        gridBagConstraints.ipadx = 1616;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
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
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 19, 0, 0);
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
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 14, 0, 0);
        jPanelSport.add(jButtonNewSport, gridBagConstraints);

        jPanelSportFieldViewer.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSportFieldViewer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSportFieldViewer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelSportFieldViewerPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelSportFieldViewerLayout = new javax.swing.GroupLayout(jPanelSportFieldViewer);
        jPanelSportFieldViewer.setLayout(jPanelSportFieldViewerLayout);
        jPanelSportFieldViewerLayout.setHorizontalGroup(
            jPanelSportFieldViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSportField, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );
        jPanelSportFieldViewerLayout.setVerticalGroup(
            jPanelSportFieldViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSportFieldViewerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelSportField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 516;
        gridBagConstraints.ipady = 422;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelSport.add(jPanelSportFieldViewer, gridBagConstraints);

        jLabelFieldSize.setText("Taille du terrain:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 87, 0, 0);
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
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 11, 0, 0);
        jPanelSport.add(jTextFieldHorizontalSize, gridBagConstraints);

        jButtonLoadFieldImage.setText("Charger une image...");
        jButtonLoadFieldImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadFieldImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 12, 0, 0);
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
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanelSport.add(jTextFieldVerticalSize, gridBagConstraints);

        jLabelSportName.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 87, 0, 0);
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
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 87;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 0);
        jPanelSport.add(jTextFieldSportName, gridBagConstraints);

        jLabelFieldText.setText("Terrain");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 0);
        jPanelSport.add(jLabelFieldText, gridBagConstraints);

        tableSportPlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Catégorie", "Nom/Rôle", "Équipe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSportPlayers.getTableHeader().setReorderingAllowed(false);
        tableSportPlayers.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableSportPlayersPropertyChange(evt);
            }
        });
        jScrollPanePlayers.setViewportView(tableSportPlayers);
        if (tableSportPlayers.getColumnModel().getColumnCount() > 0) {
            tableSportPlayers.getColumnModel().getColumn(0).setResizable(false);
            tableSportPlayers.getColumnModel().getColumn(1).setResizable(false);
            tableSportPlayers.getColumnModel().getColumn(2).setResizable(false);
        }
        // The following code is customized using http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/components/TableRenderDemoProject/src/components/TableRenderDemo.java
        javax.swing.JComboBox sportCellComboBox = new javax.swing.JComboBox();
        javax.swing.table.TableColumn categoryColumn = tableSportPlayers.getColumnModel().getColumn(0);
        // Dummy items, please remove later
        sportCellComboBox.addItem("Frontier Pierrien");
        sportCellComboBox.addItem("Ailier Picardier");
        sportCellComboBox.addItem("Gardien Röckenfelleur");
        sportCellComboBox.addItem("Lutteur Avant-gardissien");
        categoryColumn.setCellEditor(new javax.swing.DefaultCellEditor(sportCellComboBox));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 633;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 13, 0, 0);
        jPanelSport.add(jScrollPanePlayers, gridBagConstraints);

        jLabelPlayerNumber.setText("Nombre de joueurs:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 87, 0, 0);
        jPanelSport.add(jLabelPlayerNumber, gridBagConstraints);

        jLabelPlayersTableTitle.setText("Les joueurs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanelSport.add(jLabelPlayersTableTitle, gridBagConstraints);

        jSpinnerPlayerNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerPlayerNumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPlayerNumberStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanelSport.add(jSpinnerPlayerNumber, gridBagConstraints);

        jTableSportsItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Objet", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Short.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSportsItems.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableSportsItemsPropertyChange(evt);
            }
        });
        jScrollPaneSportObjects.setViewportView(jTableSportsItems);
        if (jTableSportsItems.getColumnModel().getColumnCount() > 0) {
            jTableSportsItems.getColumnModel().getColumn(0).setResizable(false);
            jTableSportsItems.getColumnModel().getColumn(1).setResizable(false);
        }
        // The following code is customized using http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/components/TableRenderDemoProject/src/components/TableRenderDemo.java
        javax.swing.JComboBox sportCellComboBoxItems = new javax.swing.JComboBox();
        javax.swing.table.TableColumn categoryColumnItems = jTableSportsItems.getColumnModel().getColumn(0);
        // Dummy items, please remove later
        sportCellComboBoxItems.addItem("Gourde-ballon");
        sportCellComboBoxItems.addItem("Lure");
        sportCellComboBoxItems.addItem("Objet parfaitement générique");
        sportCellComboBoxItems.addItem("Oblongoïde");
        categoryColumnItems.setCellEditor(new javax.swing.DefaultCellEditor(sportCellComboBoxItems));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 633;
        gridBagConstraints.ipady = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 13, 0, 0);
        jPanelSport.add(jScrollPaneSportObjects, gridBagConstraints);

        jSpinnerObjectTypeNumber.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        jSpinnerObjectTypeNumber.setToolTipText("Nombre de types d'objets");
        jSpinnerObjectTypeNumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerObjectTypeNumberStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 1, 0, 0);
        jPanelSport.add(jSpinnerObjectTypeNumber, gridBagConstraints);

        jLabelObjectTypeNumber.setText("Nombre de types d'objet:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 89, 0, 0);
        jPanelSport.add(jLabelObjectTypeNumber, gridBagConstraints);

        jLabelObjectTableTitle.setText("Les objets");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 0, 0);
        jPanelSport.add(jLabelObjectTableTitle, gridBagConstraints);

        jListExistingSports.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Hockey", "Hockey Spécial", "Soccer" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.ipady = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 49, 0, 0);
        jPanelSport.add(jScrollPane1, gridBagConstraints);

        jButtonDestroySelectedSport.setText("Supprimer");
        jButtonDestroySelectedSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDestroySelectedSportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 19, 0, 0);
        jPanelSport.add(jButtonDestroySelectedSport, gridBagConstraints);

        jLabelExistingSportTitle.setText("Les sports existants");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 78, 0, 0);
        jPanelSport.add(jLabelExistingSportTitle, gridBagConstraints);

        jLabel1.setText("Unités:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 11, 0, 0);
        jPanelSport.add(jLabel1, gridBagConstraints);

        jTextFieldFieldUnits.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFieldUnitsFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jTextFieldFieldUnits, gridBagConstraints);

        jCheckBoxUnlimitedPlayer.setLabel("Nombre de joueur illimité");
        jCheckBoxUnlimitedPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUnlimitedPlayerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelSport.add(jCheckBoxUnlimitedPlayer, gridBagConstraints);

        jButtonRefreshSport.setText("Actualiser");
        jButtonRefreshSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshSportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 19, 0, 0);
        jPanelSport.add(jButtonRefreshSport, gridBagConstraints);

        jTabbedPanePlayerCategory.addTab("Sport", jPanelSport);

        jPanelTeam.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelTeam.setMinimumSize(new java.awt.Dimension(0, 0));
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
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 27, 0, 0);
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 0);
        jPanelTeam.add(jButtonSaveTeam, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 111;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(80, 17, 0, 0);
        jPanelTeam.add(jTextFieldTeamName, gridBagConstraints);

        jLabel2.setText("Nom de l'équipe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 27, 0, 0);
        jPanelTeam.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.ipadx = 2043;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        jPanelTeam.add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.ipadx = 271;
        gridBagConstraints.ipady = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 17, 0, 0);
        jPanelTeam.add(jListTeam, gridBagConstraints);

        jLabel5.setText("Équipes existantes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        jPanelTeam.add(jLabel5, gridBagConstraints);

        jButtonTeamDelete.setText("Supprimer");
        jButtonTeamDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTeamDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        jPanelTeam.add(jButtonTeamDelete, gridBagConstraints);

        jLabelPlayerNumber1.setText("Nombre de joueurs:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 27, 0, 0);
        jPanelTeam.add(jLabelPlayerNumber1, gridBagConstraints);

        jSpinnerPlayerNumber1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerPlayerNumber1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPlayerNumber1StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 27, 0, 0);
        jPanelTeam.add(jSpinnerPlayerNumber1, gridBagConstraints);

        jCheckBoxUnlimitedPlayer1.setLabel("Nombre de joueur illimité");
        jCheckBoxUnlimitedPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUnlimitedPlayer1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 27, 0, 0);
        jPanelTeam.add(jCheckBoxUnlimitedPlayer1, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Catégorie", "Nom/Rôle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(0, 0));
        jTable1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTable1.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane5.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 400;
        gridBagConstraints.ipady = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelTeam.add(jScrollPane5, gridBagConstraints);

        jTabbedPanePlayerCategory.addTab("Équipe", jPanelTeam);

        getContentPane().add(jTabbedPanePlayerCategory, java.awt.BorderLayout.CENTER);
        //this.jTabbedPanePlayerCategory.setEnabledAt(4, false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxIsAGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIsAGameObstacleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxIsAGameObstacleActionPerformed

    private void jTextFieldObstacleSizeVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObstacleSizeVerticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObstacleSizeVerticalActionPerformed

    private void jTextFieldObstacleSizeHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObstacleSizeHorizontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObstacleSizeHorizontalActionPerformed

    private void jButtonNewGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameObstacleActionPerformed
        myController.resetPlaceHolderCategoryObstacle();
    }//GEN-LAST:event_jButtonNewGameObstacleActionPerformed

    private void jButtonDeleteStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteStrategyActionPerformed
        this.myController.removeStrategy();
    }//GEN-LAST:event_jButtonDeleteStrategyActionPerformed

    private void jButtonDestroySelectedSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDestroySelectedSportActionPerformed
        this.myController.removeSport();
    }//GEN-LAST:event_jButtonDestroySelectedSportActionPerformed

    private void jButtonSaveSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSportActionPerformed
        this.myController.saveSport();
    }//GEN-LAST:event_jButtonSaveSportActionPerformed

    private void jButtonCreateStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateStrategyActionPerformed
        this.myController.saveStrategy();
    }//GEN-LAST:event_jButtonCreateStrategyActionPerformed

    private void jButtonNewSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewSportActionPerformed
        myController.resetPlaceHolderSport();
    }//GEN-LAST:event_jButtonNewSportActionPerformed

    private void jButtonLoadFieldImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadFieldImageActionPerformed
        myController.getSportImage();
    }//GEN-LAST:event_jButtonLoadFieldImageActionPerformed

    private void jButtonSaveGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGameObstacleActionPerformed
        this.myController.saveCategoryObstacle();
    }//GEN-LAST:event_jButtonSaveGameObstacleActionPerformed

    private void jTextFieldObstacleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObstacleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObstacleNameActionPerformed

    private void jButtonChooseObstaclePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseObstaclePictureActionPerformed
        myController.getCategoryObstacleImage();
    }//GEN-LAST:event_jButtonChooseObstaclePictureActionPerformed

    private void jButtonDeleteGameObstacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteGameObstacleActionPerformed
        this.myController.removeCategoryObstacle();
    }//GEN-LAST:event_jButtonDeleteGameObstacleActionPerformed

    private void jButtonLoadStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadStrategyActionPerformed
        try {
        if (jListExistingStrategy.getSelectedValue() != null & myController != null) {
            myController.setSelectedStrategy(jListExistingStrategy.getSelectedValue());
        }
        else if (myController != null) {
            String empty = "";
            myController.setSelectedStrategy(empty);
        }
        } catch (Exception Ex) {
        }
    }//GEN-LAST:event_jButtonLoadStrategyActionPerformed

    private void jComboBoxChooseStrategySportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChooseStrategySportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxChooseStrategySportActionPerformed

    private void jTextFieldChooseStrategyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldChooseStrategyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldChooseStrategyNameActionPerformed

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

    private void jPanelObstacleOnTerrainPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelObstacleOnTerrainPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelObstacleOnTerrainPropertyChange

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

    private void jSpinnerPlayerNumberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPlayerNumberStateChanged

        if (this.myController != null) {
            this.myController.setSportPlayerNumber((int) this.jSpinnerPlayerNumber.getModel().getValue());
        }
        //this.myController.setSportPlayerNumber(5);
    }//GEN-LAST:event_jSpinnerPlayerNumberStateChanged

    private void tableSportPlayersPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableSportPlayersPropertyChange
        ArrayList<String> typeArray = new ArrayList();
        ArrayList<String> playerRoleArray = new ArrayList();
        int rowNumber = tableSportPlayers.getModel().getRowCount();
        Boolean allCorrect = true;
        for (int i = 0; i < rowNumber; i++) {
            Object theType = tableSportPlayers.getModel().getValueAt(i, 0);
            Object theName = tableSportPlayers.getModel().getValueAt(i, 1);
            Object theTeam = tableSportPlayers.getModel().getValueAt(i, 2);
            if (theType != null & theName != null) {

                typeArray.add(theType.toString());
                playerRoleArray.add(theName.toString());
            }

            if (theType == null || theType.toString().equals("")) {
                allCorrect = false;
            }
            if (theName == null || theName.toString().equals("")) {
                allCorrect = false;
            }
            if (theTeam == null || theTeam.toString().equals("")) {
                allCorrect = false;
            }

            //playerRoleArray.add(tableSportPlayers.getModel().getValueAt(i+1, 1).toString);
            //typeArray.add(tableSportPlayers.getModel().getValueAt(i, 0).toString());

        }
        if (allCorrect == true) {
            tableSportPlayers.getCellRenderer(0, 0).getTableCellRendererComponent(tableSportPlayers, null, false, true, 0, 0).setBackground(Color.WHITE);
        } else {
            tableSportPlayers.getCellRenderer(0, 0).getTableCellRendererComponent(tableSportPlayers, null, false, true, 0, 0).setBackground(Color.RED);
        }


        if (this.myController != null) {
            this.myController.setSportPlayers(typeArray, playerRoleArray);
        }
    }//GEN-LAST:event_tableSportPlayersPropertyChange

    private void jTableSportsItemsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableSportsItemsPropertyChange
        ArrayList<String> typeArray = new ArrayList();
        ArrayList<Integer> numberArray = new ArrayList();
        int rowNumber = jTableSportsItems.getModel().getRowCount();
        Boolean allCorrect = true;
        for (int i = 0; i < rowNumber; i++) {
            Object theType = jTableSportsItems.getModel().getValueAt(i, 0);
            Object theNumber = jTableSportsItems.getModel().getValueAt(i, 1);
            if (theType != null & theNumber != null) {

                try {
                    Integer theInteger = Integer.parseInt(theNumber.toString());
                    typeArray.add(theType.toString());
                    numberArray.add(theInteger);
                }
                catch (Exception Ex) {
                    allCorrect = false;
                }
            }

            if (theType == null || theType.toString().equals("")) {
                allCorrect = false;
            }
            if (theNumber == null || theNumber.toString().equals("")) {
                allCorrect = false;
            }

            //playerRoleArray.add(tableSportPlayers.getModel().getValueAt(i+1, 1).toString);
            //typeArray.add(tableSportPlayers.getModel().getValueAt(i, 0).toString());

        }
        if (allCorrect == true) {
            jTableSportsItems.getCellRenderer(0, 0).getTableCellRendererComponent(jTableSportsItems, null, false, true, 0, 0).setBackground(Color.WHITE);
        } else {
            jTableSportsItems.getCellRenderer(0, 0).getTableCellRendererComponent(jTableSportsItems, null, false, true, 0, 0).setBackground(Color.RED);
        }


        if (this.myController != null) {
            this.myController.setSportObjects(typeArray, numberArray);
        }
    }//GEN-LAST:event_jTableSportsItemsPropertyChange

    private void jSpinnerObjectTypeNumberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerObjectTypeNumberStateChanged
        if (this.myController != null) {
            this.myController.setSportCategoryNumber((int) this.jSpinnerObjectTypeNumber.getModel().getValue());
        }
    }//GEN-LAST:event_jSpinnerObjectTypeNumberStateChanged

    private void jTextFieldSportNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSportNameActionPerformed
        // TODO add your andling code here:
    }//GEN-LAST:event_jTextFieldSportNameActionPerformed

    private void jTextFieldHorizontalSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorizontalSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHorizontalSizeActionPerformed

    private void jTextFieldObstacleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObstacleNameFocusLost
        myController.setCategoryObstacleName(this.jTextFieldObstacleName.getText());
    }//GEN-LAST:event_jTextFieldObstacleNameFocusLost

    private void jTextFieldObstacleSizeHorizontalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObstacleSizeHorizontalFocusLost
                try {
            myController.setCategoryObstacleHorizontalSize(Float.parseFloat(this.jTextFieldObstacleSizeHorizontal.getText()));
            this.jTextFieldObstacleSizeHorizontal.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldObstacleSizeHorizontal.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldObstacleSizeHorizontalFocusLost

    private void jTextFieldObstacleSizeVerticalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObstacleSizeVerticalFocusLost
                try {
            myController.setCategoryObstacleVerticalSize(Float.parseFloat(this.jTextFieldCategorySizeVertical.getText()));
            this.jTextFieldObstacleSizeVertical.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldObstacleSizeVertical.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldObstacleSizeVerticalFocusLost

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

    private void jTextFieldChooseStrategyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChooseStrategyNameFocusLost
        myController.setStrategyName(this.jTextFieldChooseStrategyName.getText());
    }//GEN-LAST:event_jTextFieldChooseStrategyNameFocusLost

    private void jComboBoxChooseStrategySportFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxChooseStrategySportFocusLost
    //TODO fix    
    //myController.setStrategySport(this.jComboBoxChooseStrategySport.getSelectedItem());
    }//GEN-LAST:event_jComboBoxChooseStrategySportFocusLost

    private void jCheckBoxUnlimitedPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUnlimitedPlayerActionPerformed
        // TODO add your handling code here
        if(jCheckBoxUnlimitedPlayer.isSelected()){
            this.myController.setPlayerLimit(true);
        }
        else{
            this.myController.setPlayerLimit(false);
        }
    }//GEN-LAST:event_jCheckBoxUnlimitedPlayerActionPerformed

    private void jButtonRefreshSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshSportActionPerformed
        // TODO add your handling code here:
        this.myController.refreshSport();
    }//GEN-LAST:event_jButtonRefreshSportActionPerformed

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

    private void jButtonSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCategoryActionPerformed
        this.myController.saveCategoryPlayer();
    }//GEN-LAST:event_jButtonSaveCategoryActionPerformed

    private void jButtonNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewCategoryActionPerformed
        myController.resetPlaceHolderCategoryPlayer();
    }//GEN-LAST:event_jButtonNewCategoryActionPerformed

    private void jTextFieldPlaybackSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlaybackSpeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlaybackSpeedActionPerformed

    private void jTextFieldStrategyViewerTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStrategyViewerTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStrategyViewerTimeActionPerformed

    private void jToggleButtonRotationModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRotationModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonRotationModeActionPerformed

    private void jPanelStrategyEditorLocationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelStrategyEditorLocationPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelStrategyEditorLocationPropertyChange

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jButtonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRedoActionPerformed

    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jTextFieldStrategyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStrategyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStrategyNameActionPerformed

    private void jButtonStepForwardTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepForwardTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStepForwardTimeActionPerformed

    private void jButtonStepBackTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepBackTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStepBackTimeActionPerformed

    private void jButtonModificationVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificationVisualizeActionPerformed
        this.myController.playStrategy();
    }//GEN-LAST:event_jButtonModificationVisualizeActionPerformed

    private void jTextFieldTimeIntervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimeIntervalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimeIntervalActionPerformed

    private void jLabelCurrentPositionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelCurrentPositionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCurrentPositionPropertyChange

    private void jButtonNextFrameForImageModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFrameForImageModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextFrameForImageModeActionPerformed

    private void jButtonZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonZoomActionPerformed

    private void jButtonSaveStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveStrategyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveStrategyActionPerformed

    private void jListObjectsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListObjectsPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListObjectsPropertyChange

    private void jListPlayersPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListPlayersPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListPlayersPropertyChange

    private void jListTypeModificationTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListTypeModificationTypePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListTypeModificationTypePropertyChange

    private void jPanelCategoryOnTerrainPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelCategoryOnTerrainPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCategoryOnTerrainPropertyChange

    private void jTextFieldVerticalSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVerticalSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVerticalSizeActionPerformed

    private void jButtonNewTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewTeamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewTeamActionPerformed

    private void jButtonSaveTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveTeamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveTeamActionPerformed

    private void jButtonTeamDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTeamDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTeamDeleteActionPerformed

    private void jSpinnerPlayerNumber1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPlayerNumber1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinnerPlayerNumber1StateChanged

    private void jCheckBoxUnlimitedPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUnlimitedPlayer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxUnlimitedPlayer1ActionPerformed

    private void jTextFieldCategorySizeVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategorySizeVerticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCategorySizeVerticalActionPerformed

    private void jTextFieldCategorySizeVerticalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCategorySizeVerticalFocusLost
        try {
            myController.setCategoryPlayerVerticalSize(Float.parseFloat(this.jTextFieldCategorySizeVertical.getText()));
            this.jTextFieldCategorySizeVertical.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldCategorySizeVertical.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldCategorySizeVerticalFocusLost

    private void jTextFieldCategorySizeHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategorySizeHorizontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCategorySizeHorizontalActionPerformed

    private void jTextFieldCategorySizeHorizontalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCategorySizeHorizontalFocusLost
        try {
            myController.setCategoryPlayerHorizontalSize(Float.parseFloat(this.jTextFieldCategorySizeHorizontal.getText()));
            this.jTextFieldCategorySizeHorizontal.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldCategorySizeHorizontal.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldCategorySizeHorizontalFocusLost

    private void jPanelCategoryPicturePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelCategoryPicturePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCategoryPicturePropertyChange

    private void jLabelCategoryPlayerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoryPlayerIconMouseClicked
        double X = evt.getX();
        double Y = evt.getY();
        System.out.println("X: " + X + "Y: " + Y);
    }//GEN-LAST:event_jLabelCategoryPlayerIconMouseClicked

    private void jTextFieldCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCategoryNameActionPerformed

    private void jTextFieldCategoryNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCategoryNameFocusLost
        myController.setCategoryPlayerName(this.jTextFieldCategoryName.getText());
    }//GEN-LAST:event_jTextFieldCategoryNameFocusLost

    private void jButtonSavePlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePlayer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSavePlayer1ActionPerformed

    private void jButtonNewPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPlayer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewPlayer1ActionPerformed

    private void jTextFieldPlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlayerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlayerNameActionPerformed

    private void jButtonDestroyPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDestroyPlayer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDestroyPlayer1ActionPerformed

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
    private javax.swing.JButton jButtonChooseObstaclePicture;
    private javax.swing.JButton jButtonCreateStrategy;
    private javax.swing.JButton jButtonDeleteCategory;
    private javax.swing.JButton jButtonDeleteGameObstacle;
    private javax.swing.JButton jButtonDeleteStrategy;
    private javax.swing.JButton jButtonDestroyPlayer1;
    private javax.swing.JButton jButtonDestroySelectedSport;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonLoadFieldImage;
    private javax.swing.JButton jButtonLoadStrategy;
    private javax.swing.JButton jButtonModificationVisualize;
    private javax.swing.JButton jButtonNewCategory;
    private javax.swing.JButton jButtonNewGameObstacle;
    private javax.swing.JButton jButtonNewPlayer1;
    private javax.swing.JButton jButtonNewSport;
    private javax.swing.JButton jButtonNewTeam;
    private javax.swing.JButton jButtonNextFrameForImageMode;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonRefreshSport;
    private javax.swing.JButton jButtonSaveCategory;
    private javax.swing.JButton jButtonSaveGameObstacle;
    private javax.swing.JButton jButtonSavePlayer1;
    private javax.swing.JButton jButtonSaveSport;
    private javax.swing.JButton jButtonSaveStrategy;
    private javax.swing.JButton jButtonSaveTeam;
    private javax.swing.JButton jButtonStepBackTime;
    private javax.swing.JButton jButtonStepForwardTime;
    private javax.swing.JButton jButtonTeamDelete;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JButton jButtonZoom;
    private javax.swing.JCheckBox jCheckBoxIsAGameObstacle;
    private javax.swing.JCheckBox jCheckBoxUnlimitedPlayer;
    private javax.swing.JCheckBox jCheckBoxUnlimitedPlayer1;
    private javax.swing.JComboBox<String> jComboBoxChooseStrategySport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAvailableStrategies;
    private javax.swing.JLabel jLabelCategoryImage;
    private javax.swing.JLabel jLabelCategoryName;
    private javax.swing.JLabel jLabelCategoryObstacleIcon;
    private javax.swing.JLabel jLabelCategoryOnTerrain;
    private javax.swing.JLabel jLabelCategoryPlayerIcon;
    private javax.swing.JLabel jLabelCategorySize;
    private javax.swing.JLabel jLabelCategoryUnits;
    private javax.swing.JLabel jLabelChooseNameStrategy;
    private javax.swing.JLabel jLabelChooseSport;
    private javax.swing.JLabel jLabelChosenObstacleImage;
    private javax.swing.JLabel jLabelCurrentPosition;
    private javax.swing.JLabel jLabelCursorPosition;
    private javax.swing.JLabel jLabelExistingCategories;
    private javax.swing.JLabel jLabelExistingObjects;
    private javax.swing.JLabel jLabelExistingSportTitle;
    private javax.swing.JLabel jLabelFieldSize;
    private javax.swing.JLabel jLabelFieldText;
    private javax.swing.JLabel jLabelModificationModeToSelect;
    private javax.swing.JLabel jLabelObjectTableTitle;
    private javax.swing.JLabel jLabelObjectTypeNumber;
    private javax.swing.JLabel jLabelObjectsToSelect;
    private javax.swing.JLabel jLabelObstacleInformation;
    private javax.swing.JLabel jLabelObstacleName;
    private javax.swing.JLabel jLabelObstacleOnTerrain;
    private javax.swing.JLabel jLabelObstacleSize;
    private javax.swing.JLabel jLabelObstacleUnits;
    private javax.swing.JLabel jLabelPlayBackSpeedTitle;
    private javax.swing.JLabel jLabelPlayerNumber;
    private javax.swing.JLabel jLabelPlayerNumber1;
    private javax.swing.JLabel jLabelPlayerToSelect;
    private javax.swing.JLabel jLabelPlayersTableTitle;
    private javax.swing.JLabel jLabelSportField;
    private javax.swing.JLabel jLabelSportName;
    private javax.swing.JLabel jLabelSportsUnit;
    private javax.swing.JLabel jLabelStrategyCreationZoneTitle;
    private javax.swing.JLabel jLabelStrategyEditorPicture;
    private javax.swing.JLabel jLabelStrategyName;
    private javax.swing.JLabel jLabelStrategyViewerTime;
    private javax.swing.JLabel jLabelTimeInterval;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jListExistingCategories;
    private javax.swing.JList<String> jListExistingObstacle;
    private javax.swing.JList<String> jListExistingSports;
    private javax.swing.JList<String> jListExistingStrategy;
    private javax.swing.JList<String> jListObjects;
    private javax.swing.JList<String> jListPlayers;
    private java.awt.List jListTeam;
    private javax.swing.JList<String> jListTypeModificationType;
    private javax.swing.JPanel jPanelCategories;
    private javax.swing.JPanel jPanelCategoryOnTerrain;
    private javax.swing.JPanel jPanelCategoryPicture;
    private javax.swing.JPanel jPanelCreateLoadStrategy;
    private javax.swing.JPanel jPanelObstacle;
    private javax.swing.JPanel jPanelObstacleIcon;
    private javax.swing.JPanel jPanelObstacleOnTerrain;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JPanel jPanelSport;
    private javax.swing.JPanel jPanelSportFieldViewer;
    private javax.swing.JPanel jPanelStrategyEditor;
    private javax.swing.JPanel jPanelStrategyEditorLocation;
    private javax.swing.JPanel jPanelTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPaneModificationMode;
    private javax.swing.JScrollPane jScrollPaneObjectSelection;
    private javax.swing.JScrollPane jScrollPanePlayerSelection;
    private javax.swing.JScrollPane jScrollPanePlayers;
    private javax.swing.JScrollPane jScrollPaneSportObjects;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinnerObjectTypeNumber;
    private javax.swing.JSpinner jSpinnerPlayerNumber;
    private javax.swing.JSpinner jSpinnerPlayerNumber1;
    private javax.swing.JTabbedPane jTabbedPanePlayerCategory;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableSportsItems;
    private javax.swing.JTextField jTextFieldCategoryName;
    private javax.swing.JTextField jTextFieldCategorySizeHorizontal;
    private javax.swing.JTextField jTextFieldCategorySizeVertical;
    private javax.swing.JTextField jTextFieldChooseStrategyName;
    private javax.swing.JTextField jTextFieldFieldUnits;
    private javax.swing.JTextField jTextFieldHorizontalSize;
    private javax.swing.JTextField jTextFieldObstacleName;
    private javax.swing.JTextField jTextFieldObstacleSizeHorizontal;
    private javax.swing.JTextField jTextFieldObstacleSizeVertical;
    private javax.swing.JTextField jTextFieldPlaybackSpeed;
    private javax.swing.JTextField jTextFieldPlayerCategory;
    private javax.swing.JTextField jTextFieldPlayerName;
    private javax.swing.JTextField jTextFieldPlayerTeam;
    private javax.swing.JTextField jTextFieldSportName;
    private javax.swing.JTextField jTextFieldStrategyName;
    private javax.swing.JTextField jTextFieldStrategyViewerTime;
    private javax.swing.JTextField jTextFieldTeamName;
    private javax.swing.JTextField jTextFieldTimeInterval;
    private javax.swing.JTextField jTextFieldVerticalSize;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButtonRotationMode;
    private javax.swing.JTable tableSportPlayers;
    // End of variables declaration//GEN-END:variables
}
