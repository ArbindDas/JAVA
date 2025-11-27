
public class StringDemo {
    public static void main(String[] args) {
        // ======= String (Immutable) =======
        String str = "Hello";
        System.out.println("Original String: " + str);
        str.concat(" World"); // Doesn't change str
        System.out.println("After concat (String): " + str); // Still "Hello"
        str = str.concat(" World"); // Assign back to change
        System.out.println("After concat with assignment: " + str); // "Hello World"

        // ======= StringBuffer (Mutable & Thread-safe) =======
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("\nOriginal StringBuffer: " + sb);
        sb.append(" World"); // Modifies the same object
        System.out.println("After append (StringBuffer): " + sb);
        sb.insert(6, "Java "); // Inserts at position 6
        System.out.println("After insert: " + sb);
        sb.reverse(); // Reverses the content
        System.out.println("After reverse: " + sb);

        // ======= StringBuilder (Mutable & Not Thread-safe) =======
        StringBuilder sbd = new StringBuilder("Hello");
        System.out.println("\nOriginal StringBuilder: " + sbd);
        sbd.append(" World"); // Modifies the same object
        System.out.println("After append (StringBuilder): " + sbd);
        sbd.replace(6, 11, "Java"); // Replace substring
        System.out.println("After replace: " + sbd);
        sbd.reverse(); // Reverses the content
        System.out.println("After reverse: " + sbd);
    }
}
