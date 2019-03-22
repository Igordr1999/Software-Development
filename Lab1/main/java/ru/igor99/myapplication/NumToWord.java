package ru.igor99.myapplication;

public class NumToWord {
    public String getNumberInWords(int x){
        if ((x < 1) || (x > 1000000)){
            throw new IllegalArgumentException("Number converted to words should be from 1 to 1000000\n"
                    + x + " found\n");
        }
        if (x == 1000000) {
            return "миллион";
        }
        StringBuilder ansBuilder = new StringBuilder();
        if (x / 1000 > 0) {
            ansBuilder.append(getNumberFrom1to999(x / 1000, true));
            ansBuilder.append(" ");
            ansBuilder.append(getFormOf1000(x / 1000));
            ansBuilder.append(" ");
        }
        x = x % 1000;
        if (x > 0) {
            ansBuilder.append(getNumberFrom1to999(x, false));
        }
        return ansBuilder.toString().trim();
    }

    private String getFormOf1000(int numberOf1000) {
        if ((numberOf1000 < 1) || (numberOf1000 > 999))
            throw new IllegalArgumentException("numberOf1000 should be from 1 to 999\n"
                    + numberOf1000 + " found\n");
        if ((5 <= numberOf1000 % 100) && (numberOf1000 % 100 <= 20))
            return "тысяч";
        if (numberOf1000 % 10 == 1)
            return "тысяча";
        if ((2 <= numberOf1000 % 10) && (numberOf1000 % 10 <= 4)) {
            return "тысячи";
        }
        return "тысяч";
    }

    private String getFormFor1to9(int x, boolean is_female) {
        switch(x) {
            case 1:
                return is_female ? "одна" : "один";
            case 2:
                return is_female ? "две" : "два";
            case 3:
                return "три";
            case 4:
                return "четыре";
            case 5:
                return "пять";
            case 6:
                return "шесть";
            case 7:
                return "семь";
            case 8:
                return "восемь";
            case 9:
                return "девять";
            default:
                throw new IllegalArgumentException("getFormFor1to9 expects number from 1 to 9\n"
                        + x + " found\n");
        }
    }

    private String getFormFor10to19(int x) {
        switch(x) {
            case 10:
                return "десять";
            case 11:
                return "одиннадцать";
            case 12:
                return "двенадцать";
            case 13:
                return "тринадцать";
            case 14:
                return "четырнадцать";
            case 15:
                return "пятнадцать";
            case 16:
                return "шестнадцать";
            case 17:
                return "семнадцать";
            case 18:
                return "восемнадцать";
            case 19:
                return "девятнадцать";
            default:
                throw new IllegalArgumentException("getFormFor10to19 expects number from 10 to 19\n"
                        + x + " found\n");
        }
    }
    private String getTensFrom2to9(int x) {
        switch(x) {
            case 2:
                return "двадцать";
            case 3:
                return "тридцать";
            case 4:
                return "сорок";
            case 5:
                return "пятьдесят";
            case 6:
                return "шестьдесят";
            case 7:
                return "семьдесят";
            case 8:
                return "восемьдесят";
            case 9:
                return "девяносто";
            default:
                throw new IllegalArgumentException("getTensFrom2to9 expects number from 2 to 9\n"
                        + x + " found\n");
        }
    }
    private String getHundredsFrom1to9(int x) {
        switch(x) {
            case 1:
                return "сто";
            case 2:
                return "двести";
            case 3:
                return "триста";
            case 4:
                return "четыреста";
            case 5:
                return "пятьсот";
            case 6:
                return "шестьсот";
            case 7:
                return "семьсот";
            case 8:
                return "восемьсот";
            case 9:
                return "девятьсот";
            default:
                throw new IllegalArgumentException("getHundredsFrom1to9 expects number from 1 to 9\n"
                        + x + " found\n");
        }
    }

    private String getNumberFrom1to999(int x, boolean is_female) {
        StringBuilder ansBuilder = new StringBuilder();
        if (x / 100 > 0) {
            ansBuilder.append(getHundredsFrom1to9(x / 100));
            ansBuilder.append(" ");
        }
        x = x % 100;
        if ((10 <= x) && (x <= 19)) {
            ansBuilder.append(getFormFor10to19(x));
            return ansBuilder.toString();
        }
        if (x / 10 > 0) {
            ansBuilder.append(getTensFrom2to9(x / 10));
            ansBuilder.append(" ");
        }
        x = x % 10;
        if (x > 0) {
            ansBuilder.append(getFormFor1to9(x, is_female));
        }
        return ansBuilder.toString().trim();
    }
}
