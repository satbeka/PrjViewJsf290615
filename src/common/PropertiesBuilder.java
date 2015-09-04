package common;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: sat
 * Date: 04092015
 */
public class PropertiesBuilder {
    static final String GLOBAL_CFG_FILENAME = "par.xml";
    //static final String GLOBAL_CFG_XML = "all_structure.xml";
    public static Properties _prop = new Properties();
    static String GLOBAL_CFG_PATH = ""
           + "D:\\Tomcat 7.0\\test\\"
            ;

    private static void loadProperties() {
        try {
            InputStream is = new FileInputStream(getCfgPath());
            _prop.loadFromXML(is);
            is.close();
        } catch (IOException e) {
            System.out.println("e="+e.getMessage());
        }
    }

    private static String getCfgPath() {
        String s = null;
        try {
            if (GLOBAL_CFG_PATH != null) {
                s = GLOBAL_CFG_PATH;
            }
            s = s + GLOBAL_CFG_FILENAME;
        } catch (Exception e) {
            System.out.println("e=" + e.getMessage());
        }
        System.out.println("par path = " + s);

        return s;
    }


    private static void saveProperties() {
        try {
            OutputStream os = new FileOutputStream(getCfgPath());
            _prop.storeToXML(os, "---");
            os.close();
        } catch (IOException e) {
            System.out.println("e="+e.getMessage());
        }
    }


    public static String getProperty(String s) {
        if (_prop.isEmpty()) {
            loadProperties();
        }
        if (!_prop.containsKey(s)) {
            _prop.setProperty(s, "null");
            saveProperties();
        }
        String value = _prop.getProperty(s);
        return value;
    }


    public static HashMap<String, String> getMap() {
        if (_prop.isEmpty()) {
            loadProperties();
        }
        HashMap<String, String> map = new HashMap<String, String>();
        for (Object o : _prop.keySet()) {
            String s = (String) o;
            map.put(s, _prop.getProperty(s));
        }
        return map;
    }

    public static ArrayList<String> getKeyList(String sKey) {
        ArrayList<String> list = new ArrayList<String>();
        for (String o : getMap().keySet()) {
            boolean b = o.startsWith(sKey);

            if (b) {
                list.add(o);
            }
        }

        return list;
    }


    public static void setProperty(String key, String value) {
        if (_prop.isEmpty()) {
            loadProperties();
        }
        _prop.setProperty(key, value);
        saveProperties();
    }

    public static String getProxySettings(String keyWord) {
        String res = new String();
        if (keyWord.equals("useProxy")) {
            res = getProperty("UseProxy");
        }
        if (keyWord.equals("host")) {
            res = getProperty("ProxyHost");
        }
        if (keyWord.equals("port")) {
            res = getProperty("ProxyPort");
        }
        if (keyWord.equals("user")) {
            res = getProperty("ProxyUser");
        }
        if (keyWord.equals("password")) {
            res = getProperty("ProxyPassword");
        }
        return res;
    }
}
