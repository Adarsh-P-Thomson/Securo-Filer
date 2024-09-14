//md5 hasher
#include <openssl/md5.h>
#include <string>
#include <iostream>

std::string md5_hash(const std::string& input) {
    unsigned char hash[MD5_DIGEST_LENGTH];
    MD5((unsigned char*)input.c_str(), input.length(), hash);

    std::string output;
    for (int i = 0; i < MD5_DIGEST_LENGTH; i++) {
        char buffer[3];
        sprintf(buffer, "%02x", hash[i]);
        output += buffer;
    }

    return output;
}

int main() {
    std::string input = "Hello, World!";
    std::string hash = md5_hash(input);

    std::cout << "MD5 Hash: " << hash << std::endl;

    return 0;
}