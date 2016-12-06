package cn.edu.fudan.codeforces.ranking.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujy on 16-12-2.
 */
public class ByteUtil {

    public static byte[] toByteArray(List<String> stringList) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (int i = 0; i < stringList.size(); i++) {
            if (i > 0) out.writeUTF("_");  // TODO: can be removed
            out.writeUTF(stringList.get(i));
        }
        return baos.toByteArray();
    }

    public static List<String> toStringList(byte[] bytes) throws IOException {
        List<String> ret = new ArrayList<>();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream in = new DataInputStream(bais);
        try {
            while (true) {
                String str = in.readUTF();
                if (!str.equals("_")) {  // TODO: can be removed
                    ret.add(str);
                }
            }
        } catch (EOFException e) {
            // do nothing
        }
        return ret;
    }

}
