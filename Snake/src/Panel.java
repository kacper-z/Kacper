import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	static final int SZEROKOSC_OKNA=600,WYSOKOSC_OKNA=600,PIXEL=25,POLE_GRY=(SZEROKOSC_OKNA*WYSOKOSC_OKNA)/PIXEL,ODSWIEZANIE=75;
	final int x[]=new int[POLE_GRY];
	final int y[]=new int[POLE_GRY];
	
	int cialonapoczatku=5; //rozmiar wê¿a na starcie
	int jablkazjedzone; 
	//koordynaty jab³ka
	int jablkoX;
	int jablkoY;
	/**
	 * KIERUNEK WÊ¯A
	 * P - prawo
	 * L - lewo 
	 * G - góra
	 * D - dó³
	 *    PO PRZYTRRZYMANIU KTÓREGOŒ Z WYMIENIONYCH GUZIKÓW W¥¯ PRZYSPIESZA 
	 */
	char kierunek='P';
	boolean czyidzie=false;
	Timer timer;
	Random random;
	//Kontynuacja gry -- przycisk
	public JButton grajdalej=new JButton("Graj dalej");	
	public JButton koniec=new JButton("Koniec");		
	public Panel() {
		random=new Random();
		setPreferredSize(new Dimension(SZEROKOSC_OKNA,WYSOKOSC_OKNA));
		setBackground(Color.black); // kolor t³a
		setFocusable(true); //zezwalanie na wysy³anie zdarzeñ (sterowanie)
		addKeyListener(new Obslugaruchu()); // dodanie sterowania -- klasa na samym dole 
		startgry(); //START
		//przyciski po skoñczeniu gry	
		add(grajdalej);
		add(koniec);
		grajdalej.setVisible(false);
		koniec.setVisible(false);
		

		
		

	}
	
	public void startgry(){
		tworzeniejablka();
		czyidzie=true;
		timer=new Timer(ODSWIEZANIE,this);
		timer.start();
	}
	
	public void paintComponent(Graphics grafika) {
		super.paintComponent(grafika);
		siatka(grafika);
		
		
		
	}
	public void siatka(Graphics grafika) {
		if (czyidzie) {
			
		grafika.setColor(Color.red); //kolor jab³ka 
		grafika.fillRect(jablkoX, jablkoY, PIXEL, PIXEL); // wype³nienie pixela -- jab³ka 
		
		// tworzenie wê¿a 
		
		for(int i=0;i<cialonapoczatku;i++) {
			if (i==0) { //g³owa wê¿a 
				grafika.setColor(Color.white);
				grafika.fillRect(x[i], y[i], PIXEL, PIXEL);
			}
			else if (i%2==0){ // parzyste pixele wê¿a s¹ zielone 
				grafika.setColor(Color.green);
				grafika.fillRect(x[i], y[i], PIXEL, PIXEL);
			}
			else { //nieparzyste --  szare 
				grafika.setColor(Color.darkGray);
				grafika.fillRect(x[i], y[i], PIXEL, PIXEL);
			}
		}
		
		// wynik wyœwietlany u góry ekranu 
		
		grafika.setColor(Color.red);
		grafika.setFont( new Font("Tahoma",Font.BOLD, 30));
		FontMetrics tekst = getFontMetrics(grafika.getFont());
		grafika.drawString("Wynik: "+jablkazjedzone, (WYSOKOSC_OKNA - tekst.stringWidth("Wynik: "+jablkazjedzone))/2, grafika.getFont().getSize());
	}
		else {			
			// przycisk obs³uguj¹cy ponowne w³¹czenie gry			
			grajdalej.setVisible(true);
			grajdalej.addActionListener(this::actionPerformed);
			koniec.setVisible(true);
			koniec.addActionListener(this::actionPerformed);
			
		}
}
	public void tworzeniejablka() {
		//losowanie pozycji jab³ka 
		
		jablkoX=random.nextInt(SZEROKOSC_OKNA/PIXEL)*PIXEL;
		jablkoY=random.nextInt(WYSOKOSC_OKNA/PIXEL)*PIXEL;

	}
	
	public void ruch() {
		for (int i=cialonapoczatku;i>0;i--) {
			// ruch wê¿a 
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		// zmiana kierunku poruszania siê wê¿a 
		switch(kierunek) {
		case 'P':
			x[0]=x[0]+PIXEL;
			break;
		case 'L':
			x[0]=x[0]-PIXEL;	
			break;
		case 'G':
			y[0]=y[0]-PIXEL;
			break;
		case 'D':
			y[0]=y[0]+PIXEL;
			break;
		}
	}
	
	
	
	public void sprawdzaniejablka() {
		for (int i=cialonapoczatku;i>0;i--) { // iteracja po wê¿u 
		if (x[i]==jablkoX&& y[i]==jablkoY) { // je¿eli pixel nale¿¹cy do cia³a wê¿a bêdzie na tym samym miejscu co jab³ko uzyskuje siê punkt 
			cialonapoczatku+=1;
			jablkazjedzone+=1;
			tworzeniejablka();
		}
		}
		
	}
	public void kolizja(){
		//Je¿eli w¹¿ dotknie swoje cia³o gra siê koñczy 
		
		for(int i=cialonapoczatku;i>0;i--) { //iteracja po wê¿u i sprawdzanie jego pozycji
			if (x[0]==x[i] && y[0]==y[i]) { // je¿eli istniej¹ dwie takie same pozycje dla jednego pixela w¹¿ musi dotykaæ samego siebie
				czyidzie=false;
				JOptionPane.showMessageDialog(null, "Koniec gry");
			}
			
			//warunki odpowiadaj¹ce za pojawianie siê wê¿a po przeciwleglej stronie okna 
			
			//lewo
			if (x[0]<0) {
				x[0]=x[0]+PIXEL*25;
				
			}
			//prawo
			if (x[0]>SZEROKOSC_OKNA) {
				x[0]=x[0]-PIXEL*25;
			}
			//góra
			if (y[0]<0) {
				y[0]=y[0]+PIXEL*25;
				
			}
			//dó³
			if (y[0]>WYSOKOSC_OKNA) {
				y[0]=y[0]-PIXEL*25;
			}
			
		}
		
	}
	


	public void actionPerformed(ActionEvent e) {
		if (czyidzie) {
			ruch();
			sprawdzaniejablka();
			kolizja();
			repaint();	
		}
		else {
			//akcja guzika przypisana do obiektu o nazwie zrodlo a nastêpnie porównywany do guzika  
			Object zrodlo=e.getSource(); //przechwytywanie guzika
				if (zrodlo==grajdalej) {
				    new Okno();	//nowa gra
											
				}
				if (zrodlo==koniec) {
					System.exit(1); //koniec gry
				}
			}
		
	}
	public class Obslugaruchu extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			// zmiana kierunku poruszania siê w zale¿noœci od wciœniêtego guzika
			//!!!!! Nie mo¿na zmienic kierunku na przeciwleg³y. Koñczy³o by sie to koñcem gry poniewa¿ w¹¿ dotknie samego siebie !!!!1
			case KeyEvent.VK_D:
				if (kierunek!='L') {
				kierunek='P';
				ruch();
				}
				break;
			case KeyEvent.VK_A:
				if (kierunek!='P') {
				kierunek='L';
				ruch();
				}
				break;
			case KeyEvent.VK_W:
				if (kierunek!='D') {
				kierunek='G';
				ruch();
				}
				break;
			case KeyEvent.VK_S:
				if (kierunek!='G') {
				kierunek='D';
				ruch();
				}
				break;
			}
		
		}					
		}
	}


