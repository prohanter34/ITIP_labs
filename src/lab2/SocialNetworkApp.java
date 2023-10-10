package lab2;

public class SocialNetworkApp extends Application {

    private int notificCount;
    private int profileId;
    private String login;

    public SocialNetworkApp(String name, String producer, String platform, float weight) {
        super(name, producer, platform, weight);
        this.notificCount = 0;
    }
    @Override
    public void startMessage() {
        System.out.println("Присоединяемся к сети");
        clearNotifications();
    }
    @Override
    public void closeMessage() {
        System.out.println("Говорим друзьям пока");
    }
    private void clearNotifications() {
        this.notificCount = 0;
    }
    public void addNotification(int count) {
        this.notificCount += count;
    }
    public void authentication(String login) {
        setProfileId(login.hashCode());
        this.login = login;
    }
    public int getNotificCount() {
        return notificCount;
    }
    public int getProfileId() {
        return profileId;
    }
    private void setProfileId(int profileId) {
        this.profileId = profileId;
    }
    public String getLogin() {
        return login;
    }
}
