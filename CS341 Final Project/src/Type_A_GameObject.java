import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Type_A_GameObject extends GameObject implements KeyListener {
	// constructor
	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		
	}

	// implement abstract method move
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();
		
		if (getHighlight()) {
			// move the object
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
					setImage();
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
					setImage();
				}
				break;
			default:
				break;
			}
		} else {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
					setImage();
				}
			} else {
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
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
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		}

	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
		}
		if (getHighlight()) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
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
		g.draw3DRect(getX(), getY(), width, height, true);
	}
	
	
}