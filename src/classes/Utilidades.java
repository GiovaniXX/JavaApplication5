package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    public static boolean isNumeric(String Numero) {
        try {
            Integer.valueOf(Numero);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static Date stringToDate(String Data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date x = null;
        try {
            x = sdf.parse(Data);
        } catch (ParseException ex) {
        }
        return x;
    }

    // Método para formatar a data no padrão dia/mês/ano
    public static String formatDate(Date data) {
        if (data == null) {
            data = new Date();
        }
        SimpleDateFormat formatoTexto = new SimpleDateFormat("dd/MM/yyyy");
        return formatoTexto.format(data);
    }

    public static int objectToInt(Object obj) {
        String str = objectToString(obj);
        if (str.isEmpty()) {
            // Aqui você pode definir um valor padrão, por exemplo, retornar 0
            return 0;
        }

        try {
            int numInt = Integer.parseInt(str);
            return numInt;
        } catch (NumberFormatException e) {
            // Trate o erro aqui, caso a string não seja um número válido
            // Por exemplo, lançar uma exceção personalizada, logar o erro, etc.
            // Ou retorne um valor padrão, como o valor 0.
            return 0;
        }
    }

    public static double objectToDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        } else if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }

    public static boolean objectToBoolean(Object obj) {
        String CadBool = objectToString(obj);
        Boolean bool = Boolean.valueOf(CadBool);
        return bool;
    }

    public static String objectToString(Object obj) {
        String str = "";
        if (obj != null) {
            str = obj.toString();
        }
        return str;
    }

    public static Date objectToDate(Object obj) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date aux = null;
        try {
            aux = formatoDelTexto.parse(objectToString(obj));
        } catch (ParseException ex) {
        }
        return aux;
    }
}
