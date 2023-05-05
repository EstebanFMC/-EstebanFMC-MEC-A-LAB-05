/*
LINK DE LA INFORMACIÓN; https://www.datos.gov.co/Salud-y-Protecci-n-Social/Casos-positivos-de-COVID-19-en-Colombia/gt2j-8ykr/explore/query/SELECT%0A%20%20%60fecha_reporte_web%60%2C%0A%20%20%60id_de_caso%60%2C%0A%20%20%60fecha_de_notificaci_n%60%2C%0A%20%20%60departamento%60%2C%0A%20%20%60departamento_nom%60%2C%0A%20%20%60ciudad_municipio%60%2C%0A%20%20%60ciudad_municipio_nom%60%2C%0A%20%20%60edad%60%2C%0A%20%20%60unidad_medida%60%2C%0A%20%20%60sexo%60%2C%0A%20%20%60fuente_tipo_contagio%60%2C%0A%20%20%60ubicacion%60%2C%0A%20%20%60estado%60%2C%0A%20%20%60pais_viajo_1_cod%60%2C%0A%20%20%60pais_viajo_1_nom%60%2C%0A%20%20%60recuperado%60%2C%0A%20%20%60fecha_inicio_sintomas%60%2C%0A%20%20%60fecha_muerte%60%2C%0A%20%20%60fecha_diagnostico%60%2C%0A%20%20%60fecha_recuperado%60%2C%0A%20%20%60tipo_recuperacion%60%2C%0A%20%20%60per_etn_%60%2C%0A%20%20%60nom_grupo_%60/page/filter
*/
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;



public class Interfaz extends javax.swing.JFrame {

    
FileInputStream ArchivoEntrada;
XSSFWorkbook libro; 
XSSFSheet hoja;



    public Interfaz() throws FileNotFoundException, IOException {
        initComponents();
         ArchivoEntrada = new FileInputStream("NumeroContagios.xlsx");
         libro = new XSSFWorkbook (ArchivoEntrada);
         hoja = libro.getSheetAt(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        OpcionesBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BarrasButtom = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PastelButtom = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        GeneroToggle = new javax.swing.JToggleButton();
        EdadToggle = new javax.swing.JToggleButton();
        CiudadToggle = new javax.swing.JToggleButton();
        ContagioToggle = new javax.swing.JToggleButton();
        DescargarButtom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Contagios del Covid - 19. Enero 2022 - 2023");

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        OpcionesBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OpcionesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Contagios por genero", "Contagios por municipio", "Contagios por edad", "Medio de contagio" }));
        OpcionesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Filtros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(OpcionesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpcionesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BarrasButtom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BarrasButtom.setText("Graficar");
        BarrasButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarrasButtomActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Gráfico de pastel");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Gráfico de barras");

        PastelButtom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PastelButtom.setText("Graficar");
        PastelButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastelButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BarrasButtom)
                    .addComponent(jLabel4))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(PastelButtom)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BarrasButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PastelButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Graficar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("Filtrado de datos");

        GeneroToggle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GeneroToggle.setText("Genero");
        GeneroToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneroToggleActionPerformed(evt);
            }
        });

        EdadToggle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EdadToggle.setText("Edad");
        EdadToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdadToggleActionPerformed(evt);
            }
        });

        CiudadToggle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CiudadToggle.setText("Ciudad");
        CiudadToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadToggleActionPerformed(evt);
            }
        });

        ContagioToggle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ContagioToggle.setText("Tipo de contagio");
        ContagioToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContagioToggleActionPerformed(evt);
            }
        });

        DescargarButtom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DescargarButtom.setText("Descargar Datos");
        DescargarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescargarButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(GeneroToggle)
                    .addComponent(EdadToggle)
                    .addComponent(CiudadToggle)
                    .addComponent(ContagioToggle)
                    .addComponent(DescargarButtom))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GeneroToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EdadToggle)
                .addGap(11, 11, 11)
                .addComponent(CiudadToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContagioToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(DescargarButtom)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(196, 196, 196))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


