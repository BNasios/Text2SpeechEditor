package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import commands.Invoker;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;

public class GUI {

	private JFrame frmMyAwesomeGui;
	private JMenuItem mntmOpen;
	private JTextArea txtrT;
	private JMenuItem mntmNew;
	private JMenuItem mntmSave;
	private JMenuItem mntmDocument;
	private JMenuItem mntmReversedDocument;
	private JMenuItem mntmLine;
	private JMenuItem mntmReversedLine;
	private JMenuItem mntmAtbash;
	private JMenuItem mntmRot;
	private JMenuItem mntmAtbash_1;
	private JMenuItem mntmRot_1;
	private JMenuItem mntmReplay;
	private JSlider  sliderVolume;
	private JSpinner spinnerVolume;
	private JSlider  sliderRate;
	private JSpinner spinnerRate;
	private JSlider  sliderPitch;
	private JSpinner spinnerPitch;
	private JSlider  sliderRange;
	private JSpinner spinnerRange;
	private JMenuItem mntmAbout;
	private JMenuItem mntmHelpContents;
	private JMenuItem mntmProperties;
	private JMenu mnReplayOptions;
	private JMenuItem mntmStart;
	private JMenuItem mntmClear;
	private JMenuItem mntmStop;
	
	private String filepath;
	private String author;
	private String title;
	private String creationDate;  
	private String lastSavedDate;
	private ArrayList<String> replay = new ArrayList<String>(); 
	
