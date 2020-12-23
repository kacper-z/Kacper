

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Runner extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Gra gra=new Gra();
	ArrayList<String> lista = gra.alfabet();
	private JButton przycisk;
	private JTextField textField;
	int licznik=0;
	public Runner(){
		//Font
		Font font1 = new Font("Tahoma", Font.BOLD, 30);
		Font font2 = new Font("Arial", Font.BOLD, 50);
		//Title ~ window layout
		setTitle("PanstwaMiasta");
		GridLayout layout=new GridLayout(1,2);
		setLayout(layout);
		// Button and textbox 
		przycisk=new JButton("Kliknij aby wylosowaæ");
		przycisk.setFont(font1);
		add(przycisk);
		przycisk.addActionListener(this::actionPerformed);
		
		textField=new JTextField();
		textField.setFont(font2);
		add(textField);
		
		//sort the list randomly
		Collections.shuffle(lista);
		
		
					
		pack();
	}
	public static void main(String[] args) {
		Runner mojaramka = new Runner();
		mojaramka.setVisible(true);
		
		// Position of the window		
		mojaramka.setLocationRelativeTo(null); 
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object zrodlo=e.getSource();
	if (zrodlo==przycisk && licznik<=21) {
			textField.setText(lista.get(licznik));
			licznik+=1;
		}
	else  {
		JOptionPane.showMessageDialog(null, "Litery zosta³y wykorzystane");
	}
  }		
}


 

	

