import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.securofiler.util.CryptoUtil;

public class CryptoUtilTest {

    private CryptoUtil cryptoUtil;

    @BeforeEach
    public void setUp() {
        cryptoUtil = new CryptoUtil();
    }

    @Test
    public void testKeyDerivationFromText() {
        String password = "testPassword";
        byte[] key = cryptoUtil.deriveKeyFromText(password);
        assertNotNull(key);
        assertEquals(32, key.length); // AES-256 key length
    }

    @Test
    public void testKeyDerivationFromImage() {
        // Assuming we have a method to derive key from an image file
        byte[] key = cryptoUtil.deriveKeyFromImage("path/to/image.png");
        assertNotNull(key);
        assertEquals(32, key.length); // AES-256 key length
    }

    @Test
    public void testEncryptionAndDecryption() {
        String originalText = "Hello, World!";
        byte[] key = cryptoUtil.deriveKeyFromText("testPassword");
        byte[] encryptedData = cryptoUtil.encrypt(originalText.getBytes(), key);
        byte[] decryptedData = cryptoUtil.decrypt(encryptedData, key);
        
        assertArrayEquals(originalText.getBytes(), decryptedData);
    }

    @Test
    public void testInvalidKeyDecryption() {
        String originalText = "Hello, World!";
        byte[] key = cryptoUtil.deriveKeyFromText("testPassword");
        byte[] encryptedData = cryptoUtil.encrypt(originalText.getBytes(), key);
        
        // Use a different key for decryption
        byte[] wrongKey = cryptoUtil.deriveKeyFromText("wrongPassword");
        byte[] decryptedData = cryptoUtil.decrypt(encryptedData, wrongKey);
        
        assertNotEquals(originalText, new String(decryptedData));
    }
}