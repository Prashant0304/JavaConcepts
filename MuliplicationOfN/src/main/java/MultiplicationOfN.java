import java.util.Scanner;
class MultiplicationOfN{
    public static void main(String args[]){
        System.out.print("Enter the value of N value");
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=1;i<10;i++){
            System.out.print(n*i +" ");
        }
    }
}