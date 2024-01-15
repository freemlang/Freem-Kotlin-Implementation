/**
 * Precompiled [freem.kotlin-library-conventions.gradle.kts][Freem_kotlin_library_conventions_gradle] script plugin.
 *
 * @see Freem_kotlin_library_conventions_gradle
 */
public
class Freem_kotlinLibraryConventionsPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Freem_kotlin_library_conventions_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
