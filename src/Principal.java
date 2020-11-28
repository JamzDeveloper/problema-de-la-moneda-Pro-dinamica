
import javax.swing.JOptionPane;



/**
 *
 * @author jamz
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int monedas[] = {0,1,3,4,5};
         String respuesta = null;
        int moneda;
        Vuelto vuelto = new Vuelto(monedas.length, monedas);
        int matris[];
        String variable;
        
        
        
        
    do{
       
        moneda =Integer.parseInt(JOptionPane.showInputDialog("ingrese su moneda"));
         
        matris = new int[moneda];
        matris = vuelto.getDarVuelto(moneda+1);
        System.out.println("\n");
        variable = vuelto.mostrarTabla()+"\n"+"MONEDAS PARA EL VUELTO DE: "+moneda+"\n";
        System.out.println(variable);
        
        for(int i=0;i<matris.length;i++){
            variable += monedas[i]+"->"+ matris[i]+"\n";
        }
        
        respuesta = JOptionPane.showInputDialog(variable+"\ndesea seguir preguntado");
       //limpia la matris
        for(int i=0;i<matris.length;i++){
            matris[i] = 0;
        }
        
    }while(!"no".equals(respuesta));
    
    
    
    
    
    
    }
    //;
   
    
   
}
