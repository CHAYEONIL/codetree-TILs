import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ans = "";
        String ans2 = "";

        String a = br.readLine();
        String b = br.readLine();

        if(a.charAt(0)==0){
            ans ="1"+a.substring(1);
            System.out.print(Integer.parseInt(ans,2));
            return;
        }
        if(b.charAt(0)==0){
            ans2 ="1"+b.substring(1);
            System.out.print(Integer.parseInt(ans,3));
            return;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<a.length();i++){
            int ch = a.charAt(i);
            if(ch=='0'){
                ans = a.substring(0,i)+"1"+a.substring(i+1);
                arr.add(Integer.parseInt(ans,2));
            }
            else{
                ans = a.substring(0,i)+"0"+a.substring(i+1);
                arr.add(Integer.parseInt(ans,2));
            }
        }
        for(int j=0;j<b.length();j++){
            int ch = b.charAt(j);
            if(ch=='0'){
                ans2 = b.substring(0,j)+"1"+b.substring(j+1);
                if(arr.contains(Integer.parseInt(ans2,3))){
                    System.out.println(Integer.parseInt(ans2,3));
                    return;
                }
                ans2 = b.substring(0,j)+"2"+b.substring(j+1);
                if(arr.contains(Integer.parseInt(ans2,3))){
                    System.out.println(Integer.parseInt(ans2,3));
                    return;
                }
            }
            else if(ch=='1'){
                ans2 = b.substring(0,j)+"0"+b.substring(j+1);
                if(arr.contains(Integer.parseInt(ans2,3))){
                    System.out.println(Integer.parseInt(ans2,3));
                    return;
                }
                ans2 = b.substring(0,j)+"2"+b.substring(j+1);
                if(arr.contains(Integer.parseInt(ans2,3))){
                    System.out.println(Integer.parseInt(ans2,3));
                    return;
                }
            }
            else{
                ans2 = b.substring(0,j)+"1"+b.substring(j+1);
                if(arr.contains(Integer.parseInt(ans2,3))){
                    System.out.println(Integer.parseInt(ans2,3));
                    return;
                }
                ans2 = b.substring(0,j)+"0"+b.substring(j+1);
                if(arr.contains(Integer.parseInt(ans2,3))){
                    System.out.println(Integer.parseInt(ans2,3));
                    return;
                }
            }
        }
    }
}