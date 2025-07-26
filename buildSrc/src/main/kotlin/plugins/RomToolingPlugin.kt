import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.Copy

class RomToolingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("romToolingCopy", Copy::class.java) {
            group = "ROM Tooling"
            description = "Copies ROM files for tooling"
            from(project.file("src/main/rom"))
            into(project.file("build/roms"))
        }
    }
}
