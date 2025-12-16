/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 *
 * @author Notak
 */
public class tips extends javax.swing.JFrame {

    /**
     * Creates new form tips
     */
    public tips() {
        initComponents();
        //Make the continue button invisible until the user enters a tip
        cont.setVisible(false);
        
    }
    
    /**
     *Global Variables
     */
    public static File file = new File ("tips.txt"); //Variable to hold the file
    public static int numTips; //Variable to hold the number of tips in the system
    
    /**
     * The stay safe class holds tips that the user enters regarding staying 
     * safe online
     * @Author Catherine Lin
     * @since 2025-12-15
     */
    public class staySafe {
        //Attributes
        private Description description; //Description object to hold the description of the tip
        private String name; //Name to hold the name of the user who has submitted the tip
        private final String DEFAULTNAME = "Anonymous"; //String to hold the default name if the user wants to stay anonymous
        
        /**
         * Constructor for the staySafe class if user wants to stay anonymous
         * @param description of the tip the user has entered
         */
        public staySafe (Description description){
            this.description = description; //Assign description to it's attribute
            this.name = DEFAULTNAME; //Assign default name to it's attribute
            numTips++; //Add a tip to the count
        }
        /**
         * Constructor for the staySafe class if the user wants to provide their name
         * @param description of the tip the user has entered
         * @param name the user's name
         */
        public staySafe (Description description, String name){
            this.description = description;//Assign description to it's attribute
            this.name = name; //Assign the user's name to it's attribute
            numTips++;//Add a tip to the count
            
        }
        
        /**
         * Gets the description of the tip
         * @return the description of the selected tip
         */
        public Description getDescription(){
            return description;
        }
        
        /**
         * Gets the name of the user that has submitted the tip
         * @return the name of the user that has submitted the specified tip
         */
        public String getName(){
            return name;
        }

        /**
         * To string to return the object in readable language
         * @return the string representation of the object
         */
        public String toString (){
            return name + "," + description.toString();
        }
        
        /**
         * A pretty to string to return the object but with better formatting
         * @return a string representation of the object but more readable for the user
         */
        public String toPrettyString(){
           return description.toPrettyString() + "<br><br> Submitted by: " + name + "</html>";
        }
            
    }
    
    /**
     * Description objects describe the tips that users submit
     * @Author Catherine Lin
     * @since 2025-12-15
     */
    public class Description{
        //Attributes
        private String details;//Details of what the tip is 
        private String category;//What is the tip about
        
        /**
         * Description constructor (Creates the description object)
         * @param details holds the details of what the tip is about
         * @param category holds the general category of the tip
         */
        public Description(String details, String category){
            //Assigns the inputted values to their respective attributes
            this.details = details; 
            this.category = category;
            
        }
        
        /**
         * Gets the details of the tip
         * @return the details of the specified tip
         */
        public String getDetails(){
            return details;
        }
        
        /**
         * Gets the category of the tip
         * @return the specific category of the specified tip
         */
        public String getCategory(){
            return category;
        }
        
        /**
         * To string to return the object in readable language
         * @return the string representation of the object
         */
        public String toString(){
            return category + "," + details;
        }
        
        /**
         * A pretty to string to return the object but with better formatting
         * @return a string representation of the object but more readable for the user
         */
        public String toPrettyString(){
            return "<html> For the Category " + category + "<br><br> A Tip is to " + details;
        }
        
    }
    
    /**
     * Method that creates description objects
     * @return 
     */
    public Description desc(){
        //recieves input from the combo box and assigns it to a variable
        String cat = (String)box.getSelectedItem();
        //receives input from the text field and assigns it to a variable
        String det = tf1.getText();
        //Instantiate the description object
        Description desc = new Description (det, cat); 
        //Return instantiated object
        return desc;
    }
    
    /**
     * Adds the specified tip to a flat file
     * @param desc requires the user's description of their tip
     */
    public void addTips(Description desc){
        staySafe tip;//Create a staySafe object first)
        //If the user has left the text field blank call on the constructor without name (they want to be anonymous)
        if (tf2.getText().trim().equals("")){
            tip = new staySafe(desc);
        }else{
            //If not the user has inputted their name so you have to retrieve that input and use the other constructor
            tip = new staySafe(desc, tf2.getText());
        }
        //Write the user's tip into the flat file
        try{
            FileWriter write1 = new FileWriter(file, true); //Initialize filewriter
            PrintWriter output = new PrintWriter(write1); //Initialize printwriter
            output.println(tip.toString()); //print the object to the file with the formatted toString
            output.close(); //close printwriter
            
         //If exception is thrown print out an error code
        }catch(IOException e){
            System.out.println("IO Error");
        }
    }
    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        box = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fin = new javax.swing.JButton();
        cont = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>After Learning about all of those ways to stay safe on the internet, please provide a tip you would provide one of your friends</html>");

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });

        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Password Creation Tips", "Terms and Service Tips", "Email Tips" }));
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Category");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Details");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name (Leave blank if you want to remain anonymous)");

        fin.setBackground(new java.awt.Color(204, 255, 204));
        fin.setText("Finished!");
        fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finActionPerformed(evt);
            }
        });

        cont.setBackground(new java.awt.Color(204, 255, 255));
        cont.setText("Continue -->");
        cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(168, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box, javax.swing.GroupLayout.Alignment.LEADING, 0, 315, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cont, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finActionPerformed
        //When button is pressed save the user's tip
        addTips(desc());
        //Display the continue button and hide the finished button so the user can only submit one tip
        cont.setVisible(true);
        fin.setVisible(false);
        
    }//GEN-LAST:event_finActionPerformed

    private void contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contActionPerformed
        //Close the jframe and make the next one visible
        new End().setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_contActionPerformed

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
            java.util.logging.Logger.getLogger(tips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tips().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JButton cont;
    private javax.swing.JButton fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
