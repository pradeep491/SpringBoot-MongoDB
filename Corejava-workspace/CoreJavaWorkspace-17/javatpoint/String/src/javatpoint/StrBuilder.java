package javatpoint;

public class StrBuilder {
public static void main(String[] args) {
	StringBuilder sb1 = new StringBuilder("Sachin ");
	StringBuilder sb2 = new StringBuilder("Tendulkar");
	StringBuilder s3 = sb1.append(sb2);
	System.out.println(s3);
}
}
