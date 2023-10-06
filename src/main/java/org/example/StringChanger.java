package org.example;

import java.util.Scanner;

public class StringChanger {
    private String initialString;


    private void setInitialString(String initialString) {
        this.initialString = initialString;
    }

    public void inputInitialString(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input initial string: ");
        setInitialString(in.nextLine());
        in.close();
    }

    public String convertString() {

        char c;
        boolean isUpper = false;
        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i < initialString.length(); i++){
            c = initialString.charAt(i);
            if (Character.isLetter(c)){
                if (isUpper) resultStr.append(Character.toUpperCase(c));
                else resultStr.append(Character.toLowerCase(c));
                isUpper = !isUpper;
            }
            else {
                resultStr.append(c);
            }
        }
        return resultStr.toString();
    }
    public void printResult(String string){
        System.out.println("Resulted string: "+string);
    }
}
