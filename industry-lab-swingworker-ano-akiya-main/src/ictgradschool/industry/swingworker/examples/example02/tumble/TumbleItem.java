package ictgradschool.industry.swingworker.examples.example02.tumble;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


/**
 * Adapted from Oracle code.
 * 
 * This class needs to locate image resources on the classpath. The images are 
 * located in a folder named 'res' in the root of the project folder. 
 * In Eclipse, select the "Run" menu, and "Run configurations". For this class
 * (TumbleItem) select the "Classpath" tab and the select "User Entries". Click
 * on the "Advanced" button and the select "Add folders". From here, locate the
 * "res" folder and add it.
 *
 */
public class TumbleItem extends JFrame implements ActionListener {
	
	private static final int PAUSE = 2000;  // The length of the pause between revs (ms).
	private static final int SPEED = 100;   // Animation speed (ms).
	private static final int N_IMAGES = 16; // Number of images to animate.
	
    private int _currentFrame = -1;         // The current frame number.
    private Timer _timer;                   // The timer animating the images.            
    
    private Animator _animator;             // The content pane for displaying images.

    private ImageIcon _imgs[];              // The images to display.
    private JLabel _statusLabel;            // Label to display loading status.


    /** Background task for loading images. */
    private SwingWorker<ImageIcon[], Void> worker = new SwingWorker<ImageIcon[], Void>() {

        /** Loads the images in a background thread. */
        @Override
        public ImageIcon[] doInBackground() {    	
            final ImageIcon[] innerImgs = new ImageIcon[N_IMAGES];
            for (int i = 0; i < N_IMAGES; i++) {
                innerImgs[i] = loadImage(i + 1);
            }
            return innerImgs;
        }

        /**
         * When image loading is complete, this method will be called on the ED thread.
         */
        @Override
        public void done() {
            //Remove the "Loading images" label.
            _animator.removeAll();
            _currentFrame = -1;
            try {
                _imgs = get();
            } catch (InterruptedException ignore) {}
            catch (java.util.concurrent.ExecutionException e) {
                String why = null;
                Throwable cause = e.getCause();
                if (cause != null) {
                    why = cause.getMessage();
                } else {
                    why = e.getMessage();
                }
                System.err.println("Error retrieving file: " + why);
            }
        }
    };

    /** Program entry point. */
    public static void main(String[] args) {
    	new TumbleItem();
    }

    /**
     * Sets everything up.
     */
    public TumbleItem() {
    	// Construct the GUI in the ED thread.
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    	
    	// Load images in a background thread.
    	worker.execute();
    	
        // Set up timer to drive animation events. All timers invoke their
    	// listeners in the ED thread.
        _timer = new Timer(SPEED, this);
        _timer.setInitialDelay(PAUSE);
        _timer.start(); 
    }

    /**
     * Creates the GUI. Invoked in the ED thread.
     */
    protected void createGUI() {
        // Custom component to draw the current image.
        _animator = new Animator();
        _animator.setOpaque(true);
        _animator.setBackground(Color.white);
        add(_animator);

        // Put a "Loading Images..." label in the middle of
        // the content pane. 
        _statusLabel = new JLabel("Loading Images...",
                                 JLabel.CENTER);
        _animator.add(_statusLabel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    /**
     * Called in the ED thread whenever the timer ticks. Plays the animation if our images have finished loading.
     */
    public void actionPerformed(ActionEvent e) {
        // If still loading, can't animate.
        if (!worker.isDone()) {
            return;
        }

        _currentFrame++;

        if (_currentFrame >= N_IMAGES) {
            _currentFrame = 0;
        }

        _animator.repaint();

        // Last frame, restart the timer to get a long pause between loops.
       if (_currentFrame == N_IMAGES - 1) {
            _timer.restart();
        }
    }

    /**
     * Load the image for the specified frame of animation. 
     */
    protected ImageIcon loadImage(int imageNum) {
    	ImageIcon result = null;
    	
    	String path = "/ictgradschool/industry/swingworker/examples/example02/tumble/T" + imageNum + ".gif";
       	URL url = getClass().getResource(path);

		try {
			// read() blocks the caller thread while reading the image.
			Image image = ImageIO.read(url);
			result = new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    /** The component that actually presents the GUI. */
    public class Animator extends JPanel {
        public Animator() {
            super(new BorderLayout());
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (worker.isDone() &&
                (_currentFrame > -1) && (_currentFrame < N_IMAGES)) {
                    _imgs[_currentFrame].paintIcon(this, g, 0, 0);
            }
        }
        
        public Dimension getPreferredSize() {
        	return new Dimension(130, 80);
        }
    }

}

