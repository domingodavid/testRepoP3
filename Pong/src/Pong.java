import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pong extends Frame {
	//properties for the ball
	int ballX = 375, ballY = 275; 	//position of the ball object
	Color ballColor = new Color( 212, 0, 50 );
	
	//movement variables
	int speedX = 3; //control ball movement in Y-dir
	int speedY = 4; //control ball movement in X-dir
	
	//properties aka variables for left paddle
	int lpx = 10, lpy = 270;
	int pW = 10;
	int pH = 100;
	Color pColor = new Color( 212, 0, 50 );
	
	//Variables for right paddle
	int rpx = 770, rpy = 270;
	
	/*
	 * SCORING VARIABLES
	 */
	public static int playerScore1 = 0;
	public static int playerScore2 = 0;
					
	/* paint is getting called roughly 60x per second */
	public void paint(Graphics g) {
		super.paintComponent(g);
		//make it a dark background by drawing a dark really realy big rectangle first!
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600); //draw a rect roughly the size of the frame
		
		//make font bigger!
		Font biggerFont = new Font("serif", Font.PLAIN, 80);
		g.setFont(biggerFont);
		
		//draw text - change color to something lighter first
		g.setColor(Color.magenta);
		g.drawString(""+playerScore1, 300, 80);
		g.drawString(""+playerScore2, 450, 80);
		 
		
		/*
		//drawing TEXT on the frame
		Font f = new Font("serif", Font.PLAIN, 80);
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString(""+playerScore1, 200, 50);
		g.drawString(""+playerScore2, 280, 50);*/
		
		
		//paint the pong ball
		g.setColor(ballColor); //change color before drawing
		g.fillOval(ballX, ballY, 50, 50); //we didnt create a var for width since it doens't change
		
		// code for updating the POSITION of the ball object
		ballX += speedX; // same as ballX = ballX + movementX;
		ballY += speedY; // same as ballX = ballX + movementX;
		
		//paint the left paddle
		g.setColor(pColor);
		g.fillRect(lpx, lpy, pW, pH);
		
		//paint the right paddle
		g.setColor(pColor);
		g.fillRect(rpx, ballY, pW, pH);
		
		/*
		 * if-statements / conditionals / blocking statements
		 * 
		 * if( condition ){
		 *   run stuff in here if condition is true
		 * }
		 */

		if( ballY >= 530 || ballY <=0  ) { //start of if-statement
			//what to do if ball has passed the bottom border?
			speedY *= -1; // speedY = speedY * -1;			
		} //end of if-statement
		
		//complete the if-statement for the right side of the frame
		if( ballX >= 750 || ballX <=0 ) 
		{
			//instead of bouncing, reset the ball
			ballX = 375;
			ballY = 275;
			
			//add a little bit of randomness
			// int randValue = (int)(Math.random()*(range+1))+min;
			// randomize x speed between 3 and 5 inclusive
			speedX = (int)(Math.random()*(5-3+1))+3;
			
			//50% of the time, the direction changes
			if( Math.random() < .50  ) { //Math.random() returns a decimal between 0.0 and .99999999999
				//this block runs 50% of the time because Math.random() should return 
				//less than .50 roughly 50% of the time
				//reverse x direction
				speedX = -speedX; 
			}
			
			speedY = (int)(Math.random()*(5-3+1))+3;
			
			//50% of the time, the direction changes
			if( Math.random() < .50  ) { //Math.random() returns a decimal between 0.0 and .99999999999
				//this block runs 50% of the time because Math.random() should return 
				//less than .50 roughly 50% of the time
				//reverse x direction
				speedY = -speedY; 
			}
			
			
		}
		
		
		//left paddle collision
		if( ballX >= lpx && ballX <= (lpx+10) 
		    && ballY >= lpy && ballY <= lpy + 100		) {
			
			//intersecting... bounce!
			speedX *= -1; //reverse the x direction
			
		} //end of if statement
		
		
		
		

			
		
	} //end of Paint method ---- dont delete me please ------ add code above X-D
	
	
	
	
	
	public void keyPressed(KeyEvent key) {
		System.out.println(key.getKeyCode());
		if(key.getKeyCode() == 83) {
			//83 is the keycode for 's'
			//user intends to move left paddle down
			//what variable should you update?
			lpy += 5; //<-- what does this do again?
		}
		
		//your turn!
		//detect the 'w' key
		if(key.getKeyCode() == 87) {
			//paddle should go up
			lpy -= 5; //<--- what is -= ? 
		}
		
		
		
	}


	public void keyReleased(KeyEvent arg0) {
		
		
	}


	public void keyTyped(KeyEvent arg0) {
		
		
	}
	public static void main(String[] arg) {
		Pong p = new Pong();
	}
	
}
