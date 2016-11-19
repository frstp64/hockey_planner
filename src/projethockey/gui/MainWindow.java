/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.gui;
import java.awt.Color;
import java.awt.image.BufferedImage;
import projethockey.domain.Controller;
import projethockey.domain.sportSubscribable;
import java.util.List;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jButtonChooseCategoryImage = new javax.swing.JButton();
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
        jPanelObstacle = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonNewGameObject = new javax.swing.JButton();
        jButtonSaveGameObject = new javax.swing.JButton();
        jLabelObstacleInformation = new javax.swing.JLabel();
        jLabelObstacleName = new javax.swing.JLabel();
        jLabelObstacleSize = new javax.swing.JLabel();
        jLabelObstacleUnits = new javax.swing.JLabel();
        jLabelChosenObstacleImage = new javax.swing.JLabel();
        jLabelObstacleOnTerrain = new javax.swing.JLabel();
        jPanelObstacleOnTerrain = new javax.swing.JPanel();
        jPanelObstaclePicture = new javax.swing.JPanel();
        jTextFieldObjectName = new javax.swing.JTextField();
        jTextFieldObjectHorizontalSize = new javax.swing.JTextField();
        jTextFieldObjectVerticalSize = new javax.swing.JTextField();
        jButtonChooseObjectPicture = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jCheckBoxIsAGameObject = new javax.swing.JCheckBox();
        jLabelExistingObjects = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListExistingObstacle = new javax.swing.JList<>();
        jButtonDeleteGameObject = new javax.swing.JButton();
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
        jPanelCreateLoadStrategy = new javax.swing.JPanel();
        jButtonCreateStrategy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEditorStrategy = new javax.swing.JList<>();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabelObjectsToSelect = new javax.swing.JLabel();
        jLabelStrategyName = new javax.swing.JLabel();
        jLabelPlayerToSelect = new javax.swing.JLabel();
        jLabelModificationModeToSelect = new javax.swing.JLabel();
        jButtonSaveStrategy = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSliderModificationGameTime = new javax.swing.JSlider();
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
        jLabelSportsUnit = new javax.swing.JLabel();
        jLabelPlayBackSpeedTitle = new javax.swing.JLabel();
        jToggleButtonRotationMode = new javax.swing.JToggleButton();
        jTextFieldStrategyViewerTime = new javax.swing.JTextField();
        jTextFieldPlaybackSpeed = new javax.swing.JTextField();
        jLabelStrategyViewerTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1280, 1024));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButtonNewCategory.setText("Nouveau");
        jButtonNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewCategoryActionPerformed(evt);
            }
        });

        jButtonSaveCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveCategory.setText("Enregistrer");
        jButtonSaveCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCategoryActionPerformed(evt);
            }
        });

        jLabelCategoryImage.setText("Image de catégorie choisie");

        jPanelCategoryPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCategoryPicture.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelCategoryPicturePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoryPictureLayout = new javax.swing.GroupLayout(jPanelCategoryPicture);
        jPanelCategoryPicture.setLayout(jPanelCategoryPictureLayout);
        jPanelCategoryPictureLayout.setHorizontalGroup(
            jPanelCategoryPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategoryPlayerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        jPanelCategoryPictureLayout.setVerticalGroup(
            jPanelCategoryPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategoryPlayerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButtonChooseCategoryImage.setText("Choisir image...");
        jButtonChooseCategoryImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseCategoryImageActionPerformed(evt);
            }
        });

        jLabelCategoryOnTerrain.setText("Image telle que vue sur le terrain");

        jPanelCategoryOnTerrain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCategoryOnTerrain.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelCategoryOnTerrainPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoryOnTerrainLayout = new javax.swing.GroupLayout(jPanelCategoryOnTerrain);
        jPanelCategoryOnTerrain.setLayout(jPanelCategoryOnTerrainLayout);
        jPanelCategoryOnTerrainLayout.setHorizontalGroup(
            jPanelCategoryOnTerrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        jPanelCategoryOnTerrainLayout.setVerticalGroup(
            jPanelCategoryOnTerrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        jLabel3.setText("Informations sur la catégorie");

        jLabelCategoryName.setText("Nom:");

        jLabelCategorySize.setText("Taille:");

        jLabelCategoryUnits.setText("(unités):");

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

        jLabelExistingCategories.setText("Catégories existantes");

        jButtonDeleteCategory.setText("Supprimer");
        jButtonDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoriesLayout = new javax.swing.GroupLayout(jPanelCategories);
        jPanelCategories.setLayout(jPanelCategoriesLayout);
        jPanelCategoriesLayout.setHorizontalGroup(
            jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator8)
            .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonDeleteCategory))
                    .addComponent(jLabelExistingCategories))
                .addContainerGap(395, Short.MAX_VALUE))
            .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addComponent(jLabelCategoryName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCategoryName))
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addComponent(jLabelCategorySize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCategoryUnits)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCategorySizeHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCategorySizeVertical, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCategoryPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabelCategoryImage))
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButtonChooseCategoryImage)))
                .addGap(51, 51, 51)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCategoryOnTerrain, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelCategoryOnTerrain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
        jPanelCategoriesLayout.setVerticalGroup(
            jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonNewCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSaveCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addComponent(jLabelExistingCategories)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeleteCategory))))
                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator9)
                                            .addComponent(jSeparator10)))
                                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabelCategoryOnTerrain)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanelCategoryOnTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCategoryName)
                                    .addComponent(jTextFieldCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCategorySize)
                                    .addComponent(jLabelCategoryUnits)
                                    .addComponent(jTextFieldCategorySizeHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCategorySizeVertical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanelCategoriesLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabelCategoryImage)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCategoryPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonChooseCategoryImage)
                        .addContainerGap(84, Short.MAX_VALUE))))
        );

        jTabbedPanePlayerCategory.addTab("Catégories", jPanelCategories);

        jButtonNewGameObject.setText("Nouveau");
        jButtonNewGameObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameObjectActionPerformed(evt);
            }
        });

        jButtonSaveGameObject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projethockey/gui/mySaveIcon.png"))); // NOI18N
        jButtonSaveGameObject.setText("Enregistrer");
        jButtonSaveGameObject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveGameObject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveGameObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGameObjectActionPerformed(evt);
            }
        });

        jLabelObstacleInformation.setText("Informations sur l'obstacle");

        jLabelObstacleName.setText("Nom:");

        jLabelObstacleSize.setText("Taille");

        jLabelObstacleUnits.setText("(unités):");

        jLabelChosenObstacleImage.setText("Image d'obstacle choisie");

        jLabelObstacleOnTerrain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObstacleOnTerrain.setText("Obstacle tel que vu sur le terrain");
        jLabelObstacleOnTerrain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jPanelObstaclePicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelObstaclePicture.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelObstaclePicturePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelObstaclePictureLayout = new javax.swing.GroupLayout(jPanelObstaclePicture);
        jPanelObstaclePicture.setLayout(jPanelObstaclePictureLayout);
        jPanelObstaclePictureLayout.setHorizontalGroup(
            jPanelObstaclePictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        jPanelObstaclePictureLayout.setVerticalGroup(
            jPanelObstaclePictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jTextFieldObjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObjectNameActionPerformed(evt);
            }
        });

        jTextFieldObjectHorizontalSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObjectHorizontalSizeActionPerformed(evt);
            }
        });

        jTextFieldObjectVerticalSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObjectVerticalSizeActionPerformed(evt);
            }
        });

        jButtonChooseObjectPicture.setText("Choisir image...");
        jButtonChooseObjectPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseObjectPictureActionPerformed(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCheckBoxIsAGameObject.setText("Objet de jeu? (association à un joueur possible)");
        jCheckBoxIsAGameObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIsAGameObjectActionPerformed(evt);
            }
        });

        jLabelExistingObjects.setText("Objets existants");

        jListExistingObstacle.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Gourde-ballon", "Lure", "Objet parfaitement générique", "Oblongoïde" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListExistingObstacle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListExistingObstaclePropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(jListExistingObstacle);

        jButtonDeleteGameObject.setText("Supprimer");
        jButtonDeleteGameObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteGameObjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelObstacleLayout = new javax.swing.GroupLayout(jPanelObstacle);
        jPanelObstacle.setLayout(jPanelObstacleLayout);
        jPanelObstacleLayout.setHorizontalGroup(
            jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelObstacleLayout.createSequentialGroup()
                        .addComponent(jButtonNewGameObject, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSaveGameObject, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteGameObject))
                            .addComponent(jLabelExistingObjects))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelObstacleLayout.createSequentialGroup()
                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelObstacleName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelObstacleInformation)))
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxIsAGameObject)
                                    .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                        .addComponent(jLabelObstacleSize)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldObjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                                .addComponent(jLabelObstacleUnits)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldObjectHorizontalSize, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldObjectVerticalSize, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanelObstaclePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelChosenObstacleImage)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelObstacleLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonChooseObjectPicture)
                                .addGap(90, 90, 90)))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jPanelObstacleOnTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabelObstacleOnTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(477, 477, 477))))
        );
        jPanelObstacleLayout.setVerticalGroup(
            jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSaveGameObject, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jButtonNewGameObject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelObstacleLayout.createSequentialGroup()
                        .addComponent(jLabelExistingObjects)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeleteGameObject))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelObstacleLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabelObstacleInformation)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldObjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelObstacleName))
                                .addGap(8, 8, 8)
                                .addGroup(jPanelObstacleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelObstacleUnits)
                                    .addComponent(jLabelObstacleSize)
                                    .addComponent(jTextFieldObjectHorizontalSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldObjectVerticalSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jCheckBoxIsAGameObject))
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelObstacleLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabelChosenObstacleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelObstaclePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonChooseObjectPicture))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelObstacleLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelObstacleOnTerrain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelObstacleOnTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(700, 700, 700))
        );

        jCheckBoxIsAGameObject.getAccessibleContext().setAccessibleDescription("");

        jTabbedPanePlayerCategory.addTab("Objets de jeu", jPanelObstacle);

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

        jButtonNewSport.setText("Nouveau");
        jButtonNewSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewSportActionPerformed(evt);
            }
        });

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
            .addComponent(jLabelSportField, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );
        jPanelSportFieldViewerLayout.setVerticalGroup(
            jPanelSportFieldViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSportField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        jLabelFieldSize.setText("Taille du terrain:");

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

        jButtonLoadFieldImage.setText("Charger une image...");
        jButtonLoadFieldImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadFieldImageActionPerformed(evt);
            }
        });

        jTextFieldVerticalSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVerticalSizeFocusLost(evt);
            }
        });

        jLabelSportName.setText("Nom:");

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

        jLabelFieldText.setText("Terrain");

        tableSportPlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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

        jLabelPlayerNumber.setText("Nombre de joueurs:");

        jLabelPlayersTableTitle.setText("Les joueurs");

        jSpinnerPlayerNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerPlayerNumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPlayerNumberStateChanged(evt);
            }
        });

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

        jSpinnerObjectTypeNumber.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        jSpinnerObjectTypeNumber.setToolTipText("Nombre de types d'objets");
        jSpinnerObjectTypeNumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerObjectTypeNumberStateChanged(evt);
            }
        });

        jLabelObjectTypeNumber.setText("Nombre de types d'objet:");

        jLabelObjectTableTitle.setText("Les objets");

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

        jButtonDestroySelectedSport.setText("Supprimer");
        jButtonDestroySelectedSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDestroySelectedSportActionPerformed(evt);
            }
        });

        jLabelExistingSportTitle.setText("Les sports existants");

        jLabel1.setText("Unités:");

        jTextFieldFieldUnits.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFieldUnitsFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanelSportLayout = new javax.swing.GroupLayout(jPanelSport);
        jPanelSport.setLayout(jPanelSportLayout);
        jPanelSportLayout.setHorizontalGroup(
            jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSportLayout.createSequentialGroup()
                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 1225, Short.MAX_VALUE))
                    .addGroup(jPanelSportLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonNewSport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSaveSport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSportLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDestroySelectedSport)
                                .addGap(241, 241, 241))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSportLayout.createSequentialGroup()
                                .addComponent(jLabelExistingSportTitle)
                                .addGap(353, 353, 353))))
                    .addGroup(jPanelSportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelSportFieldViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSportLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneSportObjects, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPanePlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(jPanelSportLayout.createSequentialGroup()
                                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSportLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelSportLayout.createSequentialGroup()
                                                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelFieldText)
                                                    .addComponent(jButtonLoadFieldImage))
                                                .addGap(62, 62, 62)
                                                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanelSportLayout.createSequentialGroup()
                                                        .addComponent(jLabelPlayerNumber)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jSpinnerPlayerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanelSportLayout.createSequentialGroup()
                                                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabelPlayersTableTitle)
                                                            .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabelFieldSize)
                                                                .addComponent(jLabelSportName)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextFieldSportName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanelSportLayout.createSequentialGroup()
                                                                .addComponent(jTextFieldHorizontalSize, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldVerticalSize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldFieldUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                            .addGroup(jPanelSportLayout.createSequentialGroup()
                                                .addGap(244, 244, 244)
                                                .addComponent(jLabelObjectTypeNumber)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinnerObjectTypeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanelSportLayout.createSequentialGroup()
                                        .addGap(325, 325, 325)
                                        .addComponent(jLabelObjectTableTitle)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelSportLayout.setVerticalGroup(
            jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSportLayout.createSequentialGroup()
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSaveSport, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jButtonNewSport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSportLayout.createSequentialGroup()
                        .addComponent(jLabelExistingSportTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDestroySelectedSport)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFieldText)
                    .addComponent(jLabelSportName)
                    .addComponent(jTextFieldSportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSportLayout.createSequentialGroup()
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLoadFieldImage)
                            .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelFieldSize)
                                .addComponent(jTextFieldHorizontalSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldVerticalSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jTextFieldFieldUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPlayerNumber)
                            .addComponent(jSpinnerPlayerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPlayersTableTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPanePlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanelSportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObjectTypeNumber)
                            .addComponent(jSpinnerObjectTypeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelObjectTableTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneSportObjects, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelSportFieldViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPanePlayerCategory.addTab("Sport", jPanelSport);

        jButtonCreateStrategy.setText("Créer une nouvelle stratégie");
        jButtonCreateStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateStrategyActionPerformed(evt);
            }
        });

        jListEditorStrategy.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tour du chapeau", "Stratégie des Oursons" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListEditorStrategy.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListEditorStrategyPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jListEditorStrategy);

        jButtonLoadStrategy.setText("Charger une stratégie");
        jButtonLoadStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadStrategyActionPerformed(evt);
            }
        });

        jLabelChooseSport.setText("Sport:");

        jLabelChooseNameStrategy.setText("Nom:");

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelStrategyCreationZoneTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelStrategyCreationZoneTitle.setText("Création de stratégie");

        jLabelAvailableStrategies.setText("Stratégies disponibles");

        jComboBoxChooseStrategySport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hockey", "Hockey Spécial", "Soccer" }));
        jComboBoxChooseStrategySport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChooseStrategySportActionPerformed(evt);
            }
        });

        jButtonDeleteStrategy.setText("Supprimer");
        jButtonDeleteStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteStrategyActionPerformed(evt);
            }
        });

        jTextFieldChooseStrategyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldChooseStrategyNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCreateLoadStrategyLayout = new javax.swing.GroupLayout(jPanelCreateLoadStrategy);
        jPanelCreateLoadStrategy.setLayout(jPanelCreateLoadStrategyLayout);
        jPanelCreateLoadStrategyLayout.setHorizontalGroup(
            jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDeleteStrategy)
                    .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                        .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonLoadStrategy)
                                .addComponent(jLabelAvailableStrategies))
                            .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStrategyCreationZoneTitle)
                                    .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                                        .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelChooseNameStrategy)
                                            .addComponent(jLabelChooseSport))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxChooseStrategySport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldChooseStrategyName)))))
                            .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jButtonCreateStrategy)))))
                .addContainerGap(690, Short.MAX_VALUE))
        );
        jPanelCreateLoadStrategyLayout.setVerticalGroup(
            jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelStrategyCreationZoneTitle)
                        .addGap(37, 37, 37)
                        .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChooseNameStrategy)
                            .addComponent(jTextFieldChooseStrategyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCreateLoadStrategyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChooseSport)
                            .addComponent(jComboBoxChooseStrategySport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCreateStrategy))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateLoadStrategyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelCreateLoadStrategyLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButtonLoadStrategy)
                .addGap(108, 108, 108)
                .addComponent(jLabelAvailableStrategies)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDeleteStrategy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanePlayerCategory.addTab("Créer/charger stratégie", jPanelCreateLoadStrategy);

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

        jLabelObjectsToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObjectsToSelect.setText("Objets");
        jLabelObjectsToSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelStrategyName.setText("Nom de la stratégie:");

        jLabelPlayerToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayerToSelect.setText("Joueurs");

        jLabelModificationModeToSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModificationModeToSelect.setText("Mode");
        jLabelModificationModeToSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jSliderModificationGameTime.setValue(0);
        jSliderModificationGameTime.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jSliderModificationGameTimeVetoableChange(evt);
            }
        });

        jButtonZoom.setText("Zoom");
        jButtonZoom.setToolTipText("Sélectionner la zone de zoom désirée avec deux points");
        jButtonZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZoomActionPerformed(evt);
            }
        });

        jButtonNextFrameForImageMode.setText("image suivante");
        jButtonNextFrameForImageMode.setDefaultCapable(false);
        jButtonNextFrameForImageMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextFrameForImageModeActionPerformed(evt);
            }
        });

        jLabelCursorPosition.setText("position du curseur: ");

        jLabelCurrentPosition.setText("positionActuelle");
        jLabelCurrentPosition.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelCurrentPositionPropertyChange(evt);
            }
        });

        jTextFieldTimeInterval.setText("1s");
        jTextFieldTimeInterval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimeIntervalActionPerformed(evt);
            }
        });

        jLabelTimeInterval.setText("Intervalle");

        jButtonModificationVisualize.setText("Visualiser");
        jButtonModificationVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificationVisualizeActionPerformed(evt);
            }
        });

        jButtonStepBackTime.setText("Reculer");
        jButtonStepBackTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepBackTimeActionPerformed(evt);
            }
        });

        jButtonStepForwardTime.setText("Avancer");
        jButtonStepForwardTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepForwardTimeActionPerformed(evt);
            }
        });

        jTextFieldStrategyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStrategyNameActionPerformed(evt);
            }
        });

        jButtonUndo.setText("Annuler");
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });

        jButtonRedo.setText("Refaire");
        jButtonRedo.setEnabled(false);
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });

        jButtonExport.setText("Exporter");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

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
            .addGap(0, 1219, Short.MAX_VALUE)
        );
        jPanelStrategyEditorLocationLayout.setVerticalGroup(
            jPanelStrategyEditorLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        jLabelSportsUnit.setText("Unités");

        jLabelPlayBackSpeedTitle.setText("Vitesse de jeu: ");

        jToggleButtonRotationMode.setText("mode rotation");
        jToggleButtonRotationMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRotationModeActionPerformed(evt);
            }
        });

        jTextFieldStrategyViewerTime.setText("0");
        jTextFieldStrategyViewerTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStrategyViewerTimeActionPerformed(evt);
            }
        });

        jTextFieldPlaybackSpeed.setToolTipText("Multiple de la vitessse normale, de 0.01 à 10");
        jTextFieldPlaybackSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlaybackSpeedActionPerformed(evt);
            }
        });

        jLabelStrategyViewerTime.setText("Temps (s):");

        javax.swing.GroupLayout jPanelStrategyEditorLayout = new javax.swing.GroupLayout(jPanelStrategyEditor);
        jPanelStrategyEditor.setLayout(jPanelStrategyEditorLayout);
        jPanelStrategyEditorLayout.setHorizontalGroup(
            jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                        .addComponent(jPanelStrategyEditorLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStrategyEditorLayout.createSequentialGroup()
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addComponent(jLabelModificationModeToSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPlayerToSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addComponent(jScrollPaneModificationMode, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPanePlayerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addComponent(jScrollPaneObjectSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldStrategyName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonUndo)
                                    .addComponent(jButtonRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addComponent(jLabelObjectsToSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelStrategyName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSaveStrategy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                        .addComponent(jLabelCursorPosition)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCurrentPosition)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelSportsUnit))
                                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                        .addComponent(jButtonZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(193, 193, 193)))
                                .addGap(45, 45, 45)
                                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                        .addComponent(jLabelTimeInterval)
                                        .addGap(3, 3, 3)
                                        .addComponent(jTextFieldTimeInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonNextFrameForImageMode)
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                        .addComponent(jLabelStrategyViewerTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldStrategyViewerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabelPlayBackSpeedTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPlaybackSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)))
                                .addComponent(jButtonStepBackTime)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonModificationVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonStepForwardTime)
                                .addGap(51, 51, 51)
                                .addComponent(jToggleButtonRotationMode))
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addComponent(jSeparator2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSliderModificationGameTime, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelStrategyEditorLayout.setVerticalGroup(
            jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStrategyEditorLayout.createSequentialGroup()
                            .addComponent(jLabelModificationModeToSelect)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPaneModificationMode, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStrategyEditorLayout.createSequentialGroup()
                            .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelPlayerToSelect)
                                .addComponent(jLabelObjectsToSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStrategyName))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPanePlayerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPaneObjectSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jTextFieldStrategyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonUndo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStrategyEditorLayout.createSequentialGroup()
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSaveStrategy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelStrategyEditorLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSliderModificationGameTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonStepBackTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModificationVisualize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonStepForwardTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonNextFrameForImageMode)
                                    .addComponent(jToggleButtonRotationMode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPlayBackSpeedTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPlaybackSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTimeInterval)
                            .addComponent(jTextFieldTimeInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCurrentPosition)
                            .addComponent(jLabelCursorPosition)
                            .addComponent(jLabelSportsUnit))
                        .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonZoom))
                            .addGroup(jPanelStrategyEditorLayout.createSequentialGroup()
                                .addGroup(jPanelStrategyEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelStrategyViewerTime)
                                    .addComponent(jTextFieldStrategyViewerTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jTabbedPanePlayerCategory.addTab("Édition et visualisation de stratégie", jPanelStrategyEditor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanePlayerCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 1242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jTabbedPanePlayerCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxIsAGameObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIsAGameObjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxIsAGameObjectActionPerformed

    private void jTextFieldObjectVerticalSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObjectVerticalSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObjectVerticalSizeActionPerformed

    private void jTextFieldObjectHorizontalSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObjectHorizontalSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObjectHorizontalSizeActionPerformed

    private void jButtonNewGameObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameObjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewGameObjectActionPerformed

    private void jButtonDeleteStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteStrategyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteStrategyActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificationVisualizeActionPerformed

    private void jTextFieldTimeIntervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimeIntervalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimeIntervalActionPerformed

    private void jButtonNextFrameForImageModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFrameForImageModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextFrameForImageModeActionPerformed

    private void jButtonDestroySelectedSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDestroySelectedSportActionPerformed
        this.myController.removeSport();
    }//GEN-LAST:event_jButtonDestroySelectedSportActionPerformed

    private void jButtonSaveSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSportActionPerformed
        this.myController.saveSport();
    }//GEN-LAST:event_jButtonSaveSportActionPerformed

    private void jButtonChooseCategoryImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseCategoryImageActionPerformed
        myController.getCategoryPlayerImage();
    }//GEN-LAST:event_jButtonChooseCategoryImageActionPerformed

    private void jButtonDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCategoryActionPerformed
        this.myController.removeCategoryPlayer();
    }//GEN-LAST:event_jButtonDeleteCategoryActionPerformed

    private void jButtonCreateStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateStrategyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCreateStrategyActionPerformed

    private void jButtonNewSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewSportActionPerformed
        myController.resetPlaceHolderSport();
    }//GEN-LAST:event_jButtonNewSportActionPerformed

    private void jButtonLoadFieldImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadFieldImageActionPerformed
        myController.getSportImage();
    }//GEN-LAST:event_jButtonLoadFieldImageActionPerformed

    private void jButtonNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewCategoryActionPerformed
        myController.resetPlaceHolderCategoryPlayer();
    }//GEN-LAST:event_jButtonNewCategoryActionPerformed

    private void jButtonSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCategoryActionPerformed
        this.myController.saveCategoryPlayer();
    }//GEN-LAST:event_jButtonSaveCategoryActionPerformed

    private void jTextFieldCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCategoryNameActionPerformed

    private void jTextFieldCategorySizeHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategorySizeHorizontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCategorySizeHorizontalActionPerformed

    private void jButtonSaveGameObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGameObjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveGameObjectActionPerformed

    private void jTextFieldObjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObjectNameActionPerformed

    private void jButtonChooseObjectPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseObjectPictureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChooseObjectPictureActionPerformed

    private void jButtonDeleteGameObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteGameObjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteGameObjectActionPerformed

    private void jButtonLoadStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadStrategyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLoadStrategyActionPerformed

    private void jComboBoxChooseStrategySportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChooseStrategySportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxChooseStrategySportActionPerformed

    private void jTextFieldChooseStrategyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldChooseStrategyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldChooseStrategyNameActionPerformed

    private void jButtonSaveStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveStrategyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveStrategyActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jTextFieldStrategyViewerTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStrategyViewerTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStrategyViewerTimeActionPerformed

    private void jButtonZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonZoomActionPerformed

    private void jLabelCurrentPositionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelCurrentPositionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCurrentPositionPropertyChange

    private void jListExistingCategoriesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListExistingCategoriesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListExistingCategoriesPropertyChange

    private void jListExistingObstaclePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListExistingObstaclePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListExistingObstaclePropertyChange

    private void jListEditorStrategyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListEditorStrategyPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListEditorStrategyPropertyChange

    private void jListTypeModificationTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListTypeModificationTypePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListTypeModificationTypePropertyChange

    private void jListPlayersPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListPlayersPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListPlayersPropertyChange

    private void jListObjectsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListObjectsPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jListObjectsPropertyChange

    private void jSliderModificationGameTimeVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jSliderModificationGameTimeVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jSliderModificationGameTimeVetoableChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jPanelSportFieldViewerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelSportFieldViewerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelSportFieldViewerPropertyChange

    private void jPanelCategoryPicturePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelCategoryPicturePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCategoryPicturePropertyChange

    private void jPanelCategoryOnTerrainPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelCategoryOnTerrainPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelCategoryOnTerrainPropertyChange

    private void jPanelObstaclePicturePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelObstaclePicturePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelObstaclePicturePropertyChange

    private void jPanelObstacleOnTerrainPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelObstacleOnTerrainPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelObstacleOnTerrainPropertyChange

    private void jPanelStrategyEditorLocationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelStrategyEditorLocationPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelStrategyEditorLocationPropertyChange

    private void jToggleButtonRotationModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRotationModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonRotationModeActionPerformed

    private void jTextFieldPlaybackSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlaybackSpeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlaybackSpeedActionPerformed

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

    private void jTextFieldCategoryNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCategoryNameFocusLost
        myController.setCategoryPlayerName(this.jTextFieldCategoryName.getText());
    }//GEN-LAST:event_jTextFieldCategoryNameFocusLost

    private void jTextFieldCategorySizeHorizontalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCategorySizeHorizontalFocusLost
        try {
            myController.setCategoryPlayerHorizontalSize(Float.parseFloat(this.jTextFieldCategorySizeHorizontal.getText()));
            this.jTextFieldCategorySizeHorizontal.setBackground(Color.white);
        }
        catch (Exception Ex){
            this.jTextFieldCategorySizeHorizontal.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldCategorySizeHorizontalFocusLost

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

    private void jListExistingCategoriesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListExistingCategoriesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jListExistingCategoriesFocusLost

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
    private javax.swing.JButton jButtonChooseCategoryImage;
    private javax.swing.JButton jButtonChooseObjectPicture;
    private javax.swing.JButton jButtonCreateStrategy;
    private javax.swing.JButton jButtonDeleteCategory;
    private javax.swing.JButton jButtonDeleteGameObject;
    private javax.swing.JButton jButtonDeleteStrategy;
    private javax.swing.JButton jButtonDestroySelectedSport;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonLoadFieldImage;
    private javax.swing.JButton jButtonLoadStrategy;
    private javax.swing.JButton jButtonModificationVisualize;
    private javax.swing.JButton jButtonNewCategory;
    private javax.swing.JButton jButtonNewGameObject;
    private javax.swing.JButton jButtonNewSport;
    private javax.swing.JButton jButtonNextFrameForImageMode;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonSaveCategory;
    private javax.swing.JButton jButtonSaveGameObject;
    private javax.swing.JButton jButtonSaveSport;
    private javax.swing.JButton jButtonSaveStrategy;
    private javax.swing.JButton jButtonStepBackTime;
    private javax.swing.JButton jButtonStepForwardTime;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JButton jButtonZoom;
    private javax.swing.JCheckBox jCheckBoxIsAGameObject;
    private javax.swing.JComboBox<String> jComboBoxChooseStrategySport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAvailableStrategies;
    private javax.swing.JLabel jLabelCategoryImage;
    private javax.swing.JLabel jLabelCategoryName;
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
    private javax.swing.JLabel jLabelPlayerToSelect;
    private javax.swing.JLabel jLabelPlayersTableTitle;
    private javax.swing.JLabel jLabelSportField;
    private javax.swing.JLabel jLabelSportName;
    private javax.swing.JLabel jLabelSportsUnit;
    private javax.swing.JLabel jLabelStrategyCreationZoneTitle;
    private javax.swing.JLabel jLabelStrategyName;
    private javax.swing.JLabel jLabelStrategyViewerTime;
    private javax.swing.JLabel jLabelTimeInterval;
    private javax.swing.JList<String> jListEditorStrategy;
    private javax.swing.JList<String> jListExistingCategories;
    private javax.swing.JList<String> jListExistingObstacle;
    private javax.swing.JList<String> jListExistingSports;
    private javax.swing.JList<String> jListObjects;
    private javax.swing.JList<String> jListPlayers;
    private javax.swing.JList<String> jListTypeModificationType;
    private javax.swing.JPanel jPanelCategories;
    private javax.swing.JPanel jPanelCategoryOnTerrain;
    private javax.swing.JPanel jPanelCategoryPicture;
    private javax.swing.JPanel jPanelCreateLoadStrategy;
    private javax.swing.JPanel jPanelObstacle;
    private javax.swing.JPanel jPanelObstacleOnTerrain;
    private javax.swing.JPanel jPanelObstaclePicture;
    private javax.swing.JPanel jPanelSport;
    private javax.swing.JPanel jPanelSportFieldViewer;
    private javax.swing.JPanel jPanelStrategyEditor;
    private javax.swing.JPanel jPanelStrategyEditorLocation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
    private javax.swing.JSlider jSliderModificationGameTime;
    private javax.swing.JSpinner jSpinnerObjectTypeNumber;
    private javax.swing.JSpinner jSpinnerPlayerNumber;
    private javax.swing.JTabbedPane jTabbedPanePlayerCategory;
    private javax.swing.JTable jTableSportsItems;
    private javax.swing.JTextField jTextFieldCategoryName;
    private javax.swing.JTextField jTextFieldCategorySizeHorizontal;
    private javax.swing.JTextField jTextFieldCategorySizeVertical;
    private javax.swing.JTextField jTextFieldChooseStrategyName;
    private javax.swing.JTextField jTextFieldFieldUnits;
    private javax.swing.JTextField jTextFieldHorizontalSize;
    private javax.swing.JTextField jTextFieldObjectHorizontalSize;
    private javax.swing.JTextField jTextFieldObjectName;
    private javax.swing.JTextField jTextFieldObjectVerticalSize;
    private javax.swing.JTextField jTextFieldPlaybackSpeed;
    private javax.swing.JTextField jTextFieldSportName;
    private javax.swing.JTextField jTextFieldStrategyName;
    private javax.swing.JTextField jTextFieldStrategyViewerTime;
    private javax.swing.JTextField jTextFieldTimeInterval;
    private javax.swing.JTextField jTextFieldVerticalSize;
    private javax.swing.JToggleButton jToggleButtonRotationMode;
    private javax.swing.JTable tableSportPlayers;
    // End of variables declaration//GEN-END:variables
}
