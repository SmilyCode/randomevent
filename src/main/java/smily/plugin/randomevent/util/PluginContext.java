package smily.plugin.randomevent.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PluginContext {
    ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
}
