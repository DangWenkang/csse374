package problem;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {

	private SubstitutionCipher cipher;

	public EncryptOutputStream(OutputStream out, SubstitutionCipher cipher) {
		super(out);
		this.cipher = cipher;
	}

	@Override
	public void write(int b) throws IOException {
		char c = this.cipher.encrypt((char) b);
		super.write(c);
	}

	@Override
	public void write(byte[] b) throws IOException {
		int length = b.length;

		for (int i = 0; i < length; i++) {
			b[i] = (byte) this.cipher.encrypt((char) b[i]);
		}

		super.write(b);
	}

}