//METODOS CREADOS:

    int masculino = 0, femenino = 0; //NUMERO DE CONTAGIOS SEGUN EL SEXO
    public void ContagioPorSexo() throws FileNotFoundException, IOException{   
       
       for(Row fila : hoja)
        {
           Cell celda = fila.getCell(3);
           if(fila.getRowNum()!=0){
            if("M".equals(celda.getStringCellValue()))
            masculino++;
            else
            femenino++;
           } 
        }
    }
    
     
    int comunitaria = 0, relacionada = 0; //NUMERO DE CONTAGIOS SEGUN EL TIPO
    public void TipoContagio() throws FileNotFoundException, IOException{    
        for(Row fila : hoja){
            Cell celda = fila.getCell(4);
            if(fila.getRowNum()!= 0){
                if("Comunitaria".equals(celda.getStringCellValue()))
                    comunitaria++;
                else
                    relacionada ++;
            }
        }       
    }
    
    
    ArrayList<Double> Edades = new ArrayList<>();//LISTA CON TODAS LAS EDADES 
    ArrayList<Edad> ListaEdades = new ArrayList<>(); //LISTA CON TODAS LAS EDADES Y SU NUMERO DE CONTAGIOS
    public void Edades () throws FileNotFoundException, IOException{
        Edades.removeAll(Edades);
        ListaEdades.removeAll(ListaEdades);
        
        //CAPTURA DE DATOS
        for (Row fila : hoja){
            Cell celda = fila.getCell(2);
            if(fila.getRowNum()!=0 && !Edades.contains(celda.getNumericCellValue()))//INGRESA LAS EDADES SI NO ESTAN YA EN EL ARRAY
                Edades.add(celda.getNumericCellValue());
        }        
        
        //ALGORITMO DE SELECCIÓN Y ADICION DE LAS REPETICIONES Y EDAD EN LA LISTA "LISTAEDADES"

        for (int i = 0; i < Edades.size(); i ++) {
            int contador = 0;
            for(Row fila : hoja){
                Cell celda = fila.getCell(2);
                if(fila.getRowNum()!= 0 && celda.getNumericCellValue() == (Edades.get(i))){
                        contador++;
                    }
            }
            Edad objetoEdad = new Edad (Edades.get(i), contador);
            ListaEdades.add(objetoEdad);
        }
             
        //ALGORITMO DE ORDENAMIENTO DE MAYOR A MENOR SEGÚN LAS REPETICIONES DE CADA EDAD
        for (int i = 0; i < ListaEdades.size(); i++) {
            for (int j = 0; j < ListaEdades.size()-1; j++) {
                if((ListaEdades.get(i)).getRepeticiones() > (ListaEdades.get(j)).getRepeticiones()){
                    Edad auxiliar = ListaEdades.get(j);
                    ListaEdades.set(j, ListaEdades.get(i));
                    ListaEdades.set(i, auxiliar);
                }
            }
        }
    }
    
    
    
    ArrayList <String> Ciudades = new ArrayList<>();//LISTA PARA LAS CIUDADES EXISTENTES
    ArrayList <Ciudad> contagios = new ArrayList<>(); //ALMACENA LAS 3 CIUDADES CON MÁS CONTAGIOS
    ArrayList <Ciudad> ciudad_contagios = new ArrayList<>(); //LISTA ORDENADA DE MAYOR A  MENOR CON TODAS LAS CIUDADES Y SUS CONTAGIOS
    public void LeerYOrganizarCiudades() throws FileNotFoundException, IOException, InvalidFormatException{
        Ciudades.removeAll(Ciudades);
        contagios.removeAll(contagios);
        ciudad_contagios.removeAll(ciudad_contagios);
        
            for(Row fila : hoja){ //LLENADO DE TODAS LAS CIUDADES DEL ARCHIVO
                Cell celda = fila.getCell(1);

                String contenido = celda.getStringCellValue();
                if(!Ciudades.contains(contenido) && !"Nombre municipio".equals(contenido)){
                    Ciudades.add(contenido);
                }
            }            
            
            for (int i = 0; i < Ciudades.size(); i++) { //LLENADO DE UNA LISTA CON CIUDAD Y CONTAGIOS. 
            int contador = 0;
             for(Row fila : hoja){
                 Cell celda = fila.getCell(1);
                 String contenido = celda.getStringCellValue();
                 if(contenido.equals(Ciudades.get(i))){ 
                     contador++;
                 }
             }
             
             Ciudad ciudadContagios = new Ciudad(Ciudades.get(i), contador); 
             ciudad_contagios.add(ciudadContagios);
                
            }
           
           for (int i = 0; i < Ciudades.size(); i++) { //ALGORITMO DE ORDENAMIENTO MAYOR A MENOR. 
                for (int j = 0; j < Ciudades.size(); j++) { 
                     if((ciudad_contagios.get(i)).getContagios() > (ciudad_contagios.get(j)).getContagios())
                     {
                         Ciudad auxiliar = ciudad_contagios.get(j);
                         ciudad_contagios.set(j, ciudad_contagios.get(i));
                         ciudad_contagios.set(i, auxiliar);  
                     }
                }
           }
           
            for (int i = 0; i < 3; i++) { //ASIGNACION DE LAS 3 CIUDADES CON MAYORES CONTAGIOS
            contagios.add(ciudad_contagios.get(i));
            }
    } 
    
    private void OpcionesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesBoxActionPerformed
 
    }//GEN-LAST:event_OpcionesBoxActionPerformed
    
    private void PastelButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastelButtomActionPerformed
          DefaultPieDataset datos = new DefaultPieDataset();
          String opcion = OpcionesBox.getSelectedItem().toString();
            
        switch (opcion) {
            case "Contagios por genero":
                {
                    try {
                        ContagioPorSexo();
                    }
                    catch (IOException ex){
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    datos.setValue("Masculino", masculino);
                    datos.setValue("Femenino", femenino);
                    JFreeChart grafico_circular = ChartFactory.createPieChart("Contagios por genero", datos, true, true, false);
                    grafico_circular.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de pastel", grafico_circular);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            case "Contagios por edad":
                {
                    try {
                        Edades();
                    } catch (IOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }   for(int i = 0; i < 3; i++){
                        datos.setValue(((ListaEdades.get(i)).getEdad()).toString(),((ListaEdades.get(i)).getRepeticiones()));
                    }   JFreeChart grafico_circular = ChartFactory.createPieChart("Top 3 Contagios por edad", datos, true, true, false);
                    grafico_circular.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de pastel", grafico_circular);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            case "Medio de contagio":
                {
                    try {
                        TipoContagio();
                    } catch (IOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                    datos.setValue("Comunitaria", comunitaria);
                    datos.setValue("Relacionada", relacionada);
                    JFreeChart grafico_circular = ChartFactory.createPieChart("Medio de contagio", datos, true, true, false);
                    grafico_circular.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de pastel", grafico_circular);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            case "Contagios por municipio":
                {
                    try {
                        LeerYOrganizarCiudades();
                    } catch (IOException | InvalidFormatException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }  for(Ciudad x : contagios){
                        datos.setValue(x.getNombre(),x.getContagios() );
                        
                    }   JFreeChart grafico_circular = ChartFactory.createPieChart("Top 3 de los municipios con más contagios", datos, true, true, false);
                    grafico_circular.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de pastel", grafico_circular);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            default:
                break;
        }
    }//GEN-LAST:event_PastelButtomActionPerformed

    private void BarrasButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarrasButtomActionPerformed
       DefaultCategoryDataset datos = new DefaultCategoryDataset();
       String opcion = OpcionesBox.getSelectedItem().toString();
       
        switch (opcion) {
            case "Contagios por genero":
                {
                    try {
                        ContagioPorSexo();
                    }
                    catch (IOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    datos.setValue(masculino, "Masculino" , "");
                    datos.setValue(femenino, "Femenino" , "");
                    JFreeChart grafico_barras = ChartFactory.createBarChart("Contagios por genero", "Genero", "Contagios", datos, PlotOrientation.VERTICAL,true,false,false);
                    grafico_barras.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de barras", grafico_barras);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            case "Contagios por edad":
                {
                    try {
                        Edades();
                    } catch (IOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }   for(int i = 0; i < 3; i++){
                        datos.setValue(((ListaEdades.get(i)).getRepeticiones()),((ListaEdades.get(i)).getEdad()).toString(), "");
                    }   JFreeChart grafico_barras = ChartFactory.createBarChart("Top 3 Contagios por edad", "Edad", "Contagios", datos, PlotOrientation.VERTICAL,true,false,false);
                    grafico_barras.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de barras", grafico_barras);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            case "Medio de contagio":
                {
                    try {
                        TipoContagio();
                    } catch (IOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }  datos.setValue(comunitaria, "Comunitaria", "");
                    datos.setValue( relacionada, "Relacionada", "");
                    JFreeChart grafico_barras = ChartFactory.createBarChart("Medio de Contagio", "Medio", "Contagios", datos, PlotOrientation.VERTICAL,true,false,false);
                    grafico_barras.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de barras", grafico_barras);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            case "Contagios por municipio":
                {
                    try {
                        LeerYOrganizarCiudades();
                    } catch (IOException | InvalidFormatException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }  for(Ciudad x : contagios){
                        datos.setValue(x.getContagios() ,x.getNombre(), "" );
                        
                    }   JFreeChart grafico_barras = ChartFactory.createBarChart("Top 3 municipios con mas contagios", "Ciudad", "Contagios", datos, PlotOrientation.VERTICAL,true,false,false);
                    grafico_barras.setBackgroundPaint(Color.white);
                    ChartFrame frame = new ChartFrame("Gráfico de barras", grafico_barras);
                    frame.pack();
                    frame.setVisible(true);
                    break;
                }
            default:
                break;
        }
    }//GEN-LAST:event_BarrasButtomActionPerformed
  
    
    private void GeneroToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneroToggleActionPerformed
        
    }//GEN-LAST:event_GeneroToggleActionPerformed

    private void EdadToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdadToggleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EdadToggleActionPerformed

    private void CiudadToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadToggleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiudadToggleActionPerformed

    private void ContagioToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContagioToggleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContagioToggleActionPerformed

    private void DescargarButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargarButtomActionPerformed
        
         
         FileWriter writer;
    try {
        writer = new FileWriter("Reporte.csv");
        for(Row fila : hoja){
            Cell celda;
            
                if(CiudadToggle.isSelected()){
                  celda = fila.getCell(1);
                  writer.write(celda.getStringCellValue()+",");
               }
               if(GeneroToggle.isSelected()){
                   celda = fila.getCell(3);
                   writer.write(celda.getStringCellValue()+ ",");
               }
               if(EdadToggle.isSelected()){
                   celda = fila.getCell(2);
                   if(fila.getRowNum() == 0)
                   writer.write(celda.getStringCellValue()+ ",");
                   else
                    writer.write(celda.getNumericCellValue()+ ",");
               }
               if(ContagioToggle.isSelected()){
                  celda = fila.getCell(4);     
                  writer.write(celda.getStringCellValue()+ ",");
               }
               writer.write("\n");
            }     
       
    } catch (IOException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
    }   
    }//GEN-LAST:event_DescargarButtomActionPerformed

 
    
    
  
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new Interfaz().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BarrasButtom;
    private javax.swing.JToggleButton CiudadToggle;
    private javax.swing.JToggleButton ContagioToggle;
    private javax.swing.JButton DescargarButtom;
    private javax.swing.JToggleButton EdadToggle;
    private javax.swing.JToggleButton GeneroToggle;
    private javax.swing.JComboBox<String> OpcionesBox;
    private javax.swing.JButton PastelButtom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
