package ru.gb.chat.client;

import javax.swing.*;
import java.awt.*;

public class RegistrationWindow extends JFrame {

    private static final int WIDTH = 280;
    private static final int HEIGHT = 250;
    ClientGUI clientGUI;

    private final JPanel panelMain = new JPanel(new GridLayout(4, 1));

    private final JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JLabel labelLogin = new JLabel("Enter your login: ");
    private final JTextField tfLogin = new JTextField(10);

    private final JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JLabel labelPassword = new JLabel("Enter your password: ");
    private final JPasswordField tfPassword = new JPasswordField(12);

    private final JPanel panelNick = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JLabel labelNick = new JLabel("Enter your password: ");
    private final JTextField tfNickname = new JTextField(10);

    private final JPanel panelSend = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JButton btnSend = new JButton("Send");

    RegistrationWindow(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;

        Rectangle registrationWindowBounds = clientGUI.getBounds();
        int posX = (int) registrationWindowBounds.getCenterX() - WIDTH / 2;
        int posY = (int) registrationWindowBounds.getCenterY() - HEIGHT / 2;

        setLocation(posX, posY);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Registration in chat");

        add(panelMain);

        panelMain.add(panelLogin);
        panelMain.add(panelPassword);
        panelMain.add(panelNick);
        panelMain.add(panelSend);

        panelLogin.add(labelLogin);
        panelLogin.add(tfLogin);

        panelPassword.add(labelPassword);
        panelPassword.add(tfPassword);

        panelNick.add(labelNick);
        panelNick.add(tfNickname);

        panelSend.add(btnSend);
    }
}
