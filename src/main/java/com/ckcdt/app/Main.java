package com.ckcdt.app;
import java.io.*;
public class Main {
    
    public static String fileToStr(String filename) throws IOException{
        String retString = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("resources/"+filename));
            String line = br.readLine();
            line = br.readLine();
            while (!line.isEmpty()){
                line = line.concat("\n");
                retString = retString.concat(line);
                
                line = br.readLine();
            }
            br.close();
        
        }
        catch(Exception e){
            throw e;
        }
        return retString;
    }


    public static void printMatrix(String[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");  
            }
            System.out.println();
        }
    }

    public static void printArray(double[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);

        }
    }

    public static double potency(double base, int exponent){
        double product = 1;
        for(int i = 0; i < exponent; i++){
            product *= base;
        }
        return product;
        
    }

    public static double round(double number, int decimals){
        
        double temp1 = number * potency(10, decimals + 1);
        int temp2 = (int)temp1;
        boolean roundUp = temp2 % 10 >= 5;
        if(roundUp){
            temp2 += 10 - temp2 % 10;
        }
        else{
            temp2 -= temp2 % 10;
        }

        return temp2/potency(10, decimals + 1);
    }
    
    public static String output(String input) throws IOException {
        if(input == ""){
            return "";
        }
        String ret = "";
        
        String[] rows = input.split("\n");

        String [][] matrix = new String[rows.length][4];
        for(int i = 0; i< rows.length; i++){
            boolean open = false;
            for(int j = 0; j < rows[i].length(); j++){
                if(rows[i].charAt(j) == '\"'){
                    open = !open;
                }
                if(open && rows[i].charAt(j) == ','){
                    rows[i] = rows[i].substring(0,j).concat("&").concat(rows[i].substring(j+1, rows[i].length()));
                }
            }
            matrix[i] = rows[i].split(",");
        }
        

        
        double[] U = new double[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            U[i] = Double.parseDouble(matrix[i][1]);
        }

        
        double[] b = new double[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            b[i] = Double.parseDouble(matrix[i][2])/100/12;
        }



        int[] p = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            p[i] = Integer.parseInt(matrix[i][3])*12;
        
        }


        String[] name = new String[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            name[i] = (String)matrix[i][0];
        }


        for(int i = 0; i < U.length; i++){
           ret = ret.concat("Customer " + name[i] + " wants to borrow " + U[i] + "e for a period of " + p[i] / 12 + " years and wants to pay " + round(U[i]*(b[i]*potency((1 + b[i]),p[i]))/(potency((1 + b[i]), p[i]) - 1), 2) + "e each month. \n");
        }
        return ret;
    
    }

    public static String initiate(){
        try{        
            return fileToStr("prospects.txt");
        }
        catch(Exception e){
            System.out.println(e);
            return "";
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println(output(fileToStr("prospects.txt")));
    }
}
