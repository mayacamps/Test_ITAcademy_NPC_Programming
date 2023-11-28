import java.util.InputMismatchException;
import java.util.Scanner;

public class Readers {
    static Scanner en = new Scanner(System.in);
    public static int readInt(String message) {
        int res;
        while (true){
            System.out.println(message);
            try {
                res = en.nextInt();
                en.nextLine();
                return res;
            } catch (InputMismatchException e) {
                System.err.println("Format error.");
                en.nextLine();
            }
        }
    }

    public static String readString(String message){
        while (true){
            String s;
            try {
                System.out.println(message);
                s = en.nextLine();
                boolean allDigits = true;
                for(int i = 0; i < s.length(); ++i) {
                    char c = s.charAt(i);
                    if(Character.isAlphabetic(c)){
                        allDigits = false;
                    }
                }
                if(allDigits){
                    throw new Exception();
                }
                return s;
            }
            catch(Exception ex) {
                System.err.println("Format error.");
            }
        }
    }
    public static boolean readYesNo(String message){
        String s;
        while (true){
            try {
                s = readString(message);
                if (s.equalsIgnoreCase("yes")){
                    return true;
                } else if (s.equalsIgnoreCase("no")){
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e){
                System.err.println("Please answer with yes/no");
            }
        }
    }
}
