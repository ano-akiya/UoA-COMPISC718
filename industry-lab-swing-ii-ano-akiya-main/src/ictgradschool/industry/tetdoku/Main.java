package ictgradschool.industry.tetdoku;

import ictgradschool.industry.tetdoku.view.gameboard.GameBoardPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {

        GameBoardPanel gameBoardPanel = new GameBoardPanel();

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(gameBoardPanel, BorderLayout.CENTER);

        this.setTitle("Programming for Industry Lab 12 - Tetdoku v0.1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        // This will centre the JFrame on the screen.
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }

}
