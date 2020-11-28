
import javax.swing.JOptionPane;


/**
 *
 * @author jamz
 */
public class Vuelto {
    
    private int monedas[];
    private int tabla[][];
    private int respuesta[];
    private int numeroMonedas = 0;
    private int calculo = 0;
    
    
    
    public Vuelto(int i,int monedas[]){
    this.respuesta = new int[i];
     this.monedas = new int[i];   
     this.monedas = monedas;   
     this.numeroMonedas = i;
    
  
     this.tabla = new int[this.numeroMonedas][0];
     rellenar(0);
     
    }
    
   public void rellenar(int cantidadVuelto){
       
      
       for(int i = 0 ;i<this.numeroMonedas;i++){
           for(int j = 0;j<cantidadVuelto;j++){
               tabla[i][j]=0;
               if(i==0 && j>0){
                 
                   tabla[i][j]=999;
               }
               
           }
           respuesta[i]=0;
       }
      
       
   }
   
   
   
   public String mostrarTabla(){
       String respuesta="\tTABLA\n";
       for(int i = 0;i < numeroMonedas; i++){
           for(int j = 0; j < calculo; j++){
               respuesta += tabla[i][j]+"       ";
               if(i!=0){
                   respuesta +="    ";
               }
           }
           respuesta += "\n";
       }
       return respuesta;
   }
   
   
   
   public int[] getDarVuelto(int dinero){
         
       if(dinero <=calculo){
           darVuelto(dinero);
           JOptionPane.showMessageDialog(null,"se esta tomando los datos guardados");
           
       }else{
           JOptionPane.showMessageDialog(null,"calculando para la moneda dada");
      this.tabla = new int[this.numeroMonedas][dinero];  
            rellenar(dinero);
           calcularVuelto(dinero,dinero);
           darVuelto(dinero);
           calculo = dinero;
       }
       return respuesta;
     } 
   
   
   //llena la matriz para luego dar la respuesta
   public void calcularVuelto(int dinero,int cantidadVuelto){
       System.out.println("esta que calcula");
       
     //la variable calculo se encarga de retener el ultimo valor
   //del calculo que hizo el programa para no volver ha realizar
      
       
       for(int i=0; i<this.numeroMonedas;i++){
           for(int j=1;j<cantidadVuelto;j++){
               if(i!=0){
               if(this.monedas[i]>j){
                 //  System.out.println("ingreso ah la condicion");
                   //System.out.println("llego ah primera regla");
                  this.tabla[i][j] = this.tabla [i-1][j];
                  
                   
               }else{
                   
                   if(this.monedas[i] <= j){
                       this.tabla[i][j] = min(i, j);
                   }
               }
           }
               
           }
           
       }
       
       
       
   }
   public int min(int i,int j){
       
       int respuesta = 0;
       int var1 = 0;
       int var2 = 0;
       int aux = this.monedas[i];
       //System.out.println(this.tabla[i][j]);
       var1 = this.tabla[i-1][j];
       var2 = this.tabla[i][j-aux]+1;
       if(var1<=var2){
           respuesta = var1;
       }else{
           respuesta = var2;
       }
       
       return respuesta;
   } 
   
   public int[] darVuelto(int dinero){
       
       int i = this.numeroMonedas-1;
       int j = dinero-1;
       while(j != 0){
          
          if(i>1 && tabla[i][j]==tabla[i-1][j]){
              i=i-1;
          }else{
              respuesta[i] = respuesta[i]+1;
              j = j-monedas[i];
              
            } 
         
          
           
       }
          
       return respuesta;
   } 
    
}
