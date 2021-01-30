package club.fuwenhao.temp.encryption;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/30 4:05 下午
 */
public class RsaUtils {


    public static final String CHARSET = "UTF-8";
    public static final String RSA_ALGORITHM = "RSA";
    public static final int KEY_SIZE = 1024;

    public static Map<String, String> createKeys() {
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(KEY_SIZE);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<String, String>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);

        return keyPairMap;
    }

    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }


    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    public static String privateEncrypt(String data, RSAPrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64String(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), privateKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }


    public static String publicDecrypt(String data, RSAPublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) {
        int maxBlock = 0;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        byte[] resultDatas = out.toByteArray();
        try {
            out.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return resultDatas;
    }

    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            str += Integer.toHexString(ch);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> keyMap = createKeys();
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);

        privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO75mn5Ek1CNcpLH3435F1Za4bb0cO87sjHtVXi3KEx47QjGBdm1DcjXHpsNoQJK/QmQJQ7xGIwMcYP/vxY6OlQaGr9BOKSBMly0/BX9Ln8vqyN/tgnX0lhiOqwRrQn0I0mg7XZS7QijhlLEKs7ToYM8nqHyZ9TNqk+aFRV2vsBdAgMBAAECgYEAyxoCLrxzg2uj65HJsuz346G74fVgIkLXEM3H7Z+ktVG1CtbZ1AynmYES9u6fX8aBxeXnSQqpNSXCOFBchDSaqolNEBdSdMyd2O9qoNJrndCZSXYfCv7aD4CH2bGJIec/vrPftgv4D5wBwok1RPP8m/YmjmSoa020XXjnNTkc/qECQQD59omiHMOQ5tb+xf2AQgYBjmLif82fiiwjcdVx8a3jq3AU8rINnHjiGPj3Q8s2cNtyPkmh4fOYmMDOmWG/g+pFAkEA9L8hJzYvtiDDD0p803B2ygWYyDq2Gb/i/UdgyVnElnvbm4yib30CEf22e0fTiYxW3hY3Twjg/Z9THz1xNU4rOQJBAIVa9kq6tctUnFcIIhqPHs0tvavBK152RN4UGR/VJERWblF+uWdxlzxovkqMrJm61Bi7CmWHOoKq3BJc2j1mj1ECQF/i8c43AIJOW52GBVmhWijUAIOR3P5Bm2C3skewj8CVTfinJIyhYUpDKFcsUMg232GrOogQZnV3Ek3O+Kd1tKECQH/rinkJUymrbvQpGvFdKEjKVIClN3VCe0E5N1pfhwBpnFIfdfnbFT2x/qpIL0eArVj7pq3NyVz6bvAqxAeBiWI=";
        publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDu+Zp+RJNQjXKSx9+N+RdWWuG29HDvO7Ix7VV4tyhMeO0IxgXZtQ3I1x6bDaECSv0JkCUO8RiMDHGD/78WOjpUGhq/QTikgTJctPwV/S5/L6sjf7YJ19JYYjqsEa0J9CNJoO12Uu0Io4ZSxCrO06GDPJ6h8mfUzapPmhUVdr7AXQIDAQAB";

        System.out.println("私钥加密——公钥解密");
        String str = "{\"domainId\":\"ssotest\",\"externalUserId\":\"A0001\",\"timestamp\":1521616977}";
        System.out.println("\r明文：\r\n" + str);
        String encodedData = privateEncrypt(str, getPrivateKey(privateKey));
        System.out.println("密文：\r\n" + toHexString(encodedData));
        String decodedData = publicDecrypt(encodedData, getPublicKey(publicKey));
        System.out.println("解密后文字: \r\n" + decodedData);
    }
}
