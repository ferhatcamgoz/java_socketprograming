


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




public class r4{
	//client görevi
	static Socket serverSocket;      
       static  DataInputStream dataInputStream;

	//server görevi
	static ServerSocket rserverSocket;
	static Socket rclientSocket = new Socket();
	static String mesaj;
	static DataOutputStream dataOutputStream;
	static boolean conn=false;
	
	
static int a =0;
    public static void main(String[] args) throws UnknownHostException, IOException {

    	//Queue<String> kuyruk = new LinkedList<>();
 serverSocket = new Socket("localhost", 1453);
 rserverSocket = new ServerSocket(1454);      
        ArrayList<Socket> bağlanlar = new ArrayList<>();
        while(true) {
        	rclientSocket = rserverSocket.accept();
        	bağlanlar.add(rclientSocket);
        	if(bağlanlar.size()==1) {
        		break;
        	}
        	
        }
while(true){
	
		
		/*if(!rclientSocket.isBound()) {
			 rclientSocket = rserverSocket.accept();
		}*/

System.out.println("dinleniyor");
dataInputStream = new DataInputStream(serverSocket.getInputStream());
			System.out.println("geldi");
            mesaj = dataInputStream.readUTF();
           /* boolean state= kuyruk.offer(mesaj);
            if(!state) {
            	continue;
            }*/
            System.out.println("Alınan mesaj: " + mesaj);
        
                			try {							
							System.out.println("bulundu");
						//	String mesaj= kuyruk.poll();
							for(Socket rclientSocket : bağlanlar) {
								  dataOutputStream = new DataOutputStream(rclientSocket.getOutputStream());
		                			
		                			dataOutputStream.writeUTF(mesaj+"->r4 ");
							}
                		  
                			System.out.println("gönderildi");
                			
                		
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}               		                			
                			
                		}
                   
        } 

}


