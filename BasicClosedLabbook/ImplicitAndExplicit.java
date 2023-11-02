package BasicClosedLabbook;

public class ImplicitAndExplicit {
public static void main(String[] args) {
	byte a=10;
	System.out.println(a);
	short b=a;
	System.out.println(b);
	int c=b;
	System.out.println(c);
	float d=c;
	System.out.println(d);
	double e=d;
	System.out.println(e);
	double b1=12;
	System.out.println(b1);
	float c1=(float)b1;
	System.out.println(c1);
	int d1=(int)c1;
	System.out.println(d1);
	short e1=(short) (d1);
	System.out.println(e1);
	byte f1=(byte)e1;
	System.out.println(f1);
}
}