	// checking flags:
	private int documentFlag = 0;
	private int saveFlag = 0;
	private int createFlag = 0;
	private int replayFlag = 0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				
				try {
					GUI window = new GUI();
					window.frmMyAwesomeGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyAwesomeGui = new JFrame();
		frmMyAwesomeGui.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/view/logo1.jpg")));
		frmMyAwesomeGui.setTitle("Text2Speech");
		frmMyAwesomeGui.setBounds(100, 100, 728, 592);
		frmMyAwesomeGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyAwesomeGui.setMinimumSize(frmMyAwesomeGui.getSize());
		frmMyAwesomeGui.setMaximumSize(new Dimension(850,700));
		frmMyAwesomeGui.setResizable(false);
		
		JLabel label = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/view/50-Beautiful-and-Minimalist-Presentation-Backgrounds-031.jpg"))));
		frmMyAwesomeGui.setContentPane(label);
				
		JScrollPane scrollPane = new JScrollPane();
		
		sliderVolume = new JSlider();
		sliderVolume.setOpaque(false);
		sliderVolume.setMinorTickSpacing(1);
		sliderVolume.setPaintLabels(true);
		sliderVolume.setPaintTicks(true);
		sliderVolume.setMajorTickSpacing(2);
		sliderVolume.setMaximum(10);
		
		SpinnerModel sm = new SpinnerNumberModel(10, 0, 10, 1);
		spinnerVolume = new JSpinner(sm);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) spinnerVolume.getEditor()).getTextField();
	    tf.setEditable(false);
	    tf.setBackground(Color.white);
				
		JLabel lblVolume = DefaultComponentFactory.getInstance().createLabel("Volume");
		
		sliderRate = new JSlider();
		sliderRate.setOpaque(false);
		sliderRate.setMinorTickSpacing(50);
		sliderRate.setPaintTicks(true);
		sliderRate.setPaintLabels(true);
		sliderRate.setMajorTickSpacing(100);
		sliderRate.setMaximum(500);
		sliderRate.setValue(150);
		
		
		SpinnerModel sm1 = new SpinnerNumberModel(150,0,500,1);
		spinnerRate = new JSpinner(sm1);
		JFormattedTextField tf2 = ((JSpinner.DefaultEditor) spinnerRate.getEditor()).getTextField();
	    tf2.setEditable(false);
	    tf2.setBackground(Color.white);
			
		
		JLabel lblRate = DefaultComponentFactory.getInstance().createLabel("Rate");
		
		sliderRange = new JSlider();
		sliderRange.setOpaque(false);
		sliderRange.setMinorTickSpacing(5);
		sliderRange.setPaintTicks(true);
		sliderRange.setPaintLabels(true);
		sliderRange.setMajorTickSpacing(10);
		sliderRange.setMaximum(50);
		sliderRange.setValue(11);
		
		SpinnerModel sm2 = new SpinnerNumberModel(11,0,50,1);
		spinnerRange = new JSpinner(sm2);
		JFormattedTextField tf3 = ((JSpinner.DefaultEditor) spinnerRange.getEditor()).getTextField();
	    tf3.setEditable(false);
	    tf3.setBackground(Color.white);
		
		JLabel lblRange = DefaultComponentFactory.getInstance().createLabel("Range");
		
		sliderPitch = new JSlider();
		sliderPitch.setOpaque(false);
		sliderPitch.setMinorTickSpacing(50);
		sliderPitch.setPaintTicks(true);
		sliderPitch.setPaintLabels(true);
		sliderPitch.setMajorTickSpacing(100);
		sliderPitch.setMaximum(600);
		sliderPitch.setValue(100);
		
		SpinnerModel sm3 = new SpinnerNumberModel(100,0,600,1);
		spinnerPitch = new JSpinner(sm3);
		JFormattedTextField tf4 = ((JSpinner.DefaultEditor) spinnerPitch.getEditor()).getTextField();
	    tf4.setEditable(false);
	    tf4.setBackground(Color.white);
		
		JLabel lblPitchhz = DefaultComponentFactory.getInstance().createLabel("Pitch (Hz)");
		GroupLayout groupLayout = new GroupLayout(frmMyAwesomeGui.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sliderVolume, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(spinnerVolume, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(sliderRate, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinnerRate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(104))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(lblVolume, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
					.addComponent(lblRate, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(253))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(sliderRange, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(spinnerRange, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(sliderPitch, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinnerPitch, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(95))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(lblRange)
					.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
					.addComponent(lblPitchhz)
					.addGap(236))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVolume)
						.addComponent(lblRate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sliderVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerVolume, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(sliderRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerRate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRange)
						.addComponent(lblPitchhz))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sliderRange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerRange, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(sliderPitch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerPitch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		
		txtrT = new JTextArea();
		txtrT.setTabSize(4);
		txtrT.setBackground(UIManager.getColor("inactiveCaption"));
		txtrT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(txtrT);
		frmMyAwesomeGui.getContentPane().setLayout(groupLayout);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmMyAwesomeGui.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmProperties = new JMenuItem("Properties");
		mnFile.add(mntmProperties);
		
		JMenu mnPlay = new JMenu("Play");
		menuBar.add(mnPlay);
		
		mntmDocument = new JMenuItem("Document");
		mnPlay.add(mntmDocument);
		
		mntmReversedDocument = new JMenuItem("Reversed Document");
		mnPlay.add(mntmReversedDocument);
		
		JMenu mnEncodedDocument = new JMenu("Encoded Document");
		mnPlay.add(mnEncodedDocument);
		
		mntmAtbash = new JMenuItem("AtBash");
		mnEncodedDocument.add(mntmAtbash);
		
		mntmRot = new JMenuItem("Rot13");
		mnEncodedDocument.add(mntmRot);
		
		mntmLine = new JMenuItem("Line");
		mnPlay.add(mntmLine);
		
		mntmReversedLine = new JMenuItem("Reversed Line");
		mnPlay.add(mntmReversedLine);
		
		JMenu mnEncodedLine = new JMenu("Encoded Line");
		mnPlay.add(mnEncodedLine);
		
		mntmAtbash_1 = new JMenuItem("AtBash");
		mnEncodedLine.add(mntmAtbash_1);
		
		mntmRot_1 = new JMenuItem("Rot13");
		mnEncodedLine.add(mntmRot_1);
		
		mnReplayOptions = new JMenu("Replay");
		menuBar.add(mnReplayOptions);
		
		mntmStart = new JMenuItem("Start");
		mnReplayOptions.add(mntmStart);
		
		mntmStop = new JMenuItem("Stop");
		mnReplayOptions.add(mntmStop);
		
		mntmClear = new JMenuItem("Clear");
		mnReplayOptions.add(mntmClear);
		
		mntmReplay = new JMenuItem("Replay");
		mnReplayOptions.add(mntmReplay);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmHelpContents = new JMenuItem("Help Contents");
		mnHelp.add(mntmHelpContents);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}
	
	
	/**
	 * Contains all the code for creating events.
	 */
	private void createEvents() {
		/*
		 * 	Menu Item Open
		 */
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Object[] ob = new Object[2];
        		
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		            filepath = fc.getSelectedFile().getAbsolutePath();
		            File file = new File(filepath);
		    		Scanner sc = null;
		    		try {
		    			sc = new Scanner(file);
		    		} catch (IOException e1) {
		    			e1.printStackTrace();
		    		}
		    		
		    		author = sc.nextLine();
		    		title = sc.nextLine();
		    		creationDate = sc.nextLine();
		    		lastSavedDate = sc.nextLine();		            
		            
		            ob[0] = filepath;
	        		ob[1] = txtrT;
	        		
	        		if(replayFlag == 1) {
	        			String s = "Open" + "#" + filepath ;
	        			replay.add(s);
	        		}
	        		
	        		txtrT.setText("");
					Invoker inv = new Invoker(ob);
					inv.performedAction("Open");
					
					/*
					 *  If user open or create a document enable flags below that used to prevent illegal actions
					 */
					documentFlag = 1;
					createFlag = 1;
					saveFlag = 1;
	            }
			}
		});
		
		/*
		 * 	Menu Item New
		 */
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String inputAuthor = JOptionPane.showInputDialog("Enter Author:","Author");
				
				if(inputAuthor == null) {
					return;
				}
				
				if(inputAuthor.isEmpty()){
					JOptionPane.showMessageDialog(null, "Press Ok Button after you input Author");
					return;
				}
				

				if(inputAuthor != null && !inputAuthor.isEmpty()) {	
		    		LocalDate date = LocalDate.now(); 
					LocalTime time = LocalTime.now();
					String strTime = time.toString();
					creationDate  = "creation date:   " + date.toString() + " " + strTime.substring(0, 8);
					lastSavedDate = "last saved date: -";
		    		
		    		JFileChooser fc = new JFileChooser();
		    		if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		            	filepath = fc.getSelectedFile().getAbsolutePath();  	
		    		}
		    		if (filepath!=null) {	
		    		
			    		String[] tokens = filepath.split("/");
			    		
			    		author = "author: "+inputAuthor;
			    		title  = "title:  "+tokens[tokens.length -1 ];
			    					    		
			    		Object[] ob = new Object[5];
			    		ob[0] = filepath;
		        		ob[1] = author;
		        		ob[2] = title;
		        		ob[3] = creationDate;
		        		ob[4] = lastSavedDate;
			    		
		        		if(replayFlag == 1) {
		        			String s = "Create" + "#" + filepath + "#" + author + "#" + title;
		        			replay.add(s);
		        		}
		        		
		        		txtrT.setText("");
			    		Invoker inv = new Invoker(ob);
						inv.performedAction("Create");
					
					}
				}
				
				createFlag   = 1;
				documentFlag = 1;
				saveFlag = 1;
			}
		});
		
		/*
		 * 	Menu Item Save
		 */
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(createFlag == 0 || documentFlag == 0) {
					JOptionPane.showMessageDialog(null, "To Save, open or create a document\n");
					return;
				}
				
				LocalDate date = LocalDate.now(); 
				LocalTime time = LocalTime.now();
				String strTime = time.toString();
				lastSavedDate = "last saved date: " + date.toString() + " " + strTime.substring(0, 8);
				
				Object[] ob = new Object[6];
				ob[0] = filepath;
        		ob[1] = txtrT;
        		ob[2] = author;
        		ob[3] = title;
        		ob[4] = creationDate;
        		ob[5] = lastSavedDate;
        		
        		if(replayFlag == 1) {
        			String s = "Save" + "#" + filepath + "#" + author + "#" + title + "#" + creationDate;
        			replay.add(s);
        			replay.add(txtrT.getText());
        		}
        		
        		Invoker inv = new Invoker(ob);
				inv.performedAction("Save");
				
				saveFlag = 1;
			}
		});
		
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		/*
		 * 	Menu Item Play Document
		 */
		mntmDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(documentFlag == 0) {
					JOptionPane.showMessageDialog(null, "To transform a document to audio:\n   Open a document or\n   Make a new one\n ");
					return;
				}
				
				if(txtrT.getText().length() == 0) {
					return;
				}
								
				if(saveFlag == 0) {
					JOptionPane.showMessageDialog(null, "Press Save and after Play\n ");
					return;
				}
				
				Object[] ob = new Object[6];
				ob[0] = filepath;
				ob[1] = String.valueOf(sliderVolume.getValue());   // volume from 0.0 to 1.0  must be float 
				ob[2] = String.valueOf(sliderRate.getValue()); 	   // rate   from 0.0 to 500  default = 150.0
				ob[3] = String.valueOf(sliderPitch.getValue());    // pitch  from 0.0 to 600  default = 100.0
				ob[4] = String.valueOf(sliderRange.getValue());    // range  from 0.0 to 50   default = 11.0					
				ob[5] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayDocument" + "#" + filepath + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue())+"#action";
        			replay.add(s);
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayDocument");
			}
		});
		
		/*
		 * 	Menu Item Reversed Document
		 */
		mntmReversedDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(documentFlag == 0) {
					JOptionPane.showMessageDialog(null, "To transform a document to audio:\n   Open a document or\n   Make a new one\n ");
					return;
				}
				
				if(txtrT.getText().length() == 0) {
					return;
				}
				
				if(saveFlag == 0) {
					JOptionPane.showMessageDialog(null, "Press Save and after Play\n ");
					return;
				}
				
				Object[] ob = new Object[6];
				ob[0] = filepath;
				ob[1] = String.valueOf(sliderVolume.getValue());   
				ob[2] = String.valueOf(sliderRate.getValue());     
				ob[3] = String.valueOf(sliderPitch.getValue());    
				ob[4] = String.valueOf(sliderRange.getValue());       
				ob[5] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayReverseDocument" + "#" + filepath + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) + "#action";
        			replay.add(s);
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayReverseDocument");
			}
		});
		
		/*
		 * 	Menu Item Line
		 */
		mntmLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtrT.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null, "To transform a line to audio:\n   You have to highlight a text area first\n ");
					return;
				}
				
				Object[] ob = new Object[6];
				ob[0] = txtrT.getSelectedText();
				ob[1] = String.valueOf(sliderVolume.getValue());   
				ob[2] = String.valueOf(sliderRate.getValue());     
				ob[3] = String.valueOf(sliderPitch.getValue());    
				ob[4] = String.valueOf(sliderRange.getValue());
				ob[5] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayLine" + "#" + txtrT.getSelectedText() + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) + "#action";
        			replay.add(s);
        			replay.add(txtrT.getText());
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayLine");
			}
		});
		
		/*
		 * 	Menu Item Reversed Line
		 */
		mntmReversedLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtrT.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null, "To transform a line to audio:\n   You have to highlight a text area first\n ");
					return;
				}
				
				Object[] ob = new Object[6];
				ob[0] = txtrT.getSelectedText();
				ob[1] = String.valueOf(sliderVolume.getValue());   
				ob[2] = String.valueOf(sliderRate.getValue());     
				ob[3] = String.valueOf(sliderPitch.getValue());    
				ob[4] = String.valueOf(sliderRange.getValue());
				ob[5] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayReverseLine" + "#" + txtrT.getSelectedText() + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) +"#action";
        			replay.add(s);
        			replay.add(txtrT.getText());
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayReverseLine");
			}
		});
		
		/*
		 * 	Menu Item EncodedDocument => Atbash
		 */
		mntmAtbash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(documentFlag == 0) {
					JOptionPane.showMessageDialog(null, "To transform a document to audio:\n   Open a document or\n   Make a new one\n ");
					return;
				}
				
				if(txtrT.getText().length() == 0) {
					return;
				}
				
				if(saveFlag == 0) {
					JOptionPane.showMessageDialog(null, "Press Save and after Play\n ");
					return;
				}
				
				Object[] ob = new Object[7];
				ob[0] = "AtBash";
				ob[1] = filepath;
				ob[2] = String.valueOf(sliderVolume.getValue());   
				ob[3] = String.valueOf(sliderRate.getValue());     
				ob[4] = String.valueOf(sliderPitch.getValue());    
				ob[5] = String.valueOf(sliderRange.getValue());  
				ob[6] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayEncodedDocument" + "#" + "AtBash" + "#" + filepath + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) + "#action";
        			replay.add(s);
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayEncodedDocument");
			}
		});
		
		/*
		 * 	Menu Item EncodedDocument => Rot13
		 */
		mntmRot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(documentFlag == 0) {
					JOptionPane.showMessageDialog(null, "To transform a document to audio:\n   Open a document or\n   Make a new one\n ");
					return;
				}
				
				if(txtrT.getText().length() == 0) {
					return;
				}
				
				if(saveFlag == 0) {
					JOptionPane.showMessageDialog(null, "Press Save and after Play\n ");
					return;
				}
				
				Object[] ob = new Object[7];
				ob[0] = "Rot13";
				ob[1] = filepath;
				ob[2] = String.valueOf(sliderVolume.getValue());   
				ob[3] = String.valueOf(sliderRate.getValue());     
				ob[4] = String.valueOf(sliderPitch.getValue());    
				ob[5] = String.valueOf(sliderRange.getValue());
				ob[6] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayEncodedDocument" + "#" + "Rot13" + "#" + filepath + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) + "#action";
					replay.add(s);
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayEncodedDocument");
			}
		});
		
		/*
		 * 	Menu EncodedLine => Atbash
		 */
		mntmAtbash_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtrT.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null, "To transform a line to audio:\n   You have to highlight a text area first\n ");
					return;
				}
				
				Object[] ob = new Object[7];
				ob[0] = "AtBash";
				ob[1] = txtrT.getSelectedText();
				ob[2] = String.valueOf(sliderVolume.getValue());   
				ob[3] = String.valueOf(sliderRate.getValue());     
				ob[4] = String.valueOf(sliderPitch.getValue());    
				ob[5] = String.valueOf(sliderRange.getValue());
				ob[6] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayEncodedLine" + "#" + "AtBash" + "#" + txtrT.getSelectedText() + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) + "#action";
					replay.add(s);
					replay.add(txtrT.getText());
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayEncodedLine");
			}
		});
		
		/*
		 * 	Menu Item EncodedLine => Rot13
		 */
		mntmRot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtrT.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null, "To transform a line to audio:\n   You have to highlight a text area first\n ");
					return;
				}
				
				Object[] ob = new Object[7];
				ob[0] = "Rot13";
				ob[1] = txtrT.getSelectedText();
				ob[2] = String.valueOf(sliderVolume.getValue());   
				ob[3] = String.valueOf(sliderRate.getValue());     
				ob[4] = String.valueOf(sliderPitch.getValue());    
				ob[5] = String.valueOf(sliderRange.getValue());
				ob[6] = "action";
				
				if(replayFlag == 1) {
					String s = "PlayEncodedLine" + "#" + "Rot13" + "#" + txtrT.getSelectedText() + "#" +String.valueOf(sliderVolume.getValue()) + "#" + String.valueOf(sliderRate.getValue()) + "#" + String.valueOf(sliderPitch.getValue()) + "#" + String.valueOf(sliderRange.getValue()) + "#action";
					replay.add(s);
					replay.add(txtrT.getText());
				}
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayEncodedLine");
			}
		});
		
		/*
		 * 	Menu Item Replay
		 */
		mntmReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(replay.size() > 0) {
					replayCommands();
				}
			}
		});
		
	
		
		sliderVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerVolume.setValue(sliderVolume.getValue());
			}
		});
				
		spinnerVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sliderVolume.setValue((int)spinnerVolume.getValue());
			}
		});
		
		sliderRate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerRate.setValue(sliderRate.getValue());
			}
		});
		
		spinnerRate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sliderRate.setValue(((int)spinnerRate.getValue()));
			}
		});
		
		sliderRange.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerRange.setValue(sliderRange.getValue());
			}
		});
		
		spinnerRange.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sliderRange.setValue(((int)spinnerRange.getValue()));
			}
		});
		
		sliderPitch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerPitch.setValue(sliderPitch.getValue());
			}
		});
		
		spinnerPitch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sliderPitch.setValue(((int)spinnerPitch.getValue()));
			}
		});
		
		/*
		 * 	Menu Item About
		 */
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});
		
		/*
		 * 	Menu Item Help Contents
		 */
		mntmHelpContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.setVisible(true);
			}
		});
		
		/*
		 * 	Menu Item File => Properties
		 */
		mntmProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(documentFlag == 0) {
					JOptionPane.showMessageDialog(null, "To see document properties you have\n to open or create one document.\n");
					return;
				}
				FileProperties fp = new FileProperties(author,title,creationDate,lastSavedDate,"filepath: "+filepath);
				fp.setVisible(true);
			}
		});
		
		/*
		 * 	Menu Item Replay => Start
		 */
		mntmStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replayFlag = 1;
			}
		});
		
		/*
		 * 	Menu Item Replay => Clear
		 */
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replay.clear();
			}
		});
		
		/*
		 * 	Menu Item Replay => Stop
		 */
		mntmStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replayFlag = 0;
			}
		});
		
		txtrT.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() >= 44 && e.getKeyCode() <= 111) {
					saveFlag = 0;
				}
				if( (e.getKeyCode() >= 8 && e.getKeyCode() <= 10) || e.getKeyCode() == 32 ) {
					saveFlag = 0;
				}
			}
		});	
	}

	/*
	 * 	Replay method implementation
	 * 
	 * 	Format: Command_Name#argument(#argument)*	where (constructor) argument differs for each command
	 * 
	 */
	private void replayCommands() {
		for(int i = 0; i<replay.size(); i++) {
			System.out.println(replay.get(i));
			
			String[] token = replay.get(i).split("#");
			
			if(token[0].equals("Open")) {
				filepath = token[1];
				
				File file = new File(filepath);
	    		Scanner sc = null;
	    		try {
	    			sc = new Scanner(file);
	    		} catch (IOException e1) {
	    			e1.printStackTrace();
	    		}
				author = sc.nextLine();
	    		title = sc.nextLine();
	    		creationDate = sc.nextLine();
	    		lastSavedDate = sc.nextLine();
	            
	            Object[] ob = new Object[2]; 
	            ob[0] = filepath;
        		ob[1] = txtrT;
        		
        		txtrT.setText("");
				Invoker inv = new Invoker(ob);
				inv.performedAction("Open");
			}
						
			if(token[0].equals("Save")) {
				LocalDate date = LocalDate.now(); 
				LocalTime time = LocalTime.now();
				String strTime = time.toString();
				lastSavedDate = "last saved date: " + date.toString() + "\t" + strTime.substring(0, 8);
				
				Object[] ob = new Object[6];
				ob[0] = token[1];
        		ob[1] = txtrT;
        		ob[2] = token[2];
        		ob[3] = token[3];
        		ob[4] = token[4];
        		ob[5] = lastSavedDate;
        		
        		String contexts = replay.get(i+1);
        		i++;
        		txtrT.setText(contexts);
        		Invoker inv = new Invoker(ob);
				inv.performedAction("Save");
			}
			
			if(token[0].equals("Create")) {
	    		LocalDate date = LocalDate.now(); 
				LocalTime time = LocalTime.now();
				String strTime = time.toString();
				creationDate  = "creation date:   " + date.toString() + "\t" + strTime.substring(0, 8);
				lastSavedDate = "last saved date: -";
	    		
	    		Object[] ob = new Object[5];
	    		ob[0] = token[1];
        		ob[1] = token[2];
        		ob[2] = token[3];
        		ob[3] = creationDate;
        		ob[4] = lastSavedDate;
        		
        		txtrT.setText("");
	    		Invoker inv = new Invoker(ob);
				inv.performedAction("Create");
			}
			
			if(token[0].equals("PlayDocument")){
				Object[] ob = new Object[6];
				ob[0] = token[1];
				ob[1] = token[2];
				ob[2] = token[3];
				ob[3] = token[4];
				ob[4] = token[5];
				ob[5] = token[6];
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayDocument");
			}
			
			if(token[0].equals("PlayReverseDocument")){
				Object[] ob = new Object[6];
				ob[0] = token[1];
				ob[1] = token[2];
				ob[2] = token[3];
				ob[3] = token[4];
				ob[4] = token[5];
				ob[5] = token[6];
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayReverseDocument");
			}
			
			if(token[0].equals("PlayEncodedDocument")){
				Object[] ob = new Object[7];
				ob[0] = token[1];
				ob[1] = token[2];
				ob[2] = token[3];
				ob[3] = token[4];
				ob[4] = token[5];
				ob[5] = token[6];
				ob[6] = token[7];
				
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayEncodedDocument");
			}
			
			if(token[0].equals("PlayLine")){
				Object[] ob = new Object[6];
				ob[0] = token[1];
				ob[1] = token[2];
				ob[2] = token[3];
				ob[3] = token[4];
				ob[4] = token[5];
				ob[5] = token[6];
				
				String contexts = replay.get(i+1);
        		i++;
        		txtrT.setText(contexts);
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayLine");
			}
			
			if(token[0].equals("PlayReverseLine")){
				Object[] ob = new Object[6];
				ob[0] = token[1];
				ob[1] = token[2];
				ob[2] = token[3];
				ob[3] = token[4];
				ob[4] = token[5];
				ob[5] = token[6];
				
				String contexts = replay.get(i+1);
        		i++;
        		txtrT.setText(contexts);
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayReverseLine");
			}
			
			if(token[0].equals("PlayEncodedLine")){
				Object[] ob = new Object[7];
				ob[0] = token[1];
				ob[1] = token[2];
				ob[2] = token[3];
				ob[3] = token[4];
				ob[4] = token[5];
				ob[5] = token[6];
				ob[6] = token[7];
				
				String contexts = replay.get(i+1);
        		i++;
        		txtrT.setText(contexts);
				Invoker inv = new Invoker(ob);
				inv.performedAction("PlayEncodedLine");
			}
		}
	}
}
