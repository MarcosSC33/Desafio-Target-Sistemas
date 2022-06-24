
package faturamento;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Faturamento {

    public static void main(String[] args) throws Exception {
        int cont = 0;
        JSONParser jp = new JSONParser();
        ArrayList<Float> listaV = new ArrayList();
        
        try(FileReader reader = new FileReader("dados.json")){
            Object obj = jp.parse(reader);
            JSONArray lista = (JSONArray) obj;
            lista.forEach(l -> {
                listaV.add(obtemValor((JSONObject) l));
            });
            for(Float v : listaV){
                if(v == 0.0){
                    cont++;
                }
            }
            calculaValores(listaV,cont);
        }catch(Exception e){
            
        } 
        
    }
    
    public static float obtemValor(JSONObject valor){
        float x =  Float.parseFloat(valor.get("valor").toString());
        return x;
    }
    
    public static void calculaValores(ArrayList<Float> aValores, int cont){
        JSONObject dia = null;
        Iterator<Float> it = aValores.iterator();
        
        float aux = 0;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        int contaValores = 0;
        int indiceMax = 0;
        int indiceMin = 0;
        
        
        for(int i = 0; i < aValores.size(); i++){
            aux += aValores.get(i);
            if(aValores.get(i) > max){
                max = aValores.get(i);
                indiceMax = i;
            }
            if(aValores.get(i) != 0){
                if(aValores.get(i) < min){
                    min = aValores.get(i);
                    indiceMin = i;
                }
            }
            
        }
        float media = aux/((aValores.size())-cont);
        
        for(int i = 0;i < aValores.size();i++){
            if(aValores.get(i) > media){
                contaValores++;
            }
        }
        
        while(it.hasNext()){
            Float v = it.next();
            if(v == 0){
                it.remove();
            }
        }
        
        System.out.println("O maior valor é: " +max + " no dia: " +(indiceMax+1));
        System.out.println("O menor valor é: " +min + " no dia: " +(indiceMin+1));
        System.out.println("O valor da média mensal de "+media+ " é ultrapassado em "+contaValores+" dias");
    }
}
