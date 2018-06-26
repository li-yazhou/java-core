package cn.itcast.swing.demo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class MyWindow extends javax.swing.JFrame {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JTextField jTextField1;
	private JButton jButton1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyWindow inst = new MyWindow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyWindow() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, "Center");
				jTextField1.setBounds(12, 41, 368, 34);
				jTextField1.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTextField1KeyPressed(evt);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u8f6c\u5230");
				jButton1.setBounds(397, 41, 99, 34);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 87, 484, 356);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
				}
			}
			pack();
			this.setSize(523, 482);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		
		showDir();
	}

	/**
	 * 
	 */
	public void showDir() {
		/*
		 * 通过点击按钮获取文本框中目录，
		 * 将目录中的内容显示在文本区域中。
		 */
		
		String dir_str = jTextField1.getText();
		File dir = new File(dir_str);
		
		if(dir.exists() && dir.isDirectory()){
			jTextArea1.setText("");
			String[] names = dir.list();
			
			for(String  name : names){
				jTextArea1.append(name+LINE_SEPARATOR);
			}
		}
	}
	
	private void jTextField1KeyPressed(KeyEvent evt) {
		
		if(evt.getKeyCode()==KeyEvent.VK_ENTER)
			showDir();
	}

}
