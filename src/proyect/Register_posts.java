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
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Anthonny
 */
public class Register_posts {

    public static void menu_Posts() {
        String menu = "Job posting\n";
        int n1, n2, n3;
        int op = 0;

        menu += "1.Add Posts\n";
        menu += "2.Modify Posts\n";
        menu += "3.Delete Posts\n";
        menu += "4.End\n";
        menu += "Choose Option:\n";

        while (op != 4) {

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {

                case 1:

                    Register_posts objeto = new Register_posts();
                    objeto.add_Posts();

                    break;

                case 2:
                    Register_posts objeto2 = new Register_posts();
                    objeto2.modify_Post();

                    break;

                case 3:
                    Register_posts objeto3 = new Register_posts();
                    objeto3.delete_Posts();

                case 4:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Option invalid.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Funtions the add in file
    public static void add_Posts() {
        //String nombre;
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wi;
        String texto = "";

        File archivo;

        try {// 

            archivo = new File("C:\\Users\\Anthonny\\Documents\\CodigoProyecto\\Proyect\\Posts.txt"); 

            if (archivo.createNewFile()) {//crea el archivo
                System.out.println("Se ha creado un archivo");
            }

            w = new FileWriter(archivo, true);
            bw = new BufferedWriter(w); 
            wi = new PrintWriter(bw);
            
            String nombre_Puesto;
            String sigla;
            int salario;
            nombre_Puesto = JOptionPane.showInputDialog("Job title");
            sigla = JOptionPane.showInputDialog("Acronym");
            salario = Integer.parseInt(JOptionPane.showInputDialog("Salary of the position"));
            JOptionPane.showMessageDialog(null, "Posts add.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
            

            bw.write(nombre_Puesto.replaceAll("_","\n") + " ");
            bw.write(sigla.replaceAll("_","\n") + " ");
            bw.write(String.valueOf(new Integer(salario) + " "));
            bw.newLine();
            wi.close();
            bw.close();

        } catch (IOException e) { 
            System.err.println("No se ha creado el archivo" + e);

        }
    }

    public static void modify_Post() {
        try {
            String archivo = "Posts.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String nombre_Puesto;
            nombre_Puesto = JOptionPane.showInputDialog("Job title");

            FileReader fr = new FileReader("Posts.txt");
            BufferedReader lector = new BufferedReader(fr);
            String newPosts = "";
            String newSigla = "";
            String newSalary = "";
            String newLinea = "";
            String newLinea1 = "";
            boolean bandera = false;

            ArrayList<String> listaPuestos = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaPuestos.add(linea);
            }

            for (int i = 0; i < listaPuestos.size(); i++) {
                if (nombre_Puesto.equals(listaPuestos.get(i).split(" ")[0])) {

                    newPosts = JOptionPane.showInputDialog("Enter the new job name");
                    newSigla = JOptionPane.showInputDialog("Enter the acronym again");
                    newSalary = JOptionPane.showInputDialog("Enter the new salary for the position");
                    newLinea1 = newPosts + " " + newSigla + " " + newSalary;
                    listaPuestos.set(i, newLinea1);

                    PrintWriter escritor = null;
                    FileWriter fichero = null;
                    try {
                        fichero = new FileWriter(archivo);
                        escritor = new PrintWriter(fichero);
                        escritor.flush();
                        for (String usuario : listaPuestos) {
                            pw.write(usuario);
                            pw.println();
                        }
                        escritor.close();
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Posts modification.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Posts incorrec.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void delete_Posts() {
        try {
            String archivo = "Posts.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String nombre = "";
            nombre = JOptionPane.showInputDialog("Job title");
            FileReader fr = new FileReader("Posts.txt");
            BufferedReader lector = new BufferedReader(fr);

            String newNombre = "";
            String newPuesto = "";
            String newSalario = "";

            boolean bandera = false;

            ArrayList<String> listaUsuarios = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaUsuarios.add(linea);
            }

            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (nombre.equals(listaUsuarios.get(i).split(" ")[0])) {

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
                    JOptionPane.showMessageDialog(null, "Post Removed.", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Incorrect post.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
