package problem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DecryptInputStreamTest {
	private SubstitutionCipher substitutionCipher;

	@Before
	public void setUp() throws Exception {
		this.substitutionCipher = new SubstitutionCipher();
	}

	@After
	public void tearDown() throws Exception {
		this.substitutionCipher = null;
	}

	@Test
	public final void testRead() throws IOException {
		byte[] data = "A random string".getBytes();
		byte[] encryptedData = new byte[data.length];

		for (int i = 0; i < data.length; i++) {
			encryptedData[i] = (byte) this.substitutionCipher
					.encrypt((char) data[i]);
		}

		InputStream input = new ByteArrayInputStream(encryptedData);
		DecryptInputStream in = new DecryptInputStream(input,
				this.substitutionCipher);

		char actual;

		for (int i = 0; i < data.length; i++) {
			actual = (char) in.read();
			assertEquals("chars are not the same", actual, data[i]);
			// System.out.println("actual: " + actual + " and expected: " + data[i);
		}
	}

	@Test
	public final void testReadByte() throws IOException {
		byte[] data = "A random string".getBytes();
		byte[] encryptedData = new byte[data.length];

		for (int i = 0; i < data.length; i++) {
			encryptedData[i] = (byte) this.substitutionCipher
					.encrypt((char) data[i]);
		}

		InputStream input = new ByteArrayInputStream(encryptedData);
		DecryptInputStream in = new DecryptInputStream(input,
				this.substitutionCipher);

		in.read(encryptedData);

		for (int i = 0; i < data.length; i++) {
			assertEquals("chars are not the same", encryptedData[i], data[i]);
			// System.out.println("actual: " + encryptedData[i] + " and expected: " + data[i]);
		}
	}

	@Test
	public final void testReadByteAtOffToLen() throws IOException {
		byte[] data = "A random string".getBytes();
		byte[] encryptedData = new byte[data.length];

		for (int i = 0; i < data.length; i++) {
			encryptedData[i] = (byte) this.substitutionCipher
					.encrypt((char) data[i]);
		}

		InputStream input = new ByteArrayInputStream(encryptedData);
		DecryptInputStream in = new DecryptInputStream(input,
				this.substitutionCipher);

		int off, len;
		off = 0;
		len = 10;

		in.read(encryptedData, off, len);

		for (int i = off; i < off + len; i++) {
			assertEquals("chars are not the same", encryptedData[i], data[i]);
			// System.out.println("actual: " + encryptedData[i] + " and expected: " + data[i]);
		}
	}

}
