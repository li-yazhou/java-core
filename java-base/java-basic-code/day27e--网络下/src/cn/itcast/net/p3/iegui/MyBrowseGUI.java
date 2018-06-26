package cn.itcast.net.p3.iegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JButton;
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
public class MyBrowseGUI extends javax.swing.JFrame {
	private JTextField url_text;
	private JButton goto_but;
	private JScrollPane jScrollPane1;
	private JTextArea page_content;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyBrowseGUI inst = new MyBrowseGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyBrowseGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				url_text = new JTextField();
				getContentPane().add(url_text);
				url_text.setBounds(12, 36, 531, 44);
				url_text.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						url_textKeyPressed(evt);
					}
				});
			}
			{
				goto_but = new JButton();
				getContentPane().add(goto_but);
				goto_but.setText("\u8f6c \u5230");
				goto_but.setBounds(555, 36, 134, 44);
				goto_but.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						goto_butActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 92, 676, 414);
				{
					page_content = new JTextArea();
					jScrollPane1.setViewportView(page_content);
				}
			}
			pack();
			this.setSize(708, 545);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void goto_butActionPerformed(ActionEvent evt) {
		showPage();
	}
	
	private void url_textKeyPressed(KeyEvent evt) {
		if(evt.getKeyCode()==KeyEvent.VK_ENTER)
			showPage();
		
	}

	private void showPage() {
		try {
			
			String url_str = url_text.getText();
			URL url = new URL(url_str);
			
			InputStream in = url.openConnection().getInputStream();//url.openStream();
			
			page_content.setText("");
			
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String text = new String(buf,0,len,"utf-8");
			
			page_content.setText(text);
			
			in.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
