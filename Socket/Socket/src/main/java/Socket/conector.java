/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author HP
 */
public class conector {
    ServerSocket server;
    Socket socket;
    int puerto=9000;
    DataOutputStream salida;
    BufferedReader entrada;
    public void iniciar (){
    try{
    server = new ServerSocket(puerto);
    socket = new Socket();
    socket = server.accept();

    entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String mensaje = entrada.readLine();
    System.out.println(mensaje);
    salida = new DataOutputStream(socket.getOutputStream());
    salida.writeUTF("Adios");
    socket.close();
    }catch(Exception e){};
    }
}
