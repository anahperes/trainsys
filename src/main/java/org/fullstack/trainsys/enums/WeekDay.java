package senums;

public enum WeekDay {
    SEGUNDA("Segunda", "Segunda-feira"),
    TERÇA("Terça", "Terça-feira"),
    QUARTA("Quarta", "Quarta-feira"),
    QUINTA("Quinta", "Quinta-feira"),
    SEXTA("Sexta", "Sexta-feira"),
    SÁBADO("Sábado", "Sábado"),
    DOMINGO("Domingo", "Domingo");
}

private final String day;

private final String fullDay;

WeekDay(String day, String fullDay) {
    this.day = day;
    this.fullDay = fullDay;
}

public  String getDay() {
    return day;
}

public  String getFullDay() {
    return fullDay;
}

public static WeekDay getDaybyFullDay(String day) {
    for (WeekDay value : values()) {
        if(value.fullDay == day) {
            return value;
        }
    }
    return null;
}
