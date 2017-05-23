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
import java.util.concurrent.Semaphore;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

public class Handler implements Func_Grafo.Iface {

    Object grafoInput = null;
    Grafo grafo = null;
    static Semaphore semaphore = new Semaphore(1);

    @Override
    public void criarVertice(int nome, int cor, java.lang.String descricao, double peso) {
        
    try {
        semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        Vertice vertice = new Vertice(nome, cor, descricao, peso);
        vertice.setCor(cor);
        vertice.setDescricao(descricao);
        vertice.setNome(nome);
        vertice.setPeso(peso);

        grafo.addToVertice(vertice);

        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();

    }

    @Override
    public void criarAresta(int nomeV1, int nomeV2, double peso, boolean direcao) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        Aresta aresta = new Aresta();
        aresta.setNomeV1(nomeV1);
        aresta.setNomeV2(nomeV2);
        aresta.setFlag_Direcao(direcao);
        aresta.setPeso(peso);

        grafo.addToAresta(aresta);
        
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    public void atualizarVertice(int nome, int cor, java.lang.String descricao, double peso) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        for (i = 0; i < grafo.vertice.size(); i++) {
            if (grafo.vertice.get(i).nome == nome) {
                grafo.vertice.get(i).setDescricao(descricao);
                grafo.vertice.get(i).setPeso(peso);
                grafo.vertice.get(i).setNome(nome);
                break;
            }
        }
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    public void atualizarAresta(int nomeV1, int nomeV2, double peso, boolean direcao) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        for (i = 0; i < grafo.aresta.size(); i++) {
            if (grafo.aresta.get(i).nomeV1 == nomeV1 && grafo.aresta.get(i).nomeV2 == nomeV2) {
                grafo.aresta.get(i).setPeso(peso);
                grafo.aresta.get(i).setFlag_Direcao(direcao);
            }
        }
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();

    }

    @Override
    public void lerAresta(int nomeA) {
        int i;

    }

    @Override
    public void lerVertice(int nomeV) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        for (i = 0; i < grafo.vertice.size(); i++) {
            System.out.println(i);
            if (grafo.vertice.get(i).nome == nomeV) {
                String des = grafo.vertice.get(i).getDescricao();
                int corVer = grafo.vertice.get(i).getCor();
                double pesoV = grafo.vertice.get(i).getPeso();
                System.out.println("ok");
                System.out.println("Vértice de nome: " + nomeV);
                System.out.println("Descrição: " + des);
                System.out.println("Peso: " + pesoV);
                System.out.println("Cor: " + corVer);

                break;
            }
        }
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    public void deletarVertice(int nomeV) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        for (i = 0; i < grafo.vertice.size(); i++) {
            if (grafo.vertice.get(i).nome == nomeV) {
                grafo.vertice.remove(i);
                break;
            }
        }
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    public void deletarAresta(int nomeV1, int nomeV2) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        for (i = 0; i < grafo.aresta.size(); i++) {
            if (grafo.aresta.get(i).nomeV1 == nomeV1 && grafo.aresta.get(i).nomeV2 == nomeV2) {
                grafo.aresta.remove(i);
            }
        }
        try {
            semaphore.acquire();

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    public void listarVerticesAresta(java.lang.String descricao) {
        int i;
    }

    @Override
    public void listarArestasVertice(int nomeV) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        System.out.println("Vertice: " + nomeV);
        for (i = 0; i < grafo.aresta.size(); i++) {
            if (grafo.aresta.get(i).nomeV1 == nomeV || grafo.aresta.get(i).nomeV2 == nomeV) {
                System.out.println("Aresta:");
                System.out.println("NomeV1: " + grafo.aresta.get(i).nomeV1);
                System.out.println("NomeV2: " + grafo.aresta.get(i).nomeV2);
                System.out.println("Peso: " + grafo.aresta.get(i).peso);
                System.out.println("Direção: " + grafo.aresta.get(i).flag_Direcao);
            }
        }
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    public void listarVerticesVizinhos(int nomeV) {
        try {
            semaphore.acquire();
        FileInputStream restFile = new FileInputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
        ObjectInputStream stream = new ObjectInputStream(restFile);
        // recupera o objeto
        grafoInput = stream.readObject();
        grafo = (Grafo)grafoInput;
        stream.close();

    }
    catch (Exception e) {

         e.printStackTrace();

    }
        int i;

        System.out.println("Vizinhos do vértice " + nomeV);
        for (i = 0; i < grafo.aresta.size(); i++) {
            if (grafo.aresta.get(i).nomeV1 == nomeV) {
                lerVertice(grafo.aresta.get(i).nomeV2);
            } else if (grafo.aresta.get(i).nomeV2 == nomeV) {
                lerVertice(grafo.aresta.get(i).nomeV1);
            }
        }
        try {

            FileOutputStream saveFile = new FileOutputStream("/home/neliton/Documents/UFU/SD/gen-java/grafos/grafoBD");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            // salva o objeto
            stream.writeObject(grafo);
            stream.close();
            System.out.println("Vértice adicionado!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        semaphore.release();
    }

}
