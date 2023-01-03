package thread.slideshow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageThread extends Thread {
	JLabel lbl;
	int time = 1000;
	public ImageThread(JLabel lbl) {
		this.lbl = lbl;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public void run() {
		int i = 0;
		ImageIcon icon;
		while(true) {
			icon = new ImageIcon("images/강해린"+ (++i )+".jpg");
			lbl.setIcon(icon);
			if(i == 5) {
				i = 0;
			}
			try {
				sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
