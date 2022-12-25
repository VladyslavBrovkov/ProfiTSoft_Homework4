package configuration;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;


/**
 * Class for Embedded Tomcat configuration
 */
public class TomcatConfiguration {
    private static final Tomcat tomcat = new Tomcat();

    public static void startTomcat(Integer webPort) {
        tomcat.setPort(webPort);
        contextConfigure();
        tomcat.enableNaming();
        tomcat.getConnector();
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }

    private static void contextConfigure() {
        StandardContext standardContext = (StandardContext) tomcat.addWebapp("", new File("src/main/webapp/")
                .getAbsolutePath());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(standardContext);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        standardContext.setResources(resources);
    }

}
