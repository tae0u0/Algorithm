import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            sb.append(c);
            if(c == bomb.charAt(bomb.length()-1) && sb.length() >= bomb.length()) {
                if(sb.substring(sb.length() - bomb.length(), sb.length()).equals(bomb)) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        if (sb.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
