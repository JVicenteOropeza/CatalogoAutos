package catalogoAutos;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoCat extends JPanel {

	private Image fondoCat;

    public FondoCat(String imagePath) {
        fondoCat = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondoCat, 0, 0, getWidth(), getHeight(), this);
    }
	
}
