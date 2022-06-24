
package invertestring;

import java.util.ArrayList;
import java.util.Scanner;

public class InverteString {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        ArrayList<String> inverteString = new ArrayList();
        
        System.out.println("Insira uma palavra:");
        String string = input.nextLine();
        
        String[] recebeString = string.split("");
        
        for(int i = (recebeString.length - 1); i >= 0; i--){
            inverteString.add(recebeString[i]);
        }
        
        String converteString = String.join(" ", inverteString);
        System.out.println("O inverso de " +"'"+string+"'"+" é: "+converteString);
    }
    
}
