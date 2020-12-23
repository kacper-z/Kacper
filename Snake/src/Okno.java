

import javax.swing.JFrame;

public class Okno extends JFrame {
	
	public Okno () {

		add(new Panel()); //dodanie panelu do okna 
		setTitle("Snake"); //tytu³ okna  // zamykanie okna 
		setResizable(false); //wy³¹czanie mo¿liwoœci powiêkszania okna 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); //dostosowywanie rozmiaru do komponentów w œrodku
		setVisible(true); //widocznosc okna
		setLocationRelativeTo(null); // okno na œrodku pulpitu

	}

}
