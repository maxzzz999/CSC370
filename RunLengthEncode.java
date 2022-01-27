/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runlengthencode;
import java.util.*;
/**
 *
 * @author max-maryzorblewu
 */
public class RunLengthEncode {
    public static String encode(String input){
        String output = "";
        String encode = "";
        for (int i = 0; i < input.length(); i++) { 
            int count = 1;
            while(i + 1 < input.length() && input.charAt(i) == input.charAt(i+1)){
                count++;
                i++;
            }
                if(count <10){
                    encode = "/0" + count + input.charAt(i);
                }
                else{
                    encode = "/" + count + input.charAt(i);
                }
                
                if(count>4){
                output += encode;
                }
                else{
                    for(int j = 0; j<count;j++)
                    output += input.charAt(i);
                }
        }
        return output;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String input1;   
        boolean rightInput = false;
        do{
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your input: ");
        input1  = myObj.nextLine();
        System.out.println();
        for(int i = 0; i < input1.length();i++){
            if((input1.charAt(i) >= '0' && input1.charAt(i) <= '9')|| (input1.charAt(i) >= 'a' && input1.charAt(i) <= 'z')|| (input1.charAt(i) >= 'A' && input1.charAt(i) <= 'Z')|| input1.charAt(i) == '{' || input1.charAt(i) == '}'|| input1.charAt(i) == '.' || input1.charAt(i) == ',' || input1.charAt(i) == '(' || input1.charAt(i) == ')' || input1.charAt(i) == '[' || input1.charAt(i) == ']' || input1.charAt(i) == ':' || input1.charAt(i) == ';'|| input1.charAt(i) == '\'' || input1.charAt(i) == '+' || input1.charAt(i) == '='){
                rightInput = true;
            }
        }
        }while(rightInput == false);
        
        System.out.println(encode(input1));
    }
    
}
