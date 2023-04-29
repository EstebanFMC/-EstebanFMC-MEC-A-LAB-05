/*
FILTROS A IMPLEMENTAR:
CIUDADES CON MAYOR CONTAGIO. COMPLETADO
EDADES CON MAYOR CONTAGIO. COMPLETADO
TIPO DE CONTAGIO:   COMUNITARIA - RELACIONADO. COMPLETADO
SEXO CON MAYOR CONTAGIO.  COMPLETADO
*/



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MainPrueba {
    
    public static void CrearArchivos(){
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet("Java");
        
        try{
            FileOutputStream archivo = new FileOutputStream(new File("Reporte.txt"));
            libro.write(archivo);
            archivo.close();
        } catch (IOException exception){
            System.out.println("ERROR: " + exception);
        }
    }
    
    public static void LeerArchivos() throws FileNotFoundException, IOException, InvalidFormatException{
        
        FileInputStream ArchivoEntrada = new FileInputStream("NumeroContagios.xlsx");
        XSSFWorkbook libro = new XSSFWorkbook (ArchivoEntrada);
        XSSFSheet hoja = libro.getSheetAt(0);
        int NumeroFilas = hoja.getLastRowNum();
        int contador =0;
        
        for(int i = 0; i < NumeroFilas; i++){ //RECORRER LA HOJA DE EXCEL
                Row fila = hoja.getRow(i);
            int NumeroColumnas = fila.getLastCellNum();
            
            for(int j = 0; j < NumeroColumnas; j++){
                Cell celda = fila.getCell(j); //RECORRER LAS FILAS
                 switch ((celda.getCellTypeEnum()).toString()){
                    case ("NUMERIC"):
                        System.out.print(celda.getNumericCellValue() + " ");
                        break;
                    case("STRING"):    
                        if("LA CRUZ".equals(celda.getStringCellValue())){
                            contador++;
                            System.out.print(celda.getStringCellValue() + " ");
                        } else
                            
                        System.out.print(celda.getStringCellValue() + " ");
                        break;
                    case ("FORMULA"):
                        System.out.print(celda.getCellFormula()+ " ");
                        break;
                }
            }
            
            
            System.out.println(" ");
        }
         System.out.println("El contador es: " + contador);
    }
    
    public static void LeerYOrganizarCiudades() throws FileNotFoundException, IOException, InvalidFormatException{
        
        FileInputStream ArchivoEntrada = new FileInputStream("NumeroContagios.xlsx");
        XSSFWorkbook libro = new XSSFWorkbook (ArchivoEntrada);
        XSSFSheet hoja = libro.getSheetAt(0);
        
        ArrayList <String> Ciudades = new ArrayList<>(); //LISTA PARA LAS CIUDADES EXISTENTES
        ArrayList <Ciudad> contagios = new ArrayList<>(); //ALMACENA LAS 3 CIUDADES CON MÁS CONTAGIOS
        ArrayList <Ciudad> ciudad_contagios = new ArrayList<>();
        
            for(Row fila : hoja){ //LLENADO DE TODAS LAS CIUDADES DEL ARCHIVO
                Cell celda = fila.getCell(1);

                String contenido = celda.getStringCellValue();
                if(!Ciudades.contains(contenido) && !"Nombre municipio".equals(contenido)){
                    Ciudades.add(contenido);
                }
            }            
            
            for (int i = 0; i < Ciudades.size(); i++) { //LLENADO DE UNA LISTA CON CIUDAD Y CONTAGIOS. FUNCIONANDO CORRECTAMENTE 
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
           
           for (int i = 0; i < Ciudades.size(); i++) { //ALGORITMO DE ORDENAMIENTO MAYOR A MENOR. FUNCIONA CORRECTAMENTE
                for (int j = 0; j < Ciudades.size(); j++) { 
                     if((ciudad_contagios.get(i)).getContagios() > (ciudad_contagios.get(j)).getContagios())
                     {
                         Ciudad auxiliar = ciudad_contagios.get(j);
                         ciudad_contagios.set(j, ciudad_contagios.get(i));
                         ciudad_contagios.set(i, auxiliar);  
                     }
                }
           }
            //System.out.println("Las ciudades son: " + Ciudades);
           
            for (int i = 0; i < 3; i++) { //ASIGNACION DE LAS 3 CIUDADES CON MAYORES CONTAGIOS
            contagios.add(ciudad_contagios.get(i));
            }
            System.out.println(contagios);
            
            
    }
    
    public static void Edades () throws FileNotFoundException, IOException{
        FileInputStream ArchivoEntrada = new FileInputStream("NumeroContagios.xlsx");
        XSSFWorkbook libro = new XSSFWorkbook (ArchivoEntrada);
        XSSFSheet hoja = libro.getSheetAt(0);
        
        
        //CAPTURA DE DATOS
        ArrayList<Double> Edades = new ArrayList<>();
        for (Row fila : hoja){
            Cell celda = fila.getCell(2);
          
            if(fila.getRowNum()!=0 && !Edades.contains(celda.getNumericCellValue()))//INGRESA LAS EDADES SI NO ESTAN YA EN EL ARRAY
                Edades.add(celda.getNumericCellValue());
        }System.out.println("TAMAÑO DEL ARRAY: "+ Edades.size());
        //System.out.println(Edades);
        
        
        //ALGORITMO DE SELECCIÓN Y ADICION DE LAS REPETICIONES Y EDAD EN LA LISTA "LISTAEDADES"
        ArrayList<Edad> ListaEdades = new ArrayList<>();
        
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
        System.out.println("Lista de Edades: " + ListaEdades);
        
             
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
        //System.out.println("ARRAY ORDENADO: " + ListaEdades);
        
    }
    
    public static void TipoContagio() throws FileNotFoundException, IOException{
       FileInputStream ArchivoEntrada = new FileInputStream("NumeroContagios.xlsx");
        XSSFWorkbook libro = new XSSFWorkbook (ArchivoEntrada);
        XSSFSheet hoja = libro.getSheetAt(0);  
        
        
        int comunitaria = 0, relacionada = 0;
        for(Row fila : hoja){
            Cell celda = fila.getCell(4);
            if(fila.getRowNum()!= 0){
                if("Comunitaria".equals(celda.getStringCellValue()))
                    comunitaria++;
                else
                    relacionada ++;
            }
        }
        System.out.println("Hubieron " + comunitaria + " contagios por tipo comunitario y " + relacionada + " contagios por tipo relacionada");
        
    }
    
    public static void ContagioPorSexo() throws FileNotFoundException, IOException{
        FileInputStream ArchivoEntrada = new FileInputStream("NumeroContagios.xlsx");
        XSSFWorkbook libro = new XSSFWorkbook (ArchivoEntrada);
        XSSFSheet hoja = libro.getSheetAt(0);
        
        int masculino = 0, femenino = 0;
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
        System.out.println("Hubieron " + masculino + " contagios en el sexo masculino y " + femenino + " contagios en el sexo femenino");
        
    }
    
    
    public static void main(String[] args) throws InvalidFormatException, IOException {
       // LeerArchivos();
        //LeerYOrganizarCiudades();
        //Edades();
       // TipoContagio();
        ContagioPorSexo();
        }
    }
    
    






