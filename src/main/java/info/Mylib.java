package info;

import moduls.ClientH;

import java.util.ArrayList;

public class Mylib {
    public static boolean nomCognomCheck(String string) {
        return string.matches("^[a-zA-Z]+$");
    }

    public static boolean dniCheck(String dni) {
        String[] arrayDni = dni.split("");

        if (dni.length() != 9) {
            return false;
        }
        for (int i = 0; i < arrayDni.length; i++) {
            if (i != 8) {
                if (!arrayDni[i].matches("^[0-9]+$")) {
                    return false;
                }
            } else {
                if (!arrayDni[i].matches("^[A-Z]$")) {
                    return false;
                }
            }
        }
        return true;
    }
}
