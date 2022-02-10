import java.util.*;

public class Dirsort {
    
    public static String [] dirSort(String [] dirs){
        int precLength = dirs.length;
        int[] precedence = new int[precLength];
        
        for(int i = 0; i < dirs.length; i++){
            int count = 0;
            for(int j = 0; j <dirs[i].length();j++){
                if(dirs[i].charAt(j) == '/'){
                    count+=1;
                }
            }
            precedence[i] = count;
        }
 
        for (int i = 0; i < precLength-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < precLength; j++)
                if (precedence[j] < precedence[minIndex])
                    minIndex = j;
            
            int temp = precedence[minIndex];
            String temp2 = dirs[minIndex];
            precedence[minIndex] = precedence[i];
            dirs[minIndex] = dirs[i];
            precedence[i] = temp;
            dirs[i] = temp2;
        }
        int i = 0;
        int j = i+1;

        for (i = 0; i< precLength && j < precLength ;i++){
            if(dirs[i].compareToIgnoreCase(dirs[j])> 0 && precedence[i] == precedence[j] ){
                if(dirs[i].contentEquals(dirs[j]) == false){
                    
                }
                String temp = dirs[i];
                dirs[i] = dirs[j];
                dirs[j] = temp;
            }
            j++;
        }
        
        return dirs;
    }
    public static void inputValidation(String [] valArr){
        
        boolean isValidLength = false;
        if (valArr.length >= 1 && valArr.length <= 50){
            isValidLength = true;
        }
        else{
            System.out.println(" Array length is invalid");
            System.exit(0);
        }
        
        boolean isValidStrLength = false;
        
        for(int i = 0; i < valArr.length; i++){
            if (valArr[i].length() >= 1 && valArr[i].length() <= 50){
                isValidStrLength = true;
            }
            else{
                System.out.println(" Array element length is invalid");
                System.exit(0);
            }
        }
        
        boolean isValidChar = false;
        
        for(int i = 0; i < valArr.length; i++){
            for(int j = 0; j < valArr[i].length();j++){
                if (Character.isLowerCase(valArr[i].charAt(j)) || valArr[i].charAt(j) == '/'){
                    isValidChar = true;
                }
                else{
                    System.out.println(" Character within string is invalid");
                    System.exit(0);
                }
            }
        }
   
        boolean isValidFormat = false;
        
        for(int i = 0; i < valArr.length; i++){
            if (valArr[i].charAt(0) == '/' &&  valArr[i].charAt(valArr[i].length()-1) == '/'){
                isValidFormat = true;
            }
            else{
                System.out.println(" Array format is invalid");
                System.exit(0);
            }
        }       
        
        if (isValidLength == true && isValidStrLength == true && isValidChar == true && isValidFormat == true){
            printArr(dirSort(valArr));
        }
    }
    public static void printArr(String [] dirs2){
        for (int i = 0; i < dirs2.length;i++){
            System.out.println(dirs2[i]);
        }
        System.out.println();
    }
    public static void main(String args[]) {
        String [] test1 = {"/","/usr/","/usr/local/","/usr/local/bin/","/games/","/games/snake/","/homework/","/temp/downloads/"};
        String [] test2 = {"/usr/","/usr/local/","/bin/","/usr/local/bin/","/usr/bin/","/bin/local/","/bin/local/"};
        String [] test3 = {"/","/a/","/b/","/c/","/d/","/e/","/f/","/g/"};
        String [] test4 = {"/","/a/","/b/","/c/","/d/","/e/","/f/","/g/","/a/a/","/b/g/c/","/g/f/"};
        String [] test5 = {"/a/b/c/d/e/f/g/h/i/j/k/l/m/n/","/o/p/q/r/s/t/u/v/w/x/y/z/"};
        String [] test6 = {"/a/b/","/ab/cd/","/c/d/","/a/b/c/","/ab/c/d/","/a/bc/d/", "/a/b/cd/"};
                      
        inputValidation(test1);
        inputValidation(test2);
        inputValidation(test3);
        inputValidation(test4);
        inputValidation(test5);
        inputValidation(test6);
        
    }
}
