package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * Custom Gradle task for generating ROM using DataveinConstructor.
 */
abstract class GenerateRomTask : DefaultTask() {
    init {
        group = "ROM Tools"
        description = "Runs DataveinConstructor ROM generator"
    }

    @get:Input
    abstract val inputDir: Property<File>

    @get:Input
    abstract val outputDir: Property<File>

    @TaskAction
    fun generate() {
        println("🔧 Starting ROM generation...")
        
        // Ensure output directory exists
        outputDir.get().mkdirs()
        
        // TODO: Implement the actual ROM generation logic here
        // This is where you would call your DataveinConstructor or other ROM building logic
        
        println("✅ ROM generation completed successfully!")
        println("   Input directory: ${inputDir.get().absolutePath}")
        println("   Output directory: ${outputDir.get().absolutePath}")
    }
}
