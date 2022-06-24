
package desafiofibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class DesafioFibonacci {

    public static void main(String[] args) {
        ArrayList<Integer> sF = new ArrayList();
        
        int a = 0, b=1, aux;
        Scanner input = new Scanner(System.in);
        System.out.println("Entre com um numero:");
        int num = input.nextInt();
        
        for(int i = 0; i <= num+2; i++){
            sF.add(a);
            aux = a;
            a = a + b;
            b = aux;
        }
        if(sF.contains(num)){
            System.out.println("O número "+num+" está contido na sequência.");
        }else
            System.out.println("O número "+num+" não está contido na sequência.");
    }
    
}
