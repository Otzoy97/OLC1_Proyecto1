/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import analyzer.Scanner;
import analyzer.Parser;
import analyzer.Token;
import html.hscript.Variable;
import java.awt.Desktop;
import java.io.StringReader;
import java.util.LinkedList;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author otzoy
 */
public class Proyecto extends javax.swing.JFrame {

    private String nameFile = "";
    private JFileChooser jabrir = new JFileChooser();
    private JFileChooser jsave = new JFileChooser();
    private File tkErrores = null;
    private File tkLexico = null;
    private File tkSintactico = null;
    private File fileHTML = null;

    /**
     * Creates new form proyecto
     */
    public Proyecto() {
        initComponents();
        this.editHtml.setEditable(false);
        this.txtResult.setEditable(false);
    }

    public BufferedImage getImageIcon() {
        try {
            return ImageIO.read(this.getClass().getResource("src/res/seo.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
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

        tabTop = new javax.swing.JTabbedPane();
        panelInput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        panelOutput = new javax.swing.JPanel();
        panelOutputTop = new javax.swing.JPanel();
        cmbActionResult = new javax.swing.JComboBox<>();
        btnAbrirNavegador = new javax.swing.JButton();
        tabOutputBottom = new javax.swing.JTabbedPane();
        panelTextPlain = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        panelHTMLView = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        editHtml = new javax.swing.JEditorPane();
        sepResult = new javax.swing.JSeparator();
        tabBottom = new javax.swing.JTabbedPane();
        panelConsole = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        panelVar = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVar = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemAbrir = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemGuardar = new javax.swing.JMenuItem();
        itemGuardarComo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemCompilar = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        itemUsuario = new javax.swing.JMenuItem();
        itemTecnico = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[OLC1] - Proyecto 1");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/res/seo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tabTop.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        panelInput.setLayout(new java.awt.GridBagLayout());

        txtInput.setColumns(20);
        txtInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtInput.setRows(5);
        jScrollPane1.setViewportView(txtInput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelInput.add(jScrollPane1, gridBagConstraints);

        tabTop.addTab("Edición", panelInput);

        panelOutput.setLayout(new java.awt.GridBagLayout());

        panelOutputTop.setLayout(new java.awt.GridBagLayout());

        cmbActionResult.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbActionResult.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Archivo de salida", "Reporte de tokens", "Errores léxicos", "Errores sintácticos" }));
        cmbActionResult.setToolTipText("");
        cmbActionResult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbActionResultItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        panelOutputTop.add(cmbActionResult, gridBagConstraints);

        btnAbrirNavegador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAbrirNavegador.setText("Abrir con navegador");
        btnAbrirNavegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirNavegadorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelOutputTop.add(btnAbrirNavegador, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelOutput.add(panelOutputTop, gridBagConstraints);

        panelTextPlain.setLayout(new java.awt.GridBagLayout());

        txtResult.setColumns(20);
        txtResult.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtResult.setRows(5);
        jScrollPane4.setViewportView(txtResult);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelTextPlain.add(jScrollPane4, gridBagConstraints);

        tabOutputBottom.addTab("Texto plano", panelTextPlain);

        panelHTMLView.setLayout(new java.awt.GridBagLayout());

        editHtml.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane5.setViewportView(editHtml);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelHTMLView.add(jScrollPane5, gridBagConstraints);

        tabOutputBottom.addTab("Vista HTML", panelHTMLView);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        panelOutput.add(tabOutputBottom, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        panelOutput.add(sepResult, gridBagConstraints);

        tabTop.addTab("Resultados", panelOutput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        getContentPane().add(tabTop, gridBagConstraints);

        tabBottom.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        panelConsole.setLayout(new java.awt.GridBagLayout());

        txtConsole.setColumns(20);
        txtConsole.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtConsole.setRows(5);
        jScrollPane2.setViewportView(txtConsole);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelConsole.add(jScrollPane2, gridBagConstraints);

        tabBottom.addTab("Consola", panelConsole);

        panelVar.setLayout(new java.awt.GridBagLayout());

        tableVar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableVar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo", "Valor", "Linea", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableVar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelVar.add(jScrollPane3, gridBagConstraints);

        tabBottom.addTab("Variables", panelVar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(tabBottom, gridBagConstraints);

        menuArchivo.setText("Archivo");

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNuevo.setText("Nuevo archivo...");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemNuevo);
        menuArchivo.add(jSeparator1);

        itemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemAbrir.setText("Abrir archivo...");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemAbrir);
        menuArchivo.add(jSeparator2);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemGuardar.setText("Guardar...");
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardar);

        itemGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemGuardarComo.setText("Guardar como...");
        itemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarComoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardarComo);
        menuArchivo.add(jSeparator3);

        itemCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemCompilar.setText("Compilar");
        itemCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompilarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCompilar);

        jMenuBar1.add(menuArchivo);

        menuAyuda.setText("Ayuda");

        itemUsuario.setText("Manual de usuario");
        menuAyuda.add(itemUsuario);

        itemTecnico.setText("Manual técnico");
        menuAyuda.add(itemTecnico);
        menuAyuda.add(jSeparator4);

        itemAcerca.setText("Acerca de");
        itemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaActionPerformed(evt);
            }
        });
        menuAyuda.add(itemAcerca);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Guarda el archivo actual, si no existe un archivo actual solicita al usuario a guardar un nuevo
     * @param evt 
     */
    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        if (!this.nameFile.isEmpty()) {
            this.guardar();
        } else {
            this.guardarComo();
        }
    }//GEN-LAST:event_itemGuardarActionPerformed
    /**
     * Solicita al usuario guardar el archivo actual, o si ya existe solo lo guarda
     * Limpia la dirección del archivo actual y limpia el txtInput
     * @param evt 
     */
    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        //Solicita guardar el archivo actual
        if (!this.nameFile.isEmpty()) {
            this.guardar();
        } else {
            this.guardarComo();
        }
        //Elimina el contenido actual del input
        this.txtInput.setText("");
        //Limpia la dirección del archivo
        this.nameFile = "";
    }//GEN-LAST:event_itemNuevoActionPerformed
    /**
     * Despliega un mensaje con mi información uwu
     * @param evt 
     */
    private void itemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaActionPerformed
        // TODO add your handling code here:
        javax.swing.JOptionPane.showMessageDialog(this, "201602782\nSergio Fernando Otzoy Gonzalez", "[OLC1] - Proyecto 1", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_itemAcercaActionPerformed
    /**
     * Guarda el archivo actual
     * @param evt 
     */
    private void itemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarComoActionPerformed
        // TODO add your handling code here:
        this.guardarComo();
    }//GEN-LAST:event_itemGuardarComoActionPerformed
    /**
     * Despliega un filechooser para especificar la dirección del archivo a abrir
     * @param evt 
     */
    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        // TODO add your handling code here:
        jabrir.setDialogTitle("Seleccionar archivo...");
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivo código web", new String[]{"uweb", "UWEB"});
        jabrir.setAcceptAllFileFilterUsed(false);
        jabrir.setFileFilter(ext);
        int resultChoose = jabrir.showOpenDialog(this);
        if (resultChoose == JFileChooser.APPROVE_OPTION) {
            this.nameFile = jabrir.getSelectedFile().getAbsolutePath();
            String nombreArchivo = jabrir.getSelectedFile().getName();
            String linea, output = "";
            try {
                FileReader fileReader = new FileReader(nameFile);
                try (BufferedReader bfReader = new BufferedReader(fileReader)) {
                    while ((linea = bfReader.readLine()) != null) {
                        output += linea + "\n";
                    }
                    this.setTitle("[OLC1] - Practica 1 : " + nombreArchivo);
                    this.txtInput.setText(output);
                    jabrir.setCurrentDirectory(new File(nameFile));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al leer el archivo.\n" + ex.getMessage(), "[OLC1] - Practica 1", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se cargó el archivo", "[OLC1] - Proyecto 1", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_itemAbrirActionPerformed
    /**
     * Analiza léxicamente y sintácticamente un archivo para generar : un
     * archivo de salida informe de tokens informe de errores léxicos informe de
     * errores sintácticos
     *
     * @param evt
     */
    private void itemCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompilarActionPerformed
        // TODO add your handling code here:
        //Limpia el texto de consola
        Proyecto.txtConsole.setText("");
        //Instancia un objeto de Scanner
        //Luego instancia un objeto parser
        //Recupera las listas u objetos que generó el parser
        Scanner scan = new analyzer.Scanner(new BufferedReader(new StringReader(this.txtInput.getText())));
        //Realiza el informe léxico
        this.construirInformeLexico(scan);
        Parser parser = new Parser(scan);
        try {
            parser.parse();
            //Realiza el inform sintáctico
            this.construirInformeSintactico(parser);
            //Llena la tabla de variables
            this.llenarTabla(parser);
            //Genera el archivo de salida
            this.makeFile(parser.html_file.getHtml(), "ArchivoResultante.html", this.fileHTML);
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage() + " " + ex.getLocalizedMessage() + " ", "[OLC1] Proyecto 1 - Parser", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemCompilarActionPerformed
    /**
     * 
     * @param evt 
     */
    private void btnAbrirNavegadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirNavegadorActionPerformed
        // TODO add your handling code here:
        try{
            switch( ( (JComboBox) evt.getSource()).getSelectedIndex()){
                case 0:
                    Desktop.getDesktop().browse(this.fileHTML.toURI());
                    break;
                case 1:
                    Desktop.getDesktop().browse(this.tkLexico.toURI());
                    break;
                case 2:
                    Desktop.getDesktop().browse(this.tkErrores.toURI());
                    break;
                case 3:
                    Desktop.getDesktop().browse(this.tkSintactico.toURI());
                    break;
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(this, "Nada que mostrar", "[OLC1 - Proyecto 1]", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAbrirNavegadorActionPerformed
    
    /**
     * Al cambiar el indice cambiará la vista del editor pane
     *
     * @param evt
     */
    private void cmbActionResultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbActionResultItemStateChanged
        // TODO add your handling code here:
        try{
            if (evt.getStateChange() == 1){
                switch( ( (JComboBox) evt.getSource()).getSelectedIndex()){
                    case 0:
                        this.editHtml.setPage(this.fileHTML.getAbsolutePath());
                        break;
                    case 1:
                        this.editHtml.setPage(this.tkLexico.getAbsolutePath());
                        break;
                    case 2:
                        this.editHtml.setPage(this.tkErrores.getAbsolutePath());
                        break;
                    case 3:
                        this.editHtml.setPage(this.tkSintactico.getAbsolutePath());
                        break;
                }
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(this, "Nada que mostrar", "[OLC1 - Proyecto 1]", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cmbActionResultItemStateChanged
   
    /**
     * Especifica una nueva ruta para el archivo
     */
    private void guardarComo() {
        jsave.setDialogTitle("Guardar como...");
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivo código web", new String[]{"uweb", "UWEB"});
        jsave.setAcceptAllFileFilterUsed(false);
        jsave.setFileFilter(ext);
        int resultSave = jsave.showSaveDialog(this);
        if (resultSave == JFileChooser.APPROVE_OPTION) {
            this.nameFile = jsave.getSelectedFile().getAbsolutePath() + ".uweb";
            String nombreArchivo = this.jsave.getSelectedFile().getName() + ".uweb";
            FileWriter fileWriter = null;
            BufferedWriter bfWriter = null;
            File fileSave;
            try {
                fileSave = new File(this.nameFile);
                fileWriter = new FileWriter(fileSave);
                bfWriter = new BufferedWriter(fileWriter);
                bfWriter.write(this.txtInput.getText());
                this.setTitle("[OLC1] - Proyecto 1 : " + nombreArchivo);
                jsave.setCurrentDirectory(fileSave);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al escribir el archivo.\n" + ex.getMessage(), "[OLC1] - Proyecto 1", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (bfWriter != null) {
                        bfWriter.close();
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "[OLC1] - Proyecto 1", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Guarda el archivo actual
     */
    private void guardar() {
        if (!this.nameFile.isEmpty()) {
            FileWriter fileWriter = null;
            BufferedWriter bfWriter = null;
            File fileSave;
            try {
                fileSave = new File(this.nameFile);
                fileWriter = new FileWriter(fileSave);
                bfWriter = new BufferedWriter(fileWriter);
                bfWriter.write(this.txtInput.getText());
                this.setTitle("[OLC1] - Proyecto 1 : " + fileSave.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al escribir el archivo.\n" + ex.getMessage(), "[OLC1] - Proyecto 1", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (bfWriter != null) {
                        bfWriter.close();
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "[OLC1] - Proyecto 1", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Realiza el informe de erroes léxico y el informe general de tokens
     *
     * @param scan
     */
    private void construirInformeLexico(Scanner scan) {
        //Recupera ambas listas
        LinkedList<Token> tk = scan.LexTok;
        LinkedList<Token> terr = scan.LexErr;
        //Desde acá se construirá la cadena HTML
        StringBuilder sb = new StringBuilder();
        //Recorre ambas listas y arma una tabla HTML
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"UTF-8\" />\n");
        sb.append("<title>\n").append("Análisis léxico").append("</title>\n");
        sb.append("</head>\n");
        sb.append("<style>\n");
        sb.append(".tg  {border-collapse:collapse;border-spacing:0;border-color:#aaa;margin:0px auto;}\n"
                + ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#aaa;color:#333;background-color:#fff;}\n"
                + ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#aaa;color:#fff;background-color:#f38630;}\n"
                + ".tg .tg-baqh{text-align:center;vertical-align:top}\n"
                + ".tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}\n"
                + "@media screen and (max-width: 767px) {.tg {width: auto !important;}.tg col {width: auto !important;}.tg-wrap {overflow-x: auto;-webkit-overflow-scrolling: touch;margin: auto 0px;}}");
        sb.append("</style>\n");
        sb.append("<body>\n");
        sb.append("<div class=\"tg-wrap\">\n");
        sb.append("<table class=\"tg\">");
        sb.append("<tr>");
        sb.append("<th  class=\"tg-baqh\">").append("No.").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Fila").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Columna").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Lexema").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Token").append("</th>");
        sb.append("</tr>");
        //este contador servirá para contar los tokens encontrados
        int contador = 1;
        //Obtiene la forma HTML del token
        for (Token token : tk) {
            sb.append(token.getToken(contador++));
        }
        sb.append("</table>");
        sb.append("</div>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        //Manda a hacer el fichero
        this.makeFile(sb.toString(), "Análisis_Lexico", this.tkLexico);
        //Limpia el stringbuilder
        sb = new StringBuilder();
        //---------------Ahora realiza el mismo procedimiento
        //con los erroes
        //Añade el encabezado anteriormente guardado
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"UTF-8\" />\n");
        sb.append("<title>\n").append("Errores léxico").append("</title>\n");
        sb.append("</head>\n");
        sb.append("<style>\n");
        sb.append(".tg  {border-collapse:collapse;border-spacing:0;border-color:#aaa;margin:0px auto;}\n"
                + ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#aaa;color:#333;background-color:#fff;}\n"
                + ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#aaa;color:#fff;background-color:#f38630;}\n"
                + ".tg .tg-baqh{text-align:center;vertical-align:top}\n"
                + ".tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}\n"
                + "@media screen and (max-width: 767px) {.tg {width: auto !important;}.tg col {width: auto !important;}.tg-wrap {overflow-x: auto;-webkit-overflow-scrolling: touch;margin: auto 0px;}}");
        sb.append("</style>\n");
        sb.append("<body>\n");
        sb.append("<div class=\"tg-wrap\">\n");
        sb.append("<table class=\"tg\">");
        sb.append("<tr>");
        sb.append("<th  class=\"tg-baqh\">").append("No.").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Fila").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Columna").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Lexema").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Token").append("</th>");
        sb.append("</tr>");
        //reinicia el contador
        contador = 1;
        //Obtiene la forma HTML del token
        for (Token token : terr) {
            sb.append(token.getToken(contador++));
        }
        sb.append("</table>");
        sb.append("</div>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        //Manda a hacer el fichero
        this.makeFile(sb.toString(), "Errores_Lexicos", this.tkErrores);
    }

    /**
     * Realiza el informe de errores sintácticos
     *
     * @param parser
     */
    private void construirInformeSintactico(Parser parser) {
        //Desde acá se construirá la cadena HTML
        StringBuilder sb = new StringBuilder();
        //Recorre ambas listas y arma una tabla HTML
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"UTF-8\" />\n");
        sb.append("<title>\n").append("Errores sintácticos").append("</title>\n");
        sb.append("</head>\n");
        sb.append("<style>\n");
        sb.append(".tg  {border-collapse:collapse;border-spacing:0;border-color:#aaa;margin:0px auto;}\n"
                + ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#aaa;color:#333;background-color:#fff;}\n"
                + ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#aaa;color:#fff;background-color:#f38630;}\n"
                + ".tg .tg-baqh{text-align:center;vertical-align:top}\n"
                + ".tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}\n"
                + "@media screen and (max-width: 767px) {.tg {width: auto !important;}.tg col {width: auto !important;}.tg-wrap {overflow-x: auto;-webkit-overflow-scrolling: touch;margin: auto 0px;}}");
        sb.append("</style>\n");
        sb.append("<body>\n");
        sb.append("<div class=\"tg-wrap\">\n");
        sb.append("<table class=\"tg\">");
        sb.append("<tr>");
        sb.append("<th  class=\"tg-baqh\">").append("No.").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Tipo").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Fila").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Columa").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Lexema").append("</th>");
        sb.append("<th  class=\"tg-baqh\" >").append("Token").append("</th>");
        sb.append("</tr>");
        parser.errores.forEach((str) -> {
            sb.append(str);
        });
        sb.append("</table>");
        sb.append("</div>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        //Manda a hacer el fichero
        this.makeFile(sb.toString(), "Errores sintácticos", this.tkSintactico);
    }

    /**
     * Construye el archivo para los infomes
     *
     * @param cadena
     */
    private void makeFile(String cadena, String titulo, File file) {
        FileWriter fileWriter = null;
        BufferedWriter bfWriter = null;
        try {
            file = new File(titulo + ".html");
            fileWriter = new FileWriter(file);
            bfWriter = new BufferedWriter(fileWriter);
            bfWriter.write(cadena);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al escribir el archivo.\n" + ex.getMessage(), "[OLC1] - Proyecto 1", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (bfWriter != null) {
                    bfWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "[OLC1] - Proyecto 1", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Llena la tabla del informe de variables
     *
     * @param parser
     */
    private void llenarTabla(Parser parser) {
        //Recupera el modelo de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) this.tableVar.getModel();
        //Limpia la tabla
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            //Remueve todas las filas
            tableModel.removeRow(i);
        }
        //Llena la tabla conlos datos del parser
        parser.listaVariable.forEach((Variable var) -> {
            //Añade la información
            tableModel.addRow(var.getFilaInfo());
        });
    }

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
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Proyecto proyecto = new Proyecto();
            proyecto.setLocationRelativeTo(null);
            proyecto.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirNavegador;
    private javax.swing.JComboBox<String> cmbActionResult;
    private javax.swing.JEditorPane editHtml;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemAcerca;
    private javax.swing.JMenuItem itemCompilar;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemGuardarComo;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemTecnico;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JPanel panelConsole;
    private javax.swing.JPanel panelHTMLView;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPanel panelOutputTop;
    private javax.swing.JPanel panelTextPlain;
    private javax.swing.JPanel panelVar;
    private javax.swing.JSeparator sepResult;
    private javax.swing.JTabbedPane tabBottom;
    private javax.swing.JTabbedPane tabOutputBottom;
    private javax.swing.JTabbedPane tabTop;
    private javax.swing.JTable tableVar;
    public static javax.swing.JTextArea txtConsole;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables
}
