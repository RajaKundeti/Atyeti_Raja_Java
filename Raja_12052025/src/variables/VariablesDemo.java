package variables;

import static java.lang.Byte.parseByte;

public class VariablesDemo {
    //  STATIC VARIABLES
    static byte byteVar = -128;
    static short shortVar = 12345;
    static int intVar = 987654321;
    static long longVar = 44556677;
    static float floatVar = 1234.56f;
    static double doubleVar = 12345.678;
    static char charVar = 'R';
    static boolean boolVar = false;

    public static void main(String[] args) {

        System.out.println(
                "Type: "+Byte.TYPE+
                        "\n\tSize: "+Byte.BYTES+" byte"+
                        "\n\tMax Value of Byte: "+Byte.MAX_VALUE+
                        "\n\tMin Value of Byte: "+Byte.MIN_VALUE+
                        "\n\tHashcode: "+Byte.hashCode(byteVar)
                        //  VALUE OUT OF RANGE
                        //" ,Byte Value of \"200\""+ parseByte("200")
        );
        System.out.println(
                "Type: "+Short.TYPE+
                        "\n\tSize: "+Short.BYTES+" bytes"+
                        "\n\tHashcode: "+Short.hashCode(shortVar)+
                        "\n\tMax Value of Byte: "+Short.MAX_VALUE+
                        "\n\tMin Value of Byte: "+Short.MIN_VALUE
        );
        System.out.println(
                "Type: "+Integer.TYPE+
                        "\n\tSize: "+Integer.BYTES+" bytes"+
                        "\n\tHashcode: "+Integer.hashCode(intVar)+
                        "\n\tMax Value of Byte: "+Integer.MAX_VALUE+
                        "\n\tMin Value of Byte: "+Integer.MIN_VALUE
        );
        System.out.println(
                "Type: "+Long.TYPE+
                        "\n\tSize: "+Long.BYTES+" bytes"+
                        "\n\tHashcode: "+Long.hashCode(longVar)+
                        "\n\tMax Value of Byte: "+Long.MAX_VALUE+
                        "\n\tMin Value of Byte: "+Long.MIN_VALUE
        );
        System.out.println(
                "Type: "+Float.TYPE+
                        "\n\tSize: "+Float.BYTES+" bytes"+
                        "\n\tHashcode: "+Float.hashCode(floatVar)+
                        "\n\tMax Value of Byte: "+Float.MAX_VALUE+
                        "\n\tMin Value of Byte: "+Float.MIN_VALUE
        );
        System.out.println(
                "Type: "+Double.TYPE+
                        "\n\tSize: "+Double.BYTES+" bytes"+
                        "\n\tHashcode: "+Double.hashCode(doubleVar)+
                        "\n\tMax Value of Byte: "+Double.MAX_VALUE+
                        "\n\tMin Value of Byte: "+Double.MIN_VALUE
        );
        System.out.println(
                "Type: "+Character.TYPE+
                        "\n\tSize: "+Character.BYTES+" bytes"+
                        "\n\tHashcode: "+Character.hashCode(charVar)
        );
        System.out.println(
                "Type: "+Boolean.TYPE+
                        "\n\tHashcode: "+Boolean.hashCode(boolVar)
        );

    }
}
