import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Notak
 */
public class startemails extends javax.swing.JFrame {

    /**
     * Creates new form startemails
     */
    public startemails() {
        initComponents();
        //Hide the continue button until the user chooses an option
        cont.setVisible(false);
        //Set the Title and Sender once the scene changes
        title.setText(emails[currentIndex].getSubject());
        send.setText(emails[currentIndex].getSender());
        //Display a count of the emails that the user will be looking at
        NumChange();
  
    }
    
    /** 
    * Global variables 
    **/
    
    //Read the text file that holds all the emails and instaintate objects with that information 
    //and put them into an email array by using a method created below
    public Email[] emails = readEmails(new File("emails.txt"));
    //Two static booleans to hold the button flags (once button is pressed it will trigger
    public static boolean report = false;
    public static boolean open = false;
    //A static integer to hold the user's score
    public static int score = 0;
    //A static integer to to hold the current index of the email that the user is looking at
    public static int currentIndex = 0;
    
    /**
     * An email class to hold email objects that will be used to hold specific 
     * information about the email
     * @Author Catherine Lin
     * @since 2025-12-13
     */
    public class Email {
        //Attributes
        private final String type; //Type of email (safe or unsafe)
        private final String sender; //Sender of the email
        private final String subject; //Subject of the email
        public static int numEmails; // Static integer to hold the number of emails
        
        /**
         * Constructor for the email class
         * @param type holds the type of email that is being instantiated
         * @param sender holds the sender of the email that is being instantiated
         * @param subject holds the subject of the email that is being instantiated 
         */
        public Email(String type, String sender, String subject){
            //assign the inputted values to their respective attributes 
            this.type = type;
            this.sender = sender;
            this.subject = subject;
            numEmails ++; //Add one to the number of emails as an email object has been created
        }
        /**
         * Get the type of the specified object
         * @return the type of the specified email object
         */
        public String getType(){
            return type;
        }
        
        /**
         * Get the sender of the specified object
         * @return the name of the sender of the specified email object
         */
        public String getSender(){
            return sender;
        }
        
        /**
         * Get the subject of the specified object
         * @return the subject of the specified email object 
         */
        public String getSubject(){
            return subject;
        }
        /**
         * Get the number of email objects created 
         * @return the number of email objects created by the constructor
         */
        public static int getNumEmails(){
            return numEmails;
        }
        
    }
    /**
     * Child class of the Parent (Email Class)
     * Holds methods and attributes for unsafe emails
     * @Author Catherine Lin
     * @since 2025-12-13
     */
    public class Unsafe extends Email {
        //Attributes 
        private final String level; //Holds the severity of the email
        private final String reason; //Holds the reason why the email is unsafe
        
        /**
         * Constructor for the unsafe class
         * @param type holds the type of email that is being instantiated
         * @param sender holds the sender of the email that is being instantiated
         * @param subject holds the subject of the email that is being instantiated 
         * @param level holds the severity of the unsafe email being instantiated
         * @param reason holds the reason why the email being instantiated is unsafe
         */
        public Unsafe(String type, String sender, String subject, String level, String reason){
            super(type, sender, subject); //Calls on parent constructor
            //assign the inputted values to their respective attributes 
            this.level = level; 
            this.reason = reason;
        }
        
        /**
         * Gets the severity of the email object
         * @return the severity of the specified email object
         */
        public String getLevel(){
            return level;
        }
        
        /**
         * Gets the reason why the email is dangerous
         * @return the reason why the specified email object is unsafe
         */
        public String getReason(){
            return reason;
        }
       
    }
    /**
     * Child class of the Parent (Email Class)
     * Holds methods and attributes for safe emails
     * @Author Catherine Lin
     * @since 2025-12-13
     */
    public class Safe extends Email {
        //Attributes 
        private final String quote; //holds a nice quote from the sender
        private final String reason; //holds the reason why the email is safe
        
        
        /**
         * Constructor for the safe class
         * @param type holds the type of email that is being instantiated
         * @param sender holds the sender of the email that is being instantiated
         * @param subject holds the subject of the email that is being instantiated 
         * @param quote holds the a nice quote from the sender of the email being instantiated
         * @param reason holds the reason why the email being instantiated is safe
         */
        public Safe(String type, String sender, String subject, String quote, String reason){
            super(type, sender, subject); //Calls on the parent constructor
            //Assigns the users input to the instantiated safe email attributes
            this.reason = reason;
            this.quote = quote;
        }
        
