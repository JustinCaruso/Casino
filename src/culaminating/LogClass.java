package culaminating;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Justin
 */
public class LogClass {

    private Formatter Cred;
    String[] UserData;
    boolean Success;
    String Cash, User, Pass, RequestedData, newContent,oldString, newString,oldContent,line;
    String[] split, Temp;
    File file;
    BufferedReader reader = null;
    FileWriter writer = null;
    int LineCounter;
    /**
     * User Info Class
     *
     * @throws java.io.FileNotFoundException
     */
    public LogClass() throws FileNotFoundException {
        this.Success = false;
        this.file = new File("Credentials.txt");
        this.RequestedData = null;
        UserData = new String[3];
        Temp = new String[3];
        split = new String[3];

    }

    /**
     * !!! MUST RUN BEFORE ANYTHING FROM CLASS !!! !!! MUST RUN BEFORE ANYTHING
     * FROM CLASS !!! !!! MUST RUN BEFORE ANYTHING FROM CLASS !!!
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void OpenFile() throws FileNotFoundException, IOException {

        try {
            FileWriter f = new FileWriter("Credentials.txt", true);
            Cred = new Formatter(f);

        } catch (FileNotFoundException e) {
            System.out.println("File Already Exists\n");
        }
    }

    /**
     * Three String arguments to add to login file
     *
     * 1. Cash 2. Username 3. Password
     *
     * @param cash Users Currency
     * @param user Users Name
     * @param pass Users Login Password
     */
    public void AddLog(String cash, String user, String pass) {
        Cred.format("%s%s%s", cash, user, pass);

    }

    /**
     * Closes all file reader and scanner objects when finished with login
     * screen
     */
    public void CloseFile() {
        Cred.close();

    }

    /**
     * Checks to see if user and pass are in file returning a boolean to tell if
     * so and allows Credentials to be called for requesting the users
     * information within the program
     *
     * !!! REQUIRED TO BE RAN BEFORE CREDENTIALS!!!
     *
     * @param user
     * @param pass
     * @return
     * @throws IOException
     */
    public boolean ReadFile(String user, String pass) throws IOException {
        user = user.replaceAll("[^A-Za-z]+", "");
        pass = pass.replaceAll("[^A-Za-z]+", "");
        Scanner sc = null;
        sc = new Scanner(file);
        if (sc.hasNext() == true) {
            while (sc.hasNext()) {
                for (int i = 0; i <= 2; i++) {
                    split[i] = sc.next();
                }
                Cash = split[0];
                User = split[1].replaceAll("[^A-Za-z]+", "");
                Pass = split[2].replaceAll("[^A-Za-z]+", "");

                if (Pass.equalsIgnoreCase(pass) & User.equalsIgnoreCase(user)) {
                    UserData[0] = User;
                    UserData[1] = Pass;
                    UserData[2] = Cash;
                    Success = true;
                    break;
                }
            }
        }
        return Success;

    }

    /**
     * Requests users data
     *
     * 0 = User 1 = Pass 2 = Cash
     *
     * @param x integer value for key above
     * @return RequestedData DUHR!
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String ReqCredentials(int x) throws FileNotFoundException, IOException {
        if (x == 0) {
            RequestedData = UserData[0];
        }
        if (x == 1) {
            RequestedData = UserData[1];
        }
        if (x == 2) {
            RequestedData = UserData[2];
        }
        else{
            System.out.println("Requirments Not Met\nPossible Issue\nUser Not Logged In");
        }
        return RequestedData;
    }

    /**
     *
     * Changes the temporary value of their cash
     * to keep track of cash while in game(s)
     * 
     * @param TempCash
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChngCredentials(String TempCash) throws FileNotFoundException, IOException{
     UserData[2] = TempCash;
 }
    /**
     * Called for when in closing procedure of 
     * casino to save final balance permanently
     *
     * @param newBalance
     * @throws java.io.FileNotFoundException
     */
    public void modifyFile(String newBalance) throws FileNotFoundException, IOException {
        if (UserData[2] != null) {
            LineCounter = 0;
            oldString=null;
            newString=null;
            oldString = (UserData[2] + " " + UserData[0] + " " + UserData[1]);
            newString = (newBalance + " " + UserData[0] + " " + UserData[1]);
            oldContent = "";
            try {
                reader = new BufferedReader(new FileReader("Credentials.txt"));
                line = reader.readLine();
                while (line != null) {
                    oldContent = oldContent + line + System.lineSeparator();
                    line = reader.readLine();
                    LineCounter = LineCounter + 1;
                }
                newContent = oldContent.replaceAll(oldString, newString);
                //Rewriting the input text file with newContent
            } catch (IOException e) {
            }
            PrintWriter writer;
            writer = new PrintWriter("Credentials.txt");
            writer.print(newContent);
            System.out.print("YEET");
            writer.close();

        
    }else{
            System.out.println("Requirments Not Met\nPossible Issue\nUser Not Logged In");
        }
    }
}
