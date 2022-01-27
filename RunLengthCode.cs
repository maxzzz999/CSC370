using System;
					
public class RunLengthCode
{
	public static string encode(string input){
        string output = "";
        string encode = "";
        for (int i = 0; i < input.Length; i++) { 
            int count = 1;
            while(i + 1 < input.Length && input[i] == input[i+1]){
                count++;
                i++;
            }
                if(count <10){
                    encode = "/0" + count + input[i];
                }
                else{
                    encode = "/" + count + input[i];
                }
                
                if(count>4){
                	output += encode;
                }
                else{
                    for(int j = 0; j<count;j++)
                    output += input[i];
                }
        }
        return output;
    }
	public static void Main()
	{
		string input1 = "";
		bool rightInput = false;
		do{
			Console.WriteLine("Enter your input");
			input1 = Console.ReadLine();
			for(int i = 0; i < input1.Length;i++){
            	if((input1[i] >= '0' && input1[i] <= '9')|| (input1[i] >= 'a' && input1[i] <= 'z')|| (input1[i] >= 'A' && input1[i] <= 'Z')|| input1[i] == '{' || input1[i] == '}'|| input1[i] == '.' || input1[i] == ',' || input1[i] == '(' || input1[i] == ')' || input1[i] == '[' || input1[i] == ']' || input1[i] == ':' || input1[i] == ';'|| input1[i] == '\'' || input1[i] == '+' || input1[i] == '='){
                rightInput = true;
            }
        }
		}while(rightInput == false);
		
		Console.WriteLine(encode(input1));
	}
}