package problem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import edu.roshulman.csse374.editor.TextEditor;

public class TextEditorApp {
	public static void main(String[] args) throws Exception {
		
		SubstitutionCipher cipher = new SubstitutionCipher();
		
		// F1
		InputStream in = new FileInputStream("./input_output/in.txt");
		OutputStream out = new FileOutputStream("./input_output/out.txt");
		EncryptOutputStream encryptedOut = new EncryptOutputStream(out, cipher);
		
		TextEditor editor = new TextEditor(in, encryptedOut);
		editor.execute();
		
		// F2
		InputStream encryptedFile = new FileInputStream("./input_output/out.txt");
		OutputStream out2 = new FileOutputStream("./input_output/out2.txt");
		DecryptInputStream decryptedIn = new DecryptInputStream(encryptedFile, cipher);
		
		TextEditor editor2 = new TextEditor(decryptedIn, out2);
		editor2.execute();
		
	}	
}
