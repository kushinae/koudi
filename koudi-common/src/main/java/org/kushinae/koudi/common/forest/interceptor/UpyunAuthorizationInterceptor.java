package org.kushinae.koudi.common.forest.interceptor;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;
import org.kushinae.koudi.common.properties.upyun.UpyunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Component
public class UpyunAuthorizationInterceptor<T> implements Interceptor<T> {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    public static final String AUTH_PREFIX = "UPYUN ";

    @Autowired
    UpyunProperties upyunProperties;

    @Override
    public void onInvokeMethod(ForestRequest request, ForestMethod method, Object[] args) {
        String authorization = null;
        String rfc1123Time = getRfc1123Time();
        try {
            authorization = getAuthorization(request, rfc1123Time);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.addHeader(upyunProperties.getAuthorization().getHeader(), authorization);
        request.addHeader("Date", rfc1123Time);
    }

    private String getAuthorization(ForestRequest request, String rfc1123Time) throws Exception {
        return sign(upyunProperties.getOperator().getName(), md5(upyunProperties.getOperator().getPassword()), request.getType().getName(), request.getURI().getPath(), rfc1123Time, "", "");
    }

    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static byte[] hashHmac(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return mac.doFinal(data.getBytes());
    }

    public static String sign(String key, String secret, String method, String uri, String date, String policy,
                              String md5) throws Exception {
        String value = method + "&" + uri + "&" + date;
        if (!Objects.equals(policy, "")) {
            value = value + "&" + policy;
        }
        if (!Objects.equals(md5, "")) {
            value = value + "&" + md5;
        }
        byte[] hmac = hashHmac(value, secret);
        String sign = Base64.getEncoder().encodeToString(hmac);
        return AUTH_PREFIX + key + ":" + sign;
    }

    public static String getRfc1123Time() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }
}
