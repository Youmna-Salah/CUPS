
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.FileWriter;


public class AP {

	public static void main(String[] args) {

		String inFile = "../Go/MS2/Go3.in";
		String outFile = "../Go/MS2/Go11.out";
		if (args.length > 1) {
			inFile = args[0];
		}

		try {

			FileReader fis = new FileReader(inFile);
			BufferedReader bis = new BufferedReader(fis);

			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

			@SuppressWarnings("deprecation")
			parser parser = new parser(new Lexer(bis));
			try {
				parser.parse();
				writer.write("Done");
				 System.out.println("DONE");
			} catch (Exception e) {
				e.printStackTrace();
				writer.write("ParseError");
			}

			fis.close();
			bis.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
