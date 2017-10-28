import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 10/28/2017.
 */

public class Main {
    public static void main (String[] args) {

        Map<String, String> keywords = new HashMap<String, String>();
        keywords.put("for", "оператор цикла");
        keywords.put("(", "открывающаяся скобка");
        keywords.put(")", "закрывающаяся скобка");
        keywords.put(";", "точка с запятой");
        keywords.put("do", "оператор цикла");
        keywords.put("<", "знак сравнения");
        keywords.put(">", "знак сравнения");
        keywords.put("=", "знак сравнения");
        keywords.put(":=", "знак присваивания");
        keywords.put("+", "знак сложения");

        String row = "for ( a := 6.55 ; a < 8 ; a := a + 1 ) do";


        System.out.println(row);
        String[] row_pars = row.split(" ");
        for (int i = 0; i < row_pars.length; i++){
            System.out.print(row_pars[i]);

            if (keywords.get(row_pars[i])!=null) {
                System.out.println("\t\t\t" +keywords.get(row_pars[i]));
            }

            else {
                if(analize(row_pars[i])!=null) {
                    System.out.println("\t\t\t" +analize(row_pars[i]));
                }
                else {
                    System.out.println();
                }
            }




        }
    }
    public static String analize(String row){
        String type = null;
        char[] massive = row.toCharArray();
        for(int i=0; i < massive.length; i++){
            if (massive[i]=='.') {
                type = "число с плавающей точкой";
                break;
            }
            else{
                if ((massive[i]>='a' && massive[i]<='z')||(massive[i]>='A' && massive[i]<='Z') ) {
                    type = "переменная";
                    break;
                }
                else{
                    if (massive[i]>='0' && massive[i]<='9'){
                        type = "целое число";
                    }
                }

            }
        }
        return type;
    }
}
