package clientudp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP {
//déclarer variables 
  static final int port = 6010 ;
  DatagramSocket socket;
  DatagramPacket envoye, recu;
  InetAddress address;
  
  void envoi(String msg) throws UnknownHostException, SocketException, IOException {
    int msglen = msg.length() ;
    byte [] message = new byte [1024] ;
    message = msg.getBytes() ;
    envoye = new DatagramPacket(message, msglen, address, port) ;
    socket.send(envoye) ;
    System.out.println("\nLe message envoye => "+msg);
  }
  
  String recu() throws UnknownHostException, SocketException, IOException {
    byte[] buf = new byte[1024];
    recu = new DatagramPacket(buf, buf.length);
    socket.receive(recu);
    String rcvd = "Message recu du serveur : " + recu.getAddress() + ", au port : " + recu.getPort();
    System.out.println(rcvd);
    return new String(recu.getData(), 0, recu.getLength());
  }
  
  ClientUDP() throws UnknownHostException, SocketException, IOException{
    address = InetAddress.getByName("127.0.0.1") ;
    socket = new DatagramSocket() ;
//scénario des requêtes, vérifier dans les commandes les messages recu qui sont explicites
//peut ajouter requetes si debug
    envoi("inscription@francois@mdp1");
    System.out.println(recu());
    
    envoi("inscription@hakim@mdp2");
    System.out.println(recu());
    
    envoi("connexion@francois@mdp1");
    System.out.println(recu());

    envoi("inscription@user1@user1");
    System.out.println(recu());
    
    //envoi("connexion,jean");
    //System.out.println(recu());

   // envoi("demande_ami,francois,hakim");
    //System.out.println(recu());

    envoi("connexion@hakim@mpd2");
    System.out.println(recu());
    
   // envoi("connexion,thomas,raynaud");
   // System.out.println(recu());

    envoi("ami@demande@thomas@francois");
    System.out.println(recu());
    
    envoi("ami@demande@hakim@thomas");
    System.out.println(recu());
    
    envoi("ami@demande@thomasbis@thomas");
    System.out.println(recu());
    
    envoi("ami@accept@thomas@francois");
    System.out.println(recu());

    envoi("ami@bloque@thomas@francois");
    System.out.println(recu());
    
    envoi("message@thomas@francois@subject@data"); //thomas envoie un message a francois
    System.out.println(recu());
    
    envoi("message@francois@thomas@BAHAHAH@HAHAHAHHAHAHAHAAHAHH"); //francois envoie un message a thomas
    System.out.println(recu());
    
    
    //envoi("update,thomas");
    //System.out.println(recu());
   
    //envoi("action,hakim");
    //System.out.println(recu());

    //envoi("ami,demande,hakim,fracvncois");
    //System.out.println(recu());

    //envoi("message,francois,thomas,sujet,data");
    //System.out.println(recu());
    
    /*envoi("message,hakim,francois,le sujet,lorem blabla");
    System.out.println(recu());
    
    envoi("message,hakim,francoi,subject2,blablablablablablablablablablablablablablablabla");
    System.out.println(recu());
    
    
    
    envoi("lecture,hakim,francois");
    System.out.println(recu());*/
    
  }
      
  public static void main(String args[])throws UnknownHostException, SocketException, IOException {
    new ClientUDP(); //exécuter le scénario, on pourait faire un bouton sur l'interface graphique 
    new LoginPageGui().setVisible(true);//mettre la page de connexion quand lance ce programme, 
    //version 15 de netbeans pb des fois (v11 pas de pb)
    //System.out.println(LoginPageGui.myName());
  }
}
