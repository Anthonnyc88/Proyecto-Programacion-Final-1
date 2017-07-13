/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Anthonny
 */
public class Reports {
    
    public static void menu_Reports(){
        String menu = " Reports Financial Project Management\n";
        int n1, n2, n3;
        int op = 0;

        menu += "1.  Reports 1\n";
        menu += "2.  Reports 2\n";
        menu += "3.  Reports 3\n";
        menu += "4.  Reports 4\n";
        menu += "5.  Reports 5\n";
        menu += "6.  Reports 6\n";
        menu += "7.  End\n";
        menu += "Choose Option:\n";

        while (op != 7) {

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {

                case 1:
                    report1();
                    break;

                case 2:
                    report2();
                    break;

                case 3:
                    report3();
                    break;
                    
                case 4:
                    report4();
                    break;
                    
                case 5:
                    report5();
                    break;
                    
                case 6:
                    report6();
                    break;
                    
                case 7:
                    break;
                 
                    
                default:
                    JOptionPane.showMessageDialog(null, "Option invalid.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public static void report1(){
        String ced = JOptionPane.showInputDialog("Enter the cedula:");
        
        try{
            String archivo = "Employees.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader("Employees.txt");
            BufferedReader lector = new BufferedReader(fr);
            String linea;
            boolean bandera = false;
            
            ArrayList<String> listaEmpleado = new ArrayList();
            
            while( (linea = lector.readLine()) != null ){
                listaEmpleado.add(linea);
            }        
            
            archivo = "Posts.txt";
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            
            fr = new FileReader("Posts.txt");
            lector = new BufferedReader(fr);
            linea = "";
            
            ArrayList<String> listaPuestos = new ArrayList();
            
            while( (linea= lector.readLine()) != null){
                listaPuestos.add(linea);
            }
            
            int salarioB = 0;
            String cedColaborador = "";
            
            for(int i = 0; i<listaEmpleado.size(); i++){
                if(ced.equalsIgnoreCase(listaEmpleado.get(i).split(" ")[2])){
                    String puesto = listaEmpleado.get(i).split(" ")[6];
                    for(int j=0; j<listaPuestos.size();j++){
                        if(puesto.equalsIgnoreCase(listaPuestos.get(j).split(" ")[1])){
                            salarioB = Integer.parseInt(listaPuestos.get(i).split(" ")[2]);
                            bandera = true;
                        }
                    }
                }
            }
            
            if(!bandera){
                JOptionPane.showMessageDialog(null, "Incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            int cambioDolar = 560;
            double reduccEnfer = (5.5*salarioB)/100;
            double reduccBanco =  (1*salarioB)/100;
            double reduccPension = (8*salarioB)/100;
            double reduccVacas = salarioB/30;
            
            int diasVacas = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of vacation days:"));
            reduccVacas *= diasVacas;
             
            double total = salarioB - (reduccBanco + reduccEnfer + reduccPension + reduccVacas);
             
            String pago = "The Employee signs: " + ced + "_"
                        + "Net salary: $" + salarioB + "_"
                        + "Disease(5.5%): $" + reduccEnfer + "_"
                        + "Banco Popular(1%): $" + reduccBanco + "_"
                        + "Pensión(8%): $" + reduccPension + "_"
                        + "Vacations(" + diasVacas + "): $" + reduccVacas + "_"
                        + "Total: $" + total;
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date());
            
            JOptionPane.showMessageDialog(null, pago.replaceAll("_","\n") + "\nCurrent date: " + fechaActual,"Payment",JOptionPane.INFORMATION_MESSAGE);
            
            File f;
            
            f = new File("E:\\Java\\Proyect\\Pagos.txt");
            if ( f.createNewFile()){
                System.out.println("Se ha creado un archivo");
            }
            
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            
            bw.write(pago);
            bw.newLine();
            pw.close();
            bw.close();
            
            
            int opc = JOptionPane.showConfirmDialog(null, "Want to see the report in colones?", "Colones",JOptionPane.YES_NO_OPTION);
            
            if( opc == JOptionPane.YES_OPTION){
                pago = "The Employee signs: " + ced + "_"
                        + "Dollar change: ₡" + cambioDolar + "_"
                        + "Net salary: ₡" + (salarioB*cambioDolar) + "_"
                        + "Disease(5.5%): ₡" + (reduccEnfer*cambioDolar) + "_"
                        + "Banco Popular(1%): ₡" + (reduccBanco*cambioDolar) + "_"
                        + "Pensión(8%): ₡" + (reduccPension*cambioDolar) + "_"
                        + "Vacations(" + diasVacas + "): ₡" + (reduccVacas*cambioDolar) + "_"
                        + "Total: ₡" + (total*cambioDolar);
                
                JOptionPane.showMessageDialog(null, pago.replaceAll("_","\n") + "\nCurrent date: " + fechaActual,"Payment",JOptionPane.INFORMATION_MESSAGE);
            }
                    
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se encontro archivo " + e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void report2(){
        try{
            String archivo = "Employees.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader("Employees.txt");
            BufferedReader lector = new BufferedReader(fr);
            
            String linea;
            ArrayList<String> listaEmpleados = new ArrayList();
            
            while( (linea = lector.readLine()) != null ){
                listaEmpleados.add(linea);
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date());
            ArrayList<String> listaCumple = new ArrayList();
            int contador = listaEmpleados.size();
            
            for (int i = 0; i < contador; i++) {
                String fechaEmpleado = listaEmpleados.get(i).split(" ")[4];
                if (Integer.parseInt(fechaEmpleado.split("/")[1]) < Integer.parseInt(fechaActual.split("/")[1])) {
                    listaCumple.add(listaEmpleados.get(i));
                } else if (Integer.parseInt(fechaEmpleado.split("/")[1]) == Integer.parseInt(fechaActual.split("/")[1])) {
                    if(Integer.parseInt(fechaEmpleado.split("/")[0]) <= Integer.parseInt(fechaActual.split("/")[0])){
                        listaCumple.add(listaEmpleados.get(i));
                    }
                }
            }
            pw.close();
            
            String imprimirEmpleados = "";
            
            if(listaCumple.isEmpty()){
                imprimirEmpleados = "No employee has reached the age of.";
            }else{
                for(String empleado : listaCumple){
                    imprimirEmpleados += empleado + "\n";        
                }
            }
            
            
            
            JOptionPane.showMessageDialog(null, imprimirEmpleados + "\nCurrent date: " + fechaActual, "Years old", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "No se encontro el archivo" + e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void report3(){
        try {
            String archivo = "Employees.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("Employees.txt");
            BufferedReader lector = new BufferedReader(fr);

            String linea;
            ArrayList<String> listaEmpleados = new ArrayList();

            while ((linea = lector.readLine()) != null) {
                listaEmpleados.add(linea);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date());
            
            int contador = listaEmpleados.size();
            
            ArrayList<String> listaNoCumple = new ArrayList();

            for (int i = 0; i < contador; i++) {
                String fechaEmpleado = listaEmpleados.get(i).split(" ")[4];
                if (Integer.parseInt(fechaEmpleado.split("/")[1]) > Integer.parseInt(fechaActual.split("/")[1])) {
                    listaNoCumple.add(listaEmpleados.get(i));
                } else if (Integer.parseInt(fechaEmpleado.split("/")[1]) == Integer.parseInt(fechaActual.split("/")[1])) {
                    if (Integer.parseInt(fechaEmpleado.split("/")[0]) > Integer.parseInt(fechaActual.split("/")[0])) {
                        listaNoCumple.add(listaEmpleados.get(i));
                    }
                }
            }
            pw.close();

            String imprimirEmpleados = "";
            if (listaNoCumple.isEmpty()) {
                imprimirEmpleados = "No employee is missing years.";
            } else {
                for (String empleado : listaNoCumple) {
                    imprimirEmpleados += empleado + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, imprimirEmpleados + "\nCurrent Date: " + fechaActual, "Years old", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "No se encontro el archivo" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void report4(){
        try{
            String archivo = "Pagos.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader("Pagos.txt");
            BufferedReader lector = new BufferedReader(fr);
            
            String linea,ced = (JOptionPane.showInputDialog("Enter the cedula: "));
            ArrayList<String> listaPagos = new ArrayList();

            while ((linea = lector.readLine()) != null) {
                listaPagos.add(linea);
            }
            
            ArrayList<String> listaSalario = new ArrayList();
            
            for (int i = 0; i < listaPagos.size(); i++) {
                String cedEmpl = listaPagos.get(i).split("_")[0];            
                if(ced.equalsIgnoreCase(cedEmpl.split(":")[1].replaceAll(" ", ""))){
                    String dato = ((listaPagos.get(i).split("_")[1]).split(":")[1]);
                    listaSalario.add(dato.replace("$",""));
                }
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date());
            System.out.println(listaSalario);
            double aguinaldo = 0;
            
            for(String saldo : listaSalario){
                aguinaldo += Double.parseDouble(saldo);
            }
            
            JOptionPane.showMessageDialog(null, "The bonus of the employee cedula ("+ced+") is: " + (aguinaldo/listaSalario.size()) + "\nCurrent Date: " + fechaActual, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "No se encontro el archivo. " + e,"Error",JOptionPane.ERROR_MESSAGE);
        } 
    } 
    
    public static void report5(){
        try {
            String archivo = "Proyects.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("Proyects.txt");
            BufferedReader lector = new BufferedReader(fr);

            String linea, codigo = (JOptionPane.showInputDialog("Enter the code of the project: "));
            ArrayList<String> listaProyectos = new ArrayList();

            while ((linea = lector.readLine()) != null) {
                listaProyectos.add(linea);
            }
            
            String imprimir="";
            int meses;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date());
            
            for(String proyect : listaProyectos){
                if(proyect.split(" ")[0].equalsIgnoreCase(codigo)){
                    meses = Integer.parseInt(fechaActual.split("/")[1]) - Integer.parseInt((proyect.split(" ")[2]).split("/")[1]);
                    String[] listaProyecto = proyect.split(" ");
                    imprimir = "Project code: " + listaProyecto[0] + "\n"
                                    + "Project's name: " + listaProyecto[1] + "\n"
                                    + "Creation date: " + listaProyecto[2] + "\n"
                                    + "Months of duration: " + listaProyecto[3] + "\n"
                                    + "Customer name: " + listaProyecto[4] + "\n"
                                    + "Project manager: " + listaProyecto[5] + "\n"
                                    + "Project Leader: " + listaProyecto[6] + "\n"
                                    + "Project Developer: " +listaProyecto[7] + "\n"
                                    + "QA of the proyect: " + listaProyecto[8] + "\n"
                                    + "Months on the project: " + meses;
                }
            } 
            JOptionPane.showMessageDialog(null, imprimir+"\nCurrent Date: " + fechaActual,"Proyect",JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "No se encontro el archivo. " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void report6() {
        try {
            String archivo = "Proyects.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("Proyects.txt");
            BufferedReader lector = new BufferedReader(fr);

            String linea, codigo = (JOptionPane.showInputDialog("Enter the code of the project: "));
            ArrayList<String> listaProyectos = new ArrayList();

            while ((linea = lector.readLine()) != null) {
                listaProyectos.add(linea);
            }
            
            int precioMes = 3000,pagar=0;
            
            for(String proyect : listaProyectos){
                if(proyect.split(" ")[0].equalsIgnoreCase(codigo)){
                    pagar = Integer.parseInt(proyect.split(" ")[3]) * precioMes;
                }
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date()); 
            String imprimir="The code project: " + codigo 
                          + "\nTotal paid: $" + pagar 
                          + "\nCurrent Date: " + fechaActual;
            
            JOptionPane.showMessageDialog(null,imprimir,"Project price",JOptionPane.INFORMATION_MESSAGE);

        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, "No se encontro el archivo. " + e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
    

