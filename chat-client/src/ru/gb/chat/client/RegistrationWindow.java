package ru.gb.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow extends JFrame implements ActionListener {

    private static final int WIDTH = 280;
    private static final int HEIGHT = 250;
    ClientGUI clientGUI;

    final JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.CENTER));
    final JLabel labelLogin = new JLabel("Enter your login: ");
    final JTextField tfLogin = new JTextField(10);

    final JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
    final JLabel labelPassword = new JLabel("Enter your password: ");
    final JPasswordField tfPassword = new JPasswordField(12);

    final JPanel panelNick = new JPanel(new FlowLayout(FlowLayout.CENTER));
    final JLabel labelNick = new JLabel("Enter your nickname: ");
    final JTextField tfNickname = new JTextField(10);

    final JPanel panelLog = new JPanel(new FlowLayout(FlowLayout.CENTER));
    final JTextArea log = new JTextArea(3, 18);

    final JPanel panelSend = new JPanel(new FlowLayout(FlowLayout.CENTER));
    final JButton btnSend = new JButton("Send");

    RegistrationWindow(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;

        Rectangle registrationWindowBounds = clientGUI.getBounds();
        int posX = (int) registrationWindowBounds.getCenterX() - WIDTH / 2;
        int posY = (int) registrationWindowBounds.getCenterY() - HEIGHT / 2;

        setLocation(posX, posY);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Registration in chat");
        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        btnSend.addActionListener(this);

        panelLogin.add(labelLogin);
        panelLogin.add(tfLogin);

        panelPassword.add(labelPassword);
        panelPassword.add(tfPassword);

        panelNick.add(labelNick);
        panelNick.add(tfNickname);

        panelLog.add(scrollLog);

        panelSend.add(btnSend);

        JPanel panelMain = new JPanel(new GridLayout(5, 1));
        panelMain.add(panelLogin);
        panelMain.add(panelPassword);
        panelMain.add(panelNick);
        panelMain.add(panelLog);
        panelMain.add(panelSend);

        add(panelMain);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnSend) {
            sendDataOnServer();
        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    private void sendDataOnServer() {
        clientGUI.connect();
    }

    public void putLog(String msg) {
        SwingUtilities.invokeLater(() -> {
            log.append(msg + "\n");
            log.setCaretPosition(log.getDocument().getLength());
        });
    }
}
