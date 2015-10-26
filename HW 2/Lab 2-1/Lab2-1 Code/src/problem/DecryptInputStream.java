package problem;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {

	private SubstitutionCipher cipher;

	protected DecryptInputStream(InputStream in, SubstitutionCipher cipher) {
		super(in);
		this.cipher = cipher;
	}

	@Override
	public int read() throws IOException {
		int c = super.read();

		if (c == -1) {
			return c;
		}

		return this.cipher.decrypt((char) c);
	}

	@Override
	public int read(byte[] b) throws IOException {
		int total = super.read(b);

		read(b, 0, total);

		return total;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int total = super.read(b, off, len);

		for (int i = off; i < off + total; i++) {
			if (b[i] != -1) {
				b[i] = (byte) this.cipher.decrypt((char) b[i]);
			}
		}

		return total;
	}

}
