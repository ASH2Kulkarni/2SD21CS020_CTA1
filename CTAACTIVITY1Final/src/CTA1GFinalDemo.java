
import java.awt.*; //imports awt abstract window toolkit 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // to inform what action to perform
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// class frame uses Jframe

class Frame extends JFrame implements ActionListener {
	Container c;

	JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField t1, t2, t3, t4, t5;
	JButton b;

	public Frame(String title) {
		super(title);
		c = this.getContentPane();
		c.setLayout(null);
		// TODO Auto-generated constructor stub

		// labels of frame taken with corresponding names
		l1 = new JLabel("GRADE CALCULATOR");
		l2 = new JLabel("ENTER IA1 MARKS:");
		l3 = new JLabel("ENTER IA2 MARKS:");
		l4 = new JLabel("ENTER IA3 MARKS:");
		l5 = new JLabel("ENTER CTA MARKS:");
		l6 = new JLabel("ENTER SEE MARKS:");
		l7 = new JLabel(); // prints total marks of a sub
		l8 = new JLabel(); // print grades
		l9 = new JLabel();

		// label bounds
		l1.setBounds(85, 50, 500, 20);
		l2.setBounds(10, 100, 500, 20);
		l3.setBounds(10, 120, 500, 20);
		l4.setBounds(10, 140, 500, 20);
		l5.setBounds(10, 160, 500, 20);
		l6.setBounds(10, 180, 500, 20);
		l7.setBounds(20, 225, 500, 20);
		l8.setBounds(180, 225, 100, 20);
		l9.setBounds(50, 250, 1000, 20);

		// add labels to container
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(l7);
		c.add(l8);
		c.add(l9);

		// textfields
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();

		// set textfield size

		t1.setBounds(127, 100, 135, 20);
		t2.setBounds(127, 120, 135, 20);
		t3.setBounds(127, 140, 135, 20);
		t4.setBounds(128, 160, 135, 20);
		t5.setBounds(129, 180, 135, 20);

		// add titles to container
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(t5);

		// add button and add to container
		JButton b = new JButton("CALCULATE");
		b.setBounds(90, 205, 105, 20);
		c.add(b);
		b.addActionListener(this);
	}

	// calculate total marks

	double total() {
		double t = 0;
		double cie = 0;

		// take all values entered as text and convert it to numbers
		double ia1 = Double.parseDouble(t1.getText());
		double ia2 = Double.parseDouble(t2.getText());
		double ia3 = Double.parseDouble(t3.getText());
		double cta = Double.parseDouble(t4.getText());
		double see = Double.parseDouble(t5.getText());

		if (ia1 < 0 || ia1 > 20)

			l9.setText("Enter ia1 marks in range 0-20");
		if (ia2 < 0 || ia2 > 20)
			l9.setText("Enter ia2 marks in range 0-20");
		if (ia3 < 0 || ia3 > 20)

			l9.setText("Enter ia3 marks in range 0-20");

		if (cta > 10)
			l9.setText("Enter CTA marks in range 0-10");

		if (see > 100)
			l9.setText("Enter SEE marks in range 0-10");

		if (see % 2 != 0)
			see = see + 1;
		else
			see = see;

		if (ia1 <= ia2 && ia1 <= ia3) {
			cie = (ia3 + ia2 + cta);

		} else if (ia2 <= ia1 && ia2 <= ia3) {
			cie = (ia1 + ia3 + cta);

		} else {
			cie = (ia1 + ia2 + cta);

		}
		t = cie + (see / 2);
		if (cie < 20)
			l9.setText("STUDENT DETAINED from SEE ");

		return t;

	}

	// check grade
	String Grade() {
		double see = Double.parseDouble(t5.getText());
		double t = total();
		double cie = t - (see / 2);
		if (cie < 20)
			return "";
		if (see < 38)
			return "F";
		else {
			if (t >= 90 && t <= 100)
				return ("S");
			else if (t >= 80 && t <= 89)
				return ("A");
			else if (t >= 70 && t <= 79)
				return ("B");
			else if (t >= 60 && t <= 69)
				return ("C");
			else if (t >= 50 && t <= 59)
				return ("D");
			else if (t >= 40 && t <= 49)
				return ("E");
			else if (t >= 0 && t <= 39)
				return ("F");

		}
		return null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		l7.setText("TOTAL MARKS:" + total());

		l8.setText("GRADE:" + Grade());

	}

}

public class CTA1GFinalDemo {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		JFrame f = new Frame("Students Grading System");
		// mention the title of window
		System.out.println("If the student is absent please neter marks as 0");

		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // it should stop when cancelled
		f.setSize(365, 365);
		f.setVisible(true); // to make it visible

	}

}
