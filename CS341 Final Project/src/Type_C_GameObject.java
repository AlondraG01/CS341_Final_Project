import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	// constructor
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconWidth = icon.getIconHeight();
		int canvasWidth = (int) c.getSize().getHeight();
		
		if (getHighlight()) {
			// move the object
			switch (getDirection()) {
			case Direction.RIGHT:
				setImage();
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
				}
				break;
			case Direction.LEFT:
				setImage();
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
				}
				break;
			}
		} else {
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
					setImage();
				}
			} else {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.LEFT);
					setImage();
				}
			}
		}

	}

	@Override
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.LEFT:
			currentImage = 0;
			break;
		case Direction.RIGHT:
			currentImage = 1;
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
		}
		if (getHighlight() == true) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (getHighlight()) {
			if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
			}
		}

	}

	@Override
	public void highlight(Component c, Graphics g) {
		Icon icon = imageList.get(currentImage);
		int height = icon.getIconHeight();
		int width = icon.getIconWidth();
		
		g.setColor(Color.red);
		g.draw3DRect( getX(), getY(), width, height, true);
	}
}