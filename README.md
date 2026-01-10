# Securo Filer 🛡️

**Securo Filer** is a high-performance, cross-platform encryption utility built with **Java 17**. It allows users to encrypt and decrypt any file or entire folder structures using flexible key sources—including text, images, and other files—as the cryptographic seed.

## 🚀 Key Features

* **Universal File Support:** Encrypt any file format (Images, Videos, Databases, etc.) or entire directory trees.
* **Flexible Key Sources:** * **Text:** Standard passwords/passphrases.
* **Images/Files:** Use the unique binary signature of an image or document as your encryption key.


* **Recursive Folder Processing:** Maintains directory structures while encrypting every file within.
* **Authenticated Encryption:** Uses **AES-GCM (256-bit)** to ensure both data privacy and integrity (tamper detection).
* **Streaming I/O:** Memory-efficient processing that handles multi-gigabyte files without high RAM usage.

---

## 🛠️ Technical Stack

* **Language:** Java 17 (LTS)
* **Security Provider:** Java Cryptography Architecture (JCA)
* **Algorithm:** AES/GCM/NoPadding
* **Key Derivation:** SHA-256 Hashing (for mapping arbitrary file data to 256-bit keys)
* **I/O:** Java NIO (New I/O) for fast file walking and streaming.

---

## 🏗️ How It Works

### 1. Key Derivation from Media

When an image or file is selected as a key, Securo Filer reads the binary stream of that file and passes it through a **SHA-256** message digest. This produces a consistent, high-entropy 256-bit key.

> **Note:** Even a 1-bit change in the "Key Image" will result in a completely different hash, making the original data unrecoverable.

### 2. Encryption Pipeline

1. **IV Generation:** A unique 12-byte Initialization Vector (IV) is generated for every file.
2. **Streaming:** The file is read in chunks via `CipherOutputStream`.
3. **Header:** The IV is prepended to the encrypted output file to allow for stateless decryption.

---

## 💻 Usage

### Prerequisites

* JDK 17 or higher.
* Maven/Gradle (optional for building).

---

## ⚠️ Security Warning

* **Loss of Key Source:** If you use an image as a key and delete that image, or if the image metadata is altered by a photo editor, **you cannot decrypt your files.**
* **Cold Storage:** It is recommended to keep a backup of your "Key File" in a separate, secure location.

---

