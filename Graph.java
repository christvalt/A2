package controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neigbort {
    public int vertub;
    public Neigbort next;

    public Neigbort(int vnum, Neigbort nbr){
        this.vertub=vnum;
        next=nbr;

    }
}
class vertex{
    String name;
    Neigbort adjList;
    vertex(String name, Neigbort neigbort ){
    this.name=name;
    this.adjList=neigbort;
    }
}
 public class  Graphi {
    vertex[] adjLists;

    public Graphi(String file) throws FileNotFoundException {
        Scanner sc = new Scanner((new File("src/controller/stanly.txt")));
        adjLists = new vertex[sc.nextInt()];

        //read vertces
        for (int v=0 ; v<adjLists.length;v++){
            adjLists[v]=new vertex(sc.next(),null);
        }
        //read edge
        while (sc.hasNext()){
            int v1 =indexForName(sc.next());
            int v2 =indexForName(sc.next());

            adjLists[v1].adjList=new Neigbort(v2,adjLists[v1].adjList);
            adjLists[v2].adjList= new Neigbort(v1,adjLists[v2].adjList);
        }
    }
    int indexForName(String name){
        for (int v =0 ; v<adjLists.length;v++){
            if (adjLists[v].name.equals(name)){
                return v;
            }

        }
        return -1;
    }

    public void printGraph(){
        System.out.println();
        for (int v =0 ; v < adjLists.length; v++){
            System.out.println(adjLists[v].name);
            for (Neigbort nbr=adjLists[v].adjList ; nbr!=null ;nbr=nbr.next){

                System.out.print("-->"+adjLists[nbr.vertub].name);
            }
            System.out.println("\n");
        }
    }
    public  static void main (String[]args)throws  IOException{
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("enter the file where is description");
       // String file = scanner.nextLine();
        Graphi graph =new Graphi("");
        graph.printGraph();
    }
}
