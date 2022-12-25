import configuration.TomcatConfiguration;

public class WebAppRunner {
    public static void main(String[] args) {
        TomcatConfiguration.startTomcat(8888);
    }
}
