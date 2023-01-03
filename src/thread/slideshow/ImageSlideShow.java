package thread.slideshow;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageSlideShow extends JFrame {
	JLabel lbl;
	JTextField tf;
	int time;
	ImageThread imageThread;
	
	public ImageSlideShow() {
		JPanel p = new JPanel();
		JButton button = new JButton("시간설정");
		tf = new JTextField(10);
		button.addActionListener(buttonListener);
		p.add(tf);
		p.add(button);
		add(p,"North");
		
		ImageIcon icon = new ImageIcon("images/강해린1.jpg");
		lbl= new JLabel(icon);
		add(lbl,"Center");
		
		setTitle("이미지슬라이드쇼");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(150, 300, 700, 700);
		setVisible(true);
		setResizable(false);//사이즈변경불가
		imageThread = new ImageThread(lbl);
		imageThread.start();
	}
	
	public static void main(String[] args) {
		
		new ImageSlideShow();
		
	}
	ActionListener buttonListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			time = (int) (Double.parseDouble(tf.getText())*1000);
			imageThread.setTime(time);  //시간설정
		}
	};
}
