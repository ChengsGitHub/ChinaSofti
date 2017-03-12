


public class Task3 {
	public static void main(String[] args) {
		int [] [] a=new int [10][10];
		for (int i=0;i<a.length;i++){
			for (int j=0;j<=i;j++){
				if (i==j || j==0){
					a[i][j]=1;
				}else{
					a[i][j]=a[i-1][j]+a[i-1][j-1];
				}
			}
		}
		for (int p=0;p<a.length;p++){
			for (int q=0;q<=p;q++){
				System.out.print(a[p][q]+"\t");
			}
			System.out.println();
		}
	}
}
