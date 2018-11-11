/**
 * @author Lais Frigério da Silva
 */

package model;

import java.awt.Color;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import view.FixedButtonModel;

public class Formatacao {
    public static String removeCEPmask(String cep) {
        cep = cep.replaceAll("-", "");
        return cep.replaceAll("        ", "");
    }
    
    public static String removeCPFmask(String cpf){
        return cpf.replaceAll("[-.]", "");
    }
    
    public static String removeFoneMask(String f){
        return f.replaceAll("[ ()-]", "");
    }
    
    public static String removeDateMask(String d){
        d = d.replaceAll("[ /]","");
        return d.replaceAll("      ", "");
    }
    
    public static Date string2Date(String d){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(d);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static Date string2DateTime(String d){
        try {
            Date h = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(d);
            return h;
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static String dateTime2String(Date d){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    }
    
    public static String dateTime2OnlyStringTime(Date d) {
        return new SimpleDateFormat("HH:mm:ss").format(d);
    }
    
    public static String dateTime2OnlyStringDate(Date d) {
        return new SimpleDateFormat("dd/MM/yyyy").format(d);
    }
    
    public static Time string2Time(String t){
        SimpleDateFormat mask = new SimpleDateFormat("HH:mm");
        try {
            Date data = mask.parse(t);
            return new Time(data.getTime());
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static String date2String(Date d){
        return new SimpleDateFormat("yyyy-MM-dd").format(d);
    }
    
    public static String date2StringScreen(Date d){
        return new SimpleDateFormat("dd/MM/yyyy").format(d);
    }
    
    public static String time2StringNoSec(Time t) {
        return new SimpleDateFormat("HH:mm").format(t);
    }
    
    public static String time2StringWithSec(Date t) {
        return new SimpleDateFormat("HH:mm:ss").format(t);
    }
    
    public static String time2String(Time t) {
        return new SimpleDateFormat("HH:mm:ss").format(t);
    }
    
    public static String time2String(Date d) {
        return new SimpleDateFormat("HH:mm").format(d);
    }
    
    public static String removeRGmask(String r){
        return r.replaceAll("[ .-]", "");
    }
    
    public static String removeTimeMask(String t){
        t = t.replaceAll("[:]", "");
        return t.replaceAll("[  ]", "");
    }
    
    public static String replaceComma2Dot(String v){
        return v.replaceAll(",", ".");
    }
    
    public static String removeComma(String v){
        v = v.replaceAll("[.]", "");
        return v.replaceAll("[,]", ".");
    }
    
    public static String setCPFmask(String cpf){
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + 
                "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
    
    public static String setDateMask(Date d){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(d);
    }
    
    public static String setCelularMask(String c){
        return "(" + c.substring(0,2) + ") " + c.substring(2, 7) + "-" + c.substring(7,11);
    }
    
    // Format text field's
    
    public static void setDisableTextField(JTextField field) {
        field.setDisabledTextColor(Color.black);
        field.setBorder(BorderFactory.createLineBorder(Color.gray));
        field.setBackground(Color.decode("#F7F7F7"));
    }
    
    public static void setDisableTextField(JFormattedTextField field) {
        field.setDisabledTextColor(Color.black);
        field.setBorder(BorderFactory.createLineBorder(Color.gray));
        field.setBackground(Color.decode("#F7F7F7"));
    }
    
    public static void setDisableTextField(JTextArea field) {
        field.setDisabledTextColor(Color.black);
        field.setBackground(Color.decode("#F7F7F7"));
    }

    // Format button's
    public static void setButtonStyle(JButton button) {
        button.setModel(new FixedButtonModel());
        button.setBorder(BorderFactory.createEtchedBorder(0));
    }
    
    public static void setButtons(JButton buttons[]) {
        for(JButton b:buttons)
            Formatacao.setButtonStyle(b);
    }    
}
