package com.chige.util;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Enumeration;

@Data
public class RequestReadUtils {
    private static final int BUFFER_SIZE = 1024 * 8;

    public static String read(HttpServletRequest request) {
        StringWriter writer;
        try {
            BufferedReader bufferedReader = request.getReader();
            writer = new StringWriter();
            write(bufferedReader, writer);
        } catch (Exception e) {
            return getString(request);
        }
        String str = writer.getBuffer().toString();
        if (StringUtils.isBlank(writer.toString())) {
            if (HttpMethod.GET.name().equals(request.getMethod())) {
                return request.getQueryString();
            }
            str = request.getQueryString();
            if (StringUtils.isBlank(str)) {
                str = getString(request);
            }
        }
        return str.replaceAll("\r\n", "");
    }

    private static String getString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            sb.append(name);
            sb.append("=");
            sb.append(request.getParameter(name));
            sb.append(",");
        }
        return sb.toString();
    }

    public static long write(Reader reader, Writer writer) throws IOException {
        return write(reader, writer, BUFFER_SIZE);
    }

    public static long write(Reader reader, Writer writer, int bufferSize) throws IOException {
        int read;
        long total = 0;
        char[] buf = new char[bufferSize];
        while ((read = reader.read(buf)) != -1) {
            writer.write(buf, 0, read);
            total += read;
        }
        return total;
    }
}
