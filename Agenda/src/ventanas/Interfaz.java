/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import agenda.CURP;
import agenda.Entidad;
import agenda.Persona;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

/**
 *
 * @author erick
 */
public class Interfaz extends javax.swing.JFrame {

    ArrayList<Persona> listaContactos = new ArrayList<>();

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();

        CBEntidad.setModel(new javax.swing.DefaultComboBoxModel<>(Entidad.getEstadosLista()));
    }

    private Persona obtieneDatosVentana() {
        Persona p = new Persona();

        p.setNombre(TXTNombres.getText());
        p.setApellidoP(TXTApellidoP.getText());
        p.setApellidoM(TXTApellidoM.getText());
        p.setEmail(TXTemail.getText());
        p.setSexo(CBSexo.getSelectedItem().toString().charAt(0));
        p.setTel(Integer.parseInt(TXTTel.getText()));

        return p;
    }

    private void limpiajFrameInfoContacto() {
        TXTNombres.setText("");
        TXTApellidoP.setText("");
        TXTApellidoM.setText("");
        TXTemail.setText("");
        CBSexo.setSelectedIndex(0);
        TXTTel.setText("");
        CBEntidad.setSelectedIndex(0);
        TXTFechaNac.setText("");
    }

    private void estableceCURP() {
        System.out.println("Aqui");
        GregorianCalendar fechaNac = new GregorianCalendar(1987, 9 - 1, 3); //Temporal
        TXTcurp.setText(CURP.calculaCURP(TXTApellidoP.getText(), TXTApellidoM.getText(), TXTNombres.getText(), CBSexo.getSelectedItem().toString().charAt(0), fechaNac, Entidad.DISTRITO_FEDERAL));
    }

    private void creaPanelContactos(Persona p) {
        JPanel jPanelContactoResumen = new JPanel();
        javax.swing.GroupLayout jPanelContactoResumenLayout = new javax.swing.GroupLayout(jPanelContactoResumen);
        javax.swing.JLabel jLabelImagen = new javax.swing.JLabel();
        javax.swing.JLabel jLNombre = new javax.swing.JLabel();
        javax.swing.JLabel jLTel = new javax.swing.JLabel();
        javax.swing.JLabel jLcurp = new javax.swing.JLabel();
        javax.swing.JLabel jLNombreContenido = new javax.swing.JLabel();
        javax.swing.JLabel jLTelContenido = new javax.swing.JLabel();
        javax.swing.JLabel jLcurpContenido = new javax.swing.JLabel();
        javax.swing.JButton BTNeditar = new javax.swing.JButton();
        javax.swing.JButton BTNborrar = new javax.swing.JButton();

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        jLNombre.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLNombre.setText("Nombre:");

        jLTel.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLTel.setText("Teléfono:");

        jLcurp.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLcurp.setText("CURP:");

        BTNeditar.setText("Editar");
        BTNborrar.setText("Borrar");

        jLNombreContenido.setText(p.getNombre() + " " + p.getApellidoP() + " " + p.getApellidoM());

        jLTelContenido.setText(String.valueOf(p.getTel()));

        jLcurpContenido.setText(p.getCURP());

        jPanelContactoResumen.setLayout(jPanelContactoResumenLayout);
        jPanelContactoResumenLayout.setHorizontalGroup(
                jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelContactoResumenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelImagen)
                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelContactoResumenLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLTel)
                                                        .addComponent(jLNombre)
                                                        .addComponent(jLcurp))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLcurpContenido)
                                                        .addComponent(jLTelContenido)
                                                        .addComponent(jLNombreContenido))
                                                .addContainerGap(242, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContactoResumenLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BTNborrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BTNeditar)
                                                .addContainerGap())))
        );
        jPanelContactoResumenLayout.setVerticalGroup(
                jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContactoResumenLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelContactoResumenLayout.createSequentialGroup()
                                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLNombre)
                                                        .addComponent(jLNombreContenido))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLTel)
                                                        .addComponent(jLTelContenido))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLcurp)
                                                        .addComponent(jLcurpContenido))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BTNeditar)
                                                        .addComponent(BTNborrar))
                                                .addContainerGap())
                                        .addComponent(jLabelImagen)))
        );

        jPanelContacto.add(jPanelContactoResumen);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameInfoContacto = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        TXTNombres = new javax.swing.JTextField();
        TXTApellidoP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXTApellidoM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        CBEntidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TXTFechaNac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TXTTel = new javax.swing.JTextField();
        TXTcurp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TXTemail = new javax.swing.JTextField();
        jPanelContactoResumen = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLTel = new javax.swing.JLabel();
        jLcurp = new javax.swing.JLabel();
        jLNombreContenido = new javax.swing.JLabel();
        jLTelContenido = new javax.swing.JLabel();
        jLcurpContenido = new javax.swing.JLabel();
        BTNeditar = new javax.swing.JButton();
        BTNborrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelContacto = new javax.swing.JPanel();
        BTNagregaContacto = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jFrameInfoContacto.setMinimumSize(new java.awt.Dimension(300, 400));

        jLabel1.setText("Nombres:");

        TXTNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTNombresKeyTyped(evt);
            }
        });

        TXTApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTApellidoPActionPerformed(evt);
            }
        });
        TXTApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTApellidoPKeyTyped(evt);
            }
        });

        jLabel2.setText("Apellido Paterno:");

        TXTApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTApellidoMActionPerformed(evt);
            }
        });
        TXTApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTApellidoMKeyTyped(evt);
            }
        });

        jLabel3.setText("Apellido Materno:");

        jLabel4.setText("Sexo:");

        CBSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        CBSexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBSexoItemStateChanged(evt);
            }
        });

        jLabel5.setText("Entidad:");

        CBEntidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBEntidadItemStateChanged(evt);
            }
        });

        jLabel6.setText("Fecha de Nacimiento:");

        TXTFechaNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTFechaNacKeyTyped(evt);
            }
        });

        jLabel7.setText("Teléfono:");

        TXTTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTTelActionPerformed(evt);
            }
        });

        TXTcurp.setEnabled(false);
        TXTcurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTcurpActionPerformed(evt);
            }
        });

        jLabel8.setText("CURP:");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("e-mail:");

        TXTemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTemailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameInfoContactoLayout = new javax.swing.GroupLayout(jFrameInfoContacto.getContentPane());
        jFrameInfoContacto.getContentPane().setLayout(jFrameInfoContactoLayout);
        jFrameInfoContactoLayout.setHorizontalGroup(
            jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTNombres))
                    .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTApellidoP))
                    .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTApellidoM))
                    .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                        .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTTel)))
                        .addGap(0, 107, Short.MAX_VALUE))
                    .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTcurp))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameInfoContactoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAceptar))
                    .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTemail)))
                .addContainerGap())
        );
        jFrameInfoContactoLayout.setVerticalGroup(
            jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameInfoContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXTApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(CBEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TXTFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(TXTTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(TXTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(TXTcurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jFrameInfoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        jLNombre.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLNombre.setText("Nombre:");

        jLTel.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLTel.setText("Teléfono:");

        jLcurp.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLcurp.setText("CURP:");

        jLNombreContenido.setText("Nombres");

        jLTelContenido.setText("Telefono");

        jLcurpContenido.setText("CURP");

        BTNeditar.setText("Editar");

        BTNborrar.setText("Borrar");

        javax.swing.GroupLayout jPanelContactoResumenLayout = new javax.swing.GroupLayout(jPanelContactoResumen);
        jPanelContactoResumen.setLayout(jPanelContactoResumenLayout);
        jPanelContactoResumenLayout.setHorizontalGroup(
            jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactoResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagen)
                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContactoResumenLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTel)
                            .addComponent(jLNombre)
                            .addComponent(jLcurp))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLcurpContenido)
                            .addComponent(jLTelContenido)
                            .addComponent(jLNombreContenido))
                        .addContainerGap(242, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContactoResumenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNborrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNeditar)
                        .addContainerGap())))
        );
        jPanelContactoResumenLayout.setVerticalGroup(
            jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContactoResumenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelContactoResumenLayout.createSequentialGroup()
                        .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNombre)
                            .addComponent(jLNombreContenido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTel)
                            .addComponent(jLTelContenido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLcurp)
                            .addComponent(jLcurpContenido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelContactoResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNeditar)
                            .addComponent(BTNborrar))
                        .addContainerGap())
                    .addComponent(jLabelImagen)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelContacto.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(jPanelContacto);

        BTNagregaContacto.setText("Añadir Contacto");
        BTNagregaContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNagregaContactoActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTNagregaContacto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNagregaContacto))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNagregaContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNagregaContactoActionPerformed
        // TODO add your handling code here:
        limpiajFrameInfoContacto();
        jFrameInfoContacto.setVisible(true);
    }//GEN-LAST:event_BTNagregaContactoActionPerformed

    private void TXTApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTApellidoPActionPerformed

    private void TXTApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTApellidoMActionPerformed

    private void TXTTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTTelActionPerformed

    private void TXTcurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTcurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTcurpActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        listaContactos.add(obtieneDatosVentana());

        jFrameInfoContacto.setVisible(false);
        jFrameInfoContacto.dispose();

        //listaContactos.add(new JPanel());
        //jPanelContacto.add(listaContactos.get(listaContactos.size() - 1));
        creaPanelContactos(listaContactos.get(listaContactos.size() - 1));
        jPanelContacto.updateUI();

    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jFrameInfoContacto.setVisible(false);
        jFrameInfoContacto.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void TXTemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTemailActionPerformed

    private void TXTNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTNombresKeyTyped
        estableceCURP();
    }//GEN-LAST:event_TXTNombresKeyTyped

    private void TXTApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTApellidoPKeyTyped
        estableceCURP();
    }//GEN-LAST:event_TXTApellidoPKeyTyped

    private void TXTApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTApellidoMKeyTyped
        estableceCURP();
    }//GEN-LAST:event_TXTApellidoMKeyTyped

    private void TXTFechaNacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTFechaNacKeyTyped
        estableceCURP();
    }//GEN-LAST:event_TXTFechaNacKeyTyped

    private void CBSexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBSexoItemStateChanged
        estableceCURP();
    }//GEN-LAST:event_CBSexoItemStateChanged

    private void CBEntidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBEntidadItemStateChanged
        estableceCURP();
    }//GEN-LAST:event_CBEntidadItemStateChanged

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNagregaContacto;
    private javax.swing.JButton BTNborrar;
    private javax.swing.JButton BTNeditar;
    private javax.swing.JComboBox<String> CBEntidad;
    private javax.swing.JComboBox<String> CBSexo;
    private javax.swing.JTextField TXTApellidoM;
    private javax.swing.JTextField TXTApellidoP;
    private javax.swing.JTextField TXTFechaNac;
    private javax.swing.JTextField TXTNombres;
    private javax.swing.JTextField TXTTel;
    private javax.swing.JTextField TXTcurp;
    private javax.swing.JTextField TXTemail;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JFrame jFrameInfoContacto;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLNombreContenido;
    private javax.swing.JLabel jLTel;
    private javax.swing.JLabel jLTelContenido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLcurp;
    private javax.swing.JLabel jLcurpContenido;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelContacto;
    private javax.swing.JPanel jPanelContactoResumen;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
