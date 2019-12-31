package cipher.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * <br>Created by Soybeany on 2019/12/31.
 */
@Mojo(name = "test", defaultPhase = LifecyclePhase.INSTALL)
public class TestMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            List<String> elements = project.getRuntimeClasspathElements();
            if (elements.isEmpty()) {
                throw new Exception("运行时类路径为空");
            }
            String[] files = new File(elements.get(0)).list();
            System.out.println(Arrays.asList(files != null ? files : new String[]{"没有找到"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
