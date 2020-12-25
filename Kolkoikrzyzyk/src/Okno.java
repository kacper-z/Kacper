import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultEditorKit.BeepAction;

public class Okno extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton przycisk;
	public JButton przycisk2;
	public JButton przycisk3;
	public JButton przycisk4;
	public JButton przycisk5;
	public JButton przycisk6;
	public JButton przycisk7;
	public JButton przycisk8;
	public JButton przycisk9;
	int i=1;
	public Okno() {
		// Title, size and position
		setTitle("Kó³ko i Krzy¿yk");
		GridLayout layout=new GridLayout(3,3);
		setLayout(layout);
		setSize(300,300);
		setLocation(500,300);
		
		//Font
		Font font = new Font("Arial", Font.BOLD, 50);
		//Buttons
		przycisk=new JButton("");
		przycisk.setFont(font);
		przycisk2=new JButton("");
		przycisk2.setFont(font);
		przycisk3=new JButton("");
		przycisk3.setFont(font);
		przycisk4=new JButton("");
		przycisk4.setFont(font);
		przycisk5=new JButton("");
		przycisk5.setFont(font);
		przycisk6=new JButton("");
		przycisk6.setFont(font);
		przycisk7=new JButton("");
		przycisk7.setFont(font);
		przycisk8=new JButton("");
		przycisk8.setFont(font);
		przycisk9=new JButton("");
		przycisk9.setFont(font);
		add(przycisk);
		add(przycisk2);
		add(przycisk3);
		add(przycisk4);
		add(przycisk5);
		add(przycisk6);
		add(przycisk7);
		add(przycisk8);
		add(przycisk9);
		przycisk.addActionListener(this::actionPerformed);
		przycisk2.addActionListener(this::actionPerformed);
		przycisk3.addActionListener(this::actionPerformed);
		przycisk4.addActionListener(this::actionPerformed);
		przycisk5.addActionListener(this::actionPerformed);
		przycisk6.addActionListener(this::actionPerformed);
		przycisk7.addActionListener(this::actionPerformed);
		przycisk8.addActionListener(this::actionPerformed);
		przycisk9.addActionListener(this::actionPerformed);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo=e.getSource(); // 
		/**
		 * !! Circle always starts the game !!
		 * Conditons checking the current moment of the game  (number of move)
		 * 
		 *  comparison of objects
		 *  |      |       |
		 *  V      V       V
		 */
		if (zrodlo==przycisk && i%2!=0) { //the remainder of the division checks whether it is an even move or not
			przycisk.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk && i%2==0) {
			przycisk.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk2 && i%2!=0) {
			przycisk2.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk2 && i%2==0) {
			przycisk2.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk3 && i%2!=0) {
			przycisk3.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk3 && i%2==0) {
			przycisk3.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk4 && i%2!=0) {
			przycisk4.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk4 && i%2==0) {
			przycisk4.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk5 && i%2!=0) {
			przycisk5.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk5 && i%2==0) {
			przycisk5.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk6 && i%2!=0) {
			przycisk6.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk6 && i%2==0) {
			przycisk6.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk7 && i%2!=0) {
			przycisk7.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk7 && i%2==0) {
			przycisk7.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk8 && i%2!=0) {
			przycisk8.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk8 && i%2==0) {
			przycisk8.setText("X");
			i+=1;
		}
		if (zrodlo==przycisk9 && i%2!=0) {
			przycisk9.setText("O");
			i+=1;
		}
		else if (zrodlo==przycisk9 && i%2==0) {
			przycisk9.setText("X");
			i+=1;
		}
		/* conditions for checking that all three fields are in the correct position
		 *  and they are not empty fields.
		 */
		
		if (przycisk.getText().equals(przycisk2.getText()) && przycisk2.getText().equals(przycisk3.getText()) && przycisk2.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk.getText());	
		}
		if (przycisk4.getText().equals(przycisk5.getText()) && przycisk5.getText().equals(przycisk6.getText()) && przycisk4.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk4.getText());			
		}
		if (przycisk7.getText().equals(przycisk8.getText()) && przycisk8.getText().equals(przycisk9.getText()) && przycisk9.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk7.getText());			
		}
		if (przycisk.getText().equals(przycisk4.getText()) && przycisk4.getText().equals(przycisk7.getText()) && przycisk.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk7.getText());			
		}
		if (przycisk2.getText().equals(przycisk5.getText()) && przycisk5.getText().equals(przycisk8.getText()) && przycisk8.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk8.getText());			
		}
		if (przycisk3.getText().equals(przycisk6.getText()) && przycisk6.getText().equals(przycisk9.getText()) && przycisk9.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk9.getText());			
		}
		if (przycisk.getText().equals(przycisk5.getText()) && przycisk5.getText().equals(przycisk9.getText()) && przycisk5.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk9.getText());			
		}
		if (przycisk3.getText().equals(przycisk5.getText()) && przycisk5.getText().equals(przycisk7.getText()) && przycisk3.getText()!="") {
			JOptionPane.showMessageDialog(null, "Koniec gry - wygra³ "+przycisk7.getText());			
		}
		if (i>9) {
			JOptionPane.showMessageDialog(null, "Remis");			
		}
	}
}

