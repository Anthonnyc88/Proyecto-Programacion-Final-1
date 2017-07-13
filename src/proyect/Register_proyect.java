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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Anthonny
 */
public class Register_proyect {

    public static void menu_Proyect() {
        String menu = "Job posting\n";
        int n1, n2, n3;
        int op = 0;

        menu += "1.Add Proyect\n";
        menu += "2.Modify Proyect\n";
        menu += "3.Delete Proyect\n";
        menu += "4.End\n";
        menu += "Choose Option:\n";

        while (op != 4) {

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {

                case 1:

                    Register_proyect objeto = new Register_proyect();
                    objeto.add_Proyect();

                    break;

                case 2:
                    Register_proyect objeto2 = new Register_proyect();
                    objeto2.modify_Proyect();

                    break;

                case 3:
                    Register_proyect objeto3 = new Register_proyect();
                objeto3.delete_Proyects();

                case 4:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Option invalid.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public static void add_Proyect() {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wi;
        String texto = "";

        File archivo;

        try {

            archivo = new File("C:\\Users\\Anthonny\\Documents\\CodigoProyecto\\Proyect\\Proyects.txt"); 

            if (archivo.createNewFile()) {
                System.out.println("Se ha creado un archivo");
            }
            w = new FileWriter(archivo, true);
            bw = new BufferedWriter(w);
            wi = new PrintWriter(bw);
            String name_Proyect;
            int duration;
            String client_Proyect;
            String manager_Proyect;
            String lyder_Proyect;
            String d_Proyect;
            String qA;
            int numero = (int) (Math.random() * 1000 + 1);
            name_Proyect = JOptionPane.showInputDialog("Name of the proyect");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = sdf.format(new Date());
            duration = Integer.parseInt( JOptionPane.showInputDialog("Project duration"));
            client_Proyect = JOptionPane.showInputDialog("Customer name");
            manager_Proyect = JOptionPane.showInputDialog("Name of project manager");
            lyder_Proyect = JOptionPane.showInputDialog("Name of the project leader");
            d_Proyect = JOptionPane.showInputDialog("Name of the project developer");
            qA = JOptionPane.showInputDialog("Project QA Name");
            JOptionPane.showMessageDialog(null, "Proyect add.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);

            bw.write(String.valueOf(new Integer(numero) + " "));
            bw.write(name_Proyect + " ");
            bw.write(fechaActual + " ");
            bw.write(String.valueOf(new Integer(duration)+ " "));
            bw.write(client_Proyect + " ");
            bw.write(manager_Proyect + " ");
            bw.write(lyder_Proyect + " ");
            bw.write(d_Proyect + " ");
            bw.write(qA);

            bw.newLine();
            wi.close();
            bw.close();

        } catch (IOException e) {
            System.err.println("No se ha creado el archivo" + e);

        }
    }

    public static void modify_Proyect() {

        try {
            String archivo = "Proyects.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String name_Proyects;
//            
            name_Proyects = JOptionPane.showInputDialog("Name of the project to modify");
            FileReader fr = new FileReader("Proyects.txt");
            BufferedReader lector = new BufferedReader(fr);
            int newCodigo;
            String newProyect = "";
            int newDuration;
            String newClient = "";
            String newManager = "";
            String newLider = "";
            String newdesa_Proyect = "";
            String newDesa2_Proyect = "";
            String qA = "";
            String qA2 = "";
            String newLinea1;
            boolean bandera = false;

            ArrayList<String> listaProyects = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaProyects.add(linea);
            }

            //nota me suscribe el nombre del puesto a modificar en el txt
            for (int i = 0; i < listaProyects.size(); i++) {
                if (name_Proyects.equals(listaProyects.get(i).split(" ")[1])) {
                    newCodigo = (int) (Math.random() * 25 + 1);
                    newProyect = JOptionPane.showInputDialog("Enter the new project name");
                    newDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of the project"));
                    newClient = JOptionPane.showInputDialog("Project Client Name");
                    newManager = JOptionPane.showInputDialog("Name of the project manager");
                    newLider = JOptionPane.showInputDialog("Name of the project leader");
                    newdesa_Proyect = JOptionPane.showInputDialog("Name of the project developers");
                    qA = JOptionPane.showInputDialog("Name of project quality insurer");
                    qA2 = JOptionPane.showInputDialog("Name of the second project quality insurer");
                    newLinea1 =  newCodigo + "  " + newProyect + " " + newDuration + " " + newClient + " " + newManager + " " + newLider + " " + newdesa_Proyect + " " + newDesa2_Proyect + " " + qA + " " + qA2;
                    listaProyects.set(i, newLinea1);

                    PrintWriter escritor = null;
                    FileWriter fichero = null;
                    try {
                        fichero = new FileWriter(archivo);
                        escritor = new PrintWriter(fichero);
                        escritor.flush();
                        for (String proyects : listaProyects) {
                            pw.write(proyects);
                            pw.println();
                        }
                        escritor.close();
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Proyect modification.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Proyect incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void delete_Proyects() {

        try {
            String archivo = "Proyects.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String nombre = "";
            nombre = JOptionPane.showInputDialog("Name of the proyect");
            FileReader fr = new FileReader("Proyects.txt");
            BufferedReader lector = new BufferedReader(fr);

            boolean bandera = false;

            ArrayList<String> listaUsuarios = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaUsuarios.add(linea);
            }

            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (nombre.equals(listaUsuarios.get(i).split(" ")[1])) {

                    listaUsuarios.remove(i);

                    PrintWriter escritor = null;
                    FileWriter fichero = null;
                    try {
                        fichero = new FileWriter(archivo);
                        escritor = new PrintWriter(fichero);
                        escritor.flush();
                        for (String usuario : listaUsuarios) {
                            pw.write(usuario);
                            pw.println();
                        }
                        escritor.close();
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Delete proyect.", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Project does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
