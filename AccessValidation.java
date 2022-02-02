import java.util.Scanner;
public class AccessLevel{

    public static String validateAccess(int [] users, int permission){
        String accessValidation= "";
        for(int i = 0; i < users.length; i++){
            if(users[i] < permission){
                accessValidation += "D";
            }
            else{
                accessValidation += "A";
            }
        }
        return accessValidation;
    }
    
    public static void main(String args[]) {
        int userMaxSize = 0;
        boolean isMaxSize = false;
        System.out.println();
        System.out.println("Enter number of users: ");
        do{
            Scanner myObj = new Scanner(System.in);
            userMaxSize = myObj.nextInt();
                if(userMaxSize >= 0 && userMaxSize <=50){
                    isMaxSize = true;
                }
                else{
                    System.out.println("Invalid input, please enter a valid value: ");
                }               
        }while(isMaxSize == false);
        int [] rights = new int[userMaxSize];
        boolean isElement = false;
        for(int i=0; i < rights.length; i++){
            System.out.println();
            System.out.println("Enter your input: "); 
            Scanner myObj2 = new Scanner(System.in);
            int temp;
            do{              
                temp  = myObj2.nextInt();
                if (temp >= 0 && temp<=100){
                   isElement = true; 
                }
                else{
                    System.out.println("Invalid input, please enter a valid value: ");
                }              
            }while(isElement == false);
            
            rights[i] = temp;
        }
        int minPermission = 0;
        boolean isMinPermission = false;
        System.out.println();
        System.out.println("Enter your minimum access requirement: ");
        do{
            Scanner myObj3 = new Scanner(System.in);
            minPermission  = myObj3.nextInt();
            if(minPermission >= 0 && minPermission <= 100){
               isMinPermission = true;     
            }
            else{
                System.out.println("Invalid input, please enter a valid value: ");
            }            
        }while(isMinPermission == false);
        System.out.println();
        System.out.println(validateAccess(rights, minPermission));
    }
}