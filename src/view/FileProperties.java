package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class FileProperties extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAuthor;
	private JTextField txtTitle;
	private JTextField txtCreationDate;
	private JTextField txtLastSave;
	private JTextField txtFilepath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FileProperties dialog = new FileProperties(args[0],args[1],args[2],args[3],args[4]);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FileProperties(String author,String title,String creationDate,String lastSavedDate,String filepath) {
		setTitle("File Properties");
		setBounds(200, 200, 366, 231);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		txtAuthor = new JTextField();
		txtAuthor.setEditable(false);
		txtAuthor.setBorder(null);
		txtAuthor.setBackground(UIManager.getColor("inactiveCaption"));
		txtAuthor.setColumns(10);
		txtAuthor.setText(author);

		txtTitle = new JTextField();
		txtTitle.setEditable(false);
		txtTitle.setBorder(null);
		txtTitle.setBackground(UIManager.getColor("inactiveCaption"));
		txtTitle.setColumns(10);
		txtTitle.setText(title);
		
		txtCreationDate = new JTextField();
		txtCreationDate.setEditable(false);
		txtCreationDate.setBorder(null);
		txtCreationDate.setBackground(UIManager.getColor("inactiveCaption"));
		txtCreationDate.setColumns(10);
		txtCreationDate.setText(creationDate);
		
		txtLastSave = new JTextField();
		txtLastSave.setEditable(false);
		txtLastSave.setBorder(null);
		txtLastSave.setBackground(UIManager.getColor("inactiveCaption"));
		txtLastSave.setColumns(10);
		txtLastSave.setText(lastSavedDate);
		
		txtFilepath = new JTextField();
		txtFilepath.setEditable(false);
		txtFilepath.setBorder(null);
		txtFilepath.setBackground(UIManager.getColor("inactiveCaption"));
		txtFilepath.setColumns(10);
		txtFilepath.setText(filepath);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtAuthor, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(txtTitle)
						.addComponent(txtCreationDate)
						.addComponent(txtLastSave)
						.addComponent(txtFilepath, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtCreationDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtLastSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtFilepath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
