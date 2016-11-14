
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class ProgramPanel extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container con = getContentPane();
	JLabel minLabel = new JLabel("Enter minimum value:");
	JLabel maxLabel = new JLabel("Enter maximum Value:");
	JLabel limitLabel = new JLabel("How many numbers would you like to generate?");
	JLabel result = new JLabel();
	JLabel resultInfo = new JLabel();
	Font promptFont = new Font("Times", Font.BOLD, 14);
	Font resultFont = new Font("Times", Font.BOLD, 24);
	Font resultInfoFont = new Font("Times", Font.BOLD, 60);

	JTextField minValue = new JTextField(20);
	JTextField maxValue = new JTextField(20);
	JTextField limitValue = new JTextField(20);

	JButton generateNums = new JButton("Generate Random Numbers");
	JButton readNext = new JButton("Read Next Number");
	JButton readPrev = new JButton("Read Previous Number");
	JButton openList = new JButton("Open the List");

	int r = 0;
	int[] RESULT;

	public ProgramPanel() {

		super("Random Number Generator");
		setSize(500, 300);
		con.setLayout(new FlowLayout());
		minLabel.setFont(promptFont);
		maxLabel.setFont(promptFont);
		limitValue.setFont(promptFont);
		result.setFont(resultFont);
		resultInfo.setFont(resultInfoFont);

		con.add(minLabel);
		con.add(minValue);
		con.add(maxLabel);
		con.add(maxValue);
		con.add(limitLabel);
		con.add(limitValue);
		con.add(generateNums);
		con.add(readNext);
		con.add(readPrev);
		con.add(openList);
		con.add(result);
		con.add(resultInfo);

		// action listeners
		generateNums.addActionListener(this);
		readNext.addActionListener(this);
		readPrev.addActionListener(this);
		openList.addActionListener(this);

	}

	public static void display() {

		ProgramPanel demo = new ProgramPanel();
		demo.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		NumbersGenerator ng = new NumbersGenerator();

		if (source == generateNums) {
			String val1 = minValue.getText();
			int min = Integer.parseInt(val1);
			String val2 = maxValue.getText();
			int max = Integer.parseInt(val2);
			String val3 = limitValue.getText();
			int limit = Integer.parseInt(val3);

			try {
				ng.generate(limit, max, min);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			RESULT = ng.numbers;
			String res = new Integer(RESULT[r]).toString();
			result.setText("Your random number is: ");
			resultInfo.setText(res);

		}

		if (source == readNext) {
			r = r + 1;
			String res = new Integer(RESULT[r]).toString();
			resultInfo.setText(res);
		}

		if (source == readPrev) {
			r = r - 1;
			String res = new Integer(RESULT[r]).toString();
			resultInfo.setText(res);

		}

		if (source == openList) {
			Runtime rt = Runtime.getRuntime();
			String file = "C://Users/rafal.matuszczak/Documents/RandomNumbers.txt";

			try {
				Process p = rt.exec("notepad " + file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}