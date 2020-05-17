package com.epam.izh.rd.online.service;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     *
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        String s = base;
        s = s.replaceAll(remove, "");
        return s;
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     *
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        if (text.length() == 0) return false;
        return (text.charAt(text.length()-1) == '?');
    }

    /**
     * Реализовать функционал соединения переданных строк.
     *
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        StringBuilder str = new StringBuilder();
        for (String s : elements) {
            str.append(s);
        }
        return str.toString();
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     *
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        String s = "";
        if (text.length() > 0) s += text.substring(0, 1).toLowerCase();
        if (text.length() > 1) s += text.substring(1, 2).toUpperCase();
        if (text.length() > 2) {
            for (int i = 2; i < text.length(); i++) {
                if (text.charAt(i) < 65 && text.charAt(i) > 90 && text.charAt(i) < 97 && text.charAt(i) > 122) continue;
                    if (i%2 == 0) s += text.substring(i, i+1).toLowerCase();
                    else s += text.substring(i, i+1).toUpperCase();
            }
        }
        return s;
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     *
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     *
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
        boolean theString = true;
        String s  = string.replaceAll("\\s+", "").toLowerCase();
        int l = s.length();
        if (l < 2) return false;
        for (int i = 0; i < l/2; i++) {
            if (s.charAt(i) != s.charAt(l-i-1)) {
                theString = false;
                break;
            }
        }
        return theString;
    }
}
