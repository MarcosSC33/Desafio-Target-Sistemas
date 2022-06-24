
package desafiopercentua;

import java.util.ArrayList;

public class DesafioPercentua {

   
    public static void main(String[] args) {
        ArrayList<Float> faturamento = new ArrayList();
        float aux = 0;
        
        faturamento.add((float)67836.43);
        faturamento.add((float)36678.66);
        faturamento.add((float)29229.88);
        faturamento.add((float)27165.48);
        faturamento.add((float)19849.53);
        
        float sp = faturamento.get(0);
        float rj = faturamento.get(1);
        float mg = faturamento.get(2);
        float es = faturamento.get(3);
        float outros = faturamento.get(4);
        
        for(float f : faturamento){
            aux += f;
        }
        
        float media = aux/faturamento.size();
        
        System.out.println("O valor da media mensal foi de "+media);
        System.out.println("O estado de São Paulo obteve "+calculaPorcentagem(media,sp)+"% do valor mensal");
        System.out.println("O estado do Rio de Janeiro  obteve "+calculaPorcentagem(media,rj)+"% do valor mensal");
        System.out.println("O estado de Minas gerais obteve "+calculaPorcentagem(media,mg)+"% do valor mensal");
        System.out.println("O estado de Espiríto Santo obteve "+calculaPorcentagem(media,es)+"% do valor mensal");
        System.out.println("Os outros estados obtiveram "+calculaPorcentagem(media,outros)+"% do valor mensal");
    }
    
    public static float calculaPorcentagem(float m, float f){
        float fat = (f*100)/m;
        return fat;
    }
    
}
