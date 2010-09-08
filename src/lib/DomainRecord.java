package lib;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class DomainRecord {

    public static final String RECORD_SOA = "SOA";
    public static final String RECORD_A = "A";
    public static final String RECORD_NS = "NS";
    public static final String RECORD_MX = "MX";
    public static final String RECORD_CNAME = "CNAME";

    public static List lookup(String hostName, String record) {

        List result = new Vector();
        try {
            Hashtable env = new Hashtable();
            env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            DirContext ictx = new InitialDirContext(env);
            Attributes attrs = ictx.getAttributes(hostName, new String[] { record });
            Attribute attr = attrs.get(record);

            NamingEnumeration attrEnum = attr.getAll();
            while (attrEnum.hasMoreElements())
                result.add(attrEnum.next());
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }
}
