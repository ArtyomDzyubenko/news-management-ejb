package com.epam.newsmanagement.ejb.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Encoder {
    public String encode(String input) {
        return DigestUtils.md5Hex(input);
    }
}
