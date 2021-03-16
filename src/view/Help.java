package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Help extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Help dialog = new Help();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Help() {
		setResizable(false);
		setTitle("Help");
		setBounds(200, 130, 781, 645);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBorder(null);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea txtrHelpStep = new JTextArea();
		
		txtrHelpStep.setBorder(null);
		txtrHelpStep.setTabSize(4);
		txtrHelpStep.setEditable(false);
		txtrHelpStep.setBackground(contentPanel.getBackground());
		txtrHelpStep.setText("\t\t\r\nStep 1 Choose File\r\n\t1. Create a file and give the author and the title (select File -> New or Control+N).\r\n\t2. Open an existing file from your local directory (select File -> Open or Control+O).\r\n\t3. Save the text you have already create or open (select File -> Save or Control+S).\r\n\t\r\nStep 2 Write to File\r\n\tIn the text box, enter the word or phrase(s) you want to translate.\r\n\t\r\nStep 3 Convert to Speech \r\n\tChoose what operation you want to do.\r\n\t\t1. Convert the Document into speech (select Play -> Document).\r\n\t\t2. Convert the reverse Document into speech (select Play -> ReverseDocument).\r\n\t\t3. Convert the encoded Document into speech\r\n\t\t\t3.1 with AtBash(select Play -> EncodeDocument -> AtBash).\r\n\t\t\t3.2 with Rot13(select Play -> EncodeDocument -> Rot13).\r\n\t\t4. Convert the highlighted area text you choose into speech (select Play -> Line).\r\n\t\t5. Convert the highlighted area text you choose into speech in reverse order (select Play -> ReverseLine).\r\n\t\t6. Convert the encoded highlighted area text into speech \r\n\t\t\t6.1 with AtBash (select Play -> EncodeLine -> AtBash).\r\n\t\t\t6.2 with Rot13 (select Play -> EncodeLine -> Rot13).\r\n\t\t\r\nStep 3 Extra \r\n\tChoose your preferred volume,rate,pitch,range.\r\n\tView the properties of the current open document (select File -> Properties)\r\n\t\r\nReplay steps\r\n\tYou can repeat your preferred steps many times using Replay menu:\r\n\t\tPress Start to start logging your steps.\r\n\t\tPress Stop to stop logging your steps.\r\n\t\tPress Clear to reset the application's steps memory.\r\n\t\tPress Replay to repeat all the logged steps.\r\n\t\t\r\n\tWarning: You must press Start before any action you want to repeat.");		
		scrollPane.setViewportView(txtrHelpStep);

		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
