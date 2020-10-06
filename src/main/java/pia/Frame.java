package pia;

import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Frame extends javax.swing.JFrame {
    //Atributes
    public String fileName;
    public String filePath;
    public int loadedFiles;
    public boolean activeEncoding;
    
    public Frame() {
        initComponents();
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);   //Centered Screen
        
        //Default Values
        fileName = "";
        filePath = "";
        fileTag.setText("");
        warning.setVisible(false);
        messagesPerPage.setEnabled(false);
        
        //Messages Per Page Input Listener
        DocumentListener documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                updateFixButton();
            }
            public void insertUpdate(DocumentEvent documentEvent) {
                updateFixButton();
            }
            public void removeUpdate(DocumentEvent documentEvent) {
                updateFixButton();
            }
            public void updateFixButton() {
                startButton.setEnabled( startConditions() );
            }
        };
        messagesPerPage.getDocument().addDocumentListener(documentListener);
    }
    
    /*
    Checks if the Start Button can be enabled, these conditions are:
    -At least one checkbox is selected
    -If the index checbox is selected
        -The value in the input must be a number
        -That number must be greater than 0
    -There must be at least one loaded file
    */
    public boolean startConditions() {
        if( generateIndexCheck.isSelected() ) {
            try {
                int n = Integer.parseInt( messagesPerPage.getText() );
                
                if(n <= 0)
                    return false;
            }
            catch(NumberFormatException e) {
                return false;
            }
        }
        else if( !fixEncodingCheck.isSelected() )
            return false;
        
        return loadedFiles != 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        topMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        filePanel = new javax.swing.JPanel();
        fileTag = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        openFileButton = new javax.swing.JButton();
        openFolderButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        loadedFilesTag = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        fixEncodingCheck = new javax.swing.JCheckBox();
        generateIndexCheck = new javax.swing.JCheckBox();
        messagesPerPage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Main.setMinimumSize(new java.awt.Dimension(300, 100));
        Main.setPreferredSize(new java.awt.Dimension(500, 300));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topMenu.setBackground(new java.awt.Color(255, 255, 255));
        topMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 0, 0, 1));
        topMenu.setOpaque(false);
        topMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/engrane2.png"))); // NOI18N
        jLabel2.setText("Facebook JSON Fixer");
        topMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        exitButton.setBackground(new java.awt.Color(244, 63, 63));
        exitButton.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("X");
        exitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitButton.setBorderPainted(false);
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setFocusable(false);
        exitButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                exitButtonMouseMoved(evt);
            }
        });
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        topMenu.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 50, 20));

        Main.add(topMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        filePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fileTag.setText("File");
        filePanel.add(fileTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 30));

        Main.add(filePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 290, 30));

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/validar.png"))); // NOI18N
        startButton.setText("Start");
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.setEnabled(false);
        startButton.setFocusable(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        Main.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 120, 30));

        jLabel1.setText("Current File:");
        Main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 70, 30));

        openFileButton.setBackground(new java.awt.Color(255, 255, 255));
        openFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrirArchivo.png"))); // NOI18N
        openFileButton.setText("Open File");
        openFileButton.setBorder(null);
        openFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFileButton.setFocusable(false);
        openFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                openFileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                openFileButtonMouseExited(evt);
            }
        });
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });
        Main.add(openFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, 30));

        openFolderButton.setBackground(new java.awt.Color(255, 255, 255));
        openFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrirDirectorio.png"))); // NOI18N
        openFolderButton.setText("Open Folder");
        openFolderButton.setBorder(null);
        openFolderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFolderButton.setFocusable(false);
        openFolderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                openFolderButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                openFolderButtonMouseExited(evt);
            }
        });
        openFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderButtonActionPerformed(evt);
            }
        });
        Main.add(openFolderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 120, 30));

        jLabel3.setText("Loaded Files: ");
        Main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        loadedFilesTag.setText("0");
        Main.add(loadedFilesTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        warning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warning.setText("Warning");
        Main.add(warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 480, -1));

        fixEncodingCheck.setText("Fix Encoding");
        fixEncodingCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixEncodingCheckActionPerformed(evt);
            }
        });
        Main.add(fixEncodingCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 120, -1));

        generateIndexCheck.setText("Generate Index");
        generateIndexCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateIndexCheckActionPerformed(evt);
            }
        });
        Main.add(generateIndexCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, -1));

        messagesPerPage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        messagesPerPage.setText("200");
        Main.add(messagesPerPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 50, -1));

        jLabel4.setText("Messages Per Page:");
        Main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 140, 20));

        getContentPane().add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Closes the program
    */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int opc;
        
        opc = JOptionPane.showConfirmDialog(this, "Are you sure you want to close the program?", "Close Program", JOptionPane.YES_NO_OPTION);
        
        if(opc == 0)
            System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /*
    Fixes the encoding and generates an index, depending on the checkboxes selected
    */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        File file = new File(filePath); //Path selected (May be a folder or a file)
        File targetFolder = null;   //Folder where the files will be saved inside the Converted Files folder
        
        startButton.setEnabled(false);
        
        /*
        Generates an index for the file or files selected
        */
        if(generateIndexCheck.isSelected()) {
            Index ind = new Index(filePath);
            
            targetFolder = Utilities.generateFolder(filePath);
            
            ind.generateIndex( Integer.parseInt( messagesPerPage.getText() ), targetFolder );
        }
        
        /*
        Fixes the encoding of the file or files selected.
        If the Generate Index checkbox is also selected, a folder with the same name as the original will be created
        inside the folder where the index was saved.
        */
        if(fixEncodingCheck.isSelected()) {
            if(file.isDirectory())
                Encoding.fixDirectory(filePath, targetFolder);
            else
                Encoding.fixEncoding(filePath, targetFolder, "");
        } 
    }//GEN-LAST:event_startButtonActionPerformed

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        exitButton.setBackground(new Color(244,63,63));
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseMoved
        exitButton.setBackground(new Color(224,32,32));
    }//GEN-LAST:event_exitButtonMouseMoved

    /*
    Opens the File Browser so the user can select a folder.
    The Folder Name and the Folder Path will be saved inside fileName and filePath.
    */
    private void openFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        /*
        The File Browser opens on the Files folder inside the project folder.
        The File Browser only shows folders.
        */
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/Files"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        warning.setVisible(false);
      
        /*
        The File Browser returns a value depending if the user choose a folder, closed the window or clicked the
        cancel button.
        */
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            File folder = new File( fileChooser.getSelectedFile().getAbsolutePath() );    //Choosed folder
            
            //If the folder exists and it is a directory.
            if(folder.exists() && folder.isDirectory()) {
                //Folder Data is saved and displayed
                fileName = folder.getName();
                filePath = folder.getAbsolutePath();
                fileTag.setText(fileName);
                
                //Counts the number of JSON files in the directory and displays it.
                File dir = new File(filePath);
                File[] dirFiles = dir.listFiles((File dir1, String filename) -> filename.toLowerCase().endsWith(".json"));
                
                loadedFiles = dirFiles.length;
                loadedFilesTag.setText(Integer.toString(loadedFiles) );
                
                //Checks if the conditions to enable the start button are fulfilled.
                startButton.setEnabled(startConditions() );
            }
            else {
                warning.setVisible(true);
                warning.setText("The folder you chose does not exist or it isn't a folder.");
            }
        }
    }//GEN-LAST:event_openFolderButtonActionPerformed

    private void openFolderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openFolderButtonMouseExited
        openFolderButton.setBackground(Color.white);
    }//GEN-LAST:event_openFolderButtonMouseExited

    private void openFolderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openFolderButtonMouseEntered
        if(openFolderButton.isEnabled())
            openFolderButton.setBackground(new Color(183,230,225));
    }//GEN-LAST:event_openFolderButtonMouseEntered

    /*
    Opens the File Browser so the user can select a file.
    The Folder Name and the Folder Path will be saved inside fileName and filePath.
    */
    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        /*
        The File Browser opens on the Files folder inside the project folder.
        The File Browser only shows JSON files.
        */
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/Files"));  //Se abre el selector de archivos en la carpeta actual
        fileChooser.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json", "json"));    //Filtro para archivos de texto
        warning.setVisible(false);
        
        /*
        The File Browser returns a value depending if the user choose a folder, closed the window or clicked the
        cancel button.
        */
        int valor = fileChooser.showOpenDialog(fileChooser);    //Muestra el selector de archivos y regresa un valor dependiendo las acciones realizadas en él
        if (valor == JFileChooser.APPROVE_OPTION) {     //Si se selecciona un fichero válido
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());  //Se crea un archivo con la ruta seleccionada
            
            //If the file exists and it is a JSON file.
            if(file.exists() && file.getName().toLowerCase().endsWith(".json")) {
                //File Data is saved and displayed
                fileName = file.getName();
                filePath = fileChooser.getSelectedFile().getAbsolutePath();
                fileTag.setText(fileName);
                
                //Filecounter
                loadedFiles = 1;
                loadedFilesTag.setText("1");
                
                //Checks if the conditions to enable the start button are fulfilled.
                startButton.setEnabled(startConditions() );
            }
            else {
                warning.setVisible(true);
                warning.setText("The file you chose does not exist or it isn't a json file.");
            }
        }
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void openFileButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openFileButtonMouseExited
        openFileButton.setBackground(Color.white);
    }//GEN-LAST:event_openFileButtonMouseExited

    private void openFileButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openFileButtonMouseEntered
        if(openFileButton.isEnabled())
            openFileButton.setBackground(new Color(183,230,225));
    }//GEN-LAST:event_openFileButtonMouseEntered

    /*
    Toggles the Messages Per Page input when the checkbox is clicked.
    If the conditions are met, the Start Button is enabled.
    */
    private void generateIndexCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateIndexCheckActionPerformed
        if(generateIndexCheck.isSelected())
            messagesPerPage.setEnabled(true);
        else
            messagesPerPage.setEnabled(false);
        
        startButton.setEnabled( startConditions() );
    }//GEN-LAST:event_generateIndexCheckActionPerformed

    private void fixEncodingCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixEncodingCheckActionPerformed
        startButton.setEnabled( startConditions() );
    }//GEN-LAST:event_fixEncodingCheckActionPerformed

    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel filePanel;
    private javax.swing.JLabel fileTag;
    private javax.swing.JCheckBox fixEncodingCheck;
    private javax.swing.JCheckBox generateIndexCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel loadedFilesTag;
    private javax.swing.JTextField messagesPerPage;
    private javax.swing.JButton openFileButton;
    private javax.swing.JButton openFolderButton;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel topMenu;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}