public class PalindromeNumber {
    public boolean isPalindrome (int x) {
        if (x < 0)
            return false;
        String orig = "" +x;
        String palindrom = "";
        for (int i = 0; i < orig.length(); i++) {
            palindrom = orig.charAt(i) + palindrom;
        }

        return palindrom.equals(orig);

    }

    public static void main(String[] args) {
        PalindromeNumber pm = new PalindromeNumber();

        System.out.println(pm.isPalindrome(121));
    }
}
