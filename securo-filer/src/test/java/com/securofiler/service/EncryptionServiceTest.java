import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.securofiler.service.EncryptionService;
import com.securofiler.service.KeyDerivationService;

public class EncryptionServiceTest {

    private EncryptionService encryptionService;
    private KeyDerivationService keyDerivationService;

    @BeforeEach
    public void setUp() {
        encryptionService = new EncryptionService();
        keyDerivationService = new KeyDerivationService();
    }

    @Test
    public void testEncryptDecryptFile() {
        // Arrange
        String filePath = "path/to/test/file.txt";
        String keySource = "testKey";
        
        // Act
        byte[] encryptedData = encryptionService.encryptFile(filePath, keySource);
        String decryptedData = encryptionService.decryptFile(encryptedData, keySource);
        
        // Assert
        assertEquals("Expected file content", decryptedData);
    }

    @Test
    public void testKeyDerivation() {
        // Arrange
        String keySource = "testKey";
        
        // Act
        byte[] key = keyDerivationService.deriveKey(keySource);
        
        // Assert
        assertNotNull(key);
        assertEquals(32, key.length); // 256 bits
    }

    @Test
    public void testInvalidKeySource() {
        // Arrange
        String invalidKeySource = "invalidKey";
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            encryptionService.encryptFile("path/to/test/file.txt", invalidKeySource);
        });
    }
}