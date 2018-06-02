import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StringToolErase {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("String Tool");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minimumSize = new Dimension(500, 500);
		frame.setMinimumSize(minimumSize);
		frame.setLocationRelativeTo(null);
		Container contentPane = frame.getContentPane();
		GroupLayout gl = new GroupLayout(contentPane);
		contentPane.setLayout(gl);
		gl.setAutoCreateContainerGaps(true);

		JLabel label = new JLabel("Input");

		JTextArea inputTextArea = new JTextArea();
		// inputTextArea.setTabSize(1);
		JScrollPane scrollInputArea = new JScrollPane(inputTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JTextArea outputTextArea = new JTextArea();
		JScrollPane scrollOutputArea = new JScrollPane(outputTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		outputTextArea.setEditable(false);
		JButton executeButton = new JButton("Action");
		executeButton.addActionListener(new OnClickActionListener(inputTextArea, outputTextArea));
		gl.setHorizontalGroup(gl.createParallelGroup().addComponent(label).addComponent(scrollInputArea)
				.addComponent(executeButton).addComponent(scrollOutputArea));
		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(label).addGap(10).addComponent(scrollInputArea)
				.addGap(10).addComponent(executeButton).addGap(10).addComponent(scrollOutputArea));

		frame.pack();
		frame.setVisible(true);
	}

}

class OnClickActionListener implements ActionListener {
	private JTextArea inputTextArea;
	private JTextArea outputTextArea;

	public OnClickActionListener(JTextArea inputTextArea, JTextArea outputTextArea) {
		this.inputTextArea = inputTextArea;
		this.outputTextArea = outputTextArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputText = inputTextArea.getText();
		
		outputTextArea.setText(inputText);
		
	}

}
