package mastermind.distributed.dispatchers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;
import mastermind.types.Error;

public class TCPIP extends mastermind.utils.TCPIP {
    
    private static final int PORT = 2020;

    public TCPIP(Socket socket) {
        super(socket);
    }

    public TCPIP(ServerSocket serverSocket, Socket socket) {
        super(serverSocket, socket);
    }

    public static TCPIP createClientSocket() {
        try {
            Socket socket = new Socket("localhost", TCPIP.PORT);
            System.out.println("Cliente> Establecida conexion");
            return new TCPIP(socket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TCPIP createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(TCPIP.PORT);
            System.out.println("Servidor> Esperando conexion...");
            Socket socket = serverSocket.accept();
            System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort());
            return new TCPIP(serverSocket, socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void send(Error error) {
        if (error == null) {
            this.send("null");
        } else {
            this.send(error.name());
        }
    }

    public Error receiveError() {
        String error = this.receiveLine();
        if (error.equals("null")) {
            return null;
        }
        return Error.valueOf(error);
    }

    public void send(List<Color> colors) {
        if (colors == null) {
            this.send("null");
        } else {
            String colorsSend = "";
            for (Color color : colors) {
                if(color == null)
                    colorsSend += "#";
                else
                    colorsSend += color.ordinal();
            }
            this.send(colorsSend);
        }
    }

    public List<Color> recieveColors() {
        String error = this.receiveLine();
        if (error.equals("null")) {
            return null;
        }
        List<Color> colors = new ArrayList<>();
        for (char ordinal : error.toCharArray()) {
            if(ordinal == '#')
                colors.add(null);
            else
                colors.add(Color.values()[Integer.parseInt(String.valueOf(ordinal))]);
        }
        return colors;
    }

    @Override
    public void close() {
        this.send(FrameType.CLOSE.name());
        super.close();
    }
}