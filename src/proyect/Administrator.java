/*1
1

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
import javax.swing.*;

/**
 *
 * @author Anthonny
 */
public class Administrator {

    public static void
            main(String[] args) throws IOException {

        String menu = "Financial Project Management\n";
        int n1, n2, n3;
        int op = 0;

        menu += "1.  Log in\n";
        menu += "2.  Change Password\n";
        menu += "3.  End\n";
        menu += "Choose Option:\n";

        while (op != 3) {

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {

                case 1:
                    Administrator_Record objeto = new Administrator_Record();
                    objeto.record();
                    break;

                case 2:
                    Administrator_Record objeto2 = new Administrator_Record();
                    objeto2.change_Password();
                    break;

                case 3:
                    break;
                 
                    
                default:
                    JOptionPane.showMessageDialog(null, "Option invalid.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }
}
