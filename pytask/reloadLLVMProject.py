"""
task("reloadLLVMProject") {
        val propertiesPath = "llvm.properties"
        val llvmProperties = Properties().apply { FileInputStream(File(propertiesPath)).use(::load) }

        val githubRepositoryOwner = "llvm"
        val githubRepositoryName = "llvm-project"
        val githubReleaseVersion = llvmProperties.getProperty("version")
        val githubReleaseTag = "llvmorg-$githubReleaseVersion"
        val githubGetReleaseByTagURL = "https://api.github.com/repos/$githubRepositoryOwner/$githubRepositoryName/releases/tags/$githubReleaseTag"

        fun GETRequestURL(url: String): String {

            val connection = URI(url).toURL().openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            with (connection.responseCode) {
                require(this == HttpURLConnection.HTTP_OK) {
                    "API Request Failed with response code: $this"
                }
            }

            val response = InputStreamReader(connection.inputStream).use(InputStreamReader::readText)

            connection.disconnect()

            return response
        }

        val llvmAsset = JsonParser
            .parseString(
                GETRequestURL(
                    githubGetReleaseByTagURL
                )
            )
            .asJsonObject
            .also {
                require(
                    it.has("message").not()
                ) {
                    "Invalid version $githubReleaseVersion"
                }
            }
            .getAsJsonArray("assets")
            .find {
                it
                    .asJsonObject
                    .getAsJsonPrimitive("name")
                    .asString
                    .run {
                        startsWith("llvm-") && endsWith(".src.tar.xz")
                    }
            }!!
            .asJsonObject
        val llvmDownloadURL = llvmAsset.getAsJsonPrimitive("browser_download_url").asString
        val llvmFileName = llvmAsset.getAsJsonPrimitive("name").asString

        println(llvmDownloadURL)

        val outputDir = "src/nativeInterop/cinterop/llvm"

    }
"""