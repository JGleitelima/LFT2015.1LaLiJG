package mongo.main;

public class MongoTeste {
	public static void main(String[] args) {
		args = new String[2];
    	//args[0] = "test/in2.mon";
		//args[1] = "test/out.txt";
		Main c = new Main();
		c.compilar("test/in1.mon");
	}
}