        /**
         * Gets the reason why the email is safe
         * @return the reason the specified email is safe
         */
        public String getReason(){
            return reason;
        }
        
        /**
         * Gets the nice quote the sender sent
         * @return the quote of the sender in the specified email
         */
        public String getQuote(){
            return quote;
        }
    }
    
    /**
     * Reads a specified file containing emails and instantiates email objects from them 
     * and also puts them into a email array
     * @param file a file that contains email information
     * @return an Email array that holds the instantiated email objects
     */
    public Email[] readEmails(File file){
        //Create a 2D string array to hold the email information before it has been
        //instantiated into email objects [rows][columns]
        String [][] emails = new String [6][5];
        //number to count the number of lines in the file
        int num = 0;
        //try catch so that we are able to read the file
        try{
            //Open the file for reading
            Scanner read = new Scanner(file);
            //Loop until there are no more lines in the file
            while(read.hasNext()){
                //Assign the current line to a string
                String line = read.nextLine();
                //Split the data wherever there are commas and put it into an array
                String [] data = line.split(",");
                //For loop to loop through all indices to ensure all information is transferred
                for(int i = 0;i < data.length; i++){
                    emails[num][i] = data[i].trim();
                }
            //go to the next row 
            num++;
            } 
        }catch(FileNotFoundException e){ //If the file is not found print out an error
            System.out.println("Sorry! File not Found.");
        }
        
        //Create a new email array to hold all of the emails that we will be using
        Email[] emailList = new Email[6]; //size of 6 since there are 6 emails
        //For loop to loop through all indices and ensure all info is transferred
        for (int i = 0; i < num; i++){
            //Checks to see what kind of email it is and creates the correct object for it's type
            //Check if the email is safe
            if (emails[i][0].equalsIgnoreCase("Safe")){
            //If it is create a safe object(child of email)and use it's constructor
                emailList[i] = new Safe(emails[i][0], emails[i][1], emails[i][2], emails[i][3], emails[i][4]);
            }
            //Check to see if the email is unsafe
            else if (emails[i][0].equalsIgnoreCase("Unsafe")){
            //If it is create a unsafe object(child of email)and use it's constructor
                emailList[i] = new Unsafe(emails[i][0], emails[i][1], emails[i][2], emails[i][3], emails[i][4]);
            }else{
            //If the email is neither safe or unsafe create a regular email object
                emailList[i] = new Email(emails[i][0], emails[i][1], emails[i][2]);
            }
        }
        //Return the completed email array
        return emailList;
    }
    
    /**
     * A method that displays the details of the current email 
     * @param emails a email array that holds email objects
     * @param i holds the current index of the email that we want to access
     */
    public void displayDetails(Email[] emails, int i){
        //Sets the title and sender first depending on the current index
            title.setText(emails[i].getSubject());
            send.setText(emails[i].getSender());
        //If the report flag has triggered (user has clicked the report button)
        if (report) {
            //Check if the current email is an instance of the unsafe class
            if (emails[i] instanceof Unsafe) {
                //downcast into its type
                Unsafe email = (Unsafe) emails[i];
                //update score
                score += 10;
                //display a message depending on if the user has gotten the problem right
                info.setText("<html>Good Job! You got it right!<br><br>This Email is Dangerous because "+  (email.getReason()) + "</html>");
            //Check if the current email is an instance of the safe class
            }else if (emails[i] instanceof Safe) {
                //downcast into its type
                Safe email = (Safe) emails[i];
                //update score
                score -= 10;
                //display a message depending on if the user has gotten the problem right
                info.setText("<html>Sorry, your answer is wrong!<br><br>This Email is Safe because " + (email.getReason()) + "</html>");
            }
         //If the open flag has been triggered (user has clicked the open button)
        } else if (open) {
            //Check if the current email is an instance of the unsafe class
            if (emails[i] instanceof Unsafe) {
                //downcast into its type
                Unsafe email = (Unsafe) emails[i];
                //update score
                score -= 10;
                //display a message depending on if the user has gotten the problem right
                info.setText("<html>Sorry, your answer is wrong!<br><br>This Email is Dangerous because " + (email.getReason()) + "</html>");
            //Check if the current email is an instance of the safe class
            } else if (emails[i] instanceof Safe) {
                //downcast into its type
                Safe email = (Safe) emails[i];
                //update score
                score += 10; 
                //display a message depending on if the user has gotten the problem right
                info.setText("<html>Good Job! You got it right!<br><br>This Email is Safe because " + (email.getReason()) + "</html>");
            }
        }
    }
    
