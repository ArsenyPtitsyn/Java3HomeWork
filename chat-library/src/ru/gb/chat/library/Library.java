package ru.gb.chat.library;

public class Library {
    /**
     * /reg_request±login±password±nickname
     * /auth_request±login±password
     * /auth_accept±nickname
     * /auth_denied
     * /broadcast±msg
     * /msg_format_error
     * /user_list±user1±user2±user3
     * /reg_incomplete
     * */

    public static final String DELIMITER = "±";
    public static final String REG_REQUEST = "/reg_request";
    public static final String REG_INCOMPLETE = "/reg_incomplete";
    public static final String AUTH_REQUEST = "/auth_request";
    public static final String AUTH_ACCEPT = "/auth_accept";
    public static final String AUTH_DENIED = "/auth_denied";
    public static final String MSG_FORMAT_ERROR = "/msg_format_error"; // если мы вдруг не поняли, что за сообщение и не смогли разобрать
    public static final String TYPE_BROADCAST = "/bcast"; // то есть сообщение, которое будет посылаться всем
    public static final String USER_LIST = "/user_list";
    public static final String CLIENT_MSG_BROADCAST = "/client-bcast";

    public static String getTypeBcastClient(String msg) {
        return CLIENT_MSG_BROADCAST + DELIMITER + msg;
    }

    public static String getRegRequest(String login, String password, String nickname) {
        return REG_REQUEST + DELIMITER + login + DELIMITER + password + DELIMITER + nickname;
    }

    public static String getAuthRequest(String login, String password) {
        return AUTH_REQUEST + DELIMITER + login + DELIMITER + password;
    }

    public static String getAuthAccept(String nickname) {
        return AUTH_ACCEPT + DELIMITER + nickname;
    }

    public static String getAuthDenied() {
        return AUTH_DENIED;
    }

    public static String getMsgFormatError(String message) {
        return MSG_FORMAT_ERROR + DELIMITER + message;
    }

    public static String getTypeBroadcast(String src, String message) {
        return TYPE_BROADCAST + DELIMITER + System.currentTimeMillis() +
                DELIMITER + src + DELIMITER + message;
    }

    public static String getUserList(String users) {
        return USER_LIST + DELIMITER + users;
    }

    public static String getRegDataIncomplete() {
        return REG_INCOMPLETE + DELIMITER + "Enter all fields please";
    }
}
