package ru.itis.stroki;

public class ex249 {
    public static void main(String[] args) {
        String str = "лололо 15 + 3 лололол 7 - 5 лололо лололо 6 * 2 лололо  длдлд 10 / 3 длдлдл ";
        String[] arr = str.split(" ");
        double t;
        for (int i = 1; i < arr.length - 1; i++) {
            switch (arr[i]){
                case "+":
                    t = Double.parseDouble(arr[i - 1]) + Double.parseDouble(arr[i + 1]);
                    System.out.println(arr[i-1] + arr[i] + arr[i + 1] + " = " + t );
                    break;
                case "-":
                    t = Double.parseDouble(arr[i - 1]) - Double.parseDouble(arr[i + 1]);
                    System.out.println(arr[i-1] + arr[i] + arr[i + 1] + " = " + t );
                    break;
                case "*":
                    t = Double.parseDouble(arr[i - 1]) * Double.parseDouble(arr[i + 1]);
                    System.out.println(arr[i-1] + arr[i] + arr[i + 1] + " = " + t );
                    break;
                case "/":
                    t = Double.parseDouble(arr[i - 1]) / Double.parseDouble(arr[i + 1]);
                    System.out.println(arr[i-1] + arr[i] + arr[i + 1] + " = " + t );
                    break;

            }
        }
    }
}
