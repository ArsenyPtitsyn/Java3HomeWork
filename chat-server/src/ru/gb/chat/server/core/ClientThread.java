package ru.gb.chat.server.core;

import ru.gb.chat.library.Library;
import ru.gb.jthree.network.SocketThread;
import ru.gb.jthree.network.SocketThreadListener;

import java.net.Socket;

public class ClientThread extends SocketThread {

    private String nickname;
    private boolean isAuthorized;
    private boolean isReconnecting;

    public ClientThread(String name, SocketThreadListener listener, Socket socket) {
        super(name, listener, socket);
    }

    public boolean isReconnecting() {
        return isReconnecting;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    void reconnect() {
        isReconnecting = true;
        close();
    }

    void authAccept(String nickname) {
        isAuthorized = true;
        this.nickname = nickname;
        sendMessage(Library.getAuthAccept(nickname));
    }

    void authFail() {
        sendMessage(Library.getAuthDenied());
        close();
    }

    void msgFormatError(String msg) {
        sendMessage(Library.getMsgFormatError(msg));
        close();
    }

    void regFailByInfoLack() {
        sendMessage(Library.getRegDeniedByInfoLack());
        close();
    }

    void regFailByNotUniqueLoginOrNickname() {
        sendMessage(Library.getRegDeniedByNotUniqueLoginOrNickname());
        close();
    }

    void regAccept(String login, String password, String nickname) {
        sendMessage(Library.getRegAccept(login, password, nickname));
    }
}
