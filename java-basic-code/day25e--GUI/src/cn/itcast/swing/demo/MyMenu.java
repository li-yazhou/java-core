package cn.itcast.swing.demo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MyMenu extends javax.swing.JFrame {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JMenuBar jMenuBar1;
	private JScrollPane jScrollPane1;
	private JMenuItem jMenuItem2;
	private JTextArea jTextArea1;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private JFileChooser chooser;
	private JDialog dialog;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyMenu inst = new MyMenu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyMenu() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u6587\u4ef6");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("\u6253\u5f00");
						jMenuItem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								try {
									jMenuItem1ActionPerformed(evt);
								} catch (IOException e) {
									
									e.printStackTrace();
								}
							}
						});
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("\u4fdd\u5b58");
						jMenuItem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								try {
									jMenuItem2ActionPerformed(evt);
								} catch (IOException e) {
									
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
			pack();
			this.setSize(610, 402);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jMenuItem1ActionPerformed(ActionEvent evt) throws IOException {
		
		
		chooser = new JFileChooser();
	
//		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//		        "JPG & GIF Images", "jpg", "gif");
//		    chooser.setFileFilter(filter);
		    
		    
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.CANCEL_OPTION){
			System.out.println("没有选取文件，取消了");
			return;
		}
		    
		File file = chooser.getSelectedFile();
		
		
		
		BufferedReader bufr = new BufferedReader(new FileReader(file));
			
		String line = null;
		while((line=bufr.readLine())!=null){
			jTextArea1.append(line+LINE_SEPARATOR);
		}
			
		bufr.close();

	}
	
	private void jMenuItem2ActionPerformed(ActionEvent evt) throws IOException {
		
		chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);
		if(returnVal == JFileChooser.CANCEL_OPTION){
			System.out.println("没有指定文件，取消了");
			return;
		}
		
		File file = chooser.getSelectedFile();
		
		String text = jTextArea1.getText();
		
		BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
		bufw.write(text);
		bufw.close();
		
	}

}
