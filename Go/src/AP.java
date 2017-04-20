
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java_cup.Lexer;
import java_cup.runtime.Symbol;


public class AP {

	public static void main(String[] args) {

		String inFile = "../Go/MS2/Go1.in";
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
			System.out.println( parser.equals(null));

			try {
				Symbol res = parser.parse();
				String value = (String)res.value;
				writer.write(value);
				writer.write("Done");
				System.out.println("DONE");
			} catch (Exception e) {
				System.out.println("error");

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
