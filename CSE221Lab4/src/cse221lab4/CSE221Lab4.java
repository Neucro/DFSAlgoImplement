/*
 *12201027
 * A N M Sajedul Alam 
 * Lab DFS 
 * 
 */
package cse221lab4;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Stack;
/**
 *
 * @author 12201027
 */
public class CSE221Lab4 {
//White==1, Grey==2, Black==3
public static int color[];
public static int time;//time maintaining
public static int prev[];//parent, previous 
public static int d[];//discovery time, starting time
public static int f[];//finishing time, ending time
public static Node[]a;//main node array
public static int v1,v2;
public static int connectedComponents;
public static Scanner sc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{

                   sc=new Scanner(new File("file.txt"));
                   int vertex=sc.nextInt();
                   System.out.println(vertex);
                   a=new Node[vertex+1];
                   color=new int[a.length];
                   prev=new int[a.length];
                   d=new int[a.length];
                   f=new int[a.length];
                   //parent=new int[a.length];
                   for(int i=0;i<=a.length-1;i++)
        {
          a[i]=new Node(i,null);
        }
                    while(sc.hasNextLine())
        {
          v1=Integer.parseInt(sc.next());
//          System.out.print(v1+" ");
          v2=Integer.parseInt(sc.next());
//          System.out.print(v2);
//          System.out.println();
        add(v2);//
        
      }
         for(int i=0;i<a.length;i++)
       {
           for(Node n=a[i];n!=null;n=n.next)
           {
               System.out.print(n.value+" ");
           }
           System.out.println();
       }   

        DFS(a,1);
        for(int i=1;i<=a.length-1;i++)
        {
           System.out.println("For "+i+": "+"Starting Time: "+d[i]+" Ending Time: "+f[i]);
        }
        System.out.println("Number of connected components: "+connectedComponents);
        Scanner k=new Scanner(System.in);
        System.out.println("Input for choosing destination");
        int destination=k.nextInt();
        int x=destination;
        System.out.println("Path of destination "+destination+", from destination to source :");
        //int c=1;
        //Printing Path
        Stack st = new Stack();
        while(x!=1)
        {
            //System.out.print(prev[x]+" ");
            if(x==-1)
            {
                break;
            }
            st.push(new Integer(x));//pushing on built in stack
            System.out.print(x+" ");
            x=prev[x];
        }
        //System.out.print("1");
        System.out.println();
        System.out.println("Path of destination "+destination+", from source to destination :");
        while ( !st.empty() )//printing from stack
                {
                        System.out.print ( st.pop()+" " );
                        //System.out.print ( ',' );
                }
        System.out.println();
          }
          catch(Exception e)
                    {
                        e.printStackTrace();
                    }
        
    }
    public static void DFS(Node [] G,int s)//G=node array, s=source node
    {
        //initialization
        for(int u=1;u<=G.length-1;u++)//v will change 
        {
            color[u]=1;//white
            prev[u]=-1;//null
            f[u]=4543352;//infinity
            d[u]=45472147;//infinity
        }
        time=0;
        connectedComponents=0;
        for(int u=1;u<=G.length-1;u++)//v will change 
        {
            if(color[u]==1)
            {
                DFS_Visit(u);
                connectedComponents++;
            }
        }
    }
    public static void DFS_Visit(int u)
    {
        color[u]=2;//Grey
        time=time+1;
        d[u]=time;
        for(Node n=a[u];n!=null;n=n.next)//Node n=a[u];n!=null;n=n.next
        {
            if(color[n.value]==1)
            {
                prev[n.value]=u;
               DFS_Visit(n.value);
            }
        }
        color[u]=3;
        time=time+1;
        f[u]=time;
    }
    public static void add(int v)
      {
        Node n1=new Node(v,null);
        Node tail=a[v1];
        for(Node n=tail;n!=null;n=n.next)
        {
          tail=n;
        }
        tail.next=n1;
      }
}
