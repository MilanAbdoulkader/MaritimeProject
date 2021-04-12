package test;

public class test {
    public static void main(String[] Args){
        int[][] tab ={{12,34},{21,43}};
        for (int[] values: tab){
            for(int v: values){
                System.out.println(v+"\t");
            }
        }
    }
}
