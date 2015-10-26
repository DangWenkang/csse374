package problem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EncryptOutputStreamTest {
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
	public final void testWrite() throws IOException {
		byte[] data = "A random string".getBytes();

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		EncryptOutputStream out = new EncryptOutputStream(output,
				this.substitutionCipher);

		for (int i = 0; i < data.length; i++) {
			out.write(data[i]);
		}

		byte[] actualData = output.toByteArray();

		for (int i = 0; i < data.length; i++) {
			assertEquals("chars are not the same", actualData[i],
					this.substitutionCipher.encrypt((char) data[i]));
			// System.out.println("actual: " + actualData[i] + " and expected: " + data[i]);
		}
	}

	@Test
	public final void testWriteByte() throws IOException {
		byte[] data = "A random string".getBytes();

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		EncryptOutputStream out = new EncryptOutputStream(output,
				this.substitutionCipher);

		out.write(data);

		byte[] actualData = output.toByteArray();

		for (int i = 0; i < data.length; i++) {
			assertEquals("chars are not the same", actualData[i],
					this.substitutionCipher.encrypt((char) data[i]));
			// System.out.println("actual: " + actualData[i] + " and expected: " + data[i]);
		}
	}

}
