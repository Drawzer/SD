/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_cliserv;

/**
 *
 * @author neliton
 */


import grafo_cliserv.*;

import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;


public class Servidor {
    public static void main(String[] args)
    {
        try
        {
            
      
            TServerTransport serverTransport = new TServerSocket(9090);
            Handler handler = new Handler();
            Func_Grafo.Processor processor = new Func_Grafo.Processor(handler);
            
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            
            System.out.println("Iniciando o servidor...");
            server.serve();
        }
        catch(Exception x)
        {
            x.printStackTrace();
        }
    }
}

