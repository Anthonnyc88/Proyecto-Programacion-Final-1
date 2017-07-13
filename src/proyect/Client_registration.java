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

/**
 *
 * @author Anthonny
 */
public class Client_registration {

    public static void menu_Client() {
        String menu = "Client registration\n";
        int n1, n2, n3;
        int op = 0;

        menu += "1.Add Clients\n";
        menu += "2.Modify Clients\n";
        menu += "3.Delete Clients\n";
        menu += "4.End\n";
        menu += "Choose Option:\n";

        while (op != 4) {

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {

                case 1:

                    Client_registration objeto = new Client_registration();
                    objeto.add_Client();

                    break;

                case 2:
                    Client_registration objeto2 = new Client_registration();
                    objeto2.modify_Client();

                    break;

                case 3:
                    Client_registration objeto3 = new Client_registration();
                    objeto3.delete_Client();

                case 4:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Option invalid.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public static void add_Client() {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wi;
        String texto = "";

        File archivo;

        try {

            archivo = new File("C:\\Users\\Anthonny\\Documents\\CodigoProyecto\\Proyect\\Client.txt"); //Aqui ponemos el nombre del archivo que vamos a crear y la ruta

            if (archivo.createNewFile()) {//crea el archivo
                System.out.println("Se ha creado un archivo");
            }

            w = new FileWriter(archivo, true);
            bw = new BufferedWriter(w);
            wi = new PrintWriter(bw);
            String name_Client;
            int id;

            name_Client = JOptionPane.showInputDialog("Customer name");
            id = Integer.parseInt(JOptionPane.showInputDialog("Customer ID"));
            JOptionPane.showMessageDialog(null, "Add client.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);

            bw.write(name_Client + " ");
            bw.write(String.valueOf(new Integer(id) + " "));
            bw.newLine();
            wi.close();
            bw.close();

        } catch (IOException e) {
            System.err.println("No se ha creado el archivo" + e);

        }

    }

    public static void modify_Client() {

        try {
            String archivo = "Client.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String nombre_Client;
            int id_Client;
            nombre_Client = JOptionPane.showInputDialog("Name of Customer to modify");
            id_Client=Integer.parseInt(JOptionPane.showInputDialog("Customer ID number to modify"));
            FileReader fr = new FileReader("Client.txt");
            BufferedReader lector = new BufferedReader(fr);
            String newClient = "";
            String newId = "";

            String newLinea1 = "";
            boolean bandera = false;

            ArrayList<String> listaClient = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaClient.add(linea);
            }

            for (int i = 0; i < listaClient.size(); i++) {
                if (nombre_Client.equals(listaClient.get(i).split(" ")[0])) {
                    newClient = JOptionPane.showInputDialog("Enter the new Customer name");
                    newId = JOptionPane.showInputDialog("Enter the customer ID number");
                    newLinea1 = newClient + " " + newId;
                    listaClient.set(i, newLinea1);
                    PrintWriter escritor = null;
                    FileWriter fichero = null;
                    try {
                        fichero = new FileWriter(archivo);
                        escritor = new PrintWriter(fichero);
                        escritor.flush();
                        for (String usuario : listaClient) {
                            pw.write(usuario);
                            pw.println();
                        }
                        escritor.close();
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Client modification.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Client Incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void delete_Client() {

        try {
            String archivo = "Client.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String nombre = "";
            nombre = JOptionPane.showInputDialog("Customer name");
            FileReader fr = new FileReader("Client.txt");
            BufferedReader lector = new BufferedReader(fr);

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
                    JOptionPane.showMessageDialog(null, "Customer Deleted.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Client does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
