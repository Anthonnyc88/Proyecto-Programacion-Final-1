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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;

/**
 *
 * @author Anthonny
 */
public class Register_employees {

    public static void menu_employees() {
        String menu = "Employee registration\n";
        int n1, n2, n3;
        int op = 0;

        menu += "1.Add Employees\n";
        menu += "2.Modify Employees\n";
        menu += "3.Delete Employees\n";
        menu += "4.End\n";
        menu += "Choose Option:\n";

        while (op != 4) {

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {

                case 1:

                    Register_employees objeto = new Register_employees();
                    objeto.add_Employees();

                    break;

                case 2:
                    Register_employees objeto2 = new Register_employees();
                    objeto2.modify_Employees();

                    break;

                case 3:
                    Register_employees objeto3 = new Register_employees();
                  objeto3.delete_Employees();

                case 4:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Option invalid.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    // functions the add , modify and delete
    public static void add_Employees() {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wi;
        String texto = "";
        File archivo;

        try {

            archivo = new File("C:\\Users\\Anthonny\\Documents\\CodigoProyecto\\Proyect\\Employees1.txt"); //Aqui ponemos el nombre del archivo que vamos a crear y la ruta

            if (archivo.createNewFile()) {//crea el archivo
                System.out.println("Se ha creado un archivo");
            }

            w = new FileWriter(archivo, true);
            bw = new BufferedWriter(w);
            wi = new PrintWriter(bw);

            String name_Employees;
            String lastname;
            String id;
            String direccion;

            int Date = 2017;
            int user;
            int fecha_Nacimiento;

            String puesto;
            name_Employees = JOptionPane.showInputDialog("Name of employee");
            lastname = JOptionPane.showInputDialog("Lastname of employee");
            id = JOptionPane.showInputDialog("ID of employee");
            direccion = JOptionPane.showInputDialog("Partner Address");
            puesto = JOptionPane.showInputDialog("Name of employee's position");

            int year, month, day;
            year = Integer.parseInt(JOptionPane.showInputDialog(null, "Year of birth"));
            month = Integer.parseInt(JOptionPane.showInputDialog(null, "Month birth"));
            day = Integer.parseInt(JOptionPane.showInputDialog(null, "Birth day"));
            JOptionPane.showMessageDialog(null, "Employees add.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
            Date now = new Date();
            int nowMonth = now.getMonth() + 1;
            int nowYear = now.getYear() + 1900;
            int result = nowYear - year;

            if (month > nowMonth) {
                result--;
            } else if (month == nowMonth) {
                int nowDay = now.getDate();

                if (day > nowDay) {

                    result--;
                }
            }
            // JOptionPane.showMessageDialog(null, result);

            bw.write(name_Employees + " ");
            bw.write(lastname + " ");
            bw.write(id + " ");
            bw.write(direccion + " ");
            bw.write(puesto + " ");
            bw.write(String.valueOf(new Integer(result) + " "));
            bw.newLine();
            wi.close();
            bw.close();

        } catch (IOException e) { // Aqui usamos Exceptiones , este + e nos informa que tipo de error se da cuando no se crea el archivo
            System.err.println("No se ha creado el archivo" + e);

        }

    }

    public static void modify_Employees() {
        try {
            String archivo = "Employees1.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String name_Employees;
            String id_Employees;
            name_Employees = JOptionPane.showInputDialog("Name of employee");
            id_Employees = JOptionPane.showInputDialog("ID of employee");
            FileReader fr = new FileReader("Employees.txt");
            BufferedReader lector = new BufferedReader(fr);
            String newEmployees = "";
            String lastname_Employees = "";
            String newDirection = "";
            String newId = "";
            String newPosts = "";
            int newYear;
            int newMont;
            int newDay;

            String newLinea1 = "";
            boolean bandera = false;

            ArrayList<String> listaEmployees = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaEmployees.add(linea);
            }

            //nota me suscribe el nombre del puesto a modificar en el txt
            for (int i = 0; i < listaEmployees.size(); i++) {
                if (name_Employees.equals(listaEmployees.get(i).split(" ")[0]) && (id_Employees.equals(listaEmployees.get(i).split(" ")[2]))) {
                    newEmployees = JOptionPane.showInputDialog("Enter the name of the new employee");
                    lastname_Employees = JOptionPane.showInputDialog("Enter the surname of the collaborator");
                    newId = JOptionPane.showInputDialog("Enter the employee ID number");
                    newDirection = JOptionPane.showInputDialog("Enter the employee's address");
                    newPosts = JOptionPane.showInputDialog("Enter the collaborator's post");
                    newYear = Integer.parseInt(JOptionPane.showInputDialog(null, "Year of birth"));
                    newMont = Integer.parseInt(JOptionPane.showInputDialog(null, "Month birth"));
                    newDay = Integer.parseInt(JOptionPane.showInputDialog(null, "Birth day"));
                    Date now = new Date();
            int nowMonth = now.getMonth() + 1;
            int nowYear = now.getYear() + 1900;
            int result = nowYear - newYear;

            if (newMont > nowMonth) {
                result--;
            } else if (newMont == nowMonth) {
                int nowDay = now.getDate();

                if (newDay > nowDay) {

                    result--;
                }
            }
                    newLinea1 = newEmployees + " " + lastname_Employees + " " + newId + "" + newDirection + " " + newPosts + " " + result;
                    listaEmployees.set(i, newLinea1);

                    PrintWriter escritor = null;
                    FileWriter fichero = null;
                    try {
                        fichero = new FileWriter(archivo);
                        escritor = new PrintWriter(fichero);
                        escritor.flush();
                        for (String employees : listaEmployees) {
                            pw.write(employees);
                            pw.println();
                        }
                        escritor.close();
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Employees modification.", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "Employees incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void delete_Employees() {
        try {
            String archivo = "Employees1.txt";
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String nombre = "";
            nombre = JOptionPane.showInputDialog("Name of employee");
            FileReader fr = new FileReader("Employees1.txt");
            BufferedReader lector = new BufferedReader(fr);

            boolean bandera = false;

            ArrayList<String> listaUsuarios = new ArrayList();
            String linea;

            while ((linea = lector.readLine()) != null) {
                listaUsuarios.add(linea);
            }

            for (int i = 0; i < listaUsuarios.size(); i++) {
                String nombreEmployee = listaUsuarios.get(i).split(" ")[0];
                System.out.println(nombreEmployee);
                System.out.println(nombre);
                System.out.println(nombre.equalsIgnoreCase(nombreEmployee));
                if (nombre.equals(nombreEmployee)) {

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
                    JOptionPane.showMessageDialog(null, "Employee Eliminated.", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            pw.close();

            if (!bandera) {
                JOptionPane.showMessageDialog(null, "No such employee.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            String error = "No se encontro archivo" + e;
            JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
