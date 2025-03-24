public enum StudyProfile {
    MEDICINE("Медицина"),
    COMPUTER_SCIENCE("Компьютерные науки"),
    LAW("Юриспруденция"),
    ECONOMICS("Экономика"),
    LITERATURE("Филология");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
