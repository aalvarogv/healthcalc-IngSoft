package healthcalc.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Vista {

  private JFrame frame;
  private JButton bIdealWeight;
  private JButton bBMR;
  private JCheckBox bMasc;
  private JCheckBox bFem;
  private JTextField tEdad;
  private JTextField tAltura;
  private JTextField tPeso;
  private JTextField tIdealWeight;
  private JTextField tBMR;


  // Crear interfaz  
  public Vista() {
    init();
  }

  // Iniciar aplicación
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable()
      {
      public void run() {
        try {
          Vista wdw = new Vista();
          wdw.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      }
    );
  }

  // Inicializar interfaz
  public void init() {
    JFrame frame = new JFrame("Health Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    for (int row = 0; row < 20; row++) {
      for (int col = 0; col < 15; col++) {
          constraints.gridx = col;
          constraints.gridy = row;
          constraints.weightx = 1.0;
          constraints.weighty = 1.0;
          constraints.fill = GridBagConstraints.BOTH;

          Component filler = Box.createRigidArea(new Dimension(0, 0));
          panel.add(filler, constraints);
      }
  }

  constraints.weightx = 0;
  constraints.weighty = 0;
  constraints.fill = GridBagConstraints.NONE;
  constraints.anchor = GridBagConstraints.NORTHWEST;

    // Botones
    
    JButton bIdealWeight = new JButton("Ideal Weight");
    bIdealWeight.setPreferredSize(new Dimension(112, 31));
    
    constraints.gridx = 6;
    constraints.gridy = 15;
    constraints.gridwidth = 4;
    constraints.gridheight = 4;
    panel.add(bIdealWeight, constraints);
    
    JButton bBMR = new JButton("Basal Metabolic Rate");
    bBMR.setPreferredSize(new Dimension(158, 30));
    
    constraints.gridx = 10;
    constraints.gridy = 15;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(bBMR, constraints);

    // Checkbox
    
    JCheckBox bMasc = new JCheckBox("Masculino");
    bMasc.setPreferredSize(new Dimension(84, 16));
    bMasc.setSelected(false);
    constraints.gridx = 10;
    constraints.gridy = 6;
    constraints.gridwidth = 3;
    constraints.gridheight = 3;
    panel.add(bMasc, constraints);
    
    JCheckBox bFem = new JCheckBox("Femenino");
    bFem.setPreferredSize(new Dimension(84, 16));
    bFem.setSelected(false);
    constraints.gridx = 8;
    constraints.gridy = 6;
    constraints.gridwidth = 3;
    constraints.gridheight = 3;
    panel.add(bFem, constraints);

    // Labels
    
    JLabel lGenero = new JLabel("Género");
    constraints.gridx = 7;
    constraints.gridy = 6;
    constraints.gridwidth = 12;
    constraints.gridheight = 2;
    panel.add(lGenero, constraints);
    
    JLabel lEdad = new JLabel("Edad");
    constraints.gridx = 7;
    constraints.gridy = 8;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(lEdad, constraints);
    
    JLabel lAltura = new JLabel("Altura");
    constraints.gridx = 7;
    constraints.gridy = 10;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(lAltura, constraints);
    
    JLabel lPeso = new JLabel("Peso");
    constraints.gridx = 7;
    constraints.gridy = 12;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(lPeso, constraints);

    JLabel lKg = new JLabel("kg");
    constraints.gridx = 9;
    constraints.gridy = 18;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(lKg, constraints);
    
    JLabel lKcal = new JLabel("kcal/day");
    constraints.gridx = 14;
    constraints.gridy = 18;
    constraints.gridwidth = 2;
    constraints.gridheight = 2;
    panel.add(lKcal, constraints);

    // Texto

    JTextField tEdad = new JTextField(15);
    tEdad.setPreferredSize(new Dimension(131, 23));
    constraints.gridx = 8;
    constraints.gridy = 8;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(tEdad, constraints);
    
    JTextField tAltura = new JTextField(15);
    tAltura.setPreferredSize(new Dimension(131, 23));
    constraints.gridx = 8;
    constraints.gridy = 10;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(tAltura, constraints);
    
    JTextField tPeso = new JTextField(15);
    tPeso.setPreferredSize(new Dimension(131, 23));
    constraints.gridx = 8;
    constraints.gridy = 12;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(tPeso, constraints);
    
    JTextField tIdealWeight = new JTextField(15);
    tIdealWeight.setPreferredSize(new Dimension(131, 23));
    constraints.gridx = 5;
    constraints.gridy = 18;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(tIdealWeight, constraints);
    
    JTextField tBMR = new JTextField(15);
    tBMR.setPreferredSize(new Dimension(131, 23));
    constraints.gridx = 10;
    constraints.gridy = 18;
    constraints.gridwidth = 5;
    constraints.gridheight = 5;
    panel.add(tBMR, constraints);
    
    frame.add(panel);
    frame.setVisible(true);
  }

  // Registrar Controlador
  public void control(ActionListener act) {
    bIdealWeight.addActionListener(act);
    bIdealWeight.setActionCommand("getIdealWeight");

    bBMR.addActionListener(act);
    bBMR.setActionCommand("getBMR");

    bMasc.addActionListener(act);
    bMasc.setActionCommand("checkMasc");

    bFem.addActionListener(act);
    bFem.setActionCommand("checkFem");
  }

  // Obtener valores
  public JButton getCalcIdealWeight() {
		return bIdealWeight;
	}

  public JButton getCalcBMR() {
		return bBMR;
	}

  public JCheckBox getMascCheckBox() {
		return bMasc;
	}

  public JCheckBox getFemCheckBox() {
		return bFem;
	}

  public JTextField getEdad() {
		return tEdad;
	}

  public JTextField getAltura() {
		return tAltura;
	}

  public JTextField getPeso() {
		return tPeso;
	}

  public JTextField getIdealWeight() {
		return tIdealWeight;
	}

  public JTextField getBMR() {
		return tBMR;
	}	

  // Mostrar resultados
  public void setIdealWeight(float txt) {
    tIdealWeight.setText(String.valueOf(txt));
  }

  public void setBMR(float txt) {
    tBMR.setText(String.valueOf(txt));
  }

  // Errores
  public void inputsError(String error) {
    JOptionPane.showMessageDialog(frame, error);
  }

  public void noInputsError() {
    JOptionPane.showMessageDialog(frame, "Algunos campos están vacíos.");
  }
}
    