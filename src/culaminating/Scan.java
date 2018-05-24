/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package culaminating;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Dad
 */
class Scan {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        LogClass a = new LogClass();
        a.OpenFile();
        a.AddLog("20 ", "Justin ", "Caruso \n");
        System.out.println(a.ReadFile("Usman", "Khan"));
        a.modifyFile("100");
        a.modifyFile("30");

    }
}
