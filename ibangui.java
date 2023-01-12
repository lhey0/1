import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigInteger;
 
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 21.11.2022
 * @author 
 */
 
public class ibangui extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  String iban;
  String validiere;
  // Ende Attribute
 
  public ibangui() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("ibangui");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
 
    jLabel1.setBounds(72, 16, 110, 20);
    jLabel1.setText("IBAN Validierer");
    cp.add(jLabel1);
    jLabel2.setBounds(0, 64, 110, 20);
    jLabel2.setText("IBAN");
    cp.add(jLabel2);
    jTextField1.setBounds(120, 64, 150, 20);
    cp.add(jTextField1);
    jButton1.setBounds(96, 96, 75, 25);
    jButton1.setText("Prüfen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jLabel3.setBounds(0, 136, 110, 20);
    jLabel3.setText("Land");
    cp.add(jLabel3);
    jLabel4.setBounds(0, 184, 110, 20);
    jLabel4.setText("");
    cp.add(jLabel4);
    jLabel5.setBounds(144, 136, 110, 20);
    jLabel5.setText("");
    cp.add(jLabel5);
    // Ende Komponenten
 
    setVisible(true);
  } // end of public ibangui
 
  // Anfang Methoden
 
 
 
  public void jButton1_ActionPerformed(ActionEvent evt) 
  {
    gibLaenderkennung();
    pruefe();
  } // end of jButton1_ActionPerformed
  public void pruefe()
  {
    int z0 = iban.charAt(0)-55;
    int z1 = iban.charAt(1)-55;
    int IBAN_MIN_SIZE = 15;
    int IBAN_MAX_SIZE = 34;
    String trimmed = iban.trim();
    if (trimmed.length() < IBAN_MIN_SIZE || trimmed.length() > IBAN_MAX_SIZE) {
      jLabel4.setText("Ne das wird so nix");
    }
    
    validiere = iban.substring(4,22)+z0+z1+iban.substring(2,4);
    System.out.println(validiere);
    
    BigInteger ibanbig = new BigInteger(validiere);
    BigInteger modu = new BigInteger("97");
    BigInteger ergebnis = new BigInteger("1");
    
    if (ibanbig.remainder(modu).equals(ergebnis)) {
      jLabel4.setText("Jo Gültig");
    } else {
      jLabel4.setText("Ne das wird so nix");
    } // end of if-else
  }  
  
 
  public void gibLaenderkennung()
  {
    iban = jTextField1.getText();
    iban = iban.toUpperCase();
    switch (iban.substring(0,2))
    {
    case "DE":
        jLabel5.setText("Bundesrepublik Deutschland");
      break;
    case "PL":
        jLabel5.setText("Republik Polen");
      break;
    case "CZ":
        jLabel5.setText("Tschechien");
      break;
    case "AT":
        jLabel5.setText("Österreich");
      break;
    case "CH":
        jLabel5.setText("Schwiiz");
      break;
    case "FR":
        jLabel5.setText("Frankreich");
      break;
    case "LU":
         jLabel5.setText("Luxemburg");
      break;
    case "BE":
        jLabel5.setText("Belgien");
      break;
    case "NL":
        jLabel5.setText("Nederlande");
      break;
    default:
        jLabel5.setText("Fehler");
      break; 
    }
     
 
  }   
  // Ende Methoden
} // end of class ibangui
