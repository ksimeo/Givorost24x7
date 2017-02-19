package com.ksimeo.givorost.impl.utilites;

import com.ksimeo.givorost.impl.config.RepoServerConfig;

/**
 * @author Ksimeo. Created on 18.02.17 at 17:35 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class CharsetHelper {

    public static String correct(String currentValue) {
        byte[] bytes = currentValue.getBytes();
        if (bytes.length == 2 && bytes[0] == -48 && bytes[1] == 63) {
            bytes[0] = (byte) 208;
            bytes[1] = (byte) 152;
        }
        return new String(bytes);
    }

    public static String correctI(String str) {
        return str.replace("�?", "И");
    }

    public static String cp1251toUTF_8(String str) {
        try {
            return new String(str.getBytes("cp1251"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String UTF_8toISO_8859_1(String str) {
        try {
            return new String(str.getBytes("UTF-8"), "ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
//        try {
//            String URI = RepoServerConfig.URL + "string";
//            String echo = RequestsHelper.sendGet(URI);
//            byte[] bytes1 = echo.getBytes();
//
//            System.out.print(echo);
//            for (byte b1  : bytes1) {
////                byte[] b = str2.getBytes();
//                System.out.println(b1);
//            }

        try {
//            File file1 = new File("D:\\test\\output1.txt");
//            File file2 = new File("D:\\test\\output2.txt");
//            file1.createNewFile();
//            file2.createNewFile();

//            OutputStream os1 = new FileOutputStream("D:\\test\\output1.txt");
//            OutputStream os2 = new FileOutputStream("D:\\test\\output2.txt");
//
            String str = RequestsHelper.sendGet(RepoServerConfig.URL + "string");
            for (byte b : str.getBytes()) {
                System.out.println(b);
            }
                     System.out.println(" ");
            String str1 = "Иван";

            for (byte b1 : str1.getBytes()) {
                System.out.println(b1);
            }
//            os1.write(str.getBytes());
//            os2.write("\"И\r\nв\r\nа\r\nн\"".getBytes());
//            os1.flush();
//            os1.close();
//            os2.flush();
//            os2.close();
//        } catch (IOException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//            OutputStream os = new FileOutputStream();
//            ObjectMapper om = new ObjectMapper();
//            List<String> echoString = om.readValue(echo, new TypeReference<List<String>>(){});
//            echoString.

//            for (String char1 : echoString) {
//                System.out.print(char1 + " ");
//            }
            // И:    34 -17 -65 -67 34
            // Иван: 34 -17 -65 -67 -17 -65 -67 -17 -65 -67 -17 -65 -67 34
            // ван:  34 -17 -65 -67 -17 -65 -67 -17 -65 -67  34
            // в:    34 -17 -65 -67 34
            // а:    34 -17 -65 -67 34
            // н:    34 -17 -65 -67 34

            // И:    -48 -104
            // Иван: -48 -104 -48 -78 -48 -80 -48 -67
            // ван:  -48 -78  -48         -80 -48 -67
            // в:    -48 -78
            // а:    -48 -80
            // н:    -48 -67


//            byte[] b2 = {-104};
//
//            System.out.print("\r\n");
//
//            String str = "н";
//
//            byte[] bytes = str.getBytes();
//
//            for (byte b : bytes) {
//                System.out.println(b);
//            }



//            List<String> string1 = new ArrayList<>(5);
//            string1.add("И");
//            string1.add("в");
//            string1.add("а");
//            string1.add("н");
//
//            for (String char2 : string1) {
//                System.out.print(char2);
//            }
//
//            byte[] bytes1 = echo.getBytes();
//            byte[] bytes2 = "И".getBytes();
//
//            System.out.print("bytes 1: ");
//
//            for (byte byte1 : bytes1) {
//                System.out.print(" " + (byte)byte1);
//            }
//
//            System.out.print("\r\nbytes 2: ");
//
//            for (byte byte2 : bytes2) {
//                System.out.print(" " + byte2);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