    /**
     * Changes the number in the corner of the UI to show which email the user is on
     */
    public void NumChange() {
        //Change the display depending on which indice the user is currently on
        //Uses the static attribute in the email class
        no.setText((currentIndex + 1) + " of " + Email.getNumEmails());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        whitebox = new javax.swing.JPanel();
        no = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        send = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rep = new javax.swing.JButton();
        op = new javax.swing.JButton();
        cont = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whitebox.setBackground(new java.awt.Color(255, 255, 255));
        whitebox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        whitebox.add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 40, 20));

        title.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        title.setText("Email Title details go here");
        whitebox.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 540, 30));
        whitebox.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 540, 20));

        send.setText("Sender");
        whitebox.add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Please Choose An Option Below");
        whitebox.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 500, 260));
        whitebox.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 540, 10));

        rep.setText("Report and delete");
        rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repActionPerformed(evt);
            }
        });
        whitebox.add(rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 160, -1));

        op.setText("Open");
        op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opActionPerformed(evt);
            }
        });
        whitebox.add(op, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 160, -1));

        cont.setText("Continue");
        cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contActionPerformed(evt);
            }
        });
        whitebox.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 220, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gmail.png"))); // NOI18N
        whitebox.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLayeredPane1.add(whitebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repActionPerformed
        //When the report button is clicked set off the flag
        report = true;
        //Change the details and display the comments about the user's choice
        displayDetails(emails, currentIndex);
        //Make the report button and open button disappear so the user cannot click anymore 
        rep.setVisible(false);
        op.setVisible(false);
        //Make the continue button visible so that the user can go to the next email
        cont.setVisible(true);
    }//GEN-LAST:event_repActionPerformed

    private void contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contActionPerformed
        //Increase the current index by one so that it goes to the next email
        currentIndex++;
        //If the current index is less than the number of emails
        if (currentIndex < Email.getNumEmails()){
            //Make the report and open buttons visible again
            rep.setVisible(true);
            op.setVisible(true);
            //Make the continue button invisible so that the user cannot skip over everything
            cont.setVisible(false);
            //Go to the next email
            displayDetails(emails, currentIndex);
        }
        else{
            //If the current index is not less than the number of emails
            //End the game
            new End().setVisible(true);
            //Hide this form
            this.setVisible(false);
            System.out.println(score);
        }
        //Set all flags as false as a new email will appear
        report = false;
        open = false;
        //reset the information
        info.setText("Please Choose an Option Below");
        //Change the current email counter in the top right
        NumChange();
    }//GEN-LAST:event_contActionPerformed

    private void opActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opActionPerformed
        //When the open button is clicked set off the flag
        open = true;
        //Change the details and display the comments about the user's choice
        displayDetails(emails, currentIndex);
        //Make the report button and open button disappear so the user cannot click anymore 
        rep.setVisible(false);
        op.setVisible(false);
        //Make the continue button visible so that the user can go to the next email
        cont.setVisible(true);
    }//GEN-LAST:event_opActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(startemails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startemails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startemails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startemails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startemails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton cont;
    private javax.swing.JLabel info;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel no;
    private javax.swing.JButton op;
    private javax.swing.JButton rep;
    private javax.swing.JLabel send;
    private javax.swing.JLabel title;
    private javax.swing.JPanel whitebox;
    // End of variables declaration//GEN-END:variables
}
