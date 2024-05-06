
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;




public class ApplicationForm extends JFrame implements ActionListener {
    private final Font mainFont = new Font("Times New Roman", Font.BOLD, 14);
    JComboBox<String> gradeLevelCB, courseBox1,courseBox2;
    JButton b1,b2,b3,nextButton,exitButton;
    JPanel fp, hsp, addressP,sacp,eup,exitPanel;
    JTextField firstTF, lastTF, emailTF, gpaTF;
    String firstName, lastName, email, selectedGrade;
    double gpa;
    Student student;
    private List<Student> studentApplicants;
    private File file;
    
    public ApplicationForm(){
        setTitle("CSUS: Computer Science Application Form");
        UIChange();
        setSize(850,750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(196,182,129));
        fp = createFirstPage();
        add(fp);
        add(csusAddress(),BorderLayout.SOUTH);
        setVisible(true);
        hsp = highSchoolPage();
        eup = createCollegePage();
        exitPanel = exitPage();
        file = new File("applicants.txt");

    
    }
    private void UIChange(){
        try {
         
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");        
           UIManager.getLookAndFeelDefaults().put("Windows", new Color(0, 78, 56));
           SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    private JPanel createFirstPage() {
        JLabel label0,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
        JTextField tf4,tf5,tf6,tf7;
        JRadioButton jr1,jr2;
        fp = new JPanel();
        fp.add(getLogo(), BorderLayout.NORTH);
        
    
        
        label0 = new JLabel("STUDENT APPLICATION FORM");
        label0.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        
        label1 = new JLabel("First Name:");
        label1.setFont(mainFont);
        
        label2 = new JLabel("Last Name:");
        label2.setFont(mainFont);
        
        label3 = new JLabel("Email:");
        label3.setFont(mainFont);
        
        label4 = new JLabel("Gender:");
        label4.setFont(mainFont);
        
        label5 = new JLabel("Address:");
        label5.setFont(mainFont);
        
        label6 = new JLabel("City:");
        label6.setFont(mainFont);
        
        label7 = new JLabel("State:");
        label7.setFont(mainFont);
        
        label8 = new JLabel("Zip Code:");
        label8.setFont(mainFont);
        
        label9 = new JLabel("Current Grade:");
        label9.setFont(mainFont);
        
        label10 = new JLabel("Current GPA:");
        label10.setFont(mainFont);
        
        firstTF = new JTextField();
        firstTF.setFont(mainFont);
       
       
        lastTF = new JTextField();
        lastTF.setFont(mainFont);
        
        
        emailTF = new JTextField();
        emailTF.setFont(mainFont);
      
       
        jr1 = new JRadioButton("male");
        jr1.setFont(mainFont);
        jr1.setBackground(Color.WHITE);
        
        jr2 = new JRadioButton("female");
        jr2.setFont(mainFont);
        jr2.setBackground(Color.WHITE);
        
        ButtonGroup groupJrb = new ButtonGroup();
        groupJrb.add(jr1);
        groupJrb.add(jr2);
        
        tf4 = new JTextField();
        tf4.setFont(mainFont);
        
        tf5 = new JTextField();
        tf5.setFont(mainFont);
        
        tf6 = new JTextField();
        tf6.setFont(mainFont);
        
        tf7 = new JTextField();
        tf7.setFont(mainFont);
        
        gradeLevelCB = new JComboBox<>(new String[]{" ","High School Student", "Current Sac State Student", "Enrolled in another University"});
        gradeLevelCB.setFont(mainFont);
        gradeLevelCB.setBackground(Color.WHITE);
        
        gpaTF = new JTextField();
        gpaTF.setFont(mainFont);
       
        
        fp.setLayout(null);
        
        label0.setBounds(170,20,600,40);
        fp.add(label0);
        
        label1.setBounds(130,140,100,30);
        fp.add(label1);
        
        firstTF.setBounds(250,140,400,30);
        fp.add(firstTF);
       
        
        label2.setBounds(130,190,100,30);
        fp.add(label2);
        
        lastTF.setBounds(250,190,400,30);
        fp.add(lastTF);
       
        
        label3.setBounds(130,240,100,30);
        fp.add(label3);
        
        emailTF.setBounds(250,240,400,30);
        fp.add(emailTF);
        //tf3.setBounds(250,240,400,30);
       // fp.add(tf3);
         
        label4.setBounds(130,290,100,30);
        fp.add(label4);
        
        jr1.setBounds(250,290,90,30);
        fp.add(jr1);
        
        jr2.setBounds(350,290,90,30);
        fp.add(jr2);
        
        label5.setBounds(130,340,100,30);
        fp.add(label5);
        
        tf4.setBounds(250,340,400,30);
        fp.add(tf4);
        
        label6.setBounds(130,390,100,30);
        fp.add(label6);
        
        tf5.setBounds(250,390,400,30);
        fp.add(tf5);
        
        label7.setBounds(130,440,100,30);
        fp.add(label7);
        
        tf6.setBounds(250,440,400,30);
        fp.add(tf6);
        
        label8.setBounds(130,490,100,30);
        fp.add(label8);
        
        tf7.setBounds(250,490,400,30);
        fp.add(tf7);
        
        label9.setBounds(130,540,100,30);
        fp.add(label9);
        gradeLevelCB.setBounds(250,540,400,30);
        fp.add(gradeLevelCB);
        
        label10.setBounds(130,590,100,30);
        fp.add(label10);
        gpaTF.setBounds(250,590,100,30);
        fp.add(gpaTF);
        fp.setBackground(new Color(196,182,129));
        
        b1 = createNextButton();
        fp.add(b1);
        b1.addActionListener(this);
        return fp;
    }

  
    private JPanel highSchoolPage(){
        
        hsp = new JPanel();
        hsp.add(getLogo(),BorderLayout.NORTH);
        JLabel label0,label1,label2,label3,label4,label5,label6;
        JTextField tf1,tf2,tf3,tf4; 
        
        
        label0 = new JLabel("HIGH SCHOOL STUDENT APPLICATION FORM");
        label0.setFont(new Font("Times New Roman", Font.BOLD, 25));
        
        label1 = new JLabel("Score recieved on Aleks exam");
        label1.setFont(mainFont);
        
        label2 = new JLabel("Please enter your current grade level");
        label2.setFont(mainFont);
        
        label3 = new JLabel("Please list any related computer-science courses taken in the box below. (Leave blank if none)");
        label3.setFont(mainFont);
        
        label4 = new JLabel("Please list any extracurricular activties that you are/were apart of in the box below (Leave blank if none)");
        label4.setFont(mainFont);
        
        label5 = new JLabel("Please select the highest math course completed");
        label5.setFont(mainFont);
        
        label6 = new JLabel("Please select the highest science course completed");
        label6.setFont(mainFont);
        
        tf1 = new JTextField();
        tf1.setFont(mainFont);
        
       
        tf2 = new JTextField();
        tf2.setFont(mainFont);
        
        tf3 = new JTextField();
        tf3.setFont(mainFont);
        
        tf4 = new JTextField();
        tf4.setFont(mainFont);
        
        courseBox1 = new JComboBox<>(new String[] {" ","Earth-Science", "Biology", "Chemistry", "Physics", "Enviromental Science", "Physics", "AP Physics"});
        courseBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        courseBox2 = new JComboBox<>(new String[] {" ","Pre-Algebra","Geometry","Algebra 1","Algebra 2", "Trigonemetry", "Calculus", "Calculus AB", "Calculus BC"});
        courseBox2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        hsp.setLayout(null);
        
        label0.setBounds(130,20,600,40);
        hsp.add(label0);
        
        label1.setBounds(70,140,220,30);
        hsp.add(label1);
        
        tf1.setBounds(270,140,70,30);
        hsp.add(tf1);
      
        
        label2.setBounds(350,140,270,30);
        hsp.add(label2);
        
      
        tf2.setBounds(600,140,70,30);
        hsp.add(tf2);
         
        label3.setBounds(70,180,600,30);
        hsp.add(label3);
        
        tf3.setBounds(70,210,600,30);
        hsp.add(tf3);
        
        label4.setBounds(70,270,700,30);
        hsp.add(label4);
        
        tf4.setBounds(70,300,600,30);
        hsp.add(tf4);
        
        label5.setBounds(70,360,300,30);
        hsp.add(label5);
 
        courseBox1.setBounds(70,390,300,30);
        hsp.add(courseBox1);
        
        label6.setBounds(380,360,400,30);
        hsp.add(label6);
        
        courseBox2.setBounds(380,390,290,30);
        hsp.add(courseBox2);
        
        hsp.setBackground(new Color(196,182,129));
       
        b2 = createBackButton();
        hsp.add(b2);
        b2.addActionListener(this);
        b3 = createSubmitButton();
        hsp.add(b3);
        b3.addActionListener(this);
        return hsp;
   
        
    }
    private JPanel createCollegePage(){
        eup = new JPanel();
        eup.add(getLogo(),BorderLayout.NORTH);
        JLabel label0, label1, label2, label3, label4, label5, label6, label7, label8, label9;
        JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
        JRadioButton jr1,jr2;
        
        label0 = new JLabel("Sacramento State: Computer Science Application");
        label0.setFont(new Font("Times New Roman", Font.BOLD, 25));
        
        label1 = new JLabel("Please enter your Sac State ID: ");
        label1.setFont(mainFont);
        
        label2 = new JLabel("Please select if you are applying for Pre-Computer Science or Computer Science?");
        label2.setFont(mainFont);
        
        label3 = new JLabel("Have you taken MATH 30?    If so enter your grade, if not enter NA");
        label3.setFont(mainFont);
        
        label4 = new JLabel("Have you taken MATH 31?    If so enter your grade, if not enter NA");
        label4.setFont(mainFont);
        
        label5 = new JLabel("Have you taken PHYS 11A?   If so enter your grade, if not enter NA");
        label5.setFont(mainFont);
        
        label6 = new JLabel("Have you taken CSC 15?        If so enter your grade, if not enter NA");
        label6.setFont(mainFont);
        
        label7 = new JLabel("Have you taken CSC 20?        If so enter your grade, if not enter NA");
        label7.setFont(mainFont);
        
        label8 = new JLabel("Have you taken CSC 28?        If so enter your grade, if not enter NA");
        label8.setFont(mainFont);
        
        label9 = new JLabel("Have you taken CSC 35?        If so enter your grade, if not enter NA");
        label9.setFont(mainFont);
        
        
        tf1 = new JTextField();
        tf1.setFont(mainFont);
       
        tf2 = new JTextField();
        tf2.setFont(mainFont);
        
        tf3 = new JTextField();
        tf3.setFont(mainFont);
        
        tf4 = new JTextField();
        tf4.setFont(mainFont);
        
        tf5 = new JTextField();
        tf5.setFont(mainFont);
        
        tf6 = new JTextField();
        tf6.setFont(mainFont);
        
        tf7 = new JTextField();
        tf7.setFont(mainFont);
        
        tf8 = new JTextField();
        tf8.setFont(mainFont);
        
        jr1 = new JRadioButton("Pre-Computer Science");
        jr1.setFont(mainFont);
        jr1.setBackground(Color.WHITE);
        
        jr2 = new JRadioButton("Computer Science");
        jr2.setFont(mainFont);
        jr2.setBackground(Color.WHITE);
        
        eup.setLayout(null);
        
        label0.setBounds(170,20,600,40);
        eup.add(label0);
        
        label1.setBounds(110,140,220,30);
        eup.add(label1);        
        
        tf1.setBounds(310,140,100,30);
        eup.add(tf1);
        
        label2.setBounds(110, 200, 500, 30);
        eup.add(label2);        
        jr1.setBounds(110,230,200,30);
        eup.add(jr1);        
        jr2.setBounds(340,230,200,30);
        eup.add(jr2);
        
        label3.setBounds(110, 290,500,30);
        eup.add(label3);        
        tf2.setBounds(600, 290, 70, 30);
        eup.add(tf2);
        
        label4.setBounds(110, 325, 500, 30);
        eup.add(label4);
        tf3.setBounds(600, 325, 70, 30);
        eup.add(tf3);
        
        label5.setBounds(110, 360, 500, 30);
        eup.add(label5);
        tf4.setBounds(600, 360, 70, 30);
        eup.add(tf4);
        
        label6.setBounds(110, 395, 500, 30);
        eup.add(label6);
        tf5.setBounds(600, 395, 70, 30);
        eup.add(tf5);
        
        label7.setBounds(110, 430, 500, 30);
        eup.add(label7);
        tf6.setBounds(600, 430, 70, 30);
        eup.add(tf6);
        
        label8.setBounds(110, 465, 500, 30);
        eup.add(label8);
        tf7.setBounds(600, 465, 70, 30);
        eup.add(tf7);
        
        label9.setBounds(110, 500, 500, 30);
        eup.add(label9);
        tf8.setBounds(600, 500, 70, 30);
        eup.add(tf8);
                
        b2 = createBackButton();
        eup.add(b2);
        b2.addActionListener(this);
        eup.setBackground(new Color(196,182,129));
        b3 = createSubmitButton();
        eup.add(b3);
        b3.addActionListener(this);
        return eup;
    }
    private JPanel exitPage() {
        exitPanel = new JPanel();
        exitPanel.add(getLogo(),BorderLayout.NORTH);       
        ImageIcon icon = new ImageIcon("C:\\Users\\david\\Downloads\\checkmark-png-25977.png");
        Image scaledImage = icon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(330, 40, 200, 200);
        imageLabel.setOpaque(false); // Make the label transparent
        imageLabel.setBackground(new Color(0, 0, 0, 0)); // Set transparent background color
        exitPanel.add(imageLabel);
        exitPanel.setLayout(null);
        JLabel label1,label2,label3;
        label1 = new JLabel("Application submitted");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 35));
        label1.setBounds(270,200,600,50);
        exitPanel.add(label1);
        label2 = new JLabel("For your records, we have sent you an email to confirm that we have recieved and");
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label2.setBounds(120,270,700,30);
        exitPanel.add(label2);
        label3 = new JLabel("processed your application. We encourage you to print this information for your records");
        label3.setBounds(120,290,700,30);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        exitPanel.add(label3);
        exitButton = createExitButton();
        exitPanel.add(exitButton);
        exitButton.addActionListener(this);
        exitPanel.setBackground(new Color(196,182,129));
        return exitPanel;
        
        
    }
    private JPanel csusAddress() {
        addressP = new JPanel((new BorderLayout()));
        JPanel blp = new JPanel();
        blp.setBackground(new Color(0,78,56));
        JLabel j1 = new JLabel("California State University,Sacramento: 6000 J Street, Sacramento, CA 95819 Campus Main Phone:(916)278-6011");
        j1.setFont(new Font("Times New Roman", Font.BOLD, 10));
        blp.add(j1);
        addressP.add(blp, BorderLayout.SOUTH);
       
        return addressP;
        
        
    }
    private JLabel getLogo(){
        ImageIcon icon = new ImageIcon("C:\\Users\\david\\OneDrive\\Documents\\NetBeansProjects\\csc130\\src\\main\\java\\s.png");
        Image scaled_icon = icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon final_icon = new ImageIcon(scaled_icon);
        JLabel imageLabel = new JLabel(final_icon);
        imageLabel.setBounds(40,5,100,100);
        return imageLabel;
    }
    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.setBackground(new Color(0,78,56));
        button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        button.setBounds(330,400,200,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });
        return button;
    }
    private JButton createNextButton(){
        JButton button = new JButton("Next");
        button.setFont(mainFont);
        button.setBounds(680,600,80,30);
        return button;
    }

    private JButton createBackButton() {
    JButton backButton = new JButton("Back");
    backButton.setFont(mainFont);
    backButton.setBounds(50, 600, 80, 30);
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to handle back button click
            showFirstPage(); 
        }
    });
    return backButton;
}
    private JButton createSubmitButton() {
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(mainFont);
        submitButton.setBounds(680,600,80,30);
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                student = new Student(firstName, lastName, email, selectedGrade, gpa);
                studentApplicants = new ArrayList<>();
                Collections.sort(studentApplicants, new StudentComparator());
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                        writer.write(student.toString()); 
                        writer.newLine();
            } catch (IOException ex) {
                        ex.printStackTrace();
            }
        

                showExitPage();
        }
});
    
        return submitButton;
    }
    public static void main(String[] args){
        new ApplicationForm();
        
    }
    private void showHighSchoolPage() {
        add(hsp);
        hsp.setVisible(true);
            fp.setVisible(false);
        
    }
    private void showFirstPage() {
        add(fp);
           
            fp.setVisible(true);
            hsp.setVisible(false);
            eup.setVisible(false);
    }
    private void showCollegePage() {
        add(eup);
        eup.setVisible(true);
        fp.setVisible(false);
        
    }
    private void showExitPage(){
        add(exitPanel);
        exitPanel.setVisible(true);
        hsp.setVisible(false);
        eup.setVisible(false);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        selectedGrade = (String) gradeLevelCB.getSelectedItem();
     
         if(e.getSource() == b1){
              firstName = firstTF.getText();
                 lastName = lastTF.getText();
                email = emailTF.getText();
                gpa = Double.parseDouble(gpaTF.getText());
         if(selectedGrade.equals("High School Student")) {
                    
                 showHighSchoolPage();
           }  else {
             showCollegePage();

         }

}
}
}
    

