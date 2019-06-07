package com.feinno.commonlib.tools;

import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


/**
 * Created by LinHao on 2016/11/14.
 */

public class XMLTools {

    public static void writeXmlToFile(ByteArrayInputStream is, int bufferSize) {
        is.mark(is.available());
        String fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CMCCUC/imdao.xml";
        File file = new File(fileName);
        try {
            if (file.exists() == false) {
                file.createNewFile();
            }

            byte[] buffer = new byte[bufferSize];
            int count = is.read(buffer, 0, buffer.length);

            String str = new String(buffer, 0, count, "UTF-8");
            FileOutputStream os = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
            writer.write(str);
            writer.write("\n------------------------------------------------------------------------------\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.reset();
        }
    }

    public static void writeXmlToFile(ByteArrayInputStream is) {
        writeXmlToFile(is, 3*1024);
    }


    public static void printXml(ByteArrayInputStream is) {
      printXml(is, 3*1024);
    }

    public static void printXml(ByteArrayInputStream is, int size) {
        is.mark(is.available());
        try {
            byte[] buffer = new byte[size];
            int count = is.read(buffer, 0, buffer.length);
            String str = new String(buffer, 0, count, "UTF-8");
            Log.d("解析XML流", "解析出的XML信息： \n" + str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.reset();
        }
    }
}
