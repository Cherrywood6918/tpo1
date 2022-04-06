package model;

public enum PersonFeeling {
    NORMAL("ничего особенного"),
    DIZZINESS("головокружение"),
    WIND_ON_BALD("холодок на лысине"),
    HAIR_STARING("шевеление волос");

    private String str;

    PersonFeeling(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
