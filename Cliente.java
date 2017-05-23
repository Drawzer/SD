/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo_cliserv;
import grafo_cliserv.*;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TBinaryProtocol;

/**
 *
 * @author neliton
 */
public class Cliente {
    public static void main(String[] args)
    {
        try
        {
            TTransport transport = new TSocket("localhost", 9090);
            transport.open();
            
            TProtocol protocol = new TBinaryProtocol(transport);
            Func_Grafo.Client cliente = new Func_Grafo.Client(protocol);
            
            
            cliente.criarVertice(0, 0, "testev1", 0);
            cliente.criarVertice(1, 2, "vertice2", 5);
            cliente.criarVertice(2, 5, "vertice3", 5);
            cliente.criarVertice(3, 4, "vertice4", 5);
            cliente.lerVertice(0);
            cliente.lerVertice(3);
            
            cliente.criarAresta(0, 1, 0, true);
            cliente.criarAresta(2, 3, 7, true);
            cliente.criarAresta(1, 2, 4, true);
            
            cliente.listarArestasVertice(1);
            
            
            cliente.listarArestasVertice(1);
            
            System.out.println("Dados enviados!");
            transport.close();  
        }
        catch(TException x)
        {
            x.printStackTrace();
        }
    }
    
}
